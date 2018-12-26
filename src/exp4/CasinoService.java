package exp4;

import exp4.CMD.*;

import java.util.List;

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
    private SumCommand sumCommand;
    private QuitCommand quitCommand;
    private BuyCommand buyCommand;

    /**
     * 属性
     */
    private volatile int ID = 0;
    private Player player;

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public HelpCommand getHelpCommand() {
        return helpCommand;
    }

    public void setHelpCommand(HelpCommand helpCommand) {
        this.helpCommand = helpCommand;
    }

    public CashCommand getCashCommand() {
        return cashCommand;
    }

    public void setCashCommand(CashCommand cashCommand) {
        this.cashCommand = cashCommand;
    }

    public WagerCommand getWagerCommand() {
        return wagerCommand;
    }

    public void setWagerCommand(WagerCommand wagerCommand) {
        this.wagerCommand = wagerCommand;
    }

    public SumCommand getSumCommand() {
        return sumCommand;
    }

    public void setSumCommand(SumCommand sumCommand) {
        this.sumCommand = sumCommand;
    }

    public QuitCommand getQuitCommand() {
        return quitCommand;
    }

    public void setQuitCommand(QuitCommand quitCommand) {
        this.quitCommand = quitCommand;
    }

    public BuyCommand getBuyCommand() {
        return buyCommand;
    }

    public void setBuyCommand(BuyCommand buyCommand) {
        this.buyCommand = buyCommand;
    }

    public CasinoService() {
        player = new Player(); // 注意避免循环构造
        this.broker = new Broker();
        this.helpCommand = new HelpCommand(this);
        this.cashCommand = new CashCommand(this);
        this.wagerCommand = new WagerCommand(this);
        this.sumCommand = new SumCommand(this);
        this.quitCommand = new QuitCommand(this);
        this.buyCommand = new BuyCommand(this);
    }

    synchronized public Player getPlayer() {
        return player;
    }

    public void takeCommands(String line) {
        if (line.contains("help")) {
            broker.takeCommand(this.getHelpCommand());
        }
        if (line.contains("cash")) {
            broker.takeCommand(this.getCashCommand());
        }
        if (line.contains("wager")) {
            broker.takeCommand(this.getWagerCommand());
        }
        if (line.contains("sum")) {
            broker.takeCommand(this.getSumCommand());
        }
        if (line.contains("quit")) {
            broker.takeCommand(this.getQuitCommand());
        }
        if (line.contains("buy")) {
            broker.takeCommand(this.buyCommand);
        }
    }

    /**
     * 委托执行命令
     *
     * @return 有命令被执行 true，无命令被执行 false
     */
    public boolean placeCommands() {
        return this.getBroker().placeCommands();
    }

    /**
     * 查看帮助
     */
    public void help() {
        System.out.println("- help: view command information");
        System.out.println("- cash: view holding currency");
        System.out.println("- wager: view holding wager");
        System.out.println("    -- sum: calculate the total value of the wager");
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
    public void wager() {
        List<Wager> wagerList;
        /**
         * 处理异常情况
         */
        try {
            wagerList = player.getWagerList();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("[Error] The wager list is null");
            return;
        }
        if (wagerList.isEmpty()) {
            System.out.println("[Info] No wager available");
            return;
        }
        /**
         * 遍历 wager 列表，打印信息
         */
        for (Wager wager : wagerList) {
            List<Jetton> jettonList = wager.getJettonList();
            if (jettonList == null || jettonList.isEmpty())
                continue;
            /**
             * 遍历 jetton 列表，打印信息
             * jetton 可能是 cash 或 chip
             */
            for (Jetton jetton : jettonList) {
                System.out.println(jetton.toString());
            }
        }
    }

    /**
     * 计算赌注的总价值
     */
    public void sum() {
        this.player.sum();
    }

    public void buy() {
        // todo   this.player.buy();
    }
}
