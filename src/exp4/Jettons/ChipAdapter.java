package exp4.Jettons;

/**
 * 筹码适配器
 * 将有形资产（Asset）作为筹码（Chip）使用
 */
public class ChipAdapter implements Guaranty {

    @Override
    public Cash exchange(double value) {
        int count = (int) value / 100;
        Cash cash = new Cash();
        for (int i = 0; i < count; i++) {
            Chip chip = new Chip(100);
            cash.setValue(cash.getValue() + chip.exchange().getValue());
        }
        return cash;
    }
}
