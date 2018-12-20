package exp4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MillionWager implements Wager {
    private List<Chip> chipList;

    public List<Chip> getChipList() {
        return chipList;
    }

    @Override
    public double totalValue() {
        double res = 0;
        for (Chip chip : chipList) {
            res += chip.getValue();
        }
        return res;
    }

    /**
     * 构造方法
     */
    public MillionWager() {
        this.chipList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++)
            chipList.add(new Chip(100));
    }

    /**
     * 加码
     *
     * @param chip 该赌注增加的筹码
     */
    public void addJetton(Chip chip) {
        this.chipList.add(chip);
    }

    /**
     * 减码
     *
     * @param chip 该赌注移除的筹码
     */
    public void removeJetton(Chip chip) {
        this.chipList.remove(chip);
    }

}
