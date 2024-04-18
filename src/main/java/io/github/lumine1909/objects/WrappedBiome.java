package io.github.lumine1909.objects;

import io.github.lumine1909.api.objects.Biome;
import io.github.lumine1909.api.objects.BiomeColor;
import io.github.lumine1909.api.objects.ResourceKey;

import static io.github.lumine1909.RegistryAPIPlugin.plugin;
import static io.github.lumine1909.reflection.Reflection.*;

public class WrappedBiome implements Biome {
    private final Object nmsBiome;
    private BiomeColor color;
    public WrappedBiome(BiomeColor color, ResourceKey key) {
        this.color = color;
        Object biomeBuilder = CtBiomeBase_Builder.newInstance();
        MBiomeBase_Builder_generationSettings.invoke(biomeBuilder,
                MBiomeBase_getGenerationSettings.invoke(OBiome_Plains));
        MBiomeBase_Builder_mobSpawnSettings.invoke(biomeBuilder,
                MBiomeBase_getMobSettings.invoke(OBiome_Plains));
        MBiomeBase_Builder_temperature.invoke(biomeBuilder, 0.7F);
        MBiomeBase_Builder_downfall.invoke(biomeBuilder, 0.8F);
        Object biomeFogBuilder = CtBiomeFog_Builder.newInstance();
        if (color.getGrassColor() != -1) {
            MBiomeFog_Builder_grassColor.invoke(biomeFogBuilder, color.getGrassColor());
        }
        if (color.getFoliageColor() != -1) {
            MBiomeFog_Builder_foliageColor.invoke(biomeFogBuilder, color.getFoliageColor());
        }
        MBiomeFog_Builder_fogColor.invoke(biomeFogBuilder, color.getFogColor());
        MBiomeFog_Builder_skyColor.invoke(biomeFogBuilder, color.getSkyColor());
        MBiomeFog_Builder_waterColor.invoke(biomeFogBuilder, color.getWaterColor());
        MBiomeFog_Builder_waterFogColor.invoke(biomeFogBuilder, color.getWaterFogColor());
        MBiomeBase_Builder_specialEffects.invoke(biomeBuilder, MBiomeFog_Builder_build.invoke(biomeFogBuilder));
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