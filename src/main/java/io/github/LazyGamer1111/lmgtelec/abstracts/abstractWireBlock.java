package io.github.LazyGamer1111.lmgtelec.abstracts;

import io.github.LazyGamer1111.lmgtelec.testBlocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public abstract class abstractWireBlock extends Block implements BlockEntityProvider {
    public abstractWireBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new testWireEntity(pos, state);
    }
}
