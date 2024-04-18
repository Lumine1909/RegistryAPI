package io.github.lumine1909;

import io.github.lumine1909.api.manager.BiomeManager;
import io.github.lumine1909.manager.BiomeRegistryManager;
import io.github.lumine1909.reflection.Reflection;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class RegistryAPIPlugin extends JavaPlugin {
    BiomeManager biomeManager;
    public static RegistryAPIPlugin plugin;

    @Override
    public void onLoad() {
        plugin = this;
        Reflection.init();
        biomeManager = new BiomeRegistryManager();
        Bukkit.getServicesManager().register(BiomeManager.class, biomeManager, this, ServicePriority.Normal);
    }

    @Override

    public void onEnable() {
    }

    public BiomeManager getBiomeManager() {
        return biomeManager;
    }
}