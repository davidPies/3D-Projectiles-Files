package threedprojectiles;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class soundevents {
	public static SoundEvent whish;
	
	public static void registerSounds() {
		whish = registerSound("whish");
	}
	private static SoundEvent registerSound(String soundName) {
		final ResourceLocation soundID = new ResourceLocation(threedprojectiles.modid, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
}
