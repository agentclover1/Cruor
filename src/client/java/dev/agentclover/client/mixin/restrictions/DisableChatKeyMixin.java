package dev.agentclover.client.mixin.restrictions;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class DisableChatKeyMixin {

    @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
    private void onSetScreen(Screen screen, CallbackInfo ci) {
        if (screen instanceof ChatScreen) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player != null && client.interactionManager != null) {
                GameMode currentMode = client.interactionManager.getCurrentGameMode();
                if (currentMode == GameMode.SURVIVAL || currentMode == GameMode.ADVENTURE) {
                    ci.cancel();
                }
            }
        }
    }
}
