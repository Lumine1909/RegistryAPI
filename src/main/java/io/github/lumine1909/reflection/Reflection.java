package io.github.lumine1909.reflection;

import org.bukkit.Bukkit;

import java.util.List;
import java.util.Map;

public class Reflection {
    public static void init() {

    }
    public static Class<?> clazz(String name) {
        try {
            return Class.forName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //All classes
    private static final String OBC_PREFIX = "org.bukkit.craftbukkit." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    public static Class<?> CMinecraftServer = clazz("net.minecraft.server.MinecraftServer");
    public static Class<?> CWorldServer = clazz("net.minecraft.server.level.WorldServer");
    public static Class<?> CWorld = clazz("net.minecraft.world.level.World");
    public static Class<?> CDimensionManager = clazz("net.minecraft.world.level.dimension.DimensionManager");
    public static Class<?> CRegistryMaterials = clazz("net.minecraft.core.RegistryMaterials");
    public static Class<?> CIRegistryWritable = clazz("net.minecraft.core.IRegistryWritable");
    public static Class<?> CResourceKey = clazz("net.minecraft.resources.ResourceKey");
    public static Class<?> CHolder = clazz("net.minecraft.core.Holder");
    public static Class<?> CCraftServer = clazz(OBC_PREFIX + ".CraftServer");
    public static Class<?> CCraftWorld = clazz(OBC_PREFIX + ".CraftWorld");
    public static Class<?> CRegistries = clazz("net.minecraft.core.registries.Registries");
    public static Class<?> CLifecycle = clazz("com.mojang.serialization.Lifecycle");
    public static Class<?> CMinecraftKey = clazz("net.minecraft.resources.MinecraftKey");
    public static Class<?> CBiomeBase = clazz("net.minecraft.world.level.biome.BiomeBase");
    public static Class<?> CBiomeBase_Builder = clazz("net.minecraft.world.level.biome.BiomeBase$a");
    public static Class<?> CIRegistry = clazz("net.minecraft.core.IRegistry");
    public static Class<?> CIRegistryCustom_Dimension = clazz("net.minecraft.core.IRegistryCustom$Dimension");
    public static Class<?> CIRegistryCustom = clazz("net.minecraft.core.IRegistryCustom");
    public static Class<?> CBiomeSettingsGeneration = clazz("net.minecraft.world.level.biome.BiomeSettingsGeneration");
    public static Class<?> CBiomeSettingsMobs = clazz("net.minecraft.world.level.biome.BiomeSettingsMobs");
    public static Class<?> CBlockPosition = clazz("net.minecraft.core.BlockPosition");
    public static Class<?> CBiomeFog = clazz("net.minecraft.world.level.biome.BiomeFog");
    public static Class<?> CBiomeFog_Builder = clazz("net.minecraft.world.level.biome.BiomeFog$a");
    public static Class<?> CHolder_Reference = clazz("net.minecraft.core.Holder$c");
    public static Class<?> CChunk = clazz("net.minecraft.world.level.chunk.Chunk");
    public static Class<?> CIWorldReader = clazz("net.minecraft.world.level.IWorldReader");
    public static Class<?> CIChunkAccess = clazz("net.minecraft.world.level.chunk.IChunkAccess");
    public static Class<?> CChunkProviderServer = clazz("net.minecraft.server.level.ChunkProviderServer");
    public static Class<?> CPlayerChunkMap = clazz("net.minecraft.server.level.PlayerChunkMap");


    //All methods
    public static MethodAccessor MCraftServer_getServer = new MethodAccessor(CCraftServer, "getServer");
    public static MethodAccessor MMinecraftServer_registryAccess = new MethodAccessor(CMinecraftServer, 0, CIRegistryCustom_Dimension);
    public static MethodAccessor MIRegistryCustom_registryOrThrow = new MethodAccessor(CIRegistryCustom, 0, CIRegistry, CResourceKey);
    public static MethodAccessor MResourceKey_create = new MethodAccessor(CResourceKey, 0, CResourceKey, CResourceKey, CMinecraftKey);
    public static MethodAccessor MRegistryMaterials_get = new MethodAccessor(CRegistryMaterials, 0, Object.class, CMinecraftKey);
    public static MethodAccessor MRegistryMaterials_createIntrusiveHolder = new MethodAccessor(CRegistryMaterials, 0, CHolder_Reference, Object.class);
    public static MethodAccessor MRegistryMaterials_register = new MethodAccessor(CRegistryMaterials, 0, CHolder_Reference, CResourceKey, Object.class, CLifecycle);
    public static MethodAccessor MLifeCycle_stable = new MethodAccessor(CLifecycle, "stable");
    public static MethodAccessor MBiomeBase_Builder_generationSettings = new MethodAccessor(CBiomeBase_Builder, 0, CBiomeBase_Builder, CBiomeSettingsGeneration);
    public static MethodAccessor MBiomeBase_Builder_mobSpawnSettings = new MethodAccessor(CBiomeBase_Builder, 0, CBiomeBase_Builder, CBiomeSettingsMobs);
    public static MethodAccessor MBiomeBase_Builder_temperature = new MethodAccessor(CBiomeBase_Builder, 0, CBiomeBase_Builder, float.class);
    public static MethodAccessor MBiomeBase_Builder_downfall = new MethodAccessor(CBiomeBase_Builder, 1, CBiomeBase_Builder, float.class);
    public static MethodAccessor MBiomeFog_Builder_fogColor = new MethodAccessor(CBiomeFog_Builder, 5, CBiomeFog_Builder, int.class);
    public static MethodAccessor MBiomeFog_Builder_waterColor = new MethodAccessor(CBiomeFog_Builder, 0, CBiomeFog_Builder, int.class);
    public static MethodAccessor MBiomeFog_Builder_waterFogColor = new MethodAccessor(CBiomeFog_Builder, 2, CBiomeFog_Builder, int.class);
    public static MethodAccessor MBiomeFog_Builder_skyColor = new MethodAccessor(CBiomeFog_Builder, 4, CBiomeFog_Builder, int.class);
    public static MethodAccessor MBiomeFog_Builder_foliageColor = new MethodAccessor(CBiomeFog_Builder, 1, CBiomeFog_Builder, int.class);
    public static MethodAccessor MBiomeFog_Builder_grassColor = new MethodAccessor(CBiomeFog_Builder, 3, CBiomeFog_Builder, int.class);
    public static MethodAccessor MCraftWorld_getHandle = new MethodAccessor(CCraftWorld, "getHandle");
    public static MethodAccessor MBiomeBase_Builder_build = new MethodAccessor(CBiomeBase_Builder, 0, CBiomeBase);
    public static MethodAccessor MBiomeBase_Builder_specialEffects = new MethodAccessor(CBiomeBase_Builder, 0, CBiomeBase_Builder, CBiomeFog);
    public static MethodAccessor MBiomeFog_Builder_build = new MethodAccessor(CBiomeFog_Builder, 0, CBiomeFog);
    public static MethodAccessor MHolder_direct = new MethodAccessor(CHolder, 0, CHolder, Object.class);
    public static MethodAccessor MWorld_getChunkAt = new MethodAccessor(CWorld, 0, CChunk, CBlockPosition);
    public static MethodAccessor MWorld_hasChunkAt = new MethodAccessor(CWorld, 0, boolean.class, CBlockPosition);
    public static MethodAccessor MChunk_setUnSaved = new MethodAccessor(CChunk, 1, void.class, boolean.class);
    public static MethodAccessor MChunk_setBiome = new MethodAccessor(CIChunkAccess, 0, void.class, int.class, int.class, int.class, CHolder);
    public static MethodAccessor MIWorldReader_getBiome = new MethodAccessor(CIWorldReader, 0, CHolder, CBlockPosition);
    public static MethodAccessor MHolder_value = new MethodAccessor(CHolder, 0, Object.class);
    public static MethodAccessor MPlayerChunkMap_resendChange = new MethodAccessor(CPlayerChunkMap, 0, void.class, List.class);

    //All fields
    public static FieldAccessor FRegistries_BIOME = new FieldAccessor(CRegistries, 70, CResourceKey);
    public static FieldAccessor FRegistryMaterials_frozen = new FieldAccessor(CRegistryMaterials, 0, boolean.class);
    public static FieldAccessor FRegistryMaterials_unregisteredIntrusiveHolders = new FieldAccessor(CRegistryMaterials, 5, Map.class);
    public static FieldAccessor FWorldServer_chunkSource = new FieldAccessor(CWorldServer, 0, CChunkProviderServer);
    public static FieldAccessor FChunkProviderServer_chunkMap = new FieldAccessor(CChunkProviderServer, 0, CPlayerChunkMap);
    public static FieldAccessor FBiomeBase_generationSettings = new FieldAccessor(CBiomeBase, 0, CBiomeSettingsGeneration);
    public static FieldAccessor FBiomeBase_mobSettings = new FieldAccessor(CBiomeBase, 0, CBiomeSettingsMobs);
    //All constructors
    public static ConstructorAccessor CtMinecraftKey = new ConstructorAccessor(CMinecraftKey, String.class, String.class);
    public static ConstructorAccessor CtBiomeBase_Builder = new ConstructorAccessor(CBiomeBase_Builder);
    public static ConstructorAccessor CtBlockPosition = new ConstructorAccessor(CBlockPosition, int.class, int.class, int.class);
    public static ConstructorAccessor CtBiomeFog_Builder = new ConstructorAccessor(CBiomeFog_Builder);


    //All objects
    public static Object ORegistryMaterials_BiomeBase_ = MIRegistryCustom_registryOrThrow
            .invoke(MMinecraftServer_registryAccess
                            .invoke(MCraftServer_getServer
                                    .invoke(Bukkit.getServer())),
                    FRegistries_BIOME.get(null));
    public static Object OBiome_Plains = MRegistryMaterials_get
            .invoke(ORegistryMaterials_BiomeBase_,
                    CtMinecraftKey.newInstance("minecraft", "plains"));
}