package com.igteam.immersive_geology.core.registration;

import com.igteam.immersive_geology.ImmersiveGeology;
import com.igteam.immersive_geology.api.materials.Material;
import com.igteam.immersive_geology.api.materials.MaterialEnum;
import com.igteam.immersive_geology.api.materials.MaterialUseType;
import com.igteam.immersive_geology.api.materials.material_bases.MaterialStoneBase;
import com.igteam.immersive_geology.common.block.helpers.IGBlockType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedMap;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class IGRegistrationHolder {


    public static HashMap<String, Item> registeredIGItems = new HashMap<>();
    public static HashMap<String, IGBlockType> registeredIGBlocks = new HashMap<>();

    private static Logger log = ImmersiveGeology.getNewLogger();

    @SubscribeEvent
    public static void itemRegistration(final RegistryEvent.Register<Item> event){
        log.warn("Applying Registration");
        registeredIGItems.values().forEach((item) -> {
            event.getRegistry().register(item);
        });
    }

    @SubscribeEvent
    public static void blockRegistration(final RegistryEvent.Register<Block> event){
        //Best spot to create all data for items and blocks, Blocks are registered first, then Items after that it's alphabetical
        Arrays.stream(MaterialEnum.values()).forEach(material -> {
            IGVariantHolder.createVariants(material.getMaterial());
        });

        registeredIGBlocks.values().forEach((block) ->{
            event.getRegistry().register(block.getSelf());
        });
    }

    public static Item getItemByMaterial(Material material, MaterialUseType useType){
        return registeredIGItems.get(getRegistryKey(material, useType));
    }

    public static Item getItemByMaterial(Material materialBase, Material materialOre, MaterialUseType type){
        return registeredIGItems.get(getRegistryKey(materialBase, materialOre, type));
    }

    public static String getRegistryKey(Material mat, MaterialUseType useType){
        return (useType.getName() + "_" + mat.getName()).toLowerCase();
    }

    public static String getRegistryKey(Material materialBase, Material materialOre, MaterialUseType type){
        return (type.getName() + "_" + materialBase.getName() + "_" + materialOre.getName());
    }

    public static Block getBlockByMaterial(MaterialUseType useType, Material material) {
        return registeredIGBlocks.get(getRegistryKey(material, useType)).getSelf();
    }

    public static Block getBlockByMaterial(Material base_material, Material ore_material, MaterialUseType type){
        return registeredIGBlocks.get(getRegistryKey(base_material, ore_material, type)).getSelf();
    }
}
