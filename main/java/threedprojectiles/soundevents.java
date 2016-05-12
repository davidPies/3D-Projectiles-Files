package threedprojectiles;

import net.minecraft.init.Bootstrap;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class soundevents {

	public static final SoundEvent q;
	
	private static SoundEvent getRegisteredSoundEvent(String id)
    {
        SoundEvent soundevent = (SoundEvent)SoundEvent.soundEventRegistry.getObject(new ResourceLocation(id));

            return soundevent;
        }

    static
    {
        if (!Bootstrap.isRegistered())
        {
            throw new RuntimeException("Accessed Sounds before Bootstrap!");
        }
        else
        {
	q = getRegisteredSoundEvent("sounds");
        }
    }
}
