package exp4;

/**
 * 赌场服务
 * Facade
 */
public class CasinoService {
    public volatile static int ID = 0;

    public static void main(String args[]) {

    }

    public static int getID() {
        synchronized (CasinoService.class) {
            int retID = ID;
            ID++;
            return retID;
        }
    }

    /**
     * 打印菜单
     */
    public static void printMenu() {
        System.out.println("Casino>>");
    }
}
