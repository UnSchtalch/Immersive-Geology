package com.igteam.immersive_geology.common.block.helpers;

import com.igteam.immersive_geology.api.materials.Material;
import com.igteam.immersive_geology.api.materials.MaterialUseType;
import net.minecraft.block.Block;

public interface IGBlockType {
    @Deprecated
    Block getSelf();

    String getHolderName();
    MaterialUseType getBlockUseType();
    Material getMaterial(BlockMaterialType type);

    MaterialUseType getDropUseType();

    float maxDrops();
    float minDrops();
}
