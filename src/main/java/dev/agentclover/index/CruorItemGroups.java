package dev.agentclover.index;

import dev.agentclover.Cruor;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CruorItemGroups {
    public static final ItemGroup CRUOR_BLOCKS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(Cruor.MOD_ID, "cruor_blocks_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup." + Cruor.MOD_ID + ".cruor_blocks_group"))
                    .icon(() -> new ItemStack(Items.NETHERITE_BLOCK))
                    .entries((displayContext, entries) -> {
                        entries.add(CruorItems.TEST2);
                    })
                    .build()
    );

    public static final ItemGroup CRUOR_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(Cruor.MOD_ID, "cruor_items_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup." + Cruor.MOD_ID + ".cruor_items_group"))
                    .icon(() -> new ItemStack(Items.NETHERITE_SWORD))
                    .entries((displayContext, entries) -> {
                        entries.add(CruorItems.CLEAVER);
                    })
                    .build()
    );

    public static final ItemGroup CRUOR_FUNCTIONAL_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(Cruor.MOD_ID, "cruor_functional_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup." + Cruor.MOD_ID + ".cruor_functional_group"))
                    .icon(() -> new ItemStack(Items.NETHERITE_INGOT))
                    .entries((displayContext, entries) -> {
                        entries.add(CruorItems.TEST3);
                    })
                    .build()
    );

    public static void registerCruorItemGroups() {
        Cruor.CRUOR.info("Registering Item Groups for " + Cruor.MOD_ID);
    }
}