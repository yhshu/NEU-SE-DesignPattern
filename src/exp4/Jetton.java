package exp4;

/**
 * 筹码
 */
public interface Jetton {

    double getValue();

    Cash exchange();

    String toString();
}
