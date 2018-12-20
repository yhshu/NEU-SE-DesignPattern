package exp4;

import java.util.Date;

/**
 * 赌场内筹码
 */
public class Chip implements Jetton {
    private String ID;
    private double value;

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

    public Chip(double value) {
        this.ID = String.valueOf(CasinoService.getID());
        this.value = value;
    }

    public Cash exchange() {
        return new Cash(Cash.USD, value);
    }
}
