package ru.didirus.astralantivoid.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import ru.didirus.astralantivoid.cfgs.Config;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SetCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


    if (!(sender instanceof ConsoleCommandSender)) {
      Player p = (Player) sender;
      if (sender.hasPermission("astralantivoid.aavset")) {
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        float pitch = p.getLocation().getPitch();
        float yaw = p.getLocation().getYaw();
        String world = p.getLocation().getWorld().getName();
        Config.get().set("PosX", x);
        Config.get().set("PosY", y);
        Config.get().set("PosZ", z);
        Config.get().set("Pitch", pitch);
        Config.get().set("Yaw", yaw);
        Config.get().set("World", world);
        Config.save();
        Config.reload(); // принудительная перезагрузка конфигурации
        p.sendMessage
            ("§aНовые данные успешно сохранены!\n  §7X: §b" + x + "\n  §7Y: §b" + y +
                "\n  §7Z: §b" + z + "\n  §7Pitch: §b" + pitch + "\n  §7Yaw: §b" + yaw
                + "\n  §7Измерение: §b" + world +
                "\n§aКонфигурация была автоматически обновлена!");
        return true;
      } else {
        p.sendMessage("§cУ вас недостаточно прав для выполнения этой команды.");
        return false;
      }
    } else {
      Logger logger = Logger.getLogger("");
      logger.log(Level.SEVERE, "Команда может быть выполнена только от имени игрока!");
      return true;
    }
  }
}
