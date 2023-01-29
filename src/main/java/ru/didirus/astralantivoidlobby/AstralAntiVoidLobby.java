package ru.didirus.astralantivoidlobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AstralAntiVoidLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (getServer().getPluginManager().isPluginEnabled("EssentialsX") || getServer().getPluginManager().isPluginEnabled("CMI")) {
            Bukkit.getPluginManager().registerEvents(new TeleportEvent(), this);
            getLogger().warning("AstralAntiVoid using TeleportEvent class.");
            getLogger().info("Successfully enabled without critical errors.");
        } else {
            getLogger().severe("We can't found enabled EssentialX or CMI plugins for work with 'spawn'.");
            getLogger().warning("AstralAntiVoid using PotionEvent class.");
            Bukkit.getPluginManager().registerEvents(new PotionEvent(), this);
            getLogger().info("Successfully enabled without critical errors.");
        }
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Successfully disabled.");
    }
}
