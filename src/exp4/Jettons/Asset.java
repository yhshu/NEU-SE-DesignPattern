package exp4.Jettons;

/**
 * 有形资产
 * 可看做筹码，但需要接口转换
 */
public class Asset implements Guaranty, Jetton {
    private static int assetID = 1;
    private int ID;
    private String type;
    private double value;
    private ChipAdapter chipAdapter;

    public int getID() {
        return ID;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Cash exchange() {
        return this.exchange(value);
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

    public Asset(String type, double value) {
        this.type = type;
        this.value = value;
        this.ID = assignID();
        this.chipAdapter = new ChipAdapter();
    }

    synchronized public int assignID() {
        int ret = assetID;
        assetID++;
        return ret;
    }

    @Override
    public Cash exchange(double value) {
        return chipAdapter.exchange(value);
    }

    public String toString() {
        return "Asset ID: " + this.ID + " Type: " + this.type + " Value: " + this.value;
    }
}
