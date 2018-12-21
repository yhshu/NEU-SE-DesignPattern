package exp4;

/**
 * 有形资产
 * 可看做筹码，但需要接口转换
 */
public class Asset implements Guaranty {
    private String type;
    private double value;
    private ChipAdapter chipAdapter;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Asset(String type) {
        this.type = type;
        this.chipAdapter = new ChipAdapter();
    }

    @Override
    public Cash exchange() {
        return chipAdapter.exchange(this);
    }
}
