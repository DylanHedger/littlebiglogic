package me.hcdh.lbl.registries;

import me.hcdh.lbl.LittleBigLogic;
import me.hcdh.lbl.items.LogicBoardItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, LittleBigLogic.MOD_ID);

    public static final RegistryObject<Item> LOGIC_BOARD = ITEMS.register("logic_board", LogicBoardItem::new);
    public static final RegistryObject<Item> LOGIC_BOARD_PRINTER = ITEMS.register("logic_board_printer", () -> new BlockItem(ModBlocks.LOGIC_BOARD_PRINTER.get(), new Item.Properties().group(LittleBigLogic.TAB)));
}
