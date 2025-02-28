package com.igteam.immersive_geology.api.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.igteam.immersive_geology.api.materials.MaterialUseType;
import com.igteam.immersive_geology.common.block.helpers.BlockMaterialType;
import com.igteam.immersive_geology.common.item.IGOreItem;
import com.igteam.immersive_geology.core.lib.IGLib;
import com.igteam.immersive_geology.core.registration.IGRegistrationHolder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootFunction;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

public class OreDropProperty extends LootFunction {
    public static final ResourceLocation ID = new ResourceLocation(IGLib.MODID, "variable_ore_drops");

    public OreDropProperty(ILootCondition[] conditions) {
        super(conditions);
    }

    @Override
    protected ItemStack doApply(ItemStack itemStack, LootContext lootContext) {
        Item tool = lootContext.get(LootParameters.TOOL).getItem();
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(lootContext.get(LootParameters.TOOL));


        if(tool instanceof PickaxeItem) {
            PickaxeItem pick = (PickaxeItem) tool;

            int fortuneLevel = enchantments.getOrDefault(Enchantments.FORTUNE, 0);
            if(enchantments.get(Enchantments.SILK_TOUCH) != null) {
                Item dropItem = itemStack.getItem();
                if(dropItem instanceof IGOreItem) {
                    IGOreItem oreItem = (IGOreItem) dropItem;
                    return new ItemStack(IGRegistrationHolder.getBlockByMaterial(oreItem.getMaterial(BlockMaterialType.BASE_MATERIAL), oreItem.getMaterial(BlockMaterialType.ORE_MATERIAL), MaterialUseType.ORE_STONE));
                } else {
                    return itemStack;
                }
            } else {
                return new ItemStack(itemStack.getItem(), Math.min(4, pick.getTier().getHarvestLevel()) + fortuneLevel);
            }
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public LootFunctionType getFunctionType() {
        return LootIG.Functions.ORE_DROP_PROPERTIES;
    }

    public static LootFunction.Builder<?> builder() {
        return builder(OreDropProperty::new);
    }

    public static class Serializer extends LootFunction.Serializer<OreDropProperty> {

        @Override
        public OreDropProperty deserialize(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext, ILootCondition[] iLootConditions) {
            return new OreDropProperty(iLootConditions);
        }
    }
}
