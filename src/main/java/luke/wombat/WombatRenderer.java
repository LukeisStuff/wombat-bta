package luke.wombat;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.entity.Entity;
import org.lwjgl.opengl.GL11;

public class WombatRenderer extends LivingRenderer<EntityWombat> {
	public WombatRenderer(ModelBase modelbase, float scale) {
		super(modelbase, scale);
	}

}
