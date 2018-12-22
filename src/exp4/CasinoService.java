package exp4;

/**
 * 赌场服务
 * Facade
 */
public class CasinoService {
    public volatile int ID = 0;

    public int getID() {
        synchronized (CasinoService.class) {
            int retID = ID;
            ID++;
            return retID;
        }
    }

    public void setID(int ID) {
        synchronized (CasinoService.class) {
            this.ID = ID;
        }
    }

    /**
     * 查看帮助
     */
    public void help() {
        System.out.println("- help 帮助");
        System.out.println("- cash 查看持有货币");
        System.out.println("- wager 查看持有赌注");
        System.out.println("- quit 退出");
    }

    /**
     * 退出程序
     */
    public void quit() {
        System.out.println("Good bye!");
        System.exit(0);
    }

    /**
     * 查看持有货币
     */
    public void cash() {

    }
}
