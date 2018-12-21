package exp2;

public class ContactReceiptDecorator extends ReceiptDecorator {
    private String contact = "****************************\n" +
            "14天购物保证。货真价实\n" +
            "东大超市电话83688888\n"; // 联系方式

    public ContactReceiptDecorator(Receipt decoratedReceipt) {
        super(decoratedReceipt);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(contact);
        return sb.toString();
    }
}
