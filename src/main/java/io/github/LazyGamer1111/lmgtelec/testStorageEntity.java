package io.github.LazyGamer1111.lmgtelec;

import io.github.LazyGamer1111.lmgtelec.abstracts.abstractEnergyStorageEntity;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

import static io.github.LazyGamer1111.lmgtelec.Main.TEST_ENERGY_ENTITY_TYPE;

public class testStorageEntity extends abstractEnergyStorageEntity {
    public testStorageEntity(BlockPos pos, BlockState state) {
        super(TEST_ENERGY_ENTITY_TYPE, pos, state);
    }

    @Override
    public void updateBlock(double incomingAmperage, double incomingVoltage) {
        Objects.requireNonNull(this.getWorld()).playSound(null, this.getPos(), SoundEvents.BLOCK_ANVIL_HIT, SoundCategory.MASTER, 10, 1);
    }
}
