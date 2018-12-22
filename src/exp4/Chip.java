package exp4;


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
        this.ID = String.valueOf(Client.getCasinoService().getID());
        this.value = value;
    }

    public Cash exchange() {
        return exchangeStrategy.operate(this);
    }
}
