package luke.wombat.items;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.wombat.WombatMod.MOD_ID;

public class WombatItems {

	int itemID = 17550;

	public static Item HIDE;
	public static Item DIDGERIDOO;
	public void initilizeItems() {

		// Items
		HIDE = new ItemBuilder(MOD_ID)
			.build(new Item("hide", "wildwombats:item/hide", itemID++));

		DIDGERIDOO = new ItemBuilder(MOD_ID)
			.build(new ItemDidgeridoo("didgeridoo", "wildwombats:item/didgeridoo", itemID++));

	}
}
