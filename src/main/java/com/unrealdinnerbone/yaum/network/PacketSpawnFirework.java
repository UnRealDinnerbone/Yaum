package com.unrealdinnerbone.yaum.network;

import com.unrealdinnerbone.yaum.api.firework.EnumExplodeEffect;
import com.unrealdinnerbone.yaum.api.firework.EnumFireworkEffect;
import com.unrealdinnerbone.yaum.api.firework.FireworkBase;
import com.unrealdinnerbone.yaum.api.network.ISimplePacket;
import com.unrealdinnerbone.yaum.libs.utils.FacingUtil;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PacketSpawnFirework implements ISimplePacket<PacketSpawnFirework> {

    private BlockPos blockPos;
    private EnumFacing facing;
    private FireworkBase fireworkBase;


    public PacketSpawnFirework() {  }


    public PacketSpawnFirework(BlockPos blockPos, FireworkBase simpleFirework, EnumFacing facing) {
        this.blockPos = blockPos;
        this.facing = facing;
        this.fireworkBase = simpleFirework;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.blockPos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
        this.facing = FacingUtil.getFacingFormID(buf.readInt());
        EnumExplodeEffect enumExplodeEffect = EnumExplodeEffect.getEffectFormID(buf.readInt());

        int effectsSize = buf.readInt();
        List<EnumFireworkEffect> fireworkEffects = IntStream.rangeClosed(1, effectsSize).mapToObj(x -> EnumFireworkEffect.getEffectFormID(buf.readInt())).collect(Collectors.toList());

        int brustColorSize = buf.readInt();
        List<Integer> brustColors = IntStream.rangeClosed(1, brustColorSize).mapToObj(x -> buf.readInt()).collect(Collectors.toList());

        int fadeColorsSize = buf.readInt();
        List<Integer> fadeColors = IntStream.rangeClosed(1, fadeColorsSize).mapToObj(x -> buf.readInt()).collect(Collectors.toList());

        FireworkBase fireworkBase = new FireworkBase();
        fireworkBase.setExplodeEffect(enumExplodeEffect);
        fireworkBase.setFireworkEffects(fireworkEffects);
        fireworkBase.setColors(brustColors);
        fireworkBase.setFadeColors(fadeColors);
        this.fireworkBase = fireworkBase;

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(blockPos.getX());
        buf.writeInt(blockPos.getY());
        buf.writeInt(blockPos.getZ());

        buf.writeInt(facing.getIndex());

        buf.writeInt(fireworkBase.getExplodedEffect().getExplodeID());

        buf.writeInt(fireworkBase.getFireworkEffects().size());
        fireworkBase.getFireworkEffects().stream().mapToInt(EnumFireworkEffect::getExplodeID).forEach(buf::writeInt);

        buf.writeInt(fireworkBase.getBrustColors().size());
        fireworkBase.getBrustColors().stream().mapToInt(Integer::intValue).forEach(buf::writeInt);

        buf.writeInt(fireworkBase.getFadeColors().size());
        fireworkBase.getFadeColors().stream().mapToInt(Integer::intValue).forEach(buf::writeInt);



    }

    public BlockPos getBlockPos() {
        return blockPos;
    }

    public FireworkBase getFireworkBase() {
        return fireworkBase;
    }

    public EnumFacing getFacing() {
        return facing;
    }

    @Override
    public IMessage onMessage(PacketSpawnFirework message, MessageContext ctx) {
        message.getFireworkBase().spawnFirework(message.getBlockPos(), 0, 0, 0);
        return null;
    }
}
