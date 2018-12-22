package exp4.CMD;

import exp4.CasinoService;

public class HelpCommand implements Command {
    private CasinoService casinoService;

    public HelpCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        casinoService.help();
    }
}
