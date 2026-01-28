package luke.wombat.items;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.wombat.WombatMod.MOD_ID;

public class WombatItems {

    static int itemID = 17550;

    public static Item HIDE;
    public static Item DIDGERIDOO;

    private static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeItems();
        }
    }

    public static String itemKey(String string) {
        return MOD_ID + ":item/" + string;
    }

    public static void initializeItems() {
        HIDE = new ItemBuilder(MOD_ID)
            .build(new Item("hide", itemKey("hide"), itemID++));

        DIDGERIDOO = new ItemBuilder(MOD_ID)
            .build(new ItemDidgeridoo("didgeridoo", itemKey("didgeridoo"), itemID++));

    }
}
