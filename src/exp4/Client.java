package exp4;

import exp4.CMD.Broker;
import exp4.CMD.HelpCommand;
import exp4.CMD.QuitCommand;

import java.util.Scanner;

public class Client {
    private static CasinoService casinoService;
    private static Broker broker;
    private static HelpCommand helpCommand;
    private static QuitCommand quitCommand;

    public static CasinoService getCasinoService() {
        return casinoService;
    }

    public static void clientInit() {
        casinoService = new CasinoService();
        broker = new Broker();
        helpCommand = new HelpCommand(casinoService);
        quitCommand = new QuitCommand(casinoService);
    }

    public static void main(String args[]) {
        clientInit();
        Scanner sc = new Scanner(System.in);
        String line;
        printMenu();
        boolean validCommand;
        while ((line = sc.nextLine()) != null) {
            validCommand = false;
            if (line.contains("help")) {
                broker.takeCommand(helpCommand);
            } else if (line.contains("quit")) {
                broker.takeCommand(quitCommand);
            }
            validCommand = broker.placeCommands();
            if (!validCommand) {
                System.out.println(line + " is not a valid command");
            }
            printMenu();
        }
    }

    /**
     * 打印菜单
     */
    public static void printMenu() {
        System.out.print("Casino>> ");
    }
}
