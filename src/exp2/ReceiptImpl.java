package exp2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReceiptImpl implements Receipt {
    private String supermarket = "\t东北大学超市\n" +
            "----------------------------\n";

    private final List<Goods> goodsList; // 商品

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public ReceiptImpl() {
        goodsList = new CopyOnWriteArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(supermarket);
        double totalPrice = 0;
        for (Goods goods : goodsList) {
            sb.append(goods.toString()).append("\n");
            totalPrice += goods.getUnitPrice() * goods.getNum();
        }
        sb.append("\n").append("合计(人民币)\t\t\t").append(totalPrice).append("\n");
        return sb.toString();
    }

}
