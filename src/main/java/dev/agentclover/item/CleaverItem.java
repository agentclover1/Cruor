package dev.agentclover.item;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;

public class CleaverItem extends Item {

    public CleaverItem() {
        super(new Item.Settings()
                .maxCount(1)
                .attributeModifiers(
                        AttributeModifiersComponent.builder()
                                .add(
                                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                        new EntityAttributeModifier(
                                                Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
                                                6.0,
                                                EntityAttributeModifier.Operation.ADD_VALUE
                                        ),
                                        AttributeModifierSlot.MAINHAND
                                )
                                .add(
                                        EntityAttributes.GENERIC_ATTACK_SPEED,
                                        new EntityAttributeModifier(
                                                Item.BASE_ATTACK_SPEED_MODIFIER_ID,
                                                -2.4,
                                                EntityAttributeModifier.Operation.ADD_VALUE
                                        ),
                                        AttributeModifierSlot.MAINHAND
                                )
                                .build()
                )
        );
    }
}
