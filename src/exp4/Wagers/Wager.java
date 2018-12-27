package exp4.Wagers;

import exp4.Jettons.Jetton;

import java.util.List;

public interface Wager {
    List<Jetton> getJettonList();

    void add(Jetton jetton);

    void remove(Jetton jetton);

    double totalValue();
}
