package exp4;

/**
 * 赌注工厂
 * 用于创建赌注
 */
public class WagerFactory {
    public MillionWager getWager(String wagerType) {
        if (wagerType == null)
            return null;
        if (wagerType.equalsIgnoreCase("million"))
            return new MillionWager();
        return null;
    }
}
