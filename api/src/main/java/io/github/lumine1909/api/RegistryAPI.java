package io.github.lumine1909.api;

import io.github.lumine1909.api.manager.BiomeManager;
import org.bukkit.Bukkit;

public class RegistryAPI {
    public static class Manager {
        public static BiomeManager BIOME = Bukkit.getServicesManager().getRegistration(BiomeManager.class).getProvider();
    }
}
