package uwu.lopyluna.create_dd.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;
import org.jetbrains.annotations.NotNull;

public class DClient extends ConfigBase {

	public final ConfigGroup client = group(0, "client",
			Comments.client);

	// custom fluid fog
	public final ConfigGroup fluidFogSettings = group(1, "fluidFogSettings", Comments.fluidFogSettings);
    public final ConfigFloat condense_milkTransparencyMultiplier =
            f(1, .125f, 128, "condense_milk", Comments.condense_milkTransparencyMultiplier);
    public final ConfigFloat creamTransparencyMultiplier =
            f(1, .125f, 128, "cream", Comments.creamTransparencyMultiplier);
    public final ConfigFloat vanillaTransparencyMultiplier =
            f(1, .125f, 128, "vanilla", Comments.vanillaTransparencyMultiplier);
    public final ConfigFloat vanilla_milkshakeTransparencyMultiplier =
            f(1, .125f, 128, "vanilla_milkshake", Comments.vanilla_milkshakeTransparencyMultiplier);
    public final ConfigFloat strawberryTransparencyMultiplier =
            f(1, .125f, 128, "strawberry", Comments.strawberryTransparencyMultiplier);
    public final ConfigFloat strawberry_milkshakeTransparencyMultiplier =
            f(1, .125f, 128, "strawberry_milkshake", Comments.strawberry_milkshakeTransparencyMultiplier);
    public final ConfigFloat glowberryTransparencyMultiplier =
            f(1, .125f, 128, "glowberry", Comments.glowberryTransparencyMultiplier);
    public final ConfigFloat glowberry_milkshakeTransparencyMultiplier =
            f(1, .125f, 128, "glowberry_milkshake", Comments.glowberry_milkshakeTransparencyMultiplier);
    public final ConfigFloat caramelTransparencyMultiplier =
            f(1, .125f, 128, "caramel", Comments.caramelTransparencyMultiplier);
    public final ConfigFloat caramel_milkshakeTransparencyMultiplier =
            f(1, .125f, 128, "caramel_milkshake", Comments.caramel_milkshakeTransparencyMultiplier);
    public final ConfigFloat hot_chocolateTransparencyMultiplier =
            f(1, .125f, 128, "hot_chocolate", Comments.hot_chocolateTransparencyMultiplier);
    public final ConfigFloat chocolate_milkshakeTransparencyMultiplier =
            f(1, .125f, 128, "chocolate_milkshake", Comments.chocolate_milkshakeTransparencyMultiplier);
    public final ConfigFloat sapTransparencyMultiplier =
            f(1, .125f, 128, "sap", Comments.sapTransparencyMultiplier);
    public final ConfigFloat chromatic_wasteTransparencyMultiplier =
            f(1, .125f, 128, "chromatic_waste", Comments.chromatic_wasteTransparencyMultiplier);
    public final ConfigFloat shimmerTransparencyMultiplier =
            f(1, .125f, 128, "shimmer", Comments.shimmerTransparencyMultiplier);

	//ponder group
	public final ConfigGroup ponder = group(1, "ponder",
			Comments.ponder);

	@Override
	public @NotNull String getName() {
		return "client";
	}

	private static class Comments {
		static String client = "Client-only settings - If you're looking for general settings, look inside your worlds serverconfig folder!";

		static String ponder = "Ponder settings";
        static String fluidFogSettings = "Configure your vision range when submerged in Create Dream n' Desire's custom fluids";
        static String condense_milkTransparencyMultiplier = "The vision range through condense milk will be multiplied by this factor";
        static String creamTransparencyMultiplier = "The vision range through cream will be multiplied by this factor";
        static String vanillaTransparencyMultiplier = "The vision range through vanilla will be multiplied by this factor";
        static String vanilla_milkshakeTransparencyMultiplier = "The vision range through vanilla milkshake will be multiplied by this factor";
        static String strawberryTransparencyMultiplier = "The vision range through strawberry will be multiplied by this factor";
        static String strawberry_milkshakeTransparencyMultiplier = "The vision range through strawberry milkshake will be multiplied by this factor";
        static String glowberryTransparencyMultiplier = "The vision range through glowberry will be multiplied by this factor";
        static String glowberry_milkshakeTransparencyMultiplier = "The vision range through glowberry milkshake will be multiplied by this factor";
        static String caramelTransparencyMultiplier = "The vision range through caramel will be multiplied by this factor";
        static String caramel_milkshakeTransparencyMultiplier = "The vision range through caramel milkshake will be multiplied by this factor";
        static String hot_chocolateTransparencyMultiplier = "The vision range through hot chocolate will be multiplied by this factor";
        static String chocolate_milkshakeTransparencyMultiplier = "The vision range through chocolate milkshake will be multiplied by this factor";
        static String sapTransparencyMultiplier = "The vision range through sap will be multiplied by this factor";
        static String chromatic_wasteTransparencyMultiplier = "The vision range through chromatic waste will be multiplied by this factor";
        static String shimmerTransparencyMultiplier = "The vision range through shimmer will be multiplied by this factor";
	}

}
