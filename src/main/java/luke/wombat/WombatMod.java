package luke.wombat;

import luke.wombat.block.WombatBlocks;
import luke.wombat.entities.EntityWombat;
import luke.wombat.entities.WombatEntities;
import luke.wombat.items.WombatItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.enums.EnumCreatureType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.biome.Biomes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class WombatMod implements ModInitializer, GameStartEntrypoint, ClientStartEntrypoint {
    public static final String MOD_ID = "wombat";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
		new WombatBlocks().initializeBlocks();
		new WombatItems().initilizeItems();

		Biomes.OVERWORLD_DESERT.getSpawnableList(EnumCreatureType.monster).add(new SpawnListEntry(EntityWombat.class, 5));
		Biomes.OVERWORLD_OUTBACK.getSpawnableList(EnumCreatureType.monster).add(new SpawnListEntry(EntityWombat.class, 5));
		Biomes.OVERWORLD_OUTBACK_GRASSY.getSpawnableList(EnumCreatureType.monster).add(new SpawnListEntry(EntityWombat.class, 5));

		LOGGER.info("Wild Wombats initialized.");
    }

	@Override
	public void beforeGameStart() {
		new WombatEntities().initializeEntities();
	}

	@Override
	public void afterGameStart() {
		new WombatRecipes().initializeRecipes();
	}

	@Override
	public void beforeClientStart() {
		new WombatEntities().initializeModels();

		MobInfoRegistry.register(EntityWombat.class, "wombat.name", "wombat.desc",
			10, 400, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(WombatItems.hide),
				1.0f, 0, 4)});
	}

	@Override
	public void afterClientStart() {

	}

}
