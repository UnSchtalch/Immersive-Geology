package com.igteam.immersive_geology.api.materials.material_data.minerals;

import com.igteam.immersive_geology.api.materials.helper.CrystalFamily;
import com.igteam.immersive_geology.api.materials.helper.PeriodicTableElement;
import com.igteam.immersive_geology.api.materials.helper.PeriodicTableElement.ElementProportion;
import com.igteam.immersive_geology.api.materials.material_bases.MaterialMineralBase;
import com.igteam.immersive_geology.core.lib.IGLib;
import net.minecraft.item.Rarity;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Created by JStocke12 on 31-03-2020
 */
public class MaterialMineralGypsum extends MaterialMineralBase
{
	@Override
	public String getName()
	{
		return "gypsum";
	}

	@Override
	public String getModID()
	{
		return IGLib.MODID;
	}

	@Override
	public LinkedHashSet<ElementProportion> getElements()
	{
		return new LinkedHashSet<>(Arrays.asList(
				new PeriodicTableElement.ElementProportion(PeriodicTableElement.CALCIUM),
				new PeriodicTableElement.ElementProportion(PeriodicTableElement.SULFUR),
				new PeriodicTableElement.ElementProportion(PeriodicTableElement.OXYGEN)
		)
		);
	}

	@Override
	public Rarity getRarity()
	{
		return Rarity.UNCOMMON;
	}

	@Override
	public EnumMineralType getMineralType()
	{
		return EnumMineralType.CRYSTAL;
	}

	@Override
	public int getBoilingPoint()
	{
		return -1;
	}

	@Override
	public int getMeltingPoint()
	{
		return -1;
	}

	public static int baseColor = 0x90AB8C;

	@Override
	public int getColor(int temperature)
	{
		return baseColor;
	}

	//Needs to be changed in code for subtypes, such as sheetmetal
	@Override
	public float getHardness()
	{
		return -1F;
	}

	@Override
	public float getMiningResistance()
	{
		return -1F;
	}

	@Override
	public float getBlastResistance()
	{
		return -1F;
	}

	//Copied from Immersive Intelligence (steel has i think 1.65, leaves 0.35)
	@Override
	public float getDensity()
	{
		return 1f;
	}

	//Stone pickaxe level
	@Override
	public int getBlockHarvestLevel()
	{
		return 0;
	}

	@Override
	public net.minecraft.block.material.Material getBlockMaterial()
	{
		return null;
	}

	@Override
	public CrystalFamily getCrystalFamily() {
		return CrystalFamily.MONOCLINIC;
	}

}
