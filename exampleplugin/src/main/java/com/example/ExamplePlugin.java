package com.example;

import io.github.lumine1909.api.RegistryAPI;
import io.github.lumine1909.api.manager.BiomeManager;
import io.github.lumine1909.api.objects.Biome;
import io.github.lumine1909.api.objects.BiomeColor;
import io.github.lumine1909.api.objects.ResourceKey;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {
    Biome biome;
    @Override
    public void onEnable() {
        getCommand("applybiome").setExecutor(this);
        BiomeColor bc = new BiomeColor().setGrassColor(0).setFoliageColor(0);
        biome = RegistryAPI.Manager.BIOME.createBiome(bc, new ResourceKey("example", "biome1"));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            return true;
        }
        Block block = player.getTargetBlock(null, 5);
        if (block.getType() != Material.AIR) {
            BiomeManager manager =  RegistryAPI.Manager.BIOME;
            manager.setBlockBiome(block, biome);
            manager.sendBiomeChange(block);
        }
        return true;
    }
}
