package io.github.LazyGamer1111.lmgtelec;

import io.github.LazyGamer1111.lmgtelec.PassByRefArray;
import io.github.LazyGamer1111.lmgtelec.abstracts.abstractWireBlock;
import io.github.LazyGamer1111.lmgtelec.testBlocks.testWireEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class testWireBlock extends abstractWireBlock {
    public testWireBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof testWireEntity){
            if(((testWireEntity) blockEntity).ping(pos));
            ((testWireEntity) blockEntity).updateBlock(world, new PassByRefArray(new ArrayList<>()), 1, 1);
        }
        return ActionResult.PASS;
    }
}
