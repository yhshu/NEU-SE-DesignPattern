package Singleton;

public class ClientThread implements Runnable {
    private Thread thread;
    private String threadName;

    ClientThread(String name) {
        threadName = name;
        System.out.println("[Info] Thread #" + name + " has been created");
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (ClientThread.class) {
                System.out.println("========== Singleton " + threadName + " test " + i + " ==========");
                EagerSingleton.getInstance();
                LazySingleton.getInstance();
            }
        }
    }

    public void start() {
        System.out.println("[Info] Starting thread " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
