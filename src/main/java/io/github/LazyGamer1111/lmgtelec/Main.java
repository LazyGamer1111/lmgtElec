package io.github.LazyGamer1111.lmgtelec;


import io.github.LazyGamer1111.lmgtelec.abstracts.abstractEnergyStorageEntity;
import io.github.LazyGamer1111.lmgtelec.testBlocks.testStorageBlock;
import io.github.LazyGamer1111.lmgtelec.testBlocks.testWireEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class Main implements ModInitializer {
    public static final String MOD_ID = "gt-elec";

    public static final double ATMOSPHERE_TEMP = 21;

    public static final Block TEST_WIRE_BLOCK = modBlocks.register(new testWireBlock(AbstractBlock.Settings.copy(Blocks.STONE)), "test", true);
    public static final Block TEST_STORAGE_BLOCK = modBlocks.register(new testStorageBlock(AbstractBlock.Settings.copy(Blocks.STONE)), "test2", true);


    public static final BlockEntityType<testWireEntity> TEST_WIRE_ENTITY_TYPE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("tutorial", "test_block_entity"),
            BlockEntityType.Builder.create(testWireEntity::new, TEST_WIRE_BLOCK).build()
    );

    public static final BlockEntityType<testWireEntity> TEST_ENERGY_ENTITY_TYPE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("tutorial", "test_energy_entity"),
            BlockEntityType.Builder.create(testWireEntity::new, TEST_STORAGE_BLOCK).build()
    );


    @Override
    public void onInitialize() {
        ServerTickEvents.START_SERVER_TICK.register(abstractEnergyStorageEntity::onTick);
    }
}
