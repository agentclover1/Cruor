package dev.agentclover.index;

import dev.agentclover.Cruor;
import dev.agentclover.item.CleaverItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CruorItems {
    public static final Item CLEAVER = registerItem("cleaver", new CleaverItem());  
    // Cleaver item. Code later.

    public static final Item TEST2 = registerItem("test2", new BlockItem(CruorBlocks.TEST2, new Item.Settings()));
    // Second test item. Repurpose or delete later.

    public static final Item TEST3 = registerItem("test3", new BlockItem(CruorBlocks.TEST3, new Item.Settings()));
    // Third test item. Repurpose or delete later.

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Cruor.MOD_ID, name), item);
    }

    public static void registerCruorItems() {
        Cruor.CRUOR.info("Registering Mod Items for " + Cruor.MOD_ID);
    }
}
