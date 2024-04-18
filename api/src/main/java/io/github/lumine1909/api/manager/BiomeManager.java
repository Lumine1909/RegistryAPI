package io.github.lumine1909.api.manager;

import io.github.lumine1909.api.objects.Biome;
import io.github.lumine1909.api.objects.BiomeColor;
import io.github.lumine1909.api.objects.ResourceKey;
import org.bukkit.World;
import org.bukkit.block.Block;

public interface BiomeManager {
    Biome getBiomeFromKey(ResourceKey key);
    void registerBiome(Biome biome, ResourceKey key);
    Biome getBlockBiome(Block block);
    void setBlockBiome(Block block, Biome biome);
    Biome createBiome(BiomeColor color, ResourceKey key);
    void sendBiomeChange(Block block);
}