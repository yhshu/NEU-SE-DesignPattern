package exp4;


import exp4.Exchange.ChipToCashExchange;
import exp4.Exchange.ExchangeStrategy;

/**
 * 赌场内筹码
 */
public class Chip implements Jetton {
    private String ID;
    private double value;
    private ExchangeStrategy exchangeStrategy;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setExchangeStrategy(ExchangeStrategy exchangeStrategy) {
        this.exchangeStrategy = exchangeStrategy;
    }

    public Chip(double value) {
        try {
            this.ID = String.valueOf(ChipFactory.getID()); // 获取自增 ID
            this.value = value;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[Error] Chip initialization exception");
        }
        exchangeStrategy = new ChipToCashExchange();
    }

    public Cash exchange() {
        return exchangeStrategy.operate(this);
    }

    public String toString() {
        return "Chip ID: " + this.ID + "; Value: " + this.value;
    }
}
