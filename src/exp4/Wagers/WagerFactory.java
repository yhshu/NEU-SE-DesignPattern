package exp4.Wagers;

import exp4.Jettons.Jetton;

import java.util.List;

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

    public CustomizeWager getWager(List<Jetton> jettonList) {
        if (jettonList == null || jettonList.isEmpty())
            return null;
        return new CustomizeWager(jettonList);
    }
}
