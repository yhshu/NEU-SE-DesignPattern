package exp4;

/**
 * 抵押物
 * 例如有形资产
 */
public interface Guaranty {
    /**
     * 兑换
     *
     * @return 获得货币
     */
    Cash exchange(double value);
}
