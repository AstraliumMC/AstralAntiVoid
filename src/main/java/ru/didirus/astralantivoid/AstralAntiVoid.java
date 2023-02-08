package ru.didirus.astralantivoid;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.didirus.astralantivoid.cfgs.Config;
import ru.didirus.astralantivoid.cmds.ReloadCommand;
import ru.didirus.astralantivoid.cmds.SetCommand;
import ru.didirus.astralantivoid.methods.TeleportEvent;

public final class AstralAntiVoid extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().warning("AstralAntiVoid will be using TeleportEvent.");

        cfg();

        Bukkit.getPluginManager().registerEvents(new TeleportEvent(), this);
        new TeleportEvent().EventUpdate();

        getCommand("aavreload").setExecutor(new ReloadCommand());
        getCommand("aavset").setExecutor(new SetCommand());

        getLogger().warning("Successfully enabled without critical errors.");
    }
    @Override
    public void onDisable() {

    }

    public void cfg() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Config.create();
        Config.get().addDefault("UseSpawnLoc", false);
        Config.get().addDefault("PosX", 0);
        Config.get().addDefault("PosY", 0);
        Config.get().addDefault("PosZ", 0);
        Config.get().addDefault("Pitch", 0);
        Config.get().addDefault("Yaw", 0);
        Config.get().addDefault("World", "world");
        Config.get().options().copyDefaults(true);
        Config.save();
    }

}
