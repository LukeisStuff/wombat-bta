package luke.wombat;

import luke.wombat.block.WombatBlocks;
import luke.wombat.entities.MobRendererWombat;
import luke.wombat.entities.MobWombat;
import luke.wombat.entities.ModelWombat;
import luke.wombat.items.WombatItems;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static luke.wombat.WombatMod.MOD_ID;

public class WombatModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		ModelHelper.setBlockModel(WombatBlocks.FELT, () -> new BlockModelStandard<>(WombatBlocks.FELT).setAllTextures(0, "wombat:block/felt"));
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
        ModelHelper.setItemModel(WombatItems.HIDE, () -> new ItemModelStandard(WombatItems.HIDE, "wombat"));
		ModelHelper.setItemModel(WombatItems.DIDGERIDOO, () -> new ItemModelStandard(WombatItems.DIDGERIDOO, "wombat"));
    }

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {
		ModelHelper.setEntityModel(MobWombat.class, () -> new MobRendererWombat(new ModelWombat(), new ModelWombat(0.5f), 0.7f));
	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
