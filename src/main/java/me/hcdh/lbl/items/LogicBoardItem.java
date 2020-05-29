package me.hcdh.lbl.items;

import me.hcdh.lbl.LittleBigLogic;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

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

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        CompoundNBT nbt;
        if (stack.hasTag())
        {
            nbt = stack.getTag();

            if(nbt.getBoolean("isCreated")) {
                tooltip.add(new StringTextComponent("\u00A7r\u00A7c\u00A7lLogic Board Created"));
            }
        }
    }
}
