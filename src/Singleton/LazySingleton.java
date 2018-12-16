package Singleton;

public class LazySingleton {
    private volatile static int count = 0;
    private volatile static LazySingleton uniqueInstance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (LazySingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new LazySingleton();
                }
            }
        }

        System.out.println("[Info] The instance of LazySingleton " + uniqueInstance.toString() + " has been got, count = " + (++count));
        return uniqueInstance;
    }
}
