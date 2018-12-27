package exp4.Jettons;

/**
 * 筹码
 * Chip, Cash 或 Asset
 */
public interface Jetton {

    double getValue();

    Cash exchange();

    String toString();
}
