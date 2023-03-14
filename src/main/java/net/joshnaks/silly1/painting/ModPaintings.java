package net.joshnaks.silly1.painting;

import net.joshnaks.silly1.SillyMod1;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings
{
    public static final PaintingVariant FREE_DIAMONDS = registerPainting("free_diamonds", new PaintingVariant(32, 32));
    public static final PaintingVariant EVIL_MARIO = registerPainting("evil_mario", new PaintingVariant(32, 32));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant)
    {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(SillyMod1.MOD_ID, name), paintingVariant);
    }
    public static void registerPaintings()
    {
        SillyMod1.LOGGER.debug("Registering Paintings for " + SillyMod1.MOD_ID);
    }
}
