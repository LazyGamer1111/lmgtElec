package io.github.LazyGamer1111.lmgtelec.abstracts;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public abstract class abstractEnergyStorageEntity extends BlockEntity {
    public abstractEnergyStorageEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public boolean ping(BlockPos fromPos){
        return false;
    }

    public abstract void updateBlock(double incomingAmperage, double incomingVoltage);

    public static void onTick(MinecraftServer minecraftServer) {

    }
}
