package ru.didirus.astralantivoidlobby;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TeleportEvent implements Listener {
    @EventHandler
    public void onPlayerMove (PlayerMoveEvent e) {
        if((short) e.getPlayer().getLocation().getY() <= 0) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawn " + e.getPlayer().getName());
            // Вернуть игрока на спавн при getY <= target int
        }
    }
}

