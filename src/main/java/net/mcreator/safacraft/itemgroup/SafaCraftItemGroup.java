
package net.mcreator.safacraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.safacraft.item.SafaniumIngotItem;
import net.mcreator.safacraft.SafacraftModElements;

@SafacraftModElements.ModElement.Tag
public class SafaCraftItemGroup extends SafacraftModElements.ModElement {
	public SafaCraftItemGroup(SafacraftModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsafa_craft") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SafaniumIngotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
