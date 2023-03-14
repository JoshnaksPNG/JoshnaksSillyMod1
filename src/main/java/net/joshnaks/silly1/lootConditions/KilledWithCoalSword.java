package net.joshnaks.silly1.lootConditions;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.joshnaks.silly1.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameter;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.util.JsonSerializer;

import java.util.Set;

public class KilledWithCoalSword implements LootCondition {

    static final KilledWithCoalSword INSTANCE = new KilledWithCoalSword();

    private KilledWithCoalSword() {
    }

    public LootConditionType getType() {
        return LootConditionTypes.KILLED_BY_PLAYER;
    }

    public Set<LootContextParameter<?>> getRequiredParameters() {
        return ImmutableSet.of(LootContextParameters.LAST_DAMAGE_PLAYER);
    }

    public boolean test(LootContext lootContext) {
        Entity entity = lootContext.requireParameter(LootContextParameters.KILLER_ENTITY);

        if(entity instanceof LivingEntity livingEntity)
        {
            if(livingEntity.isHolding(ModItems.Coal_Sword))
            {
                return true;
            }
        }

        return false;
    }

    public static LootCondition.Builder builder() {
        return () -> {
            return INSTANCE;
        };
    }

    public static class Serializer implements JsonSerializer<KilledWithCoalSword> {
        public Serializer() {
        }

        public void toJson(JsonObject jsonObject, KilledWithCoalSword killedByPlayerLootCondition, JsonSerializationContext jsonSerializationContext) {
        }

        public KilledWithCoalSword fromJson(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
            return KilledWithCoalSword.INSTANCE;
        }
    }
}

