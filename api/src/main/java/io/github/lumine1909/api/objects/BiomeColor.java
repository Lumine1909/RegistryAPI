package io.github.lumine1909.api.objects;

public class BiomeColor {

    private int grassColor = -1;
    private int foliageColor = -1;
    private int waterColor = 0;
    private int waterFogColor = 0;
    private int skyColor = 0;
    private int fogColor = 0;
    public BiomeColor(int grass, int folia, int water, int waterFog, int sky, int fog) {
        grassColor = grass;
        foliageColor = folia;
        waterColor = water;
        waterFogColor = waterFog;
        skyColor = sky;
        fogColor = fog;
    }
    public BiomeColor() {

    }
    public BiomeColor setGrassColor(int grassColor) {
        this.grassColor = grassColor;
        return this;
    }

    public BiomeColor setFoliageColor(int foliageColor) {
        this.foliageColor = foliageColor;
        return this;
    }

    public BiomeColor setWaterColor(int waterColor) {
        this.waterColor = waterColor;
        return this;
    }

    public BiomeColor setWaterFogColor(int waterFogColor) {
        this.waterFogColor = waterFogColor;
        return this;
    }

    public BiomeColor setSkyColor(int skyColor) {
        this.skyColor = skyColor;
        return this;
    }

    public BiomeColor setFogColor(int fogColor) {
        this.fogColor = fogColor;
        return this;
    }

    public int getGrassColor() {
        return grassColor;
    }

    public int getFoliageColor() {
        return foliageColor;
    }

    public int getWaterColor() {
        return waterColor;
    }

    public int getWaterFogColor() {
        return waterFogColor;
    }

    public int getSkyColor() {
        return skyColor;
    }

    public int getFogColor() {
        return fogColor;
    }

}