package me.hcdh.lbl;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "lbl");

    public static void registerItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static Item register(String key, Item item) {
        ITEMS.register(key, () -> item);
        return item;
    }
}
