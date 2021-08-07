package dqu.additionaladditions.entity;

import dqu.additionaladditions.block.BlockRegistry;
import dqu.additionaladditions.block.GlowStickBlock;
import dqu.additionaladditions.item.ItemRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GlowStickEntity extends ThrownItemEntity {
    public GlowStickEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public GlowStickEntity(World world, LivingEntity owner) {
        super(EntityRegistry.GLOW_STICK_ENTITY_ENTITY_TYPE, owner, world);
    }

    public GlowStickEntity(World world, double x, double y, double z) {
        super(EntityRegistry.GLOW_STICK_ENTITY_ENTITY_TYPE, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.GLOW_STICK_ITEM;
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient()) {
            this.remove(RemovalReason.DISCARDED);
            BlockPos pos = new BlockPos(this.getX(), this.getY(), this.getZ());
            if (this.world.getBlockState(pos).isAir()) {
                this.world.setBlockState(pos, BlockRegistry.GLOW_STICK_BLOCK.getDefaultState()
                    .with(GlowStickBlock.FLIPPED, world.getRandom().nextBoolean()));
            } else {
                ItemStack stack = new ItemStack(ItemRegistry.GLOW_STICK_ITEM, 1);
                ItemEntity entity = new ItemEntity(this.world, this.getX(), this.getY(), this.getZ(), stack);
                this.world.spawnEntity(entity);
            }
        }
    }
}
