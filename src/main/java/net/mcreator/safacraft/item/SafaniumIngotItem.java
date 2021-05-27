
package net.mcreator.safacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.safacraft.itemgroup.SafaCraftItemGroup;
import net.mcreator.safacraft.SafacraftModElements;

@SafacraftModElements.ModElement.Tag
public class SafaniumIngotItem extends SafacraftModElements.ModElement {
	@ObjectHolder("safacraft:safanium_ingot")
	public static final Item block = null;
	public SafaniumIngotItem(SafacraftModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SafaCraftItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("safanium_ingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
