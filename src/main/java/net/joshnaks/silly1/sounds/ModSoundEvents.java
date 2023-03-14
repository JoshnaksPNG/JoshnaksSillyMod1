package net.joshnaks.silly1.sounds;

import net.joshnaks.silly1.SillyMod1;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents
{
    public static final Identifier LEBRON_ID = new Identifier("sillymod1:lebron");
    public static final Identifier EINSTEIN_ID = new Identifier("sillymod1:einstein");
    public static final Identifier FAIL_ID = new Identifier("sillymod1:fail");
    public static final Identifier FREDDY_ON_ID = new Identifier("sillymod1:freddy");
    public static final Identifier FREDDY_OFF_ID = new Identifier("sillymod1:freddy2");
    public static final Identifier CLARINET_ID = new Identifier("sillymod1:clarinet");
    public static final Identifier VACUUM_ID = new Identifier("sillymod1:vacuum");

    public static final Identifier VACUUM_OFF_ID = new Identifier("sillymod1:vacuum_off");

    public static final Identifier VACUUM_ON_ID = new Identifier("sillymod1:vacuum_on");
    public static SoundEvent LEBRON_EVENT = SoundEvent.of(LEBRON_ID);
    public static SoundEvent EINSTEIN_EVENT = SoundEvent.of(EINSTEIN_ID);
    public static SoundEvent FAIL_EVENT = SoundEvent.of(FAIL_ID);
    public static SoundEvent FREDDY_ON_EVENT = SoundEvent.of(FREDDY_ON_ID);
    public static SoundEvent FREDDY_OFF_EVENT = SoundEvent.of(FREDDY_OFF_ID);
    public static SoundEvent CLARINET_EVENT = SoundEvent.of(CLARINET_ID);
    public static SoundEvent VACUUM_EVENT = SoundEvent.of(VACUUM_ID);
    public static SoundEvent VACUUM_OFF_EVENT = SoundEvent.of(VACUUM_OFF_ID);
    public static SoundEvent VACUUM_ON_EVENT = SoundEvent.of(VACUUM_ON_ID);

    public static final SoundEvent LEBRON = Registry.register(Registries.SOUND_EVENT, LEBRON_ID, LEBRON_EVENT );
    public static final SoundEvent EINSTEIN = Registry.register(Registries.SOUND_EVENT, EINSTEIN_ID, EINSTEIN_EVENT );
    public static final SoundEvent FAIL = Registry.register(Registries.SOUND_EVENT, FAIL_ID, FAIL_EVENT );
    public static final SoundEvent FREDDY_ON = Registry.register(Registries.SOUND_EVENT, FREDDY_ON_ID, FREDDY_ON_EVENT );
    public static final SoundEvent FREDDY_OFF = Registry.register(Registries.SOUND_EVENT, FREDDY_OFF_ID, FREDDY_OFF_EVENT );
    public static final SoundEvent CLARINET = Registry.register(Registries.SOUND_EVENT, CLARINET_ID, CLARINET_EVENT );
    public static final SoundEvent VACUUM = Registry.register(Registries.SOUND_EVENT, VACUUM_ID, VACUUM_EVENT );
    public static final SoundEvent VACUUM_ON = Registry.register(Registries.SOUND_EVENT, VACUUM_ON_ID, VACUUM_ON_EVENT );
    public static final SoundEvent VACUUM_OFF = Registry.register(Registries.SOUND_EVENT, VACUUM_OFF_ID, VACUUM_OFF_EVENT );

    public static void registerModSounds()
    {
        SillyMod1.LOGGER.debug("Registering Sounds for " + SillyMod1.MOD_ID);
    }
}
