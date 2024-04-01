package luke.wombat.entities;

import luke.wombat.WombatRenderer;
import net.minecraft.client.render.model.ModelPig;
import turniplabs.halplibe.helper.EntityHelper;

public class WombatEntities {
	private static int entityID = 200;

	public void initializeEntities() {
		EntityHelper.Core.createEntity(EntityWombat.class, entityID++, "Wombat");
		EntityHelper.Client.assignEntityRenderer(EntityWombat.class, new WombatRenderer(new ModelPig(), new ModelPig(0.5f), 0.7f));
	}
	public void initializeModels(){
	}
}
