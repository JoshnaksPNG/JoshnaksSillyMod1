package net.joshnaks.silly1.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PocketGravelPitItem extends Item
{

    public PocketGravelPitItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        constructPit(pos, world);

        return super.useOnBlock(context);
    }

    private void constructPit(BlockPos pos, World world)
    {
        for(int layer = -2; layer <= 6; ++layer)
        {
            for(int i = -1; i <= 1; ++i)
            {
                for(int j = -1; j <= 1; ++j)
                {
                    BlockPos newPos = new BlockPos(
                            pos.getX() + i,
                            pos.getY() + layer,
                            pos.getZ() + j
                    );

                    if(layer >= 4)
                    {
                        world.setBlockState(newPos, Blocks.GRAVEL.getDefaultState());
                    } else
                    {
                        world.setBlockState(newPos, Blocks.AIR.getDefaultState());
                    }

                }
            }
        }
    }
}
