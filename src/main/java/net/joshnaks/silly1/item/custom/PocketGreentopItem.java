package net.joshnaks.silly1.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.EndCrystalItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PocketGreentopItem extends Item {
    public PocketGreentopItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        constuctGreentop(pos, world);

        return super.useOnBlock(context);
    }

    public void constuctGreentop(BlockPos pos, World world)
    {
        boolean isComplete = false;

        int layer = 0;
        int idx = 0;

        while (!isComplete)
        {
            if(layer == 2)
            {
                for(int i = -2; i <= 2; ++i)
                {
                    for (int j = -2; j <= 2; ++j)
                    {
                        BlockPos newPos = new BlockPos(
                                pos.getX() + i,
                                pos.getY() + layer + 1,
                                pos.getZ() + j);

                        world.setBlockState(newPos, Blocks.GRASS_BLOCK.getDefaultState());
                    }
                }
                isComplete = true;
            } else
            {
                BlockPos newPos = new BlockPos(
                        pos.getX() + blockKey[idx][0],
                        pos.getY() + layer + 1,
                        pos.getZ() + blockKey[idx][1]);

                if(idx == 2)
                {
                    if(layer == 0)
                    {
                        world.setBlockState(newPos, Blocks.OAK_DOOR.getDefaultState());
                    } else
                    {
                        world.setBlockState(newPos, Blocks.OAK_DOOR.getDefaultState().with(DoorBlock.HALF, DoubleBlockHalf.UPPER));
                    }
                } else
                {
                    world.setBlockState(newPos, Blocks.DIRT.getDefaultState());
                }

                for(int i = -1; i <= 1; ++i)
                {
                    for (int j = -1; j <= 1; ++j)
                    {
                        BlockPos newerPos = new BlockPos(
                                pos.getX() + i,
                                pos.getY() + layer + 1,
                                pos.getZ() + j);

                        world.setBlockState(newerPos, Blocks.AIR.getDefaultState());
                    }
                }

                if(idx == blockKey.length - 1)
                {
                    idx = 0;
                    ++layer;

                }else
                {
                    ++idx;
                }
            }
        }

    }

    private int[][] blockKey =
    {
            {-2, -2},
            {-1, -2},
            {0, -2},
            {1, -2},
            {2, -2},
            {2, -1},
            {2, 0},
            {2, 1},
            {2, 2},
            {1, 2},
            {0, 2},
            {-1, 2},
            {-2, 2},
            {-2, 1},
            {-2, 0},
            {-2, -1}
    };
}
