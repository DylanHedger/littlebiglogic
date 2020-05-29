package me.hcdh.lbl;

import net.minecraftforge.eventbus.api.IEventBus;

public class RegistryHandler {
    public static void register(IEventBus eventBus) {
        ModItems.registerItems(eventBus);
        ModBlocks.registerItems(eventBus);
    }
}
