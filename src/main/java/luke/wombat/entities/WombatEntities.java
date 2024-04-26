package luke.wombat.entities;

import luke.wombat.WombatRenderer;
import turniplabs.halplibe.helper.EntityHelper;

public class WombatEntities {
	private static int entityID = 250;

	public void initializeEntities() {
		EntityHelper.Core.createEntity(EntityWombat.class, entityID++, "Wombat");
	}
	public void initializeModels(){
		EntityHelper.Client.assignEntityRenderer(EntityWombat.class, new WombatRenderer(new ModelWombat(), new ModelWombat(0.5f), 0.7f));
	}
}
