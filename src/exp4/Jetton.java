package exp4;

import java.util.Date;

/**
 * 筹码
 */
public class Jetton {
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

    public Jetton(int value) {
        this.ID = String.valueOf(CasinoService.getID());
        this.value = value;
    }
}
