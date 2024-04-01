package luke.wombat;

import luke.wombat.entities.EntityWombat;
import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;

public class WombatRenderer extends LivingRenderer<EntityWombat> {
	public WombatRenderer(ModelBase modelbase, ModelBase modelbase1, float f) {
		super(modelbase, f);
		this.setRenderPassModel(modelbase1);
	}

}
