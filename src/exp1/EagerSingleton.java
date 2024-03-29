package exp1;

public class EagerSingleton {
    private volatile static int count = 0;
    private static EagerSingleton uniqueInstance = new EagerSingleton();

    /**
     * 私有构造方法，该类不会被实例化
     */
    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        System.out.println("[Info] The instance of EagerSingleton " + uniqueInstance.toString() + " has been got, count = " + (++count));
        return uniqueInstance;
    }
}
