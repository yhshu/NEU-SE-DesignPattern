package exp4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player {
    private List<MillionWager> wagerList; // 赌注

    public List<MillionWager> getWagerList() {
        return wagerList;
    }

    public void setWagerList(List<MillionWager> wagerList) {
        this.wagerList = wagerList;
    }

    /**
     * 构造方法
     */
    public Player() {
        this.wagerList = new CopyOnWriteArrayList<>();
    }
}
