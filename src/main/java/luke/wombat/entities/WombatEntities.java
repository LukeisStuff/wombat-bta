package luke.wombat.entities;

import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.EntityHelper;

public class WombatEntities {

	public void initializeEntities() {
		EntityHelper.createEntity(MobWombat.class, NamespaceID.getPermanent("wildwombats", "wombat"), "guidebook.section.mob.wombat.name");
	}
}
