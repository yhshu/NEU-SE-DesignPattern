package exp4;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 筹码工厂
 * 筹码使用了 Flyweight 模式
 */
public class ChipFactory {
    private volatile static int ID = 1;
    private static HashMap<String, Chip> chipMap = new HashMap<>();
    private static List<Chip> chipList = new CopyOnWriteArrayList<>();

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
