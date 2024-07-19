package hu.ysty04.darkring.mixin;

import com.bobmowzie.mowziesmobs.server.item.ItemGlowingJelly;
import com.bobmowzie.mowziesmobs.server.item.ItemHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(ItemGlowingJelly.class)
public abstract class ItemGlowingJellyMixin {

    @Inject(method = "appendHoverText", at = @At("RETURN"))
    private void appendAdditionalHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn, CallbackInfo ci) {
        System.out.println("Debug: appendHoverText called");
        tooltip.add(Component.translatable("item.mowziesmobs.glowing_jelly.text.1").setStyle(ItemHandler.TOOLTIP_STYLE));
        tooltip.add(Component.translatable("item.mowziesmobs.glowing_jelly.text.2").setStyle(ItemHandler.TOOLTIP_STYLE));
        tooltip.add(Component.translatable("item.mowziesmobs.glowing_jelly.text.3").setStyle(ItemHandler.TOOLTIP_STYLE));
        tooltip.add(Component.translatable("item.mowziesmobs.glowing_jelly.text.4").setStyle(ItemHandler.TOOLTIP_STYLE));
    }
}
