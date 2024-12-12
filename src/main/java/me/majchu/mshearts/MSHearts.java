package me.majchu.mshearts;

import me.majchu.mshearts.command.LevelCommand;
import me.majchu.mshearts.util.HealthTag;
import me.majchu.mshearts.util.HeartManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MSHearts extends JavaPlugin {

    private HeartManager heartManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();


        getServer().getPluginManager().registerEvents(new HealthTag(this), this);
        getCommand("serce").setExecutor(new LevelCommand(this));
    }

    @Override
    public void onDisable() {
    }

    public HeartManager getHealthManager() {
        return heartManager;
    }
}
