package luke.wombat.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;

import static luke.wombat.WombatMod.MOD_ID;
import static net.minecraft.core.block.material.MaterialColor.registerManualBlockColor;

public class WombatBlocks {

    static int blockID = 3500;

    public static Block<?> FELT;

    private static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeBlocks();
        }
    }

    public void initializeBlockDetails() {
        registerManualBlockColor(FELT, 0, MaterialColor.wood);
    }

    public static void initializeBlocks() {

        FELT = new BlockBuilder(MOD_ID)
            .setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 0.8f))
            .setHardness(0.6f)
            .setResistance(0.6f)
            .setFlammability(30, 60)
            .setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS)
            .build("felt", "block/felt", blockID++, block -> new BlockLogic(block, Material.cloth));
    }
}
