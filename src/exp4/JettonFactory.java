package exp4;

import java.util.HashMap;

/**
 * 筹码工厂
 * 筹码使用了 Flyweight 模式
 */
public class JettonFactory {
    private static final HashMap<String, Jetton> jettonMap = new HashMap<>();

    public static Jetton getJetton(String ID) {
        Jetton jetton = jettonMap.get(ID);
        if (jetton == null) {
            jetton = new Jetton(100);
            jettonMap.put(jetton.getID(), jetton);
        }
        return jetton;
    }
}
