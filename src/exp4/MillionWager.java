package exp4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MillionWager implements Wager {
    private List<Jetton> jettonList;

    public List<Jetton> getJettonList() {
        return jettonList;
    }

    /**
     * 构造方法
     */
    public MillionWager() {
        this.jettonList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++)
            jettonList.add(new Jetton(100));
    }

    /**
     * 加码
     *
     * @param jetton 该赌注增加的筹码
     */
    public void addJetton(Jetton jetton) {
        this.jettonList.add(jetton);
    }

    /**
     * 减码
     *
     * @param jetton 该赌注移除的筹码
     */
    public void removeJetton(Jetton jetton) {
        this.jettonList.remove(jetton);
    }

}
