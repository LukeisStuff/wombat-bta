package luke.wombat.entities;

import com.mojang.nbt.CompoundTag;
import luke.wombat.items.WombatItems;
import net.minecraft.core.Global;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.EntityMonster;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.World;

public class EntityWombat extends EntityMonster {
	public EntityWombat(World world) {
		super(world);
		this.skinName = "wombat";
		this.setSize(0.9F, 0.9F);
		this.scoreValue = 400;
	}

	public int getMaxHealth() {
		return 10;
	}

	protected Entity findPlayerToAttack() {
		EntityPlayer entityplayer = this.world.getClosestPlayerToEntity(this, 16.0);
		return entityplayer != null && this.canEntityBeSeen(entityplayer) && entityplayer.getGamemode().areMobsHostile() ? entityplayer : null;
	}


	protected int getDropItemId() {
		return WombatItems.hide.id;
	}

	protected void dropFewItems() {
		int i = this.random.nextInt(3);

		int k;
		for(k = 0; k < i; ++k) {
			this.spawnAtLocation(WombatItems.hide.id, 1);
		}

		i = this.random.nextInt(3);

		for(k = 0; k < i; ++k) {
			this.spawnAtLocation(WombatItems.hide.id, 1);
		}

	}

	public int getMaxSpawnedInChunk() {
		return 128;
	}

	protected float getBlockPathWeight(int i, int j, int k) {
		return 1.0F;
	}

	protected void init() {
		this.entityData.define(17, (byte)0);
	}

	public String getEntityTexture() {
		return "/assets/wombat/mob/" + this.skinName + "/" + this.getSkinVariant() + ".png";
	}
@Override
	public int getSkinVariant() {
		int skinVariantCount = 3;
		return this.entityData.getByte(1) % skinVariantCount;
}

	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
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
			this.world.playSoundAtEntity(null, this, s, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.5F + 0.25F);
		}

	}

	public void playHurtSound() {
		this.world.playSoundAtEntity(null, this, this.getHurtSound(), this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.5F + 0.25F);
	}

	public void playDeathSound() {
		this.world.playSoundAtEntity(null, this, this.getDeathSound(), this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.5F + 0.25F);
	}

	public void onDeath(Entity entity) {
		super.onDeath(entity);
	}
@Override
public boolean getCanSpawnHere() {
	return true;
}

}
