package luke.wombat.items;

import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.world.World;

import java.util.Random;

public class ItemDidgeridoo extends Item {
	public ItemDidgeridoo(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		world.playSoundAtEntity(entityplayer, entityplayer, "ambient.cave.cave", 1.0F, 0.5f);
		return itemstack;
	}

	public void onUseByActivator(ItemStack itemStack, TileEntityActivator activatorBlock, World world, Random random, int blockX, int blockY, int blockZ, double offX, double offY, double offZ, Direction direction) {
		world.playSoundAtEntity(null, null, "ambient.cave.cave", 1.0F, 0.5f);
	}
}
