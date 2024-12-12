package me.majchu.mshearts.util;

import me.majchu.mshearts.MSHearts;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class HeartManager {

    private final MSHearts plugin;
    private final FileConfiguration config;

    public HeartManager(MSHearts plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public void buyHeart(Player player) {
        int hearts = config.getInt("players." + player.getName() + ".hearts", 0);
        if (hearts >= 5) {
            player.sendMessage(Color.color(config.getString("message.limit")));
            return;
        } else if (player.getLevel() < 50) {
            player.sendMessage(Color.color(config.getString("message.noLevel")));
            return;
        }
        player.setLevel(player.getLevel() - 50);
        hearts++;

        config.set("players." + player.getName() + ".hearts", hearts);
        plugin.saveConfig();

        double maxHealth = player.getMaxHealth();
        player.setMaxHealth(maxHealth + 2.0);

        player.sendMessage(Color.color(config.getString("message.buy")));
    }
}
