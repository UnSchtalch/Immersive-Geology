package com.igteam.immersive_geology.api.materials;

import com.igteam.immersive_geology.api.materials.material_bases.*;
import com.igteam.immersive_geology.api.materials.material_data.MaterialEmpty;
import com.igteam.immersive_geology.api.materials.material_data.crystals.MaterialCrystalDiamond;
import com.igteam.immersive_geology.api.materials.material_data.crystals.MaterialCrystalGlowstone;
import com.igteam.immersive_geology.api.materials.material_data.crystals.MaterialCrystalPhlebotinum;
import com.igteam.immersive_geology.api.materials.material_data.crystals.MaterialCrystalQuartz;
import com.igteam.immersive_geology.api.materials.material_data.fluids.*;
import com.igteam.immersive_geology.api.materials.material_data.fluids.chemical.MaterialFluidHydrochloricAcid;
import com.igteam.immersive_geology.api.materials.material_data.fluids.chemical.MaterialFluidNitricAcid;
import com.igteam.immersive_geology.api.materials.material_data.fluids.chemical.MaterialFluidSodiumHydroxide;
import com.igteam.immersive_geology.api.materials.material_data.fluids.chemical.MaterialFluidSulfuricAcid;
import com.igteam.immersive_geology.api.materials.material_data.gases.MaterialGasHydrogen;
import com.igteam.immersive_geology.api.materials.material_data.metalloid.MaterialMetalloidAntimony;
import com.igteam.immersive_geology.api.materials.material_data.metalloid.MaterialMetalloidArsenic;
import com.igteam.immersive_geology.api.materials.material_data.metals.*;
import com.igteam.immersive_geology.api.materials.material_data.metals.alloys.*;
import com.igteam.immersive_geology.api.materials.material_data.minerals.*;
import com.igteam.immersive_geology.api.materials.material_data.stones.MaterialStoneVanilla;

import java.util.ArrayList;
import java.util.Arrays;

public enum MaterialEnum {
    //Empty
    Empty(new MaterialEmpty()),

    //Metals
    Aluminium(new MaterialMetalAluminium()),
    Chromium(new MaterialMetalChromium()),
    Copper(new MaterialMetalCopper()),
    Gold(new MaterialMetalGold()),
    Iron(new MaterialMetalIron()),
    Lead(new MaterialMetalLead()),
    Manganese(new MaterialMetalManganese()),
    Nickel(new MaterialMetalNickel()),
    Platinum(new MaterialMetalPlatinum()),
    Silver(new MaterialMetalSilver()),
    Cobalt(new MaterialMetalCobalt()),
    Uranium(new MaterialMetalUranium()),
    Tin(new MaterialMetalTin()),
    Titanium(new MaterialMetalTitanium()),
    Tungsten(new MaterialMetalTungsten()),
    Thorium(new MaterialMetalThorium()),
    Vanadium(new MaterialMetalVanadium()),
    Zirconium(new MaterialMetalZirconium()),
    Zinc(new MaterialMetalZinc()),

    Constantan(new MaterialMetalConstantan()),
    Electrum(new MaterialMetalElectrum()),
    Steel(new MaterialMetalSteel()),
    VikingSteel(new MaterialMetalVikingSteel()),
    Bronze(new MaterialMetalBronze()),

    //Metalloid
    Arsenic(new MaterialMetalloidArsenic()),
    Antimony(new MaterialMetalloidAntimony()),

    //Crystals
    Diamond(new MaterialCrystalDiamond()),
    Phlebotinum(new MaterialCrystalPhlebotinum()),
    Glowstone(new MaterialCrystalGlowstone()),
    Quartz(new MaterialCrystalQuartz()),

