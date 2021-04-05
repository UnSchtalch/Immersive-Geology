package com.igteam.immersive_geology.api.materials.material_data.metalloid;

import com.igteam.immersive_geology.api.materials.PeriodicTableElement.ElementProportion;
import com.igteam.immersive_geology.api.materials.material_bases.MaterialMetalloidBase;
import net.minecraft.item.Rarity;

import java.util.LinkedHashSet;

public class MaterialMetalloidArsenic extends MaterialMetalloidBase
{

	@Override
	public EnumMetalType getMetalType()
	{
		// TODO Auto-generated method stub
		return EnumMetalType.METALLOID;
	}

	@Override
	public LinkedHashSet<ElementProportion> getElements()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rarity getRarity()
	{
		// TODO Auto-generated method stub
		return Rarity.COMMON;
	}

	@Override
	public int getBoilingPoint()
	{
		// TODO Auto-generated method stub
		return 887;
	}

	@Override
	public int getMeltingPoint()
	{
		// TODO Auto-generated method stub
		return 817;
	}

	@Override
	public int getColor(int temperature)
	{
		// TODO Auto-generated method stub
		return 0x3B444B;
	}

	@Override
	public float getHardness()
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public float getMiningResistance()
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public float getBlastResistance()
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public float getDensity()
	{
		// TODO Auto-generated method stub
		return 5.73f;
	}

}
