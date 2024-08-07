package io.github.LazyGamer1111.lmgtelec.testBlocks;

import io.github.LazyGamer1111.lmgtelec.abstracts.abstractEnergyStorageBlock;
import io.github.LazyGamer1111.lmgtelec.testStorageEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class testStorageBlock extends abstractEnergyStorageBlock implements BlockEntityProvider {
    public testStorageBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new testStorageEntity(pos, state);
    }
}
