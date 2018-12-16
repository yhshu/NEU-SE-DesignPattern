package Singleton;

import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        int threadNum = 10;
        for (int i = 1; i <= threadNum; i++) {
            ClientThread clientThread = new ClientThread("thread-" + i);
            clientThread.start();
        }
    }
}
