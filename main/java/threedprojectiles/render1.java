package threedprojectiles;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.common.SidedProxy;
@SideOnly(Side.CLIENT)
public class render1 extends Render
{

// ResourceLocations are typically static and final, but that is not an absolute requirement
private static final ResourceLocation texture = new ResourceLocation("threedprojectiles:entity/entity2snow");

// if you want a model, be sure to add it here:
private ModelBase model;

public render1() {
	super(null);
// we could have initialized it above, but here is fine as well:
model = new model1();
}

@Override
protected ResourceLocation getEntityTexture(Entity entity) {
// this method should return your texture, which may be different based
// on certain characteristics of your custom entity; if that is the case,
// you may want to make a second method that takes your class:
return getCustomTexture((entity1) entity);
}

private ResourceLocation getCustomTexture(entity1 entity) {
// now you have access to your custom entity fields and methods, if any,
// and can base the texture to return upon those
return texture;
}

// in whatever render method you are using; this one is from Render class:
@Override
public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTick) {
// again, if you need some information from your custom entity class, you can cast to your
// custom class, either passing off to another method, or just doing it here
// in this example, it is not necessary

// if you are going to do any openGL matrix transformations, be sure to always Push and Pop
GL11.glPushMatrix();

// bind your texture:
bindTexture(texture);

GL11.glTranslated(x, y, z);

// if you are using a model, you can do so like this:
model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

GL11.glPopMatrix();
}
}
