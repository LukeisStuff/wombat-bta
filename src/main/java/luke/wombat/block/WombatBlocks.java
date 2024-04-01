package luke.wombat.block;

import luke.wombat.WombatConfig;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.CreativeHelper;

import static luke.wombat.WombatMod.MOD_ID;

public class WombatBlocks {

	private int blockID(String blockName) {
		return WombatConfig.cfg.getInt("Block IDs." + blockName);
	}

	public static Block felt;

	private void initializeBlockDetails() {
		CreativeHelper.setParent(felt, Block.oreCoalGranite);
	}

	public void initializeBlocks() {

		// Felt
		felt = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 0.8f))
			.setHardness(0.6f)
			.setResistance(0.6f)
			.setTextures("felt.png")
			.setFlammability(30, 60)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS)
			.build(new Block("felt", blockID("felt"), Material.cloth));

		initializeBlockDetails();
	}
}
