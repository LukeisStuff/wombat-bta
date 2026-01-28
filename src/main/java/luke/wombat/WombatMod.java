package luke.wombat;

import luke.wombat.block.WombatBlocks;
import luke.wombat.entities.MobWombat;
import luke.wombat.entities.WombatEntities;
import luke.wombat.items.WombatItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.enums.MobCategory;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.biome.Biomes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class WombatMod implements ModInitializer, GameStartEntrypoint, ClientStartEntrypoint {
    public static final String MOD_ID = "wombat";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public void onInitialize() {
        Biomes.OVERWORLD_DESERT.getSpawnableList(MobCategory.monster).add(new SpawnListEntry(MobWombat.class, 5));
        Biomes.OVERWORLD_OUTBACK.getSpawnableList(MobCategory.monster).add(new SpawnListEntry(MobWombat.class, 5));
        Biomes.OVERWORLD_OUTBACK_GRASSY.getSpawnableList(MobCategory.monster).add(new SpawnListEntry(MobWombat.class, 5));

        LOGGER.info("Wild Wombats initialized.");
    }

    @Override
    public void beforeGameStart() {
        WombatBlocks.init();
        WombatItems.init();
        WombatEntities.init();
    }

    @Override
    public void afterGameStart() {
        new WombatBlocks().initializeBlockDetails();
    }

    @Override
    public void beforeClientStart() {
    }

    @Override
    public void afterClientStart() {
        MobInfoRegistry.register(MobWombat.class, "wombat.name", "wombat.desc",
            10, 400, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(WombatItems.HIDE),
                1.0f, 0, 4)});
    }

}
