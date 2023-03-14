package net.joshnaks.silly1.entity.ai.goal;

import java.util.EnumSet;

import net.joshnaks.silly1.entity.custom.HuskSlaveEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal.Control;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.passive.TameableEntity;

public class TrackOwnerAttackerCustomGoal extends TrackTargetGoal {
    private final HuskSlaveEntity tameable;
    private LivingEntity attacker;
    private int lastAttackedTime;

    public TrackOwnerAttackerCustomGoal(HuskSlaveEntity tameable) {
        super(tameable, false);
        this.tameable = tameable;
        this.setControls(EnumSet.of(Control.TARGET));
    }

    public boolean canStart() {
        if (this.tameable.isTamed()) {
            LivingEntity livingEntity = this.tameable.getOwner();
            if (livingEntity == null) {
                return false;
            } else {
                this.attacker = livingEntity.getAttacker();
                int i = livingEntity.getLastAttackedTime();
                return i != this.lastAttackedTime && this.canTrack(this.attacker, TargetPredicate.DEFAULT) && this.tameable.canAttackWithOwner(this.attacker, livingEntity);
            }
        } else {
            return false;
        }
    }

    public void start() {
        this.mob.setTarget(this.attacker);
        LivingEntity livingEntity = this.tameable.getOwner();
        if (livingEntity != null) {
            this.lastAttackedTime = livingEntity.getLastAttackedTime();
        }

        super.start();
    }
}

