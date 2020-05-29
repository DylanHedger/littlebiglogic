package me.hcdh.lbl;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, LittleBigLogic.MOD_ID);

    public static final Item LOGIC_BOARD = register("logic_board", new Item((new Item.Properties()).group(LittleBigLogic.LBL_ITEMGROUP)));

    public static void registerItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static Item register(String key, Item item) {
        ITEMS.register(key, () -> item);
        return item;
    }
}
