package uwu.lopyluna.create_dd.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.create_dd.DesiresCreate;

public class DesiresSoundEvents {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
			DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DesiresCreate.MOD_ID);

	public static RegistryObject<SoundEvent> CREATVEDITE_BREAK = registerSoundEvent("creatvedite_break");
	public static RegistryObject<SoundEvent> CREATVEDITE_STEP = registerSoundEvent("creatvedite_step");
	public static RegistryObject<SoundEvent> CREATVEDITE_PLACE = registerSoundEvent("creatvedite_place");
	public static RegistryObject<SoundEvent> CREATVEDITE_HIT = registerSoundEvent("creatvedite_hit");
	public static RegistryObject<SoundEvent> CREATVEDITE_FALL = registerSoundEvent("creatvedite_fall");

    public static RegistryObject<SoundEvent> ORE_STONE_BREAK = registerSoundEvent("ore_stone_break");
    public static RegistryObject<SoundEvent> ORE_STONE_STEP = registerSoundEvent("ore_stone_step");
    public static RegistryObject<SoundEvent> ORE_STONE_PLACE = registerSoundEvent("ore_stone_place");
    public static RegistryObject<SoundEvent> ORE_STONE_HIT = registerSoundEvent("ore_stone_hit");
    public static RegistryObject<SoundEvent> ORE_STONE_FALL = registerSoundEvent("ore_stone_fall");

    public static RegistryObject<SoundEvent> MAGIC_CASING_BREAK = registerSoundEvent("magic_casing_break");
    public static RegistryObject<SoundEvent> MAGIC_CASING_STEP = registerSoundEvent("magic_casing_step");
    public static RegistryObject<SoundEvent> MAGIC_CASING_PLACE = registerSoundEvent("magic_casing_place");
    public static RegistryObject<SoundEvent> MAGIC_CASING_HIT = registerSoundEvent("magic_casing_hit");
    public static RegistryObject<SoundEvent> MAGIC_CASING_FALL = registerSoundEvent("magic_casing_fall");

    public static RegistryObject<SoundEvent> MAGICAL_METAL_BREAK = registerSoundEvent("magical_metal_break");
    public static RegistryObject<SoundEvent> MAGICAL_METAL_STEP = registerSoundEvent("magical_metal_step");
    public static RegistryObject<SoundEvent> MAGICAL_METAL_PLACE = registerSoundEvent("magical_metal_place");
    public static RegistryObject<SoundEvent> MAGICAL_METAL_HIT = registerSoundEvent("magical_metal_hit");
    public static RegistryObject<SoundEvent> MAGICAL_METAL_FALL = registerSoundEvent("magical_metal_fall");

    public static RegistryObject<SoundEvent> SHIMMER_FILL = registerSoundEvent("shimmer_fill");
    public static RegistryObject<SoundEvent> SHIMMER_EMPTY = registerSoundEvent("shimmer_empty");

    public static RegistryObject<SoundEvent> RUBBER_BREAK = registerSoundEvent("rubber_break");
	public static RegistryObject<SoundEvent> RUBBER_PLACE = registerSoundEvent("rubber_place");

    public static RegistryObject<SoundEvent> MUSIC_DISC_WALTZ_OF_THE_FLOWERS = registerSoundEvent("music_disc.waltz_of_the_flowers");

	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DesiresCreate.MOD_ID, name)));
	}

	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
