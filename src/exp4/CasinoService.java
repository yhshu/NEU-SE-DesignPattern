package exp4;

import java.util.concurrent.locks.Lock;

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
}
