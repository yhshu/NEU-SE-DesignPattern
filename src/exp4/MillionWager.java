package exp4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MillionWager implements Wager {
    private List<Jetton> jettonList;

    public List<Jetton> getJettonList() {
        return jettonList;
    }

    @Override
    public double totalValue() {
        double res = 0;
        for (Jetton jetton : jettonList) {
            res += jetton.getValue();
        }
        return res;
    }

    @Override
    public Cash exchange() {
        Cash cash = new Cash();
        for (Jetton jetton : jettonList) {
            cash.setValue(cash.getValue() + jetton.exchange().getValue());
        }
        return cash;
    }

    /**
     * 构造方法
     */
    public MillionWager() {
        this.jettonList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++)
            jettonList.add(new Chip(100));
    }

    /**
     * 加码
     *
     * @param chip 该赌注增加的筹码
     */
    public void addJetton(Jetton chip) {
        this.jettonList.add(chip);
    }

    /**
     * 减码
     *
     * @param chip 该赌注移除的筹码
     */
    public void removeJetton(Chip chip) {
        this.jettonList.remove(chip);
    }

}
