package luke.wombat.entities;

import turniplabs.halplibe.helper.EntityHelper;

public class WombatEntities {
	private static int entityID = 250;

	public void initializeEntities() {
		EntityHelper.createEntity(EntityWombat.class, entityID++, "Wombat", () -> new WombatRenderer(new ModelWombat(), new ModelWombat(0.5f), 0.7f));
	}
}
