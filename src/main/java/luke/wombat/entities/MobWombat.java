package luke.wombat.entities;

import luke.wombat.items.WombatItems;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;

public class MobWombat extends MobMonster {
	public MobWombat(World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("wombat", "wombat");
		this.setSize(0.9F, 0.9F);
		this.scoreValue = 400;
		this.mobDrops.add(new WeightedRandomLootObject(WombatItems.HIDE.getDefaultStack(), 0, 3));
	}

	public int getMaxHealth() {
		return 10;
	}

	protected Entity findPlayerToAttack() {
        assert this.world != null;
        Player entityplayer = this.world.getClosestPlayerToEntity(this, 16.0);
		return entityplayer != null && this.canEntityBeSeen(entityplayer) && entityplayer.getGamemode().areMobsHostile() ? entityplayer : null;
	}

	public int getMaxSpawnedInChunk() {
		return 128;
	}

	protected float getBlockPathWeight(int i, int j, int k) {
		return 1.0F;
	}

	public String getLivingSound() {
		return "mob.pig";
	}

	protected String getHurtSound() {
		return "mob.wolf.bark";
	}

	protected String getDeathSound() {
		return "mob.pigdeath";
	}

	public void playLivingSound() {
		String s = this.getLivingSound();
		if (s != null) {
            assert this.world != null;
            this.world.playSoundAtEntity(null, this, s, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.5F + 0.25F);
		}
	}

	public void playHurtSound() {
        assert this.world != null;
        this.world.playSoundAtEntity(null, this, this.getHurtSound(), this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.5F + 0.25F);
	}

	public void playDeathSound() {
        assert this.world != null;
        this.world.playSoundAtEntity(null, this, this.getDeathSound(), this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.5F + 0.25F);
	}

	public void onDeath(Entity entity) {
		super.onDeath(entity);
	}

	public boolean canSpawnHere() {
		return true;
	}


}
