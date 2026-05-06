package uwu.lopyluna.create_dd.infrastructure.ponder;

import com.simibubi.create.AllItems;
import net.createmod.ponder.foundation.PonderTag;
import net.minecraft.world.item.ItemStack;
import uwu.lopyluna.create_dd.DesiresCreate;

public class DesirePonderTags {

	public static final PonderTag DESIRES = new PonderTag(
			DesiresCreate.asResource("create_dd"),
			null,
			new ItemStack(AllItems.PRECISION_MECHANISM.get()),
			new ItemStack(AllItems.PRECISION_MECHANISM.get())
	);

	public static void register() {
		// Add items to tags here

	}

}
