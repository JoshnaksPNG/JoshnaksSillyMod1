package net.joshnaks.silly1.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.networking.ModMessages;
import net.joshnaks.silly1.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FreddyMaskHudOverlay implements HudRenderCallback
{
    private static final Identifier MASK = new Identifier(SillyMod1.MOD_ID,
            "textures/mask/mask.png");



    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta)
    {
        MinecraftClient client = MinecraftClient.getInstance();

        if(( (IEntityDataSaver) client.player).getPersistentData().getBoolean("Freddy"))
        {
            int x = 0;
            int y = 0;
            int width = 0;
            int height = 0;

            if(client != null)
            {
                width = client.getWindow().getScaledWidth();
                height = client.getWindow().getScaledHeight();

                //x = width / 2;
                //y = height;
            }

            RenderSystem.setShader(GameRenderer::getPositionTexProgram);
            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
            RenderSystem.setShaderTexture(0, MASK);

            DrawableHelper.drawTexture(matrixStack, x, y, 0, 0, width, height, width, height);
        }



    }
}
