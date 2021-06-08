package net.mcreator.safacraft.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;

import net.mcreator.safacraft.SafacraftModElements;
import net.mcreator.safacraft.SafacraftMod;

import java.util.Map;

@SafacraftModElements.ModElement.Tag
public class CheckForSpawnProcedure extends SafacraftModElements.ModElement {
	public CheckForSpawnProcedure(SafacraftModElements instance) {
		super(instance, 47);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SafacraftMod.LOGGER.warn("Failed to load dependency world for procedure CheckForSpawn!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Flappy Spawned"), ChatType.SYSTEM, Util.DUMMY_UUID);
		}
	}
}
