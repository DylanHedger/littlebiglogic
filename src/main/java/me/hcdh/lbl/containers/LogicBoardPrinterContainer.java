package me.hcdh.lbl.containers;

import me.hcdh.lbl.registries.ModBlocks;
import me.hcdh.lbl.registries.ModContainers;
import me.hcdh.lbl.tileentity.LogicBoardPrinterTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import javax.annotation.Nonnull;
import java.util.Objects;

public class LogicBoardPrinterContainer extends Container {

    public final LogicBoardPrinterTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public LogicBoardPrinterContainer(final int windowId, final PlayerInventory playerInventory, final LogicBoardPrinterTileEntity tileEntity) {
        super(ModContainers.LOGIC_BOARD_PRINTER.get(), windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

        // Main Inventory
        this.addSlot(new Slot(tileEntity, 0, 8, 18));

        // Player Inventory
        int startPlayerInvY = 102;
        for(int row = 0; row < 3; ++row) {
            for(int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row*9) + column, 8 + (column * 18), startPlayerInvY + (row * 18)));
            }
        }

        // Player Hotbar
        int hotBarY = startPlayerInvY + (startPlayerInvY / 2) + 7;
        for(int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, 8, hotBarY));
        }
    }

    private static LogicBoardPrinterTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if(tileAtPos instanceof LogicBoardPrinterTileEntity) {
            return (LogicBoardPrinterTileEntity)tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    public LogicBoardPrinterContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.LOGIC_BOARD_PRINTER.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if(index < 36) {
                if (!this.mergeItemStack(itemStack1, 36, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if(!this.mergeItemStack(itemStack1, 0, 36, false)) {
                return ItemStack.EMPTY;
            }

            if(itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

        }

        return itemStack;
    }
}
