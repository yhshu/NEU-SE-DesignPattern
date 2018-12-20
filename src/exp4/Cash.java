package exp4;

public class Cash implements Jetton {
    public static final int USD = 0;
    public static final int RMB = 0;

    private int type; // 货币种类
    private double value; // 数值

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Cash(int type, double value) {
        this.type = type;
        this.value = value;
    }

    public Cash() {
        this.type = USD;
        this.value = 0;
    }
}
