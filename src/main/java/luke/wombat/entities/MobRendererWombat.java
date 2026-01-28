package luke.wombat.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.model.ModelBase;

@Environment(EnvType.CLIENT)
public class MobRendererWombat extends MobRenderer<MobWombat> {
    public MobRendererWombat(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

}
