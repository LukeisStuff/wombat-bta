package luke.wombat;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.entity.FallingSandRenderer;
import net.minecraft.client.render.entity.SnowballRenderer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.TextureHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class WombatMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint, ClientStartEntrypoint {
    public static final String MOD_ID = "wombat";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("Wild Wombats initialized.");
    }

	@Override
	public void beforeGameStart() {
		new WombatEntities().initializeEntities();
	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void beforeClientStart() {
		new WombatEntities().initializeModels();
	}

	@Override
	public void afterClientStart() {

	}

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {

	}
}
