package exp4;

import java.util.HashMap;

/**
 * 筹码工厂
 * 筹码使用了 Flyweight 模式
 */
public class JettonFactory {
    private static final HashMap<String, Chip> jettonMap = new HashMap<>();

    public static Chip getJetton(String ID) {
        Chip chip = jettonMap.get(ID);
        if (chip == null) {
            chip = new Chip(100);
            jettonMap.put(chip.getID(), chip);
        }
        return chip;
    }
}
