package exp4.Exchange;

import exp4.Jettons.Cash;

/**
 * 抵押物兑换货币的算法
 */
public interface ExchangeStrategy {
    Cash operate(Object object);
}