    //Minerals
    Anatase(new MaterialMineralAnatase()),
    Cuprite(new MaterialMineralCuprite()),
    Zircon(new MaterialMineralZircon()),
    Ilmenite(new MaterialMineralIlmenite()),
    Cobaltite(new MaterialMineralCobaltite()),
    Casserite(new MaterialMineralCassiterite()),
    Chalcopyrite(new MaterialMineralChalcopyrite()),
    Chromite(new MaterialMineralChromite()),
    Cryolite(new MaterialMineralCryolite()),
    Ferberite(new MaterialMineralFerberite()),
    Fluorite(new MaterialMineralFluorite()),  //TODO Immersive Engineering has trouble with this as it's looking for a GEM version under the tag forge:gem/fluorite
    Gypsum(new MaterialMineralGypsum()),
    Hematite(new MaterialMineralHematite()),
    Hubnerite(new MaterialMineralHubnerite()),
    Magnetite(new MaterialMineralMagnetite()),
    Pyrolusite(new MaterialMineralPyrolusite()),
    RockSalt(new MaterialMineralRockSalt()),
    Thorianite(new MaterialMineralThorianite()),
    Thorite(new MaterialMineralThorite()),
    Uraninite(new MaterialMineralUraninite()),
    Sphalerite(new MaterialMineralSphalerite()),
    Ullmannite(new MaterialMineralUllmannite()),
    Galena(new MaterialMineralGalena()),
    Pyrite(new MaterialMineralPyrite()),
    Wolframite(new MaterialMineralWolframite()),
    Vanadinite(new MaterialMineralVanadinite()),
    Unobtainium(new MaterialMetalUnobtainium()),

    //Stones
    Vanilla(new MaterialStoneVanilla()),

    //Fluids
    //Non Volatile
    Brine(new MaterialFluidBrine()),
    Water(new MaterialFluidWater()),

    //Volatile
    SulfuricAcid(new MaterialFluidSulfuricAcid()),
    HydrochloricAcid(new MaterialFluidHydrochloricAcid()),
    NitricAcid(new MaterialFluidNitricAcid()),
    SodiumHydroxide(new MaterialFluidSodiumHydroxide()),

    //Gasses
    Hydrogen(new MaterialGasHydrogen()),

    //Glass
    Glass(new MaterialGlassBase());

    private final Material material;

    MaterialEnum(Material material)
    {
        this.material = material;
    }

    public static MaterialEnum[] fluidValues() {
        ArrayList<MaterialEnum> fluidMaterials = new ArrayList<>();
        Arrays.stream(values()).forEach((container) -> {
            if(container.getMaterial() instanceof MaterialFluidBase){
                fluidMaterials.add(container);
            }
        });
        return fluidMaterials.toArray(new MaterialEnum[fluidMaterials.size()]);
    }

    public Material getMaterial(){
        return material;
    }

    public static MaterialEnum[] stoneValues() {
        ArrayList<MaterialEnum> stoneMaterials = new ArrayList<>();
        Arrays.stream(values()).forEach((container) -> {
            if(container.getMaterial() instanceof MaterialStoneBase){
                stoneMaterials.add(container);
            }
        });
        return stoneMaterials.toArray(new MaterialEnum[stoneMaterials.size()]);
    }
    public static MaterialEnum[] minerals() {
        ArrayList<MaterialEnum> mineralMaterials = new ArrayList<>();
        Arrays.stream(values()).forEach((container) -> {
            if(container.getMaterial() instanceof MaterialMineralBase){
                mineralMaterials.add(container);
            }
        });
        return mineralMaterials.toArray(new MaterialEnum[mineralMaterials.size()]);
    }

    public static MaterialEnum[] worldMaterials() {
        ArrayList<MaterialEnum> worldMaterials = new ArrayList<>();
        Arrays.stream(values()).forEach((container) -> {
            if(container.getMaterial() instanceof MaterialMineralBase){
                worldMaterials.add(container);
            }
            if(container.getMaterial() instanceof MaterialCrystalBase){
                worldMaterials.add(container);
            }
            if(container.getMaterial() instanceof MaterialMetalBase){
                MaterialMetalBase material = ((MaterialMetalBase) container.getMaterial());
                if(material.isNativeMetal) {
                    worldMaterials.add(container);
                }
            }
        });
        return worldMaterials.toArray(new MaterialEnum[worldMaterials.size()]);
    }
}
