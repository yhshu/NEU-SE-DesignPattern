package exp4.CMD;

import exp4.CasinoService;

public class AssetCommand implements Command {
    private CasinoService casinoService;

    public AssetCommand(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @Override
    public void execute() {
        this.casinoService.asset();
    }
}
