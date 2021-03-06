
package net.mcreator.safacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.safacraft.itemgroup.SafaCraftItemGroup;
import net.mcreator.safacraft.SafacraftModElements;

@SafacraftModElements.ModElement.Tag
public class SafaniumPickaxeItem extends SafacraftModElements.ModElement {
	@ObjectHolder("safacraft:safanium_pickaxe")
	public static final Item block = null;
	public SafaniumPickaxeItem(SafacraftModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1741;
			}

			public float getEfficiency() {
				return 13f;
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
		}, 1, -3f, new Item.Properties().group(SafaCraftItemGroup.tab)) {
		}.setRegistryName("safanium_pickaxe"));
	}
}
