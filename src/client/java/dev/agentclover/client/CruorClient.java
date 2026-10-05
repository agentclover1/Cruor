package dev.agentclover.client;

import dev.agentclover.index.CruorBlockEntities;
import net.fabricmc.api.ClientModInitializer;
import dev.agentclover.client.renderer.GateLeverBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class CruorClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockEntityRendererFactories.register(CruorBlockEntities.GATE_LEVER_ENTITY, GateLeverBlockEntityRenderer::new);
	}
}