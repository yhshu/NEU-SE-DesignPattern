package exp4;

import exp4.CMD.*;

import java.util.Scanner;

public class Client {
    private static CasinoService casinoService;
    private static Broker broker;
    private static HelpCommand helpCommand;
    private static CashCommand cashCommand;
    private static WagerCommand wagerCommand;
    private static SumCommand sumCommand;
    private static QuitCommand quitCommand;

    synchronized public static CasinoService getCasinoService() {
        return casinoService;
    }

    public static void clientInit() {
        casinoService = new CasinoService();
        broker = new Broker();
        helpCommand = new HelpCommand(casinoService);
        cashCommand = new CashCommand(casinoService);
        wagerCommand = new WagerCommand(casinoService);
        sumCommand = new SumCommand(casinoService);
        quitCommand = new QuitCommand(casinoService);
    }

    public static void main(String args[]) {
        clientInit();
        System.out.println("[Info] Client initialization completed");

        Scanner sc = new Scanner(System.in);
        String line;
        printMenu();
        boolean validCommand;
        while ((line = sc.nextLine()) != null) {
            validCommand = false;
            if (line.contains("help")) {
                broker.takeCommand(helpCommand);
            }
            if (line.contains("cash")) {
                broker.takeCommand(cashCommand);
            }
            if (line.contains("wager")) {
                broker.takeCommand(wagerCommand);
            }
            if (line.contains("sum")) {
                broker.takeCommand(sumCommand);
            }
            if (line.contains("quit")) {
                broker.takeCommand(quitCommand);
            }
            validCommand = broker.placeCommands();
            if (!validCommand) {
                System.out.println(line + " 不是有效的命令");
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
