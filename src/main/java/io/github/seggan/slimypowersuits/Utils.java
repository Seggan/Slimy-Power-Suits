package io.github.seggan.slimypowersuits;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class Utils {
    public static BukkitTask runSync(Runnable r, long delay) {
        return SlimyPowerSuits.getInstance() != null && SlimyPowerSuits.getInstance().isEnabled() ? Bukkit.getScheduler().runTaskLater(SlimyPowerSuits.getInstance(), r, delay) : null;
    }
}
