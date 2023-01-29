package ru.didirus.astralantivoidlobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AstralAntiVoidLobby extends JavaPlugin {
    @Override
    public void onEnable() {
        if (getServer().getPluginManager().isPluginEnabled("EssentialsX") || getServer().getPluginManager().isPluginEnabled("CMI")) {
            getLogger().warning("AstralAntiVoid will be using TeleportEvent.");
            Bukkit.getPluginManager().registerEvents(new TeleportEvent(), this);
            getLogger().warning("Successfully enabled without critical errors.");
        } else {
            getLogger().severe("We can't found enabled EssentialsX or CMI plugins for work with TeleportEvent.");
            getLogger().warning("AstralAntiVoid will be using PotionEvent.");
            Bukkit.getPluginManager().registerEvents(new PotionEvent(), this);
            getLogger().warning("Successfully enabled without critical errors.");
        }
    }
    @Override
    public void onDisable() {
        getLogger().info("Successfully disabled.");
    }
}
