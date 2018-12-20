package exp4;

import java.util.List;

public interface Wager {
    List<Chip> getChipList();

    double totalValue();
}
