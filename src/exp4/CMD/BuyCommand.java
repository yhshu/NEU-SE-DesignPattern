package exp4.CMD;

import exp4.CasinoService;

public class BuyCommand implements Command {

    private CasinoService casinoService;

    public BuyCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        casinoService.buy();
    }
}
