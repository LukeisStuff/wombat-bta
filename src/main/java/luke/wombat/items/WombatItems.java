package luke.wombat.items;

import luke.wombat.WombatConfig;
import luke.wombat.WombatMod;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemHelper;

public class WombatItems {

	private int itemID(String blockName) {
		return WombatConfig.cfg.getInt("Item IDs." + blockName);
	}

	public static Item hide;
	public static Item didgeridoo;
	public void initilizeItems() {

		// Items
		hide = ItemHelper.createItem(WombatMod.MOD_ID,
			new Item("hide", itemID("hide")), "hide.png");

		didgeridoo = ItemHelper.createItem(WombatMod.MOD_ID,
			new ItemDidgeridoo("didgeridoo", itemID("didgeridoo")), "didgeridoo.png");

	}
}
