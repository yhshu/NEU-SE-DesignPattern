package exp4.Wagers;

import exp4.Jettons.Chip;
import exp4.Jettons.Jetton;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MillionWager implements Wager {
    private List<Jetton> jettonList;
    public final static int million = 1000000;
    private int unitValue = 100000; // 单个 chip 的价值

    public List<Jetton> getJettonList() {
        return jettonList;
    }

    @Override
    public void add(Jetton jetton) {
        this.jettonList.add(jetton);
    }

    @Override
    public void remove(Jetton jetton) {
        this.jettonList.remove(jetton);
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
}
