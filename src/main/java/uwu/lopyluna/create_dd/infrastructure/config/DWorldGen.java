package uwu.lopyluna.create_dd.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;
import uwu.lopyluna.create_dd.DesiresCreate;

public class DWorldGen extends ConfigBase {

    public final ConfigBase.ConfigBool disable = b(false, "disableWorldGen", DWorldGen.Comments.disable);

    @Override
    public String getName() {
        return "worldgen";
    }

    private static class Comments {
        static String disable = "Prevents all worldgen added by " + DesiresCreate.NAME + " from taking effect";
    }

}
