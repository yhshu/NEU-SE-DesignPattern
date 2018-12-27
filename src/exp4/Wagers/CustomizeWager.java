package exp4.Wagers;

import exp4.Jettons.Jetton;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomizeWager implements Wager {
    private List<Jetton> jettonList;

    @Override
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
    public CustomizeWager(List<Jetton> addJettonList) {
        if (addJettonList == null)
            this.jettonList = new CopyOnWriteArrayList<>();
        this.jettonList = addJettonList;
    }
}
