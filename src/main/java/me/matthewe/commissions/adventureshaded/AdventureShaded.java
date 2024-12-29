package me.matthewe.commissions.adventureshaded;

import org.bukkit.plugin.java.JavaPlugin;

public final class AdventureShaded extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Adventure Shaded Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Adventure Shaded Plugin Disabled!");
    }
}
