package exp1;

public class LazySingleton {
    private volatile static int count = 0;
    private volatile static LazySingleton uniqueInstance;

    /**
     * 私有构造方法，该类不会被实例化
     */
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
