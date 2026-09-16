package dev.agentclover.index;

import dev.agentclover.Cruor;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CruorBlocks {

    public static final Block TEST2 = registerBlock(
            "test2",
            new Block(AbstractBlock.Settings.create())
    );

    public static final Block TEST3 = registerBlock(
            "test3",
            new Block(AbstractBlock.Settings.create())
    );

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Cruor.MOD_ID, name), block);
    }

    public static void registerCruorBlocks() {
        Cruor.CRUOR.info("Registering Mod Blocks for " + Cruor.MOD_ID);
    }
}