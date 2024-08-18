package luke.wombat.items;

import luke.wombat.WombatConfig;
import luke.wombat.WombatMod;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.ItemHelper;

import static luke.wombat.WombatMod.MOD_ID;

public class WombatItems {

	private int itemID(String itemName) {
		return WombatConfig.cfg.getInt("Item IDs." + itemName);
	}

	public static Item hide;
	public static Item didgeridoo;
	public void initilizeItems() {

		// Items
		hide = new ItemBuilder(MOD_ID)
			.setIcon("wombat:item/hide")
			.build(new Item("hide", itemID("hide")));

		didgeridoo = new ItemBuilder(MOD_ID)
			.setIcon("wombat:item/didgeridoo")
			.build(new ItemDidgeridoo("didgeridoo", itemID("didgeridoo")));

	}
}
