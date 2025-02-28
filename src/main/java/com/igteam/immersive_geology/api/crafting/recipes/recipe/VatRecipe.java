package com.igteam.immersive_geology.api.crafting.recipes.recipe;

import blusunrize.immersiveengineering.api.crafting.FluidTagInput;
import blusunrize.immersiveengineering.api.crafting.IERecipeSerializer;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.RefineryRecipe;
import com.igteam.immersive_geology.api.crafting.IGMultiblockRecipe;
import com.igteam.immersive_geology.common.crafting.Serializers;
import com.igteam.immersive_geology.core.config.IGConfigurationHandler;
import com.igteam.immersive_geology.core.lib.IGLib;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.*;

public class VatRecipe extends IGMultiblockRecipe
{
    public static final IRecipeType<VatRecipe> TYPE = IRecipeType.register(IGLib.MODID + ":chemicalvat");
    public static Map<ResourceLocation, VatRecipe> recipes = new HashMap<>();


    /** May return null! */
    public static VatRecipe findRecipe(ItemStack itemInput, FluidStack fluidInput1, FluidStack fluidInput2)
    {
        if(!recipes.isEmpty()){
            for(VatRecipe r:recipes.values()){
                if(r.itemInput != null && r.fluidInput1 != null && r.fluidInput2 != null && r.fluidInput1.testIgnoringAmount(fluidInput1) && r.fluidInput2.testIgnoringAmount(fluidInput2) && r.itemInput.equals(itemInput)){
                    return r;
                }
            }
        }
        return null;
    }

    public static Optional<VatRecipe> findIncompleteVatRecipe(@Nonnull FluidStack input0, @Nonnull FluidStack input1) {
        if (input0.isEmpty() && input1.isEmpty()) {
            return Optional.empty();
        } else {
            Iterator var2 = recipes.values().iterator();

            while (var2.hasNext()) {
                VatRecipe recipe = (VatRecipe) var2.next();
                if (!input0.isEmpty() && input1.isEmpty()) {
                    if (recipe.fluidInput1.testIgnoringAmount(input0) || recipe.fluidInput2.testIgnoringAmount(input0)) {
                        return Optional.of(recipe);
                    }
                } else if (input0.isEmpty() && !input1.isEmpty()) {
                    if (recipe.fluidInput1.testIgnoringAmount(input1) || recipe.fluidInput2.testIgnoringAmount(input1)) {
                        return Optional.of(recipe);
                    }
                } else if (recipe.fluidInput1.testIgnoringAmount(input0) && recipe.fluidInput1.testIgnoringAmount(input1) || recipe.fluidInput2.testIgnoringAmount(input0) && recipe.fluidInput2.testIgnoringAmount(input1)) {
                    return Optional.of(recipe);
                }
            }
            return Optional.empty();
        }
    }

    public static VatRecipe loadFromNBT(CompoundNBT nbt){
        FluidStack fluidInput1 = FluidStack.loadFluidStackFromNBT(nbt.getCompound("fluid_input1"));
        FluidStack fluidInput2 = FluidStack.loadFluidStackFromNBT(nbt.getCompound("fluid_input2"));
        ItemStack itemInput =  ItemStack.read(nbt.getCompound("item_input"));
        return findRecipe(itemInput, fluidInput1, fluidInput2);
    }

    protected final FluidTagInput fluidInput1;
    protected final FluidTagInput fluidInput2;
    protected final FluidStack fluidOutput;
    protected final IngredientWithSize itemInput;
    protected final ItemStack itemOutput;


    public VatRecipe(ResourceLocation id, FluidStack fluidOutput, ItemStack itemOutput, FluidTagInput fluidInput1, FluidTagInput fluidInput2, IngredientWithSize itemInput, int energy, int time) {
        super(ItemStack.EMPTY, TYPE, id);
        this.fluidInput1 = fluidInput1;
        this.fluidInput2 = fluidInput2;
        this.fluidOutput = fluidOutput;
        this.itemInput = itemInput;
        this.itemOutput = itemOutput;

        this.fluidInputList = Arrays.asList(fluidInput1, fluidInput2);
        this.fluidOutputList = Arrays.asList(this.fluidOutput);
        this.outputList = NonNullList.from(ItemStack.EMPTY, itemOutput);

        timeAndEnergy(time, energy);
        modifyTimeAndEnergy(IGConfigurationHandler.Server.MULTIBLOCK.chemicalVat_energyModifier::get, IGConfigurationHandler.Server.MULTIBLOCK.chemicalVat_timeModifier::get);
    }

    @Override
    protected IERecipeSerializer getIESerializer() {
        return Serializers.CHEMICAL_VAT_SERIALIZER.get();
    }

    @Override
    public int getMultipleProcessTicks() {
        return 0;
    }

    @Override
    public List<FluidStack> getActualFluidOutputs(TileEntity tile) {
        NonNullList<FluidStack> output = NonNullList.create();
        output.add(fluidOutput);
        return output;
    }

    public FluidTagInput[] getInputFluids(){
        return new FluidTagInput[]{this.fluidInput1, this.fluidInput2};
    }

}
