package exp4.CMD;

import exp4.CasinoService;

public class CashCommand implements Command {

    private CasinoService casinoService;

    public CashCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        casinoService.cash();
    }
}
