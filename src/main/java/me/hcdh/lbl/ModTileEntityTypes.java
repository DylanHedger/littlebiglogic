package me.hcdh.lbl;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;
import me.hcdh.lbl.items.LogicBoardItem;
import me.hcdh.lbl.tileentity.LogicBoardPrinterTileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, LittleBigLogic.MOD_ID);

    // TODO FIX THIS CAUSE IDK HOW TO REGISTER TILE ENTITIES

    //public static final TileEntityType<LogicBoardPrinterTileEntity> LOGIC_BOARD_PRINTER = register("logic_board_printer", TileEntityType.Builder.create(LogicBoardPrinterTileEntity::new, ModBlocks.LOGIC_BOARD_PRINTER));

    public static void registerTileEntities(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }

    private static TileEntityType<?> register(String key, TileEntityType.Builder<?> builder) {
        Type<?> type = DataFixesManager.getDataFixer().getSchema(DataFixUtils.makeKey(SharedConstants.getVersion().getWorldVersion())).getChoiceType(TypeReferences.BLOCK_ENTITY, key);
        TileEntityType<?> tileEntityType = builder.build(type);
        TILE_ENTITIES.register(key, () -> tileEntityType);
        return tileEntityType;
    }
}
