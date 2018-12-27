package exp4.CMD;

import exp4.CasinoService;

public class BetCommand implements Command {
    private CasinoService casinoService;

    public BetCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        this.casinoService.bet();
    }
}
