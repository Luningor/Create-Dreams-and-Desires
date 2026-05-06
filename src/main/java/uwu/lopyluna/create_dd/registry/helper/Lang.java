package uwu.lopyluna.create_dd.registry.helper;

import net.createmod.catnip.lang.LangBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import uwu.lopyluna.create_dd.DesiresCreate;

import static net.createmod.catnip.lang.LangBuilder.resolveBuilders;

public class Lang extends net.createmod.catnip.lang.Lang {

    public static MutableComponent translateDirect(String key, Object... args) {
        return Component.translatable(DesiresCreate.MOD_ID + "." + key, resolveBuilders(args));
    }

    public static LangBuilder builder() {
        return new LangBuilder(DesiresCreate.MOD_ID);
    }
}
