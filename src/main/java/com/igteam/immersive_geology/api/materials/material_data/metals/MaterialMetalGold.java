package com.igteam.immersive_geology.api.materials.material_data.metals;

import com.igteam.immersive_geology.api.materials.helper.CrystalFamily;
import com.igteam.immersive_geology.api.materials.helper.PeriodicTableElement;
import com.igteam.immersive_geology.api.materials.helper.PeriodicTableElement.ElementProportion;
import com.igteam.immersive_geology.api.materials.material_bases.MaterialMetalBase;
import com.igteam.immersive_geology.core.lib.IGLib;
import net.minecraft.item.Rarity;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Created by Pabilo8 on 25-03-2020.
 */
public class MaterialMetalGold extends MaterialMetalBase
{	

	public MaterialMetalGold() {
		isNativeMetal = true;
	}
	
	@Override
	public String getName()
	{
		return "gold";
	}

	@Nonnull
	@Override
	public String getModID()
	{
		return IGLib.MODID;
	}

	@Override
	public LinkedHashSet<ElementProportion> getElements()
	{
		return new LinkedHashSet<>(Arrays.asList(
				new ElementProportion(PeriodicTableElement.GOLD)
		));
	}

	@Override
	public Rarity getRarity()
	{
		return Rarity.UNCOMMON;
	}

	@Override
	public int getBoilingPoint()
	{
		return 2973;
	}

	@Override
	public int getMeltingPoint()
	{
		return 1337;
	}

	public static int baseColor = 0xFFD700;

	@Override
	public int getColor(int temperature)
	{
		return baseColor;
	}

	//Needs to be changed in code for subtypes, such as sheetmetal
	@Override
	public float getHardness()
	{
		return 5.0F;
	}

	@Override
	public float getMiningResistance()
	{
		return 10.0F;
	}

	@Override
	public float getBlastResistance()
	{
		return 6;
	}

	//Copied from Immersive Intelligence (steel has i think 1.65, leaves 0.35)
	@Override
	public float getDensity()
	{
		return 1.25f;
	}

	//Stone pickaxe level
	@Override
	public int getBlockHarvestLevel()
	{
		return 1;
	}

	@Override
	public EnumMetalType getMetalType()
	{
		return EnumMetalType.METAL;
	}

	@Override
	public CrystalFamily getCrystalFamily() {
		return CrystalFamily.CUBIC;
	}

	/*@Nullable
	@Override
	public IItemTier getToolTier()
	{
		return IGContent.;
	}*/
}
