package threedprojectiles;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class item1 extends ItemSnowball{
public item1(){
  super();

GameRegistry.registerItem(this, "item1");
this.maxStackSize = 1;
this.setUnlocalizedName("item1");
this.setCreativeTab(CreativeTabs.tabMisc);
  }
public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
{
    if (!playerIn.capabilities.isCreativeMode)
    {
        --itemStackIn.stackSize;
    }

    worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, soundevents.q, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

    if (!worldIn.isRemote)
    {
        entity1 entitysnowball = new entity1(worldIn, playerIn);
        entitysnowball.func_184547_a(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.spawnEntityInWorld(entitysnowball);
    }

    playerIn.addStat(StatList.func_188057_b(this));
    return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}
}
