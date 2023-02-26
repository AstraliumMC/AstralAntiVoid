package ru.didirus.astralantivoid.methods;

import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import ru.didirus.astralantivoid.cfgs.Config;

import java.util.logging.Level;
import java.util.logging.Logger;


public class TeleportEvent implements Listener {

  static boolean state;
  Logger logger = Logger.getLogger("");

  public boolean EventUpdate() {
    if (!(Config.get().getBoolean("UseSpawnLoc"))) {
      logger.log(
          Level.SEVERE,
          "< ! > The plugin doesn't use the main functionality (PlayerMoveEvent in TeleportEvent class), for further changes, use the /aavreload command"
      );
      return state = false;
    } else {
      return state = true;
    }
  }

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent e) {
    if ((short) e.getPlayer().getLocation().getY() <= 0 && state) {
      Location l = new Location(
          Bukkit.getWorld(Objects.requireNonNull(Config.get().getString("World"))), Config.get().getDouble("PosX"), Config.get().getDouble("PosY"), Config.get().getDouble("PosZ"),
          (float) Config.get().getDouble("Yaw"), (float) Config.get().getDouble("Pitch")
      );
      e.getPlayer().teleport(l, PlayerTeleportEvent.TeleportCause.UNKNOWN);
    } /* Вероятнее всего это не оптимизированно когда бул стейта равен лжи,
        но я не нашел способ повторной регистрации эвента PlayerMoveEvent.
        Возможно кто-то из более опытных разработчиков на Bukkit API сможете помочь, буду благодарен! :) */
  }
}

