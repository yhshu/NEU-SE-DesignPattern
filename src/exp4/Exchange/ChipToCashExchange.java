package exp4.Exchange;

import exp4.Cash;
import exp4.Chip;

public class ChipToCashExchange implements ExchangeStrategy {

    @Override
    public Cash operate(Object object) {
        Chip chip = (Chip) object;
        return new Cash(Cash.USD, chip.getValue());
    }
}
