package exp4.Jettons;

public class Cash implements Jetton {
    public static final int USD = 0;

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

    @Override
    public Cash exchange() {
        return this;
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

    public String toString() {
        return "Cash Type: " + getType(this.type) + "; Value: " + this.value;
    }

    private String getType(int type) {
        String ret;
        switch (type) {
            case 0:
                ret = "USD";
                break;
            default:
                ret = "unknown";
                break;
        }
        return ret;
    }
}
