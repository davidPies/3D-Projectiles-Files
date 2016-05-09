package threedprojectiles;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.RegistryNamespaced;

public class sounds extends SoundEvent{
	public static final RegistryNamespaced<ResourceLocation, SoundEvent> soundEventRegistry = net.minecraftforge.fml.common.registry.GameData.getSoundEventRegistry();
    private final ResourceLocation soundName;
    private static int soundEventId = 1;

    public sounds(ResourceLocation soundNameIn)
    {
    	super(soundNameIn);
        this.soundName = soundNameIn;
    }

    @SideOnly(Side.CLIENT)
    public ResourceLocation getSoundName()
    {
        return this.soundName;
    }

    public static void registerSounds()
    {
        registerSound("weather.rain.above");
    }

    private static void registerSound(String soundNameIn)
    {
        ResourceLocation resourcelocation = new ResourceLocation(soundNameIn);
        soundEventRegistry.register(1, resourcelocation, new SoundEvent(resourcelocation));
    }
}