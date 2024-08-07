package io.github.LazyGamer1111.lmgtelec;

import net.minecraft.block.entity.BlockEntity;

import java.util.ArrayList;

public class PassByRefArray {
    private ArrayList<BlockEntity> blockEntities;

    public PassByRefArray(ArrayList<BlockEntity> blockEntities) {
        this.blockEntities = blockEntities;
    }

    public void addEntity(BlockEntity blockEntity){
        blockEntities.add(blockEntity);
    }

    public void removeEntity(BlockEntity blockEntity){
        blockEntities.remove(blockEntity);
    }

    public boolean contains(BlockEntity blockEntity){
        return blockEntities.contains(blockEntity);
    }

    public ArrayList<BlockEntity> getBlockEntities() {
        return blockEntities;
    }
}
