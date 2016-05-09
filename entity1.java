package threedprojectiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class entity1 extends EntityArrow{

	public entity1(World worldIn, EntityPlayer playerIn) {
		super(worldIn);
		this.setSize(0.5F, 0.5F);
	}

	@Override
	protected ItemStack getArrowStack() {
		return null;
	}

	public void setPotionEffect(ItemStack p_185052_2_) {
	}
}