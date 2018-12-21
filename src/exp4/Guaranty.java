package exp4;

/**
 * 抵押物
 * 例如有形资产
 */
public interface Guaranty {
    /**
     * 兑换
     * @param value 兑换的价值
     * @return 兑换所得货币
     */
    Cash exchange(double value);
}
