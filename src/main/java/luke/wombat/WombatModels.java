package luke.wombat;

import luke.wombat.block.WombatBlocks;
import luke.wombat.entities.MobRendererWombat;
import luke.wombat.entities.MobWombat;
import luke.wombat.entities.ModelWombat;
import luke.wombat.items.WombatItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

@Environment(EnvType.CLIENT)
public class WombatModels implements ModelEntrypoint {

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {
        dispatcher.addDispatch(WombatBlocks.FELT, new BlockModelStandard<>(WombatBlocks.FELT)
            .setAllTextures(0, "wombat:block/felt"));
    }

    @Override
    public void initItemModels(ItemModelDispatcher dispatcher) {
        dispatcher.addDispatch(WombatItems.HIDE, new ItemModelStandard(WombatItems.HIDE, null).setIcon("wombat:item/hide"));
        dispatcher.addDispatch(WombatItems.DIDGERIDOO, new ItemModelStandard(WombatItems.DIDGERIDOO, null).setIcon("wombat:item/didgeridoo"));
    }

    @Override
    public void initEntityModels(EntityRenderDispatcher dispatcher) {
        ModelHelper.setEntityModel(MobWombat.class, () -> new MobRendererWombat(new ModelWombat(), 0.7f));
    }

    @Override
    public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

    }

    @Override
    public void initBlockColors(BlockColorDispatcher dispatcher) {

    }
}
