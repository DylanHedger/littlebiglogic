package me.hcdh.lbl;

import me.hcdh.lbl.items.LogicBoardItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, LittleBigLogic.MOD_ID);

    public static final Item LOGIC_BOARD = register("logic_board", new LogicBoardItem());
    public static final Item LOGIC_BOARD_PRINTER = register("logic_board_printer", new BlockNamedItem(ModBlocks.LOGIC_BOARD_PRINTER, (new Item.Properties())));

    public static void registerItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static Item register(String key, Item item) {
        ITEMS.register(key, () -> item);
        return item;
    }
}
