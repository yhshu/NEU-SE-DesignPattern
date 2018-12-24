package exp4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player {
    private String nickname = "player";
    private List<Wager> wagerList; // 赌注
    private List<Cash> cashList; // 货币
    private List<Asset> assetList;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Wager> getWagerList() {
        return wagerList;
    }

    public List<Cash> getCashList() {
        return cashList;
    }

    /**
     * 构造方法
     */
    public Player() {
        this.wagerList = new CopyOnWriteArrayList<>();
        this.cashList = new CopyOnWriteArrayList<>();
        this.assetList = new CopyOnWriteArrayList<>();
        // 玩家初始资产
        cashList.add(new Cash(Cash.USD, 1e6));
        wagerList.add(new MillionWager());
    }

    /**
     * 支付
     *
     * @param cash 支付所用货币
     */
    public void pay(Cash cash) {
// todo
    }

    public void sum() {
        double res = 0;
        try {
            List<Wager> wagerList = this.getWagerList();
            for (Wager wager : wagerList) {
                List<Jetton> jettonList = wager.getJettonList();
                for (Jetton jetton : jettonList) {
                    res += jetton.getValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[Error] Wager summation exception");
        }
        System.out.println("Player: " + this.nickname + "; Sum of wagers:" + res);
    }
}
