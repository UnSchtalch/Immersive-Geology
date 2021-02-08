package com.igteam.immersivegeology.common;

import com.igteam.immersivegeology.common.world.ImmersiveBiomeProvider;
import com.igteam.immersivegeology.common.world.ImmersiveNetherBiomeProvider;
import com.igteam.immersivegeology.common.world.biome.biomes.helpers.ForestType;
import com.igteam.immersivegeology.common.world.biome.biomes.helpers.MountainType;
import com.igteam.immersivegeology.common.world.biome.biomes.nether.NetherMantle;
import com.igteam.immersivegeology.common.world.biome.biomes.nether.NetherOcean;
import com.igteam.immersivegeology.common.world.biome.biomes.overworld.*;
import com.igteam.immersivegeology.common.world.biome.biomes.overworld.PlainsBiome.PlainsType;
import com.igteam.immersivegeology.common.world.biome.biomes.helpers.OceanType;
import com.igteam.immersivegeology.common.world.chunk.ChunkGeneratorImmersiveNether;
import com.igteam.immersivegeology.common.world.chunk.ChunkGeneratorImmersiveOverworld;
import com.igteam.immersivegeology.common.world.gen.config.ImmersiveGenerationSettings;
import com.igteam.immersivegeology.common.world.gen.config.ImmersiveNetherGenSettings;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.igteam.immersivegeology.ImmersiveGeology.MODID;


@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class WorldGenRegistryEvents
{
	@SubscribeEvent
	public static void registerChunkGeneratorTypes(RegistryEvent.Register<ChunkGeneratorType<?, ?>> event)
	{
		event.getRegistry().registerAll(
				new ChunkGeneratorType<>(ChunkGeneratorImmersiveOverworld::new, false, ImmersiveGenerationSettings::new).setRegistryName("overworld"),
				new ChunkGeneratorType<>(ChunkGeneratorImmersiveNether::new, false, ImmersiveNetherGenSettings::new).setRegistryName("nether")
		);
	}

	@SubscribeEvent
	public static void registerBiomeProviderTypes(RegistryEvent.Register<BiomeProviderType<?, ?>> event)
	{
		event.getRegistry().registerAll(
				new BiomeProviderType<>(ImmersiveBiomeProvider::new, ImmersiveGenerationSettings::new).setRegistryName("overworld"),
				new BiomeProviderType<>(ImmersiveNetherBiomeProvider::new, ImmersiveNetherGenSettings::new).setRegistryName("nether")
		);
	}

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event)
	{
		event.getRegistry().registerAll(
				new OceanBiome(OceanType.NORMAL).setRegistryName("ocean"),
				new OceanBiome(OceanType.COLD).setRegistryName("cold_ocean"),
				new OceanBiome(OceanType.WARM).setRegistryName("warm_ocean"),
				new OceanBiome(OceanType.DEEP).setRegistryName("deep_ocean"),
				new OceanBiome(OceanType.DEEP_FROZEN).setRegistryName("frozen_deep_ocean"),
				new OceanBiome(OceanType.DEEP_VOLCANIC).setRegistryName("deep_ocean_volcanic"),
				new OceanBiome(OceanType.EDGE).setRegistryName("ocean_edge"),

				new NetherOcean().setRegistryName("nether_ocean"),
				new PlainsBiome(-4, 10, PlainsType.DEFAULT).setRegistryName("plains"),
				new DesertBiome(-5, 20, false).setRegistryName("desert"),
				new DesertBiome(-5, 10, true).setRegistryName("arctic_desert"),
				new LowlandsBiome().setRegistryName("lowlands"),
				new HillsBiome(16).setRegistryName("hills"),
				new CanyonsBiome(-5, 14).setRegistryName("low_canyons"),

				new MountainsBiome(52, 64, MountainType.VOLCANIC).setRegistryName("volcanic_mountains"),

				new ForestBiome(ForestType.SNOWY,3,6).setRegistryName("snowy_forest"),
				new ForestBiome(ForestType.SWEDISH,1,14).setRegistryName("swedish_forest"),
				
				new HillsBiome(28).setRegistryName("rolling_hills"),
				new BadlandsBiome().setRegistryName("badlands"),
				new PlainsBiome(20,30, PlainsType.DEFAULT).setRegistryName("plateau"),
				new PlainsBiome(20,30, PlainsType.GLACIER).setRegistryName("glacier"),
				
				new MountainsBiome(48, 28, MountainType.NORMAL).setRegistryName("old_mountains"),
				
				new MountainsBiome(48, 56, MountainType.NORMAL).setRegistryName("mountains"),
				new MountainsBiome(30, 64, MountainType.FLOODED).setRegistryName("flooded_mountains"),
				new MountainsBiome(48, 64, MountainType.LUSH).setRegistryName("lush_mountains"),
				new MountainsBiome(48, 64, MountainType.FROZEN).setRegistryName("frozen_mountains"),
				
				new MountainsBiome(35, 30, MountainType.DESERT).setRegistryName("mountain_dunes"),
				 
				new CanyonsBiome(-7, 36).setRegistryName("canyons"),

				new ShoreBiome(false).setRegistryName("shore"),
				new ShoreBiome(true).setRegistryName("stone_shore"),

				new MountainsBiome(36, 34, MountainType.NORMAL).setRegistryName("mountains_edge"),
				new LakeBiome().setRegistryName("volcanic_center"),
				new LakeBiome().setRegistryName("lake"),
				new OasisBiome().setRegistryName("oasis"),
				new RiverBiome().setRegistryName("river"),

				/*
					Nether Biomes
				*/
				new NetherMantle().setRegistryName("mantle")
		);
	}

}
