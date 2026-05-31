package uwu.lopyluna.create_dd.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;
import uwu.lopyluna.create_dd.DesiresCreate;

public class DCommon extends ConfigBase {

    public final DWorldGen worldGen = nested(0, DWorldGen::new, DCommon.Comments.worldGen);

    @Override
    public String getName() {
        return "common";
    }

    private static class Comments {
        static String worldGen = "Modify " + DesiresCreate.NAME + " impact on your terrain";
    }

}
