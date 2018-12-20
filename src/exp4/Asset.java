package exp4;

/**
 * 有形资产
 * 可看做筹码，但需要接口转换
 */
public class Asset {
    private String type;
    private double value;

    public Asset(String type, double value) {
        this.type = type;
        this.value = value;
    }
}
