package com.igteam.immersive_geology.core.data.generators.recipe;

import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public interface ISubRecipeProvider {
    void addRecipes(Consumer<IFinishedRecipe> consumer);
}
