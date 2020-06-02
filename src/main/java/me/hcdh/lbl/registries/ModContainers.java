package me.hcdh.lbl.registries;

import me.hcdh.lbl.LittleBigLogic;
import me.hcdh.lbl.client.gui.screens.LogicBoardPrinterScreen;
import me.hcdh.lbl.containers.LogicBoardPrinterContainer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, LittleBigLogic.MOD_ID);

    public static final RegistryObject<ContainerType<LogicBoardPrinterContainer>> LOGIC_BOARD_PRINTER = CONTAINERS
            .register("logic_board_printer_container", () -> IForgeContainerType.create(LogicBoardPrinterContainer::new));
}