package net.coderbot.redwoods.init;

import net.coderbot.redwoods.Redwoods;
import net.coderbot.redwoods.block.BlockCenterLog;
import net.coderbot.redwoods.block.BlockConiferLeaves;
import net.coderbot.redwoods.block.BlockConiferSapling;
import net.coderbot.redwoods.block.BlockQuarterLog;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ModBlocks {
	public static Block REDWOOD_LOG;
	public static Block FIR_LOG;
	public static Block REDWOOD_LOG_QUARTER;
	public static Block FIR_LOG_QUARTER;

	public static Block REDWOOD_SAPLING;
	public static Block FIR_SAPLING;

	public static Block REDWOOD_LEAVES;
	public static Block FIR_LEAVES;

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		REDWOOD_LOG = register(event, new BlockCenterLog(), "redwood_log");
		FIR_LOG = register(event, new BlockCenterLog(), "fir_log");

		REDWOOD_LOG_QUARTER = register(event, new BlockQuarterLog(), "redwood_log_quarter");
		FIR_LOG_QUARTER = register(event, new BlockQuarterLog(), "fir_log_quarter");

		REDWOOD_SAPLING = register(event, new BlockConiferSapling(), "redwood_sapling");
		FIR_SAPLING = register(event, new BlockConiferSapling(), "fir_sapling");

		REDWOOD_LEAVES = register(event, new BlockConiferLeaves(REDWOOD_SAPLING), "redwood_leaves");
		FIR_LEAVES = register(event, new BlockConiferLeaves(FIR_SAPLING), "fir_leaves");

		// Burn the blocks!
		registerFlammables();
	}

	private static void registerFlammables() {
		Blocks.FIRE.setFireInfo(REDWOOD_LOG, 5, 5);
		Blocks.FIRE.setFireInfo(FIR_LOG, 5, 5);
		Blocks.FIRE.setFireInfo(REDWOOD_LOG_QUARTER, 5, 5);
		Blocks.FIRE.setFireInfo(FIR_LOG_QUARTER, 5, 5);

		Blocks.FIRE.setFireInfo(REDWOOD_LEAVES, 30, 60);
		Blocks.FIRE.setFireInfo(FIR_LEAVES, 30, 60);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomStateMapper(REDWOOD_LEAVES, new StateMap.Builder().ignore(BlockConiferLeaves.CHECK_DECAY, BlockConiferLeaves.DECAYABLE).build());
		ModelLoader.setCustomStateMapper(FIR_LEAVES, new StateMap.Builder().ignore(BlockConiferLeaves.CHECK_DECAY, BlockConiferLeaves.DECAYABLE).build());
	}

	private static Block register(RegistryEvent.Register<Block> event, Block block, String name) {
		block.setRegistryName(new ResourceLocation(Redwoods.MODID, name));
		block.setUnlocalizedName(Redwoods.MODID + "." + name);

		event.getRegistry().register(block);

		return block;
	}
}
