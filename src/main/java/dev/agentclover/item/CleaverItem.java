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
                                                // Using vanilla ID changes display style from relative (+6) to absolute (7) green text
                                                Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
                                                6.0, // Player Base (1.0) + 6.0 = 7 Total Attack Damage
                                                EntityAttributeModifier.Operation.ADD_VALUE
                                        ),
                                        AttributeModifierSlot.MAINHAND
                                )
                                .add(
                                        EntityAttributes.GENERIC_ATTACK_SPEED,
                                        new EntityAttributeModifier(
                                                // Using vanilla ID formats the speed with a clean green text format
                                                Item.BASE_ATTACK_SPEED_MODIFIER_ID,
                                                -2.4, // Player Base (4.0) - 2.4 = 1.6 Total Attack Speed
                                                EntityAttributeModifier.Operation.ADD_VALUE
                                        ),
                                        AttributeModifierSlot.MAINHAND
                                )
                                .build()
                )
        );
    }
}
