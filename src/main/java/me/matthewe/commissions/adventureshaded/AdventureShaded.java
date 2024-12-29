package me.matthewe.commissions.adventureshaded;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdventureShaded extends JavaPlugin {
    private BukkitAudiences adventure;
    @Override
    public void onEnable() {
        this.adventure = BukkitAudiences.create(this);
        getCommand("testcommand").setExecutor(new TestCommand(adventure));
        getLogger().info("Adventure Shaded Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        if (this.adventure != null) {
            this.adventure.close();
        }
        getLogger().info("Adventure Shaded Plugin Disabled!");

    }
}
