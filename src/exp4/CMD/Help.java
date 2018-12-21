package exp4.CMD;

public class Help implements Command {
    @Override
    public void execute() {
        System.out.println("help 帮助");
        System.out.println("cash 持有货币");
        System.out.println("wager 持有赌注");
        System.out.println("quit 退出");
    }
}
