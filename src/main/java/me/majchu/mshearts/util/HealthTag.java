package me.majchu.mshearts.util;

import me.majchu.mshearts.MSHearts;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class HealthTag implements Listener {
    private final MSHearts plugin;
    private final FileConfiguration config;

    public HealthTag(MSHearts plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = board.registerNewObjective("DisplayHealth", Criteria.HEALTH, Color.color(config.getString("scoreboard.text")));
        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);

        player.setScoreboard(board);
    }
}
