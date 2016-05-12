package threedprojectiles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    super.preInit(e);
    }

    public void init(FMLInitializationEvent e) {
    super.init(e);
    RenderingRegistry.registerEntityRenderingHandler(entity1.class, threedprojectiles.render1);
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(threedprojectiles.item1, 0, new ModelResourceLocation(threedprojectiles.modid + ":" + threedprojectiles.item1.getUnlocalizedName().substring(5), "inventory"));
    Minecraft.getMinecraft().getSoundHandler().func_184398_a(new ModelResourceLocation(threedprojectiles.modid + ":" + "sounds"));
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(threedprojectiles.item2, 0, new ModelResourceLocation(threedprojectiles.modid + ":" + threedprojectiles.item2.getUnlocalizedName().substring(5), "inventory"));
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(threedprojectiles.item3, 0, new ModelResourceLocation(threedprojectiles.modid + ":" + threedprojectiles.item3.getUnlocalizedName().substring(5), "inventory"));
    }

    public void postInit(FMLPostInitializationEvent e) {
    super.postInit(e);
    }
}