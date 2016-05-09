package threedprojectiles;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class item3 extends Item {
	public item3(){
		super();
		GameRegistry.registerItem(this, "item3");
		this.maxStackSize = 16;
		this.setUnlocalizedName("item3");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public entity1 makeTippedArrow(World worldIn, ItemStack p_185052_2_, EntityPlayer shooter)
    {
        entity1 entitytippedarrow = new entity1(worldIn, shooter);
        entitytippedarrow.setPotionEffect(p_185052_2_);
        return entitytippedarrow;
    }
}
