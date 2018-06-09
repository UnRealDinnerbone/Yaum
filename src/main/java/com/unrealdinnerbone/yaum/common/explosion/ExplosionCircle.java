package com.unrealdinnerbone.yaum.common.explosion;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class ExplosionCircle extends Explosion {

    @SideOnly(Side.CLIENT)
    public ExplosionCircle(World worldIn, Entity entityIn, double x, double y, double z, float size, List<BlockPos> affectedPositions) {
        super(worldIn, entityIn, x, y, z, size, false, true, affectedPositions);
    }

    @SideOnly(Side.CLIENT)
    public ExplosionCircle(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean causesFire, boolean damagesTerrain, List<BlockPos> affectedPositions) {
        super(worldIn, entityIn, x, y, z, size, causesFire, damagesTerrain);
    }

    public ExplosionCircle(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean causesFire, boolean damagesTerrain) {
        super(worldIn, entityIn, x, y, z, size, causesFire, damagesTerrain);
    }

    @Override
    public void doExplosionA() {
        Iterable<BlockPos> posList = BlockPos.getAllInBox(new BlockPos(x - (size), y - (size), z - (size)), new BlockPos(x + (size), y + (size), z + (size)));

        posList.forEach(pos -> {
            if(pos.distanceSqToCenter(x, y, z) <= size * 8)
            {
                IBlockState iblockstate = this.world.getBlockState(pos);
                if (iblockstate.getMaterial() != Material.AIR)
                {
                    world.setBlockToAir(pos);
//                float f2 = this.exploder != null ? this.exploder.getExplosionResistance(this, this.world, pos, iblockstate) : iblockstate.getBlock().getExplosionResistance(world, blockpos, (Entity)null, this);
//                f -= (f2 + 0.3F) * 0.3F;
                }
            }
        });

//        posList.forEach(pos ->
//        {
//            IBlockState iblockstate = this.world.getBlockState(pos);
//            if (iblockstate.getMaterial() != Material.AIR)
//            {
//                world.setBlockToAir(pos);
////                float f2 = this.exploder != null ? this.exploder.getExplosionResistance(this, this.world, pos, iblockstate) : iblockstate.getBlock().getExplosionResistance(world, blockpos, (Entity)null, this);
////                f -= (f2 + 0.3F) * 0.3F;
//            }
//
////            if (f > 0.0F && (this.exploder == null || this.exploder.canExplosionDestroyBlock(this, this.world, pos, iblockstate, f)))
////            {
////                set.add(blockpos);
////            }
//        });
    }

    @Override
    public void doExplosionB(boolean spawnParticles) {
        super.doExplosionB(spawnParticles);
    }
}
