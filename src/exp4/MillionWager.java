package exp4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MillionWager implements Wager {
    private List<Jetton> jettonList;
    private static int million = 1000000;
    private int unitValue = 100000; // 单个 chip 的价值

    public List<Jetton> getJettonList() {
        return jettonList;
    }

    public int getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }

    @Override
    public double totalValue() {
        double res = 0;
        for (Jetton jetton : jettonList) {
            res += jetton.getValue();
        }
        return res;
    }

    /**
     * 构造方法
     */
    public MillionWager() {
        this.jettonList = new CopyOnWriteArrayList<>();
        int num = million / unitValue; // chip 数量
        for (int i = 0; i < num; i++)
            jettonList.add(new Chip(unitValue));
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
