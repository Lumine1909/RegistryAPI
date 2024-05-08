package io.github.lumine1909.reflection;

import org.bukkit.Bukkit;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Reflection {
    public static void init() {

    }
    public static Class<?> clazz(String name) {
        try {
            return Class.forName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Object unsafeInstance(Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //All classes
    private static final String OBC_PREFIX = "org.bukkit.craftbukkit." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    public static final Class<?> CMinecraftServer = clazz("net.minecraft.server.MinecraftServer");
    public static final Class<?> CWorldServer = clazz("net.minecraft.server.level.WorldServer");
    public static final Class<?> CWorld = clazz("net.minecraft.world.level.World");
    public static final Class<?> CDimensionManager = clazz("net.minecraft.world.level.dimension.DimensionManager");
    public static final Class<?> CRegistryMaterials = clazz("net.minecraft.core.RegistryMaterials");
    public static final Class<?> CIRegistryWritable = clazz("net.minecraft.core.IRegistryWritable");
    public static final Class<?> CResourceKey = clazz("net.minecraft.resources.ResourceKey");
    public static final Class<?> CHolder = clazz("net.minecraft.core.Holder");
    public static final Class<?> CCraftServer = clazz(OBC_PREFIX + ".CraftServer");
    public static final Class<?> CCraftWorld = clazz(OBC_PREFIX + ".CraftWorld");
    public static final Class<?> CRegistries = clazz("net.minecraft.core.registries.Registries");
    public static final Class<?> CLifecycle = clazz("com.mojang.serialization.Lifecycle");
    public static final Class<?> CMinecraftKey = clazz("net.minecraft.resources.MinecraftKey");
    public static final Class<?> CBiomeBase = clazz("net.minecraft.world.level.biome.BiomeBase");
    public static final Class<?> CBiomeBase_Builder = clazz("net.minecraft.world.level.biome.BiomeBase$a");
    public static final Class<?> CIRegistry = clazz("net.minecraft.core.IRegistry");
    public static final Class<?> CIRegistryCustom_Dimension = clazz("net.minecraft.core.IRegistryCustom$Dimension");
    public static final Class<?> CIRegistryCustom = clazz("net.minecraft.core.IRegistryCustom");
    public static final Class<?> CBiomeSettingsGeneration = clazz("net.minecraft.world.level.biome.BiomeSettingsGeneration");
    public static final Class<?> CBiomeSettingsMobs = clazz("net.minecraft.world.level.biome.BiomeSettingsMobs");
    public static final Class<?> CBlockPosition = clazz("net.minecraft.core.BlockPosition");
    public static final Class<?> CBiomeFog = clazz("net.minecraft.world.level.biome.BiomeFog");
    public static final Class<?> CBiomeFog_GrassColor = clazz("net.minecraft.world.level.biome.BiomeFog$GrassColor");
    public static final Class<?> CHolder_Reference = clazz("net.minecraft.core.Holder$c");
    public static final Class<?> CChunk = clazz("net.minecraft.world.level.chunk.Chunk");
    public static final Class<?> CIWorldReader = clazz("net.minecraft.world.level.IWorldReader");
    public static final Class<?> CIChunkAccess = clazz("net.minecraft.world.level.chunk.IChunkAccess");
    public static final Class<?> CChunkProviderServer = clazz("net.minecraft.server.level.ChunkProviderServer");
    public static final Class<?> CPlayerChunkMap = clazz("net.minecraft.server.level.PlayerChunkMap");


    //All methods
    public static final MethodAccessor MCraftServer_getServer = new MethodAccessor(CCraftServer, "getServer");
    public static final MethodAccessor MMinecraftServer_registryAccess = new MethodAccessor(CMinecraftServer, CIRegistryCustom_Dimension);
    public static final MethodAccessor MIRegistryCustom_registryOrThrow = new MethodAccessor(CIRegistryCustom, CIRegistry, CResourceKey);
    public static final MethodAccessor MResourceKey_create = new MethodAccessor(CResourceKey, CResourceKey, CResourceKey, CMinecraftKey);
    public static final MethodAccessor MRegistryMaterials_get = new MethodAccessor(CRegistryMaterials, Object.class, CMinecraftKey);
    public static final MethodAccessor MRegistryMaterials_createIntrusiveHolder = new MethodAccessor(CRegistryMaterials, CHolder_Reference, Object.class);
    public static final MethodAccessor MRegistryMaterials_register = new MethodAccessor(CRegistryMaterials, CHolder_Reference, CResourceKey, Object.class, CLifecycle);
    public static final MethodAccessor MLifeCycle_stable = new MethodAccessor(CLifecycle, "stable");
    public static final MethodAccessor MBiomeBase_Builder_generationSettings = new MethodAccessor(CBiomeBase_Builder, CBiomeBase_Builder, CBiomeSettingsGeneration);
    public static final MethodAccessor MBiomeBase_Builder_mobSpawnSettings = new MethodAccessor(CBiomeBase_Builder, CBiomeBase_Builder, CBiomeSettingsMobs);
    public static final FieldAccessor FBiomeBase_Builder_temperature = new FieldAccessor(CBiomeBase_Builder, 0, Float.class);
    public static final FieldAccessor FBiomeBase_Builder_downfall = new FieldAccessor(CBiomeBase_Builder, 1, Float.class);
    public static final FieldAccessor FBiomeFog_fogColor = new FieldAccessor(CBiomeFog, 0, int.class);
    public static final FieldAccessor FBiomeFog_waterColor = new FieldAccessor(CBiomeFog, 1, int.class);
    public static final FieldAccessor FBiomeFog_waterFogColor = new FieldAccessor(CBiomeFog, 2, int.class);
    public static final FieldAccessor FBiomeFog_skyColor = new FieldAccessor(CBiomeFog, 3, int.class);
    public static final FieldAccessor FBiomeFog_foliageColor = new FieldAccessor(CBiomeFog, 0, Optional.class);
    public static final FieldAccessor FBiomeFog_grassColor = new FieldAccessor(CBiomeFog, 1, Optional.class);
    public static final FieldAccessor FBiomeFog_ambientParticleSettings = new FieldAccessor(CBiomeFog, 2, Optional.class);
    public static final FieldAccessor FBiomeFog_ambientLoopSoundEvent = new FieldAccessor(CBiomeFog, 3, Optional.class);
    public static final FieldAccessor FBiomeFog_ambientMoodSettings = new FieldAccessor(CBiomeFog, 4, Optional.class);
    public static final FieldAccessor FBiomeFog_ambientAdditionsSettings = new FieldAccessor(CBiomeFog, 5, Optional.class);
    public static final FieldAccessor FBiomeFog_backgroundMusic = new FieldAccessor(CBiomeFog, 6, Optional.class);
    public static final FieldAccessor FBiomeFog_grassColorModifier = new FieldAccessor(CBiomeFog, 0, CBiomeFog_GrassColor);
    public static final MethodAccessor MCraftWorld_getHandle = new MethodAccessor(CCraftWorld, "getHandle");
    public static final MethodAccessor MBiomeBase_Builder_build = new MethodAccessor(CBiomeBase_Builder, CBiomeBase);
    public static final MethodAccessor MBiomeBase_Builder_specialEffects = new MethodAccessor(CBiomeBase_Builder, CBiomeBase_Builder, CBiomeFog);
    public static final MethodAccessor MWorld_getChunkAt = new MethodAccessor(CWorld, CChunk, CBlockPosition);
    public static final MethodAccessor MChunk_setBiome = new MethodAccessor(CIChunkAccess, void.class, int.class, int.class, int.class, CHolder);
    public static final MethodAccessor MIWorldReader_getBiome = new MethodAccessor(CIWorldReader, CHolder, CBlockPosition);
    public static final MethodAccessor MHolder_value = new MethodAccessor(CHolder, Object.class);
    public static final MethodAccessor MPlayerChunkMap_resendChange = new MethodAccessor(CPlayerChunkMap, void.class, List.class);

    //All fields
    public static final FieldAccessor FRegistries_BIOME = new FieldAccessor(CRegistries, 70, CResourceKey);
    public static final FieldAccessor FRegistryMaterials_frozen = new FieldAccessor(CRegistryMaterials, 0, boolean.class);
    public static final FieldAccessor FRegistryMaterials_unregisteredIntrusiveHolders = new FieldAccessor(CRegistryMaterials, 5, Map.class);
    public static final FieldAccessor FWorldServer_chunkSource = new FieldAccessor(CWorldServer, 0, CChunkProviderServer);
    public static final FieldAccessor FChunkProviderServer_chunkMap = new FieldAccessor(CChunkProviderServer, 0, CPlayerChunkMap);
    public static final FieldAccessor FBiomeBase_generationSettings = new FieldAccessor(CBiomeBase, 0, CBiomeSettingsGeneration);
    public static final FieldAccessor FBiomeBase_mobSettings = new FieldAccessor(CBiomeBase, 0, CBiomeSettingsMobs);
    public static final FieldAccessor FBiomeFog_GrassColor_none = new FieldAccessor(CBiomeFog_GrassColor, 0, CBiomeFog_GrassColor);

    //All constructors
    public static final ConstructorAccessor CtMinecraftKey = new ConstructorAccessor(CMinecraftKey, String.class, String.class);
    public static final ConstructorAccessor CtBiomeBase_Builder = new ConstructorAccessor(CBiomeBase_Builder);
    public static final ConstructorAccessor CtBlockPosition = new ConstructorAccessor(CBlockPosition, int.class, int.class, int.class);
    public static final ConstructorAccessor CtBiomeFog = new ConstructorAccessor(CBiomeFog,
            int.class, int.class, int.class, int.class,
            Optional.class, Optional.class, CBiomeFog_GrassColor,
            Optional.class, Optional.class, Optional.class, Optional.class, Optional.class
    );


    //All objects
    public static final Object ORegistryMaterials_BiomeBase_ = MIRegistryCustom_registryOrThrow
            .invoke(MMinecraftServer_registryAccess
                            .invoke(MCraftServer_getServer
                                    .invoke(Bukkit.getServer())),
                    FRegistries_BIOME.get(null));
    public static final Object OBiome_Plains = MRegistryMaterials_get
            .invoke(ORegistryMaterials_BiomeBase_,
                    CtMinecraftKey.newInstance("minecraft", "plains"));
    public static final Object OBiomeFog_GrassColor_none = FBiomeFog_GrassColor_none.get(null);
}