package exp4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player {
    private List<Wager> wagerList; // 赌注
    private List<Cash> cashList; // 货币

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
    }

    /**
     * 支付
     *
     * @param cash 支付所用货币
     */
    public void pay(Cash cash) {
// todo
    }
}
