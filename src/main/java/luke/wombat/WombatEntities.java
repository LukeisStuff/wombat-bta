package luke.wombat;

import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.entity.animal.EntityPig;
import turniplabs.halplibe.helper.EntityHelper;
import useless.dragonfly.helper.ModelHelper;
import useless.dragonfly.model.entity.BenchEntityModel;

import static luke.wombat.WombatMod.MOD_ID;

public class WombatEntities {
	private static int entityID = 200;

	public static final ModelBase modelWombat =  ModelHelper.getOrCreateEntityModel(MOD_ID, "wombat", ModelWombat.class);


	public void initializeEntities() {
		EntityHelper.Core.createEntity(EntityWombat.class, entityID++, "Wombat");
	}
	public void initializeModels(){
		EntityHelper.Client.assignEntityRenderer(EntityWombat.class, new WombatRenderer(modelWombat, 1.0f));
	}
}
