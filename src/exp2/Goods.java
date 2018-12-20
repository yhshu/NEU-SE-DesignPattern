package exp2;

public class Goods {
    private String name; // 商品名称
    private int num; // 商品数量
    private double unitPrice; // 单价

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Goods(String name, int num, double unitPrice) {
        this.name = name;
        this.num = num;
        this.unitPrice = unitPrice;
    }

    public String toString() {
        return name + " x" + num + "\t\t\t" + unitPrice;
    }
}
