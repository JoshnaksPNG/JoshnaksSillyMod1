package net.joshnaks.silly1.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class TrollEnderChest extends EnderChestBlock {

    private static final Text CONTAINER_NAME = Text.translatable("container.enderchest");

    public TrollEnderChest(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        EnderChestInventory enderChestInventory = player.getEnderChestInventory();
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (enderChestInventory != null && blockEntity instanceof EnderChestBlockEntity) {
            BlockPos blockPos = pos.up();
            if (world.getBlockState(blockPos).isSolidBlock(world, blockPos)) {
                return ActionResult.success(world.isClient);
            } else if (world.isClient) {
                return ActionResult.SUCCESS;
            } else {
                EnderChestBlockEntity enderChestBlockEntity = (EnderChestBlockEntity)blockEntity;
                enderChestInventory.setActiveBlockEntity(enderChestBlockEntity);
                player.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inventory, playerx) -> {
                    return GenericContainerScreenHandler.createGeneric9x3(syncId, inventory, enderChestInventory);
                }, CONTAINER_NAME));
                player.incrementStat(Stats.OPEN_ENDERCHEST);
                PiglinBrain.onGuardedBlockInteracted(player, true);
                return ActionResult.CONSUME;
            }
        } else {
            return ActionResult.success(world.isClient);
        }
    }
}
