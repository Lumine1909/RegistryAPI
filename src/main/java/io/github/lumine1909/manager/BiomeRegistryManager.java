package io.github.lumine1909.manager;

import io.github.lumine1909.api.manager.BiomeManager;
import io.github.lumine1909.api.objects.Biome;
import io.github.lumine1909.api.objects.BiomeColor;
import io.github.lumine1909.api.objects.ResourceKey;
import io.github.lumine1909.objects.WrappedBiome;
import org.bukkit.block.Block;

import java.util.IdentityHashMap;
import java.util.List;

import static io.github.lumine1909.reflection.Reflection.*;

public class BiomeRegistryManager implements BiomeManager {
    @Override
    public Biome getBiomeFromKey(ResourceKey key) {
        return null;
    }

    @Override
    public void registerBiome(Biome biome, ResourceKey key) {

        Object resKey = MResourceKey_create.invoke(null, FRegistries_BIOME.get(null), CtMinecraftKey.newInstance(key.key, key.value));
        System.out.println(resKey);
        FRegistryMaterials_frozen.set(ORegistryMaterials_BiomeBase_, false);
        FRegistryMaterials_unregisteredIntrusiveHolders.set(ORegistryMaterials_BiomeBase_, new IdentityHashMap<>());
        MRegistryMaterials_createIntrusiveHolder.invoke(ORegistryMaterials_BiomeBase_, ((WrappedBiome) biome).getNmsBiome());
        MRegistryMaterials_register.invoke(ORegistryMaterials_BiomeBase_,
                resKey,
                ((WrappedBiome) biome).getNmsBiome(),
                MLifeCycle_stable.invoke(null));
        FRegistryMaterials_unregisteredIntrusiveHolders.set(ORegistryMaterials_BiomeBase_, null);
        FRegistryMaterials_frozen.set(ORegistryMaterials_BiomeBase_, true);
    }

    @Override
    public Biome getBlockBiome(Block block) {
        Object blockPos = CtBlockPosition.newInstance(block.getLocation().getBlockX(), block.getLocation().getBlockY(), block.getLocation().getBlockZ());
        Object nmsWorld = MCraftWorld_getHandle.invoke(block.getWorld());
        Object nmsBiome = MHolder_value.invoke(MIWorldReader_getBiome.invoke(nmsWorld, blockPos));
        return new WrappedBiome(nmsBiome, getColorFromBiome(nmsBiome));
    }
    public BiomeColor getColorFromBiome(Object nmsBiome) {

        return null;
    }

    @Override
    public void setBlockBiome(Block block, Biome biome) {
        Object blockPos = CtBlockPosition.newInstance(block.getLocation().getBlockX(), 0, block.getLocation().getBlockZ());
        Object nmsWorld = MCraftWorld_getHandle.invoke(block.getWorld());
        Object nmsBiome = ((WrappedBiome) biome).getNmsBiome();
        if ((boolean) MWorld_hasChunkAt.invoke(nmsWorld, blockPos)) {
            Object chunk = MWorld_getChunkAt.invoke(nmsWorld, blockPos);
            if (chunk != null) {
                MChunk_setBiome.invoke(chunk,
                        block.getLocation().getBlockX() >> 2,
                        block.getLocation().getBlockY() >> 2,
                        block.getLocation().getBlockZ() >> 2,
                        MHolder_direct.invoke(null, nmsBiome));
                MChunk_setUnSaved.invoke(chunk, true);
            }
        }
    }

    @Override
    public Biome createBiome(BiomeColor color, ResourceKey key) {
        return new WrappedBiome(color, key);
    }

    @Override
    public void sendBiomeChange(Block block) {
        Object blockPos = CtBlockPosition.newInstance(block.getLocation().getBlockX(), 0, block.getLocation().getBlockZ());
        Object nmsWorld = MCraftWorld_getHandle.invoke(block.getWorld());
        Object chunk = MWorld_getChunkAt.invoke(nmsWorld, blockPos);
        Object chunkMap = FChunkProviderServer_chunkMap.get(FWorldServer_chunkSource.get(nmsWorld));
        MPlayerChunkMap_resendChange.invoke(chunkMap, List.of(chunk));
    }
}
