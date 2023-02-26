package ru.didirus.astralantivoid.cfgs;


import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

  private static File file;
  private static FileConfiguration config;

  public static void create() {
    file = new File(Bukkit.getServer().getPluginManager().getPlugin("AstralAntiVoid").getDataFolder(), "config.yml");

    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        // UwU
      }
    }

    config = YamlConfiguration.loadConfiguration(file);
  }

  public static FileConfiguration get() {
    return config;
  }

  public static void save() {
    try {
      config.save(file);
    } catch (IOException e) {
      // UwU
    }
  }

  public static void reload() {
    config = YamlConfiguration.loadConfiguration(file);
  }
}
