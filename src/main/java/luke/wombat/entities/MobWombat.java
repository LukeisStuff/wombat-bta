package luke.wombat.entities;

import luke.wombat.items.WombatItems;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;

public class MobWombat extends MobMonster {
    public MobWombat(World world) {
        super(world);
        this.textureIdentifier = NamespaceID.getPermanent("wombat", "wombat");
        this.setSize(0.9F, 0.9F);
        this.scoreValue = 400;
        this.mobDrops.add(new WeightedRandomLootObject(WombatItems.HIDE.getDefaultStack(), 0, 3));
    }

    @Override
    public int getMaxHealth() {
        return 10;
    }

    @Override
    protected Entity findPlayerToAttack() {
        assert this.world != null;
        Player entityplayer = this.world.getClosestPlayerToEntity(this, 16.0);
        return entityplayer != null && this.canEntityBeSeen(entityplayer) && entityplayer.getGamemode().areMobsHostile() ? entityplayer : null;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 4;
    }

    @Override
    protected float getBlockPathWeight(int i, int j, int k) {
        return 1.0F;
    }

    @Override
    public String getLivingSound() {
        return "mob.pig";
    }

    @Override
    protected String getHurtSound() {
        return "mob.wolf.bark";
    }

    @Override
    protected String getDeathSound() {
        return "mob.pigdeath";
    }

    @Override
    public void playLivingSound() {
        String s = this.getLivingSound();
        if (s != null) {
            assert this.world != null;
            this.world.playSoundAtEntity(null, this, s, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.5F + 0.25F);
        }
    }

    @Override
    public void playHurtSound() {
        assert this.world != null;
        this.world.playSoundAtEntity(null, this, this.getHurtSound(), this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.5F + 0.25F);
    }

    @Override
    public void playDeathSound() {
        assert this.world != null;
        this.world.playSoundAtEntity(null, this, this.getDeathSound(), this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.5F + 0.25F);
    }

    @Override
    public boolean canSpawnHere() {
        int x = MathHelper.floor(this.x);
        int y = MathHelper.floor(this.bb.minY);
        int z = MathHelper.floor(this.z);
        int id = this.world.getBlockId(x, y - 1, z);
        if (Blocks.blocksList[id] == null) {
            return false;
        } else {
            return (Blocks.blocksList[id] == Blocks.DIRT_SCORCHED || Blocks.blocksList[id] == Blocks.DIRT_SCORCHED_RICH || Blocks.blocksList[id] == Blocks.GRASS_SCORCHED)
                && this.world.getFullBlockLightValue(x, y, z) > 8 && super.canSpawnHere();
        }
    }


}
