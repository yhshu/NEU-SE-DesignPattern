package exp2;

import java.util.List;

public abstract class ReceiptDecorator implements Receipt {
    private Receipt receipt;

    public String toString() {
        return receipt.toString();
    }

    public ReceiptDecorator(Receipt receipt) {
        this.receipt = receipt;
    }

    @Override
    public List<Goods> getGoodsList() {
        return receipt.getGoodsList();
    }
}
