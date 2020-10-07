package io.github.seggan.slimypowersuits;

import io.github.seggan.slimypowersuits.lists.MiscItems;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.seggan.slimypowersuits.suits.SuitPiece;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.GitHubBuildsUpdater;
import org.bstats.bukkit.Metrics;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class SlimyPowerSuits extends JavaPlugin implements SlimefunAddon {
    private static SlimyPowerSuits instance = null;
    @Override
    public void onEnable() {
        getLogger().info("Slimy Power Suits enabled.");

        instance = this;

        new Metrics(this, 8980);

        if (getDescription().getVersion().startsWith("DEV - ")) {
            new GitHubBuildsUpdater(this, getFile(), "Seggan/Slimy-Power-Suits/master").start();
        }

        Setup.registerListeners(this);

        MiscItems.SUITS.register();

        Setup.registerItems(this);

        new BukkitRunnable() {
            @Override
            public void run() {
                runArmorTask();
            }
        }.runTaskTimer(this, 100, 20);
        // starts 5 seconds later to not cause a slowdown while sf is loading
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return null;
    }

    public static SlimyPowerSuits getInstance() {
        return instance;
    }


    private void runArmorTask() {
        for (Player p : getServer().getOnlinePlayers()) {
            PlayerInventory inv = p.getInventory();

            ItemStack item = inv.getHelmet();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitPiece.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item.getItemMeta().getLore());
            }
            item = inv.getChestplate();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitPiece.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item.getItemMeta().getLore());
            }
            item = inv.getLeggings();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitPiece.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item.getItemMeta().getLore());
            }
            item = inv.getBoots();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitPiece.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item.getItemMeta().getLore());
            }
        }
    }
}
