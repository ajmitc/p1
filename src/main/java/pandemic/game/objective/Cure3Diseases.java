package pandemic.game.objective;

import pandemic.util.ImageUtil;

public class Cure3Diseases extends Objective{

    public Cure3Diseases(){
        super("Cure the 3 non-Coda Diseases", ImageUtil.get(""));
        setMandatory(true);
    }
}
