package exp4;

import exp4.Jettons.*;
import exp4.Wagers.MillionWager;
import exp4.Wagers.Wager;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player {
    private String nickname = "player"; // 昵称
    private List<Jetton> jettonList;    // 筹码
    private List<Cash> cashList;        // 货币
    private List<Wager> wagerList;      // 赌注
    private List<Asset> assetList;      // 有形资产

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Wager> getWagerList() {
        return wagerList;
    }

    public List<Cash> getCashList() {
        return cashList;
    }

    public double cashSum() {
        double res = 0;
        if (cashList == null || cashList.isEmpty())
            return 0;
        for (Cash cash : cashList) {
            res += cash.getValue();
        }
        return res;
    }

    public List<Jetton> getJettonList() {
        return jettonList;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    /**
     * 构造方法
     */
    public Player() {
        this.jettonList = new CopyOnWriteArrayList<>();
        this.wagerList = new CopyOnWriteArrayList<>();
        this.cashList = new CopyOnWriteArrayList<>();
        this.assetList = new CopyOnWriteArrayList<>();
        // 玩家初始资产
        cashList.add(new Cash(Cash.USD, 1e6));
        for (int i = 0; i < 10; i++) {
            Chip chip = ChipFactory.getChip(String.valueOf(ChipFactory.getID()));
            chip.setValue(100000);
            jettonList.add(chip);
        }
        wagerList.add(new MillionWager());
        assetList.add(new Asset("WATCH", 108888));
    }

    public boolean spendCash(double value) {
        if (cashSum() < value) { // 如果当前拥有的现金不足以支付
            System.out.println("[Info] Sorry, dear " + this.nickname + ", your current cash is not enough to pay");
            return false;
        }
        // 如果当前拥有的现金足够支付
        Iterator<Cash> cashIterator = cashList.iterator();
        double deduction = 0;
        while (cashIterator.hasNext()) {
            Cash cash = cashIterator.next();
            double delta = value - deduction;
            if (deduction == value)
                break;
            else if (deduction > value) {
                System.out.println("[Error] Serious mistakes in payment"); // 这条消息出现时应当 debug
                return false;
            } else { // 继续扣除
                if (delta > cash.getValue()) {
                    deduction += cash.getValue();
                    cash.setValue(0);
                } else {
                    cash.setValue(cash.getValue() - delta);
                    deduction += delta;
                    break;
                }
            }
        }
        System.out.println("[Info] Player " + this.nickname + " consumed $" + value);
        if (deduction != value) {
            System.out.println("[Error] Serious mistakes in payment"); // 这条消息出现时应当 debug
            return false;
        }
        return true;
    }

    /**
     * 是否拥有某一筹码
     *
     * @param num 筹码编号
     * @return 有 true，没有 false
     */
    public boolean hasChip(int num) {
        for (Jetton jetton : jettonList) {
            if (jetton instanceof Chip) {
                if (((Chip) jetton).getID().equals(String.valueOf(num))) {
                    return true;
                }
            }
        }
        return false;
    }

    public Chip getChip(int num) {
        for (Jetton jetton : jettonList) {
            if (jetton instanceof Chip) {
                if (((Chip) jetton).getID().equals(String.valueOf(num))) {
                    return (Chip) jetton;
                }
            }
        }
        return null;
    }

    public Asset getAsset(int num) {
        for (Asset asset : assetList) {
            if (asset.getID() == num) {
                return asset;
            }
        }
        return null;
    }

    public boolean addCash(Cash cash) {
        try {
            if (this.getCashList().isEmpty()) {
                // 如果玩家当前没有货币
                cashList.add(cash);
            } else {
                boolean add = false;
                // 如果当前玩家持有货币
                for (Cash c : cashList) {
                    if (c.getType() == cash.getType()) {
                        c.setValue(c.getValue() + cash.getValue());
                        add = true;
                    }
                }
                if (!add) {
                    cashList.add(cash);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addChip(Chip chip) {
        try {
            if (this.hasChip(Integer.parseInt(chip.getID())))
                return true;
            jettonList.add(chip);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void addWager(Wager wager) {
        this.wagerList.add(wager);
    }
}
