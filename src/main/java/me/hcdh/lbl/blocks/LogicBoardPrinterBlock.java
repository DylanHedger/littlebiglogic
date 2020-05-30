package me.hcdh.lbl.blocks;

import me.hcdh.lbl.tileentity.LogicBoardPrinterTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LogicBoardPrinterBlock extends ContainerBlock {
    public LogicBoardPrinterBlock() {
        super((Block.Properties.create(Material.IRON)));
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new LogicBoardPrinterTileEntity();
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            this.interactWith(worldIn, pos, player);
            return ActionResultType.SUCCESS;
        }
    }

    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof FurnaceTileEntity) {
            player.openContainer((INamedContainerProvider)tileentity);
        }
    }
}
