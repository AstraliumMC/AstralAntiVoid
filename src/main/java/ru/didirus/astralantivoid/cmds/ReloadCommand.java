package ru.didirus.astralantivoid.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import ru.didirus.astralantivoid.cfgs.Config;
import ru.didirus.astralantivoid.methods.TeleportEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ReloadCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    if (!(sender instanceof ConsoleCommandSender)) {
      Player p = (Player) sender;
      if (sender.hasPermission("astralantivoid.aavreload")) {
        Config.reload();
        p.sendMessage("§aКонфигурация плагина AstralAntiVoid успешно перезагружена!");
        boolean check = new TeleportEvent().EventUpdate();
        if (!check) {
          p.sendMessage(
              "§4< ! > The plugin doesn't use the main functionality (PlayerMoveEvent in TeleportEvent class), for further changes, use the /aavreload command");
        }
        return true;
      } else {
        p.sendMessage("§cУ вас недостаточно прав для выполнения этой команды.");
        return false;
      }
    } else {
      Config.reload();
      Logger logger = Logger.getLogger("");
      logger.log(Level.INFO, "Конфигурация плагина AstralAntiVoid успешно перезагружена!");
      new TeleportEvent().EventUpdate();
      return true;
    }

    //        return true;
  }
}
