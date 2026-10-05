package dev.agentclover.mixin.restrictions;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class DisableJumpMixin {

    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void onJump(CallbackInfo ci) {
        if ((Object) this instanceof PlayerEntity player) {
            /*
            Weird code, but basically to avoid long lines of code I don't really understand,
            I realized that Survival + Adventure
             */
            if (!player.getAbilities().allowFlying) {
                ci.cancel();
            }
        }
    }
}
