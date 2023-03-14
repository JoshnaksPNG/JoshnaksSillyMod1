package net.joshnaks.silly1.effect.custom;

import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PercedEffect extends StatusEffect {
    public PercedEffect() {
        super(StatusEffectCategory.HARMFUL, 0xACACAC);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        if (entity instanceof PlayerEntity playerEntity)
        {
            if(!lebroning && !entity.getEntityWorld().isClient())
            {
                entity.getEntityWorld().playSound(
                        null,
                        entity.getBlockPos(),
                        ModSoundEvents.LEBRON_EVENT,
                        SoundCategory.AMBIENT,
                        1f,1f);
                lebroning = true;
            }

            SendAllPercsense(entity.getEntityWorld(), playerEntity.getDisplayName().getString() );

        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        lebroning = false;
    }

    private int percLimiter = 0;
    private boolean lebroning = false;
    private void SendAllPercsense(World world, String name)
    {


        if(percLimiter >= 20)
        {
            List<? extends PlayerEntity> players = world.getPlayers();

            String knowledge;

            int knowledge_idx = 0;

            knowledge_idx = ThreadLocalRandom.current().nextInt(0, PercedArray.length);

            knowledge = "<" + name + ">" + PercedArray[knowledge_idx];

            for(int i = 0; i < players.size(); ++i)
            {
                players.get(i).sendMessage(Text.literal(knowledge));
            }

            percLimiter = 0;
        }
        else
        {
            ++percLimiter;
        }

    }

    private String[] PercedArray =
            {
                    "Here is:!",
                    "calm before the st",
                    "aprk",
                    "My eye = is like xray.,, I see through you and lies!!!",
                    "hi",
                    "detected",
                    "julius deezer",
                    "it's called the funnel",
                    "i'd love to leave you dead in a ditch",
                    "he will fly now",
                    "the only audio in the game is the dentist going \"BWWAAAAA\" for 2 seconds",
                    "can you shut yth you shut youre mouth talk to moterH?",
                    "guys jion the smp",
                    "i'm kill wholew man",
                    "brain hurt man? I",
                    "TI-84+ CE",
                    "whe nyou make 5 cents per hour making brick",
                    "slender",
                    "you cranking 90s but i play chess the whole time",
                    "I HAVE NITRO! I HAVE NITRO! I HAVE N",
                    "Krill",
                    "1738",
                    "get a real job, i'm going to invent bricks",
                    "we go to slender forest next time",
                    "swag?"
            };
}
