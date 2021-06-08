
package net.mcreator.safacraft.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.safacraft.SafacraftModElements;

@SafacraftModElements.ModElement.Tag
public class SafaPaintingPainting extends SafacraftModElements.ModElement {
	public SafaPaintingPainting(SafacraftModElements instance) {
		super(instance, 43);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(48, 16).setRegistryName("safa_painting"));
	}
}
