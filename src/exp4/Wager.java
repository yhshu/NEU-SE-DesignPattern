package exp4;

import java.util.List;

public interface Wager {
    List<Jetton> getJettonList();

    double totalValue();

    Cash exchange();
}
