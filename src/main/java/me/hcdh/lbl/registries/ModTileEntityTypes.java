package me.hcdh.lbl.registries;

import me.hcdh.lbl.LittleBigLogic;
import me.hcdh.lbl.tileentity.LogicBoardPrinterTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, LittleBigLogic.MOD_ID);

    public static final RegistryObject<TileEntityType<LogicBoardPrinterTileEntity>> LOGIC_BOARD_PRINTER = TILE_ENTITIES
            .register("logic_board_printer", () -> TileEntityType.Builder
                    .create(LogicBoardPrinterTileEntity::new, ModBlocks.LOGIC_BOARD_PRINTER.get()).build(null));
}
