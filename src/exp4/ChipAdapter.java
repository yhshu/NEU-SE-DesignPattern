package exp4;

import exp4.Exchange.ExchangeStrategy;

/**
 * 筹码适配器
 * 将有形资产（Asset）作为筹码（Chip）使用
 */
public class ChipAdapter implements Guaranty {

    private ExchangeStrategy exchangeStrategy;

    public void setExchangeStrategy(ExchangeStrategy exchangeStrategy) {
        this.exchangeStrategy = exchangeStrategy;
    }


    public Cash exchange(Asset asset) {
        int count = (int) asset.getValue() / 100;
        Cash cash = new Cash();
        for (int i = 0; i < count; i++) {
            Chip chip = new Chip(100);
            cash.setValue(cash.getValue() + chip.exchange().getValue());
        }
        return cash;
    }

    @Override
    public Cash exchange() {
        return null;
    }
}
