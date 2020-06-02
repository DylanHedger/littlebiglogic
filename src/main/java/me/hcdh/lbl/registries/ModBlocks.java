package me.hcdh.lbl.registries;

import me.hcdh.lbl.LittleBigLogic;
import me.hcdh.lbl.blocks.LogicBoardPrinterBlock;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, LittleBigLogic.MOD_ID);

    public static final RegistryObject<Block> LOGIC_BOARD_PRINTER = BLOCKS.register("logic_board_printer", LogicBoardPrinterBlock::new);
}
