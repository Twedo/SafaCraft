package net.mcreator.safacraft.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.safacraft.SafacraftModVariables;
import net.mcreator.safacraft.SafacraftModElements;
import net.mcreator.safacraft.SafacraftMod;

import java.util.Map;
import java.util.Collections;

@SafacraftModElements.ModElement.Tag
public class GoHomeProcedure extends SafacraftModElements.ModElement {
	public GoHomeProcedure(SafacraftModElements instance) {
		super(instance, 45);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SafacraftMod.LOGGER.warn("Failed to load dependency entity for procedure GoHome!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SafacraftMod.LOGGER.warn("Failed to load dependency x for procedure GoHome!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SafacraftMod.LOGGER.warn("Failed to load dependency y for procedure GoHome!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SafacraftMod.LOGGER.warn("Failed to load dependency z for procedure GoHome!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SafacraftMod.LOGGER.warn("Failed to load dependency world for procedure GoHome!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
				RegistryKey<World> destinationType = World.OVERWORLD;
				ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
				if (nextWorld != null) {
					((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
					((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
							nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
					for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
					}
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
		}
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate(
					((entity.getCapability(SafacraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SafacraftModVariables.PlayerVariables())).safa_x),
					((entity.getCapability(SafacraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SafacraftModVariables.PlayerVariables())).safa_y),
					((entity.getCapability(SafacraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SafacraftModVariables.PlayerVariables())).safa_z));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation(
						((entity.getCapability(SafacraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SafacraftModVariables.PlayerVariables())).safa_x),
						((entity.getCapability(SafacraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SafacraftModVariables.PlayerVariables())).safa_y),
						((entity.getCapability(SafacraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SafacraftModVariables.PlayerVariables())).safa_z),
						_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"title @p title {\"text\":\"THANKS FOR PLAYING\", \"bold\":true, \"italic\":true, \"color\":\"yellow\"}");
		}
	}
}
