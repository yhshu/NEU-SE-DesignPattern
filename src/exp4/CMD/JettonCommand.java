package exp4.CMD;

import exp4.CasinoService;

public class JettonCommand implements Command {
    private CasinoService casinoService;

    public JettonCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        this.casinoService.jetton();
    }
}
