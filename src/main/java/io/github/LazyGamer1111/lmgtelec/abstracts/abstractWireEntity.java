package io.github.LazyGamer1111.lmgtelec.abstracts;

import io.github.LazyGamer1111.lmgtelec.PassByRefArray;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public abstract class abstractWireEntity extends BlockEntity {
    protected abstractWireEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public boolean ping(BlockPos fromPos){
        return true;
    }

    public void updateBlock(World world, PassByRefArray usedEntities, double throughAmperage, double voltage){
        ArrayList<BlockEntity> surroundingBlocks = getSurroundingBlocks(world, this.getPos());
        ArrayList<BlockEntity> toEntities = new ArrayList<>();

        for (BlockEntity entity : surroundingBlocks) {
            if(entity instanceof abstractWireEntity && !usedEntities.contains(entity)) {
                if(((abstractWireEntity) entity).ping(this.getPos())) {
                    usedEntities.addEntity(entity);
                    toEntities.add(entity);
                }
            } else if (entity instanceof abstractEnergyStorageEntity && !usedEntities.contains(entity)) {
                if(!((abstractEnergyStorageEntity) entity).ping(this.getPos())){
                    usedEntities.addEntity(entity);
                    toEntities.add(entity);
                }
            }
        }

        throughAmperage /= toEntities.size();

        double finalThroughAmperage = throughAmperage;
        toEntities.forEach(entity -> {
            if(entity instanceof abstractEnergyStorageEntity) {
                ((abstractEnergyStorageEntity) entity).updateBlock(finalThroughAmperage, voltage);
            } else if (entity instanceof abstractWireEntity) {
                ((abstractWireEntity) entity).updateBlock(world, usedEntities, finalThroughAmperage, voltage);
            }

        });
    }

    private ArrayList<BlockEntity> getSurroundingBlocks(World world, BlockPos pos){
        ArrayList<BlockEntity> blocks = new ArrayList<>();

        blocks.add(world.getBlockEntity(pos.add(0, 1, 0)));
        blocks.add(world.getBlockEntity(pos.add(0, -1, 0)));
        blocks.add(world.getBlockEntity(pos.add(1, 0, 0)));
        blocks.add(world.getBlockEntity(pos.add(-1, 0, 0)));
        blocks.add(world.getBlockEntity(pos.add(0, 0, 1)));
        blocks.add(world.getBlockEntity(pos.add(0, 0, -1)));

        return blocks;
    }
}
