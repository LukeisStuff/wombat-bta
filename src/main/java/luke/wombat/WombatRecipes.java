package luke.wombat;

import luke.wombat.block.WombatBlocks;
import luke.wombat.items.WombatItems;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.wombat.WombatMod.MOD_ID;

public class WombatRecipes implements RecipeEntrypoint {

	public void initializeRecipes() {

		RecipeBuilderShaped templateItemtoBlock = new RecipeBuilderShaped(MOD_ID, "XX", "XX");
		templateItemtoBlock.addInput('X', WombatItems.hide).create("felt", new ItemStack(WombatBlocks.felt, 4));

		RecipeBuilder.Shaped(MOD_ID, "  S", " H ", "S  ")
			.addInput('S', Item.stick)
			.addInput('H', WombatItems.hide)
			.create("didgeridoo", new ItemStack(WombatItems.didgeridoo, 1));

		RecipeBuilder.Shaped(MOD_ID, "H", "H")
			.addInput('H', WombatItems.hide)
			.create("hide_to_leather", new ItemStack(Item.leather, 1));

	}

	@Override
	public void onRecipesReady() {
		initializeRecipes();
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
		RecipeBuilder.getRecipeNamespace(MOD_ID);
	}

}
