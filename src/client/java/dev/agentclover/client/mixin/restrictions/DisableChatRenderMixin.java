package dev.agentclover.client.mixin.restrictions;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public class DisableChatRenderMixin {
    @Inject(method = "clear", at = @At("HEAD"))
    private void onClear(boolean clearHistory, CallbackInfo ci) {
        // left empty ig
    }
    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(org.spongepowered.asm.mixin.injection.callback.CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && client.interactionManager != null) {
            GameMode currentMode = client.interactionManager.getCurrentGameMode();
            if (currentMode == GameMode.SURVIVAL || currentMode == GameMode.ADVENTURE) {
                // This clears the active messages right off the screen seamlessly
                ((ChatHud)(Object)this).clear(false);
            }
        }
    }
}
