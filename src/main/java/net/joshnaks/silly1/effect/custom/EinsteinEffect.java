package net.joshnaks.silly1.effect.custom;

import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EinsteinEffect extends StatusEffect
{

    public EinsteinEffect()
    {
        super(StatusEffectCategory.BENEFICIAL, 0xFFACAC);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return true;
    }

    private boolean steining = false;
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        if (entity instanceof PlayerEntity playerEntity)
        {
            if(!steining && !entity.getEntityWorld().isClient())
            {
                entity.getEntityWorld().playSound(
                        null,
                        entity.getBlockPos(),
                        ModSoundEvents.EINSTEIN_EVENT,
                        SoundCategory.AMBIENT,
                        1f,1f);
                steining = true;
            }
            SendAllKnowledge(entity.getEntityWorld(), playerEntity.getDisplayName().getString() );

        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        steining = false;
    }

    private int knowLimiter = 0;
    private int knowledge_idx = 0;

    private void SendAllKnowledge(World world, String name)
    {


        if(knowLimiter == 20)
        {
            List<? extends PlayerEntity> players = world.getPlayers();

            String knowledge;

            knowledge_idx = ThreadLocalRandom.current().nextInt(0, QuestionArray.length);

            knowledge = "<" + name + ">" + QuestionArray[knowledge_idx];

            for(int i = 0; i < players.size(); ++i)
            {
                players.get(i).sendMessage(Text.literal(knowledge));
            }

            ++knowLimiter;
        } else if (knowLimiter >= 40)
        {
            List<? extends PlayerEntity> players = world.getPlayers();
            String knowledge;


            knowledge = "<" + name + ">" + AnswerArray[knowledge_idx];

            for(int i = 0; i < players.size(); ++i)
            {
                players.get(i).sendMessage(Text.literal(knowledge));
            }

            knowLimiter = 0;
        }
        else
        {
            ++knowLimiter;
        }

    }

    private String[] QuestionArray =
        {
            "9 + 10 = ?",
            "If 3x−y=12, what is the value of 8x / 2y?",
                "Points A and B lie on a circle with radius 1, and arc AB⌢ has a length of π3. What fraction of the circumference of the circle is the length of arc AB⌢?",
                "If 3(m+2) - 5 = m+2 what is value of m+2?",
                "If y>0 what is equivalent to y^(1/8) x (y^(3/4))^(3/2)",
                "What is the real solution of y = -3 and y = (x^2) + 10x + a while a is a positve constant",
                "Who said \"Now I am Sleepy, the Goer to bed\"?"
        };

    private String[] AnswerArray =
            {
                "21",
                    "4096",
                    "1 / 6",
                    "2.5",
                    "y^(5/4)",
                    "22",
                    "J Robert Oppenheimer, inventor of PJs and Warm Milk."
            };
}
