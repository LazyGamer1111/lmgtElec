package io.github.LazyGamer1111.lmgtelec.testBlocks;

import io.github.LazyGamer1111.lmgtelec.Main;
import io.github.LazyGamer1111.lmgtelec.abstracts.abstractWireEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class testWireEntity extends abstractWireEntity {
    public testWireEntity(BlockPos pos, BlockState state) {
        super(Main.TEST_WIRE_ENTITY_TYPE, pos, state);
    }
}
