package exp4.CMD;

import exp4.CasinoService;

public class QuitCommand implements Command {
    private CasinoService casinoService;

    public QuitCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        casinoService.quit();
    }
}
