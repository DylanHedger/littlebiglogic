package me.hcdh.lbl.tileentity;

import me.hcdh.lbl.LittleBigLogic;
import me.hcdh.lbl.containers.LogicBoardPrinterContainer;
import me.hcdh.lbl.registries.ModTileEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class LogicBoardPrinterTileEntity extends LockableTileEntity implements ITickableTileEntity {

    private NonNullList<ItemStack> printerContents = NonNullList.withSize(1, ItemStack.EMPTY);

    public LogicBoardPrinterTileEntity(final TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public LogicBoardPrinterTileEntity() {
        this(ModTileEntityTypes.LOGIC_BOARD_PRINTER.get());
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + LittleBigLogic.MOD_ID + ".logic_board_printer");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return null; // Working on GUI -HauntedCorpse
        // return new LogicBoardPrinterContainer(id, player, this);
    }

    @Override
    public int getSizeInventory() {
        return printerContents.size();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.printerContents.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return this.printerContents.set(index, new ItemStack(printerContents.get(index).getItem(), count));
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return this.printerContents.set(index, ItemStack.EMPTY);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.printerContents.set(index, stack);
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        this.printerContents.clear();
    }

    @Override
    public void tick() {

    }
}
