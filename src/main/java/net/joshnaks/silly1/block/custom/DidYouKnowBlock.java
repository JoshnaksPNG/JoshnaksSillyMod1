package net.joshnaks.silly1.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DidYouKnowBlock extends Block
{
    public static BooleanProperty POWERED;

    public DidYouKnowBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != (Boolean)state.get(POWERED)) {
            if (bl) {
                SendDoYouAll(world);
            }

            world.setBlockState(pos, (BlockState)state.with(POWERED, bl), 3);
        }
    }

    public boolean onSyncedBlockEvent(BlockState state, World world, BlockPos pos, int type, int data)
    {
        SendDoYouAll(world);
        return true;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(new Property[]{POWERED});
    }

    static
    {
        POWERED = Properties.POWERED;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == hand.MAIN_HAND)
        {
            SendDoYouAll(world);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    private void SendDoYouAll(World world)
    {
        List<? extends PlayerEntity> players = world.getPlayers();

        String knowledge;

        int knowledge_idx = 0;

        knowledge_idx = ThreadLocalRandom.current().nextInt(0, DoYouArray.length);

        knowledge = DoYouArray[knowledge_idx];

        for(int i = 0; i < players.size(); ++i)
        {
            players.get(i).sendMessage(Text.literal(knowledge));
        }

    }

    private String[] DoYouArray =
    {
        "Jeffery Dahmer Was Beaten To Death Behind Bars.",
        "Cleopatra wasn't Egyptian",
        "Paul Revere never actually shouted \"The British are coming\"",
            "Did you know Edison didn't invent the light bulb?",
            "Heroin was once a perfectly acceptable drug.",
            "Did you know poeple who stay up late are more likely to experience nightmares?",
            "Caesar was the richest human being in the world.",
            "Did you know Vikings discovered America?",
            "Did you know the Mona Lisa doesn't have any eyebrows?",
            "Did you know drinking too much water can kill you?",
            "Did you know you can buy a flying bicycle?",
            "Did you know a cloud weighs more than a million pounds?",
            "Did you know Crying actually makes you happier!",
            "Did you know we swallow 8 spiders in our lifetime?",
            "Did you know snails nap sometimes up to 3 years?",
            "Did you know Hippos have pink milk?",
            "Did you know we waste 2 weeks of our life at traffic lights?",
            "Did you know most babies are born with blue eyes?",
            "Did you know polar bears have clear fur?",
            "Did you know you can't hum when you plug your nose?",
            "Did you know all clownfish are born male?",
            "Did you know gorillas can catch human colds?",
            "Did you know sugar doesn't acrually make you hyper?",
            "Did you know you use more than 10% of your brain?",
            "Did you know the earth isn't flat?",
            "Did you know your phone in rise doesn't actually fix it?",
            "Did you know there is more than 7 colors in the rainbow?",
            "Did you know carrots don't increase your vision?",
            "Did you know cheetahs meow?",
            "Did you know eagles don't screech?",
            "Did you know eating before swimming doesn't give you cramps?",
            "Did you know the sun isn't actually yellow or orange?",
            "Did you know honey never expires?",
            "Did you know lobsters pee out of their faces?",
            "Did you know the lion isn't the king of the jungle?",
            "Did you know the rapper Takeoff also Deejay'd?",
            "Did you know 10% of the world's population is left handed?",
            "Did you know hot water freezes faster than cold water?",
            "Did you know fortune cookies was invented in America?",
            "Did you know sugar or honey heals cuts faster?",
            "Did you know 1700 people become millionares everyday?",
            "Did you know we will sleep 25 years of our live away?",
            "Did you know camels are not born with humps?",
            "Did you know oranges are man made fruits?",
            "Did you know stop signs use to be yellow?",
            "Did you know napping is good for your heart and health?",
            "Did you know owls don't have eyeballs?",
            "Did you know Google was first called \"Backrub\"",
            "Did you know the chicken came before the egg?",
            "Did you know Queen Elizabeth II was a trained mechanic?",
            "Did you know China owns all the giant pandas in the world?",
            "Did you know we are made of stardust?",
            "Did you know you will spend 2 years of your life on the phone?",
            "Did you know nerd was coined by Dr. Seuss?!",
            "Did you know a crocodile can not sick it's tongue out?",
            "Did you know elephants can hear with their feet?",
            "Did you know fake smiling can hurt you?",
            "Did you know robots could replace 40% of human jobs?",
            "Did you know money isn't actually made out of paper?",
            "Did you know birds get depressed?",
            "Did you know Van Gogh only sold one painting in his lifetime?",
            "Did you know your brain is made of 70% water?",
            "Did you know Facebook was used in one out of every 3 divorces?",
            "Did you know coke was initially green?",
            "Did you know the tongue is the strongest muscle",
            "Did you know there is a town in the US with a population of one?",
            "Did you know the human body literally glows?",
            "Did you know Superman didn't always fly?",
            "Did you know kids ask an average 300 questions a day?",
            "Did you know morphite use to be in medicine even for kids?",
            "Did you know the first iPhone wasn't made by Apple?",
            "Did you know there are two thousand active serial killers in the USA?",
            "Did you know Alabama just won the iron bowl?",
            "Did you know supermarket apples can be up to a year old?",
            "Did you know dogs eat their own poop?",
            "Did you know certain clouds look like ufos?",
            "Did you know most of our fears are learned or acquired?",
            "Did you know most Koreans don't have armpit odor?",
            "Did you know ab negative blood type is the most rare?",
            "Did you know at any given time 50 million people are drunk?",
            "Did you know most people fall asleep in 7 minutes?",
            "Did you know hippos can run faster than a human?",
            "Did you know nearly 40 percent of men and women will have cancer at some point in their lifetime?",
            "Did you know the mosquito is the #2 animal to kill humans?",
            "Did you know the seahorse is the only animal where the male gives birth?",
            "Did you know a flamingo has to heat with his head turned upside down?",
            "Did you know it is false that if you eat before swimming that you'll catch cramps?",
            "Did you know humans did not evolve from chimps?",
            "Did you know vitamins supposedly don't help keep you healthy? And could make you worse!!"
    };
}
