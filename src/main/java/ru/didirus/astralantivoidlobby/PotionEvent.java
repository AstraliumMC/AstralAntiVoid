package ru.didirus.astralantivoidlobby;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class PotionEvent implements Listener {
    @EventHandler
    public void onPlayerMove (PlayerMoveEvent e) {
        if((short) e.getPlayer().getLocation().getY() <= 0) {
            e.getPlayer().addPotionEffect(PotionEffectType.LEVITATION.createEffect(220, 12));
            // Выдаем эффект левитации при getY <= target
        }
    }
}
