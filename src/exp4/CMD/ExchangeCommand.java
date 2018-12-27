package exp4.CMD;

import exp4.CasinoService;

public class ExchangeCommand implements Command {
    private CasinoService casinoService;

    public ExchangeCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        casinoService.exchange();
    }
}
