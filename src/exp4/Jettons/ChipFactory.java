package exp4.Jettons;

import java.util.HashMap;

/**
 * 筹码工厂
 * 筹码使用了 Flyweight 模式
 */
public class ChipFactory {
    private volatile static int ID = 1;
    private static HashMap<String, Chip> chipMap = new HashMap<>();

    private ChipFactory() { // 享元工厂私有构造方法
    }

    public static Chip getChip(String ID) {
        Chip chip = chipMap.get(ID);
        if (chip == null) {
            chip = new Chip(100);
            chipMap.put(chip.getID(), chip);
        }
        return chip;
    }

    /**
     * 创建 Chip 时获取的编号
     *
     * @return Chip 唯一标识符
     */
    synchronized public static int getID() {
        int retID = ID;
        ID++;
        return retID;
    }
}
