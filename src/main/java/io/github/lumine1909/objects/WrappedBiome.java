package io.github.lumine1909.objects;

import io.github.lumine1909.api.objects.Biome;
import io.github.lumine1909.api.objects.BiomeColor;
import io.github.lumine1909.api.objects.ResourceKey;

import java.util.Optional;

import static io.github.lumine1909.RegistryAPIPlugin.plugin;
import static io.github.lumine1909.reflection.Reflection.*;
import static io.github.lumine1909.Util.*;

public class WrappedBiome implements Biome {
    private final Object nmsBiome;
    private BiomeColor color;
    public WrappedBiome(BiomeColor color, ResourceKey key) {
        this.color = color;
        Object biomeBuilder = CtBiomeBase_Builder.newInstance();
        MBiomeBase_Builder_generationSettings.invoke(biomeBuilder,
                FBiomeBase_generationSettings.get(OBiome_Plains));
        MBiomeBase_Builder_mobSpawnSettings.invoke(biomeBuilder,
                FBiomeBase_mobSettings.get(OBiome_Plains));
        FBiomeBase_Builder_temperature.set(biomeBuilder, 0.7F);
        FBiomeBase_Builder_downfall.set(biomeBuilder, 0.8F);
        Object biomeFog = CtBiomeFog.newInstance(
                color.getFogColor(), color.getWaterColor(), color.getWaterFogColor(), color.getSkyColor(),
                wrapOptional(color.getFoliageColor() == -1 ? null : color.getFoliageColor()),
                wrapOptional(color.getGrassColor() == -1 ? null : color.getGrassColor()),
                OBiomeFog_GrassColor_none,
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()
        );
        MBiomeBase_Builder_specialEffects.invoke(biomeBuilder, biomeFog);
        nmsBiome = MBiomeBase_Builder_build.invoke(biomeBuilder);
        plugin.getBiomeManager().registerBiome(this, key);
    }
    public WrappedBiome(Object nmsBiome, BiomeColor color) {
        this.nmsBiome = nmsBiome;
        this.color = color;
    }
    @Override
    public void setColor(BiomeColor color) {
        this.color = color;
    }
    @Override
    public BiomeColor getColor() {
        return color;
    }

    public Object getNmsBiome() {
        return nmsBiome;
    }
}