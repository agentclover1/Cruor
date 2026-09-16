package dev.agentclover.client.mixin.restrictions;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Perspective;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public class LockFirstPersonMixin {

    @Inject(method = "setPerspective", at = @At("HEAD"), cancellable = true)
    private void onSetPerspective(Perspective perspective, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.interactionManager == null) {
            return;
        }
        GameMode currentMode = client.interactionManager.getCurrentGameMode();
        boolean isRestrictedMode = (currentMode == GameMode.SURVIVAL || currentMode == GameMode.ADVENTURE);

        // Hahaha you cant go out of first person haha!!
        if (perspective != Perspective.FIRST_PERSON && isRestrictedMode) {
            ci.cancel();
        }
    }
}