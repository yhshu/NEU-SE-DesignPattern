package exp4.CMD;

import exp4.CasinoService;

public class WagerCommand implements Command {
    private CasinoService casinoService;

    public WagerCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        casinoService.wager();
    }
}
