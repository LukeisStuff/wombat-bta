package luke.wombat.items;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemDidgeridoo extends Item {
	public ItemDidgeridoo(String name, int id) {
		super(name, id);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		world.playSoundAtEntity(entityplayer, entityplayer, "ambient.cave.cave", 1.0F, 2.0F);
		return itemstack;
	}
}
