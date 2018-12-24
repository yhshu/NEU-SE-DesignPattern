package exp4.CMD;

import exp4.CasinoService;

public class SumCommand implements Command {
    private CasinoService casinoService;

    public SumCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        casinoService.sum();
    }
}
