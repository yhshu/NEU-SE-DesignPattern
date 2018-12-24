package exp4;

import java.util.List;

/**
 * 赌场服务
 * Facade
 */
public class CasinoService {
    private volatile int ID = 0;
    private Player player;

    public CasinoService() {
        player = new Player(); // 注意避免循环构造
    }

    synchronized public Player getPlayer() {
        return player;
    }

    /**
     * 查看帮助
     */
    public void help() {
        System.out.println("- help 帮助");
        System.out.println("- cash 查看持有货币");
        System.out.println("- wager 查看持有赌注");
        System.out.println("    -- sum 计算赌注总价值");
        System.out.println("- quit 退出");
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
}
