package threedprojectiles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class item2 extends ItemBow {
	@SideOnly(Side.CLIENT)
    //public static final int itemID = 501;
		public item2() {
        	 super();
        	 boolean canBePickedUp = false;
        	 GameRegistry.registerItem(this, "item2");
        	 	setMaxStackSize(1);
                setCreativeTab(CreativeTabs.tabCombat);
                setUnlocalizedName("item2");
                setMaxDamage(250);
		}
		 public int getMaxItemUseDuration(ItemStack stack)
		    {
		        return 2000;
		    }
		 public int getItemEnchantability()
		    {
		        return 0;
		    }
		 private ItemStack func_185060_a(EntityPlayer player)
		    {
		        if (this.func_185058_h_(player.getHeldItem(EnumHand.OFF_HAND)))
		        {
		            return player.getHeldItem(EnumHand.OFF_HAND);
		        }
		        else if (this.func_185058_h_(player.getHeldItem(EnumHand.MAIN_HAND)))
		        {
		            return player.getHeldItem(EnumHand.MAIN_HAND);
		        }
		        else
		        {
		            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
		            {
		                ItemStack itemstack = player.inventory.getStackInSlot(i);

		                if (this.func_185058_h_(itemstack))
		                {
		                    return itemstack;
		                }
		            }

		            return null;
		        }
		    }
		 public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
		    {
		        if (entityLiving instanceof EntityPlayer)
		        {
		            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
		            boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.infinity, stack) > 0;
		            ItemStack itemstack = this.func_185060_a(entityplayer);

		            int i = this.getMaxItemUseDuration(stack) - timeLeft;
		            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, (EntityPlayer)entityLiving, i, itemstack != null || flag);
		            if (i < 0) return;

		            if (itemstack != null || flag)
		            {
		                if (itemstack == null)
		                {
		                    itemstack = new ItemStack(threedprojectiles.item3);
		                }

		                float f = func_185059_b(i);

		                if ((double)f >= 0.1D)
		                {
		                    boolean flag1 = flag && itemstack.getItem() instanceof item3; //Forge: Fix consuming custom arrows.

		                    if (!worldIn.isRemote)
		                    {
		                        item3 itemarrow = (item3)((item3)(itemstack.getItem() instanceof item3 ? itemstack.getItem() : threedprojectiles.item3));
		                        entity1 entityarrow = itemarrow.makeTippedArrow(worldIn, itemstack, entityplayer);
		                        entityarrow.func_184547_a(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);

		                        if (f == 1.0F)
		                        {
		                            entityarrow.setIsCritical(true);
		                        }

		                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.power, stack);

		                        if (j > 0)
		                        {
		                            entityarrow.setDamage(entityarrow.getDamage() + (double)j * 0.5D + 0.5D);
		                        }

		                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.punch, stack);

		                        if (k > 0)
		                        {
		                            entityarrow.setKnockbackStrength(k);
		                        }

		                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.flame, stack) > 0)
		                        {
		                            entityarrow.setFire(100);
		                        }

		                        stack.damageItem(1, entityplayer);

		                        if (flag1)
		                        {
		                            entityarrow.canBePickedUp = entity1.PickupStatus.CREATIVE_ONLY;
		                        }

		                        worldIn.spawnEntityInWorld(entityarrow);
		                    }

		                    worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, soundevents.q, SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

		                    if (!flag1)
		                    {
		                        --itemstack.stackSize;

		                        if (itemstack.stackSize == 0)
		                        {
		                            entityplayer.inventory.deleteStack(itemstack);
		                        }
		                    }

		                    entityplayer.addStat(StatList.func_188057_b(this));
		                }
		            }
		        }
		    }

		    public static float func_185059_b(int p_185059_0_)
		    {
		        float f = (float)p_185059_0_ / 20.0F;
		        f = (f * f + f * 2.0F) / 3.0F;

		        if (f > 1.0F)
		        {
		            f = 1.0F;
		        }

		        return f;
		    }
}
