package luke.wombat.entities;

import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.EntityHelper;

import static luke.wombat.WombatMod.MOD_ID;

public class WombatEntities {
    public static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeEntities();
        }
    }

    public static void initializeEntities() {
        EntityHelper.createEntity(MobWombat.class, NamespaceID.getPermanent(MOD_ID, "wombat"), "guidebook.section.mob.wombat.name");
    }
}
