package uwu.lopyluna.create_dd.registry;

import net.createmod.catnip.lang.LangBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.function.BiConsumer;

import static uwu.lopyluna.create_dd.DesiresCreate.MOD_ID;

@SuppressWarnings({"unused"})
public class DesiresLangPartial {
    public static void provideLang(BiConsumer<String, String> consumer) {
        consume(consumer, "create_dd.recipe.fan_sanding.fan", "Fan behind Sand");
        consume(consumer, "create_dd.recipe.fan_freezing.fan", "Fan behind Powdered Snow");
        consume(consumer, "create_dd.recipe.fan_seething.fan", "Fan behind Super Heated Blaze Burner");
        consume(consumer, "create_dd.recipe.fan_sanding", "Bulk Sanding");
        consume(consumer, "create_dd.recipe.fan_freezing", "Bulk Freezing");
        consume(consumer, "create_dd.recipe.fan_seething", "Bulk Seething");
        consume(consumer, "itemGroup.create_dd.base", "Create: Dreams n' Desires");
        consume(consumer, "itemGroup.create_dd.palettes", "DnDesires Building Blocks");
        consume(consumer, "itemGroup.create_dd.beta", "DnDesires Beta Stuff");
        consume(consumer, "itemGroup.create_dd.classic", "DnDesires Classic Stuff");

    }

    public static MutableComponent translateDirect(String key, Object... args) {
        Object[] args1 = LangBuilder.resolveBuilders(args);
        return Component.translatable(MOD_ID + "." + key, args1);
    }

    private static void consume(BiConsumer<String, String> consumer, String key, String enUS) {
        consumer.accept(key, enUS);
    }
}
