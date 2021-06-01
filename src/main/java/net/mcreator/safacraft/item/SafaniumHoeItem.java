
package net.mcreator.safacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.safacraft.itemgroup.SafaCraftItemGroup;
import net.mcreator.safacraft.SafacraftModElements;

@SafacraftModElements.ModElement.Tag
public class SafaniumHoeItem extends SafacraftModElements.ModElement {
	@ObjectHolder("safacraft:safanium_hoe")
	public static final Item block = null;
	public SafaniumHoeItem(SafacraftModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1741;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 8;
			}

			public int getEnchantability() {
				return 56;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SafaniumIngotItem.block, (int) (1)));
			}
		}, 0, -3f, new Item.Properties().group(SafaCraftItemGroup.tab)) {
		}.setRegistryName("safanium_hoe"));
	}
}
