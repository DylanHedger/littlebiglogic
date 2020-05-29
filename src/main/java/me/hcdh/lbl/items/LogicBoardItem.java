package me.hcdh.lbl.items;

import me.hcdh.lbl.LittleBigLogic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class LogicBoardItem extends Item {
    public LogicBoardItem() {
        super((new Item.Properties()).maxStackSize(1).group(LittleBigLogic.LBL_ITEMGROUP));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        super.onItemRightClick(worldIn, playerIn, handIn);

        ItemStack itemstack = playerIn.getHeldItem(handIn);

        CompoundNBT nbt;
        if (itemstack.hasTag())
        {
            nbt = itemstack.getTag();

            if(nbt.getBoolean("isCreated")) {
                playerIn.sendMessage(new StringTextComponent("MMMmmmmmmmmmm YEESSSSS!"));
            }
        }
        else {
            nbt = new CompoundNBT();
            nbt.putBoolean("isCreated", true);
        }


        itemstack.setTag(nbt);
        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
    }
}
