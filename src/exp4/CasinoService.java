package exp4;

import exp4.CMD.*;

import java.util.List;
import java.util.Scanner;

/**
 * 赌资管理服务
 * Facade
 */
public class CasinoService {
    /**
     * 命令
     */
    private Broker broker;
    private HelpCommand helpCommand;
    private CashCommand cashCommand;
    private WagerCommand wagerCommand;
    private QuitCommand quitCommand;
    private BuyCommand buyCommand;
    private JettonCommand jettonCommand;
    private AssetCommand assetCommand;
    private ExchangeCommand exchangeCommand;
    private BetCommand betCommand;

    /**
     * 属性
     */
    private volatile int ID = 0;
    private Player player;

    public CasinoService() {
        player = new Player(); // 注意避免循环构造
        this.broker = new Broker();
        this.helpCommand = new HelpCommand(this);
        this.cashCommand = new CashCommand(this);
        this.wagerCommand = new WagerCommand(this);
        this.quitCommand = new QuitCommand(this);
        this.buyCommand = new BuyCommand(this);
        this.jettonCommand = new JettonCommand(this);
        this.assetCommand = new AssetCommand(this);
        this.exchangeCommand = new ExchangeCommand(this);
        this.betCommand = new BetCommand(this);
    }

    synchronized public Player getPlayer() {
        return player;
    }

    public void takeCommands(String line) {
        if (line.startsWith("help")) {
            broker.takeCommand(this.helpCommand);
        }
        if (line.startsWith("cash")) {
            broker.takeCommand(this.cashCommand);
        }
        if (line.startsWith("jetton")) {
            broker.takeCommand(this.jettonCommand);
        }
        if (line.startsWith("wager")) {
            broker.takeCommand(this.wagerCommand);
        }
        if (line.startsWith("quit")) {
            broker.takeCommand(this.quitCommand);
        }
        if (line.startsWith("buy")) { // 购买筹码
            broker.takeCommand(this.buyCommand);
        }
        if (line.startsWith("asset")) {
            broker.takeCommand(assetCommand);
        }
        if (line.startsWith("exchange")) {
            broker.takeCommand(exchangeCommand);
        }
        if (line.startsWith("bet")) {
            broker.takeCommand(betCommand);
        }
    }

    /**
     * 委托执行命令
     *
     * @return 有命令被执行 true，无命令被执行 false
     */
    public boolean placeCommands() {
        return this.broker.placeCommands();
    }

    /**
     * 查看帮助
     */
    public void help() {
        System.out.println("- help: view command information");
        System.out.println("- jetton: view holding jetton");
        System.out.println("    -- buy: consume cash to get a specified number of chips");
        System.out.println("    -- exchange: convert jetton to cash");
        System.out.println("- asset: view holding asset");
        System.out.println("- cash: view holding currency");
        System.out.println("- wager: view holding wager");
        System.out.println("    -- bet: bet with jetton");
        System.out.println("- quit: exit the program");
    }

    /**
     * 退出程序
     */
    public void quit() {
        System.out.println("Good bye!");
        System.exit(0);
    }

    /**
     * 查看持有货币
     */
    public void cash() {
        List<Cash> cashList = null;
        try {
            cashList = player.getCashList();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("[Error] The wager list is null");
        }
        if (cashList.isEmpty()) {
            System.out.println("[Info] No cash available");
            return;
        }
        for (Cash cash : cashList) {
            System.out.println(cash.toString());
        }
    }

    /**
     * 查看持有赌注
     */
    public double wager() {
        List<Wager> wagerList;
        double totalSum = 0;
        /**
         * 处理异常情况
         */
        try {
            wagerList = player.getWagerList();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("[Error] The wager list is null");
            return 0;
        }
        if (wagerList.isEmpty()) {
            System.out.println("[Info] No wager available");
            return 0;
        }
        /**
         * 遍历 wager 列表，打印信息
         */
        for (Wager wager : wagerList) {
            double wagerSum = 0;
            List<Jetton> jettonList = wager.getJettonList();
            if (jettonList == null || jettonList.isEmpty())
                continue;
            /**
             * 遍历 jetton 列表，打印信息
             * jetton 可能是 cash 或 chip
             */
            for (Jetton jetton : jettonList) {
                System.out.println(jetton.toString());
                wagerSum += jetton.getValue();
            }
            System.out.println("Player: " + player.getNickname() + "; Sum of wager " + wager.toString() + ": " + wagerSum);
            totalSum += wagerSum;
        }
        System.out.println("Player: " + player.getNickname() + "; Sum of wagers: " + totalSum);
        return totalSum;
    }

    public double jetton() {
        List<Jetton> jettonList;
        double jettonSum = 0;
        try {
            jettonList = player.getJettonList();
            if (jettonList.isEmpty()) {
                System.out.println("[Info] You haven't had any jetton yet");
            } else {
                for (Jetton jetton : jettonList) {
                    System.out.println(jetton.toString());
                    jettonSum += jetton.getValue();
                }
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        System.out.println("Player: " + player.getNickname() + "; Sum of jetton: " + jettonSum);
        return jettonSum;
    }

    public void asset() {
        List<Asset> assetList;
        double assetSum = 0;
        try {
            assetList = player.getAssetList();
            if (assetList.isEmpty()) {
                System.out.println("[Info] You haven't had any asset yet");
            } else {
                for (Asset asset : assetList) {
                    System.out.println(asset.toString());
                    assetSum += asset.getValue();
                }
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    /**
     * 购买筹码
     */
    public void buy() {
        System.out.println("- How many chips do you want to buy? Each chip is worth $100,000.");
        double unitPrice = 100000;
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        try {
            int jettonNum = Integer.parseInt(line);
            boolean payResult = this.player.spendCash(unitPrice * jettonNum);
            if (payResult) {
                for (int i = 0; i < jettonNum; i++) {
                    this.player.addChip(new Chip(unitPrice));
                }
                System.out.println("[Info] Player " + this.player.getNickname() + " has purchased " + jettonNum + " chips");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[Error] The number is incorrectly entered");
        }
    }

    public void exchange() {
        System.out.println("- Which chip in your hand do you want to exchange for cash? Please enter the chip number.");
        Scanner sc = new Scanner(System.in);
        int chipNum = sc.nextInt();
        Chip chip = player.getChip(chipNum);
        if (chip == null) {
            // 如果玩家不持有该筹码
            System.out.println("[Error] Player " + player.getNickname() + " does not hold the chip #" + chipNum);
            return;
        }
        // 如果玩家持有该筹码
        player.getJettonList().remove(chip);
        player.addCash(chip.exchange());
        System.out.println("[Info] Player " + player.getNickname() + " has converted the chip#" + chipNum + " into cash $" + chip.getValue());
    }

    public void bet() {
// todo

    }
}

