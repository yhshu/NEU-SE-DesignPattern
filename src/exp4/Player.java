package exp4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player {
    private List<Wager> wagerList; // 赌注

    public List<Wager> getWagerList() {
        return wagerList;
    }

    /**
     * 构造方法
     */
    public Player() {
        this.wagerList = new CopyOnWriteArrayList<>();
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
