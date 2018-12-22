package exp4.CMD;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 命令执行者
 */
public class Broker {
    private List<Command> commandList = new CopyOnWriteArrayList<>();

    public void takeCommand(Command command) {
        commandList.add(command);
    }

    /**
     * 执行命令
     *
     * @return 是否执行了命令
     */
    public boolean placeCommands() {
        synchronized (Broker.class) {
            if (commandList.isEmpty())
                return false;
            for (Command command : commandList) {
                command.execute();
            }
            commandList.clear();
            return true;
        }
    }
}
