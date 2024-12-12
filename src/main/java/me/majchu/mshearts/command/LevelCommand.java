package me.majchu.mshearts.command;

import me.majchu.mshearts.MSHearts;
import me.majchu.mshearts.util.HeartManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LevelCommand implements CommandExecutor {

    private final MSHearts plugin;
    private final FileConfiguration config;

    public LevelCommand(MSHearts plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            HeartManager healthManager = plugin.getHealthManager();
            healthManager.buyHeart(player);
            return true;
        }
        return false;
    }
}
