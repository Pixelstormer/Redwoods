package net.coderbot.redwoods.biomes;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;

public class AlpineBiome extends Biome {
	public AlpineBiome(Biome.Settings settings, int trees, Feature<DefaultFeatureConfig> tree1, Feature<DefaultFeatureConfig> tree2) {
		super(settings);
		this.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL));
		this.addStructureFeature(Feature.STRONGHOLD, FeatureConfig.DEFAULT);

		DefaultBiomeFeatures.addLandCarvers(this);
		DefaultBiomeFeatures.addDefaultStructures(this);
		DefaultBiomeFeatures.addDefaultLakes(this);
		DefaultBiomeFeatures.addDungeons(this);
		DefaultBiomeFeatures.addMineables(this);
		DefaultBiomeFeatures.addDefaultOres(this);
		DefaultBiomeFeatures.addDefaultDisks(this);

		this.addFeature(
				GenerationStep.Feature.VEGETAL_DECORATION,
				Biome.configureFeature(
						Feature.RANDOM_SELECTOR,
						new RandomFeatureConfig(
								new Feature[]{ tree1 },
								new FeatureConfig[]{ FeatureConfig.DEFAULT },
								new float[]{ 0.5F },

								tree2,
								FeatureConfig.DEFAULT
						),
						Decorator.COUNT_EXTRA_HEIGHTMAP,
						new CountExtraChanceDecoratorConfig(trees, 0.1F, 1)
				)
		);

		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDefaultVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addEmeraldOre(this);
		DefaultBiomeFeatures.addInfestedStone(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);

		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.SHEEP, 12, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.PIG, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.COW, 8, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.LLAMA, 5, 4, 6));
		this.addSpawn(EntityCategory.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
	}
}
