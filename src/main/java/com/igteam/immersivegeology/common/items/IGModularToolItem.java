package com.igteam.immersivegeology.common.items;

import blusunrize.immersiveengineering.api.tool.ITool;
import blusunrize.immersiveengineering.common.items.IEItemInterfaces.IColouredItem;
import blusunrize.immersiveengineering.common.util.ItemNBTHelper;
import com.igteam.immersivegeology.ImmersiveGeology;
import com.igteam.immersivegeology.api.interfaces.IBindingMaterial;
import com.igteam.immersivegeology.api.interfaces.IHandleMaterial;
import com.igteam.immersivegeology.api.interfaces.IHeadMaterial;
import com.igteam.immersivegeology.api.interfaces.ITipMaterial;
import com.igteam.immersivegeology.api.materials.Material;
import com.igteam.immersivegeology.common.materials.EnumMaterials;
import com.igteam.immersivegeology.common.materials.MaterialEmpty;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public abstract class IGModularToolItem extends IGBaseItem implements ITool, IColouredItem
{

	protected static String[] StrMaterials = {"head_material", "binding_material", "handle_material", "tip_material"};
	protected static String[] StrColors = {"head_color", "binding_color", "handle_color", "tip_color"};

	public IGModularToolItem(String name)
	{
		super(name);
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		Material toolMaterial = getToolMaterial(stack, 0);
		if(toolMaterial instanceof MaterialEmpty){
			return 1;
		} else {
			int durability = ((IHeadMaterial) toolMaterial).getHeadDurability() + ((IBindingMaterial) getToolMaterial(stack, 1)).getBindingDurability() +
					((IHandleMaterial) getToolMaterial(stack, 2)).getHandleDurability();
			durability += ((ITipMaterial) getToolMaterial(stack, 3)).getTipDurability();
			durability = (int) ((double) durability * ((IBindingMaterial) getToolMaterial(stack, 1)).getBindingMultiplier() *
					((IHandleMaterial) getToolMaterial(stack, 2)).getHandleMultiplier());
			return durability;
		}
	}

	public static Material getToolMaterial(ItemStack stack, int part)
	{
		return EnumMaterials.filterByName(ItemNBTHelper.getString(stack, StrMaterials[part])).material;
	}

	@Override
	public boolean isTool(ItemStack itemStack)
	{
		return !itemStack.getToolTypes().isEmpty();
	}

	@Override
	public boolean hasCustomItemColours()
	{
		return true;
	}

	@Override
	public int getColourForIEItem(ItemStack stack, int pass)
	{
		//0 for head, 1 for handle
		return getColorCache(stack, pass);
	}

	//true for head, false for handle
	public int getColorCache(ItemStack stack, int part)
	{
		String tagName = StrColors[part];
		//Adds quick access to the color, greatly improves performance
		if(!ItemNBTHelper.hasKey(stack, tagName))
			stack.getOrCreateTag().putInt(tagName, getToolMaterial(stack, part).getColor(0));
		return ItemNBTHelper.getInt(stack, tagName);
	}

	@Override
	public int getHarvestLevel(ItemStack stack, ToolType toolType, @Nullable PlayerEntity player, @Nullable BlockState state)
	{
		return super.getHarvestLevel(stack, toolType, player, state);
	}
}
