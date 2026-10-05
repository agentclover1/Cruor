package dev.agentclover;

import dev.agentclover.commands.CruorCommands;
import dev.agentclover.game.GameManager;
import dev.agentclover.index.CruorBlocks;
import dev.agentclover.index.CruorItemGroups;
import dev.agentclover.index.CruorItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cruor implements ModInitializer {
	public static final String MOD_ID = "cruor";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger CRUOR = LoggerFactory.getLogger(MOD_ID);
	public static final GameManager GAME_MANAGER = new GameManager();

	@Override
	public void onInitialize() {

		CruorItems.registerCruorItems();
		CruorBlocks.registerCruorBlocks();
		CruorItemGroups.registerCruorItemGroups();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			CruorCommands.register(dispatcher);
		});

		CRUOR.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
