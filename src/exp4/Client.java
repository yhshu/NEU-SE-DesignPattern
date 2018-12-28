package exp4;

import java.util.Scanner;

public class Client {
    private static CasinoService casinoService = new CasinoService();

    synchronized public static CasinoService getCasinoService() {
        if (casinoService == null) {
            casinoService = new CasinoService();
        }
        return casinoService;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your username: ");
        casinoService.getPlayer().setNickname(sc.nextLine());
        System.out.println("[Info] Client initialization completed");
        System.out.println("Welcome, " + casinoService.getPlayer().getNickname());

        String line;
        printMenu();
        boolean validCommand;
        while ((line = sc.nextLine()) != null) {
            validCommand = false;
            casinoService.takeCommands(line);
            validCommand = casinoService.placeCommands();
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
