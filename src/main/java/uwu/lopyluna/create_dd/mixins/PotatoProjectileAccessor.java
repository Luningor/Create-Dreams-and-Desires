package uwu.lopyluna.create_dd.mixins;

import com.simibubi.create.content.equipment.potatoCannon.PotatoProjectileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = PotatoProjectileEntity.class, remap = false)
public interface PotatoProjectileAccessor {
    @Accessor("recoveryChance")
    void setRecoveryChance(float value);
}