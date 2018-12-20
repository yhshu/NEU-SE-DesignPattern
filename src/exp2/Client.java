package exp2;

import java.util.Scanner;

public class Client {
    public static void printMenu() {
        System.out.println("============================");
        System.out.println("1. 联系方式");
        System.out.println("2. 温馨提示");
        System.out.println("============================");
        System.out.print("请输入小票项目序号：");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            String line = sc.nextLine();
            if (line.equals("quit")) {
                break;
            }

            System.out.print("\n\n\n");
            Receipt receipt = getReceipt();
            char[] chars = line.toCharArray();
            for (char ch : chars) {
                int choice = ch - '0';
                switch (choice) {
                    case 1:
                        receipt = new ContactReceiptDecorator(receipt);
                        break;
                    case 2:
                        receipt = new NotesReceiptDecorator(receipt);
                        break;
                    default:
                        break;
                }
            }
            System.out.println(receipt.toString());
        }
    }

    public static Receipt getReceipt() {
        Receipt receipt = new ReceiptImpl();
        receipt.getGoodsList().add(new Goods("可乐330ml", 2, 2.5));
        receipt.getGoodsList().add(new Goods("面包230g", 4, 4));
        return receipt;
    }
}
