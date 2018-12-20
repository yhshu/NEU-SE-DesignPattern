package exp2;

import java.util.List;

public class NotesReceiptDecorator extends ReceiptDecorator {
    private String notes = "****************************\n" +
            "货物售出概不退款\n" +
            "保护环境，请勿随意丢弃\n"; // 提示

    public NotesReceiptDecorator(Receipt receipt) {
        super(receipt);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(notes);
        return sb.toString();
    }
}
