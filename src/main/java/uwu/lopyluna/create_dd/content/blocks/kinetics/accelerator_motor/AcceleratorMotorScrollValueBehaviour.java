package uwu.lopyluna.create_dd.content.blocks.kinetics.accelerator_motor;

import com.google.common.collect.ImmutableList;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueSettingsBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueSettingsBoard;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueSettingsFormatter;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueBehaviour;
import com.simibubi.create.foundation.utility.CreateLang;
import uwu.lopyluna.create_dd.registry.helper.Lang;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;

public class AcceleratorMotorScrollValueBehaviour extends ScrollValueBehaviour {
    public AcceleratorMotorScrollValueBehaviour(Component label, SmartBlockEntity be, ValueBoxTransform slot) {
        super(label, be, slot);
        this.withFormatter((v) -> {
            return String.valueOf(Math.abs(v));
        });
    }

    public ValueSettingsBoard createBoard(Player player, BlockHitResult hitResult) {
        ImmutableList<Component> rows = ImmutableList.of(Component.literal("⟳").withStyle(ChatFormatting.BOLD), Component.literal("⟲").withStyle(ChatFormatting.BOLD));
        ValueSettingsFormatter formatter = new ValueSettingsFormatter(this::formatSettings);
        return new ValueSettingsBoard(this.label, 256, 32, rows, formatter);
    }

    public void setValueSettings(Player player, ValueSettingsBehaviour.ValueSettings valueSetting, boolean ctrlHeld) {
        int value = Math.max(1, valueSetting.value());
        if (!valueSetting.equals(this.getValueSettings())) {
            this.playFeedbackSound(this);
        }

        this.setValue(valueSetting.row() == 0 ? -value : value);
    }

    public ValueSettingsBehaviour.ValueSettings getValueSettings() {
        return new ValueSettingsBehaviour.ValueSettings(this.value < 0 ? 0 : 1, Math.abs(this.value));
    }

    public MutableComponent formatSettings(ValueSettingsBehaviour.ValueSettings settings) {
        return CreateLang.number(Math.max(1, Math.abs(settings.value()))).add(Lang.builder().text(settings.row() == 0 ? "⟳" : "⟲").style(ChatFormatting.BOLD)).component();
    }

    public String getClipboardKey() {
        return "Speed";
    }
}