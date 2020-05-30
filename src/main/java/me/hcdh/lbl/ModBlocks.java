package me.hcdh.lbl;

import me.hcdh.lbl.blocks.LogicBoardPrinterBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, LittleBigLogic.MOD_ID);

    public static final Block LOGIC_BOARD_PRINTER = register("logic_board_printer", new LogicBoardPrinterBlock());

    public static void registerItems(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static Block register(String key, Block block) {
        BLOCKS.register(key, () -> block);
        return block;
    }
}
