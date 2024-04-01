package luke.wombat;

import com.mojang.nbt.CompoundTag;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.EntityMonster;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.World;

public class EntityWombat extends EntityMonster {
	public EntityWombat(World world) {
		super(world);
		this.skinName = "wombat";
		this.setSize(0.9F, 0.9F);
	}

	protected Entity findPlayerToAttack() {
		EntityPlayer entityplayer = this.world.getClosestPlayerToEntity(this, 16.0);
		if (entityplayer != null && this.canEntityBeSeen(entityplayer) && entityplayer.getGamemode().areMobsHostile()) {
			return entityplayer;
		} else {
			Entity otherEntity = this.world.getClosestPlayerToEntity(this, 16.0);
			return !(otherEntity instanceof EntityWombat) ? otherEntity : null;
		}
	}

	public int getMaxSpawnedInChunk() {
		return 128;
	}

	protected float getBlockPathWeight(int i, int j, int k) {
		return 1.0F;
	}

	public boolean getCanSpawnHere() {
		return true;
	}

	protected void init() {
		super.init();
		this.entityData.define(17, (byte)0);
	}

	public String getEntityTexture() {
		return "/assets/wombat/mob/wombat/0.png";
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
	}

	public String getLivingSound() {
		return "mob.zombiepig.zpigangry";
	}

	protected String getHurtSound() {
		return "mob.wolf.growl";
	}

	protected String getDeathSound() {
		return "mob.ghast.scream";
	}

	public void playLivingSound() {
		String s = this.getLivingSound();
		if (s != null) {
			this.world.playSoundAtEntity(null, this, s, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.05F + 0.25F);
		}

	}

	public void playHurtSound() {
		this.world.playSoundAtEntity(null, this, this.getHurtSound(), this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.05F + 0.25F);
	}

	public void playDeathSound() {
		this.world.playSoundAtEntity(null, this, this.getDeathSound(), this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.05F + 0.25F);
	}

	public void onDeath(Entity entity) {
		super.onDeath(entity);
	}
}
