package io.github.seggan.slimypowersuits;

import io.github.seggan.slimypowersuits.lists.MiscItems;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.GitHubBuildsUpdater;
import org.bstats.bukkit.Metrics;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class SlimyPowerSuits extends JavaPlugin implements SlimefunAddon {

    private static SlimyPowerSuits instance = null;
    private static final Set<UUID> flying = new HashSet<>();

    @Override
    public void onEnable() {
        getLogger().info("Slimy Power Suits enabled.");

        instance = this;

        new Metrics(this, 8980);

        if (getDescription().getVersion().startsWith("DEV - ")) {
            new GitHubBuildsUpdater(this, getFile(), "Seggan/Slimy-Power-Suits/master").start();
        }

        if (!getServer().getPluginManager().isPluginEnabled("LiteXpansion")) {
            getLogger().info("Hmm, LiteXpansion is disabled. Disabling Slimy Power Suits");
            getPluginLoader().disablePlugin(this);
            return;
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
                SuitUtils.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item);
            }
            item = inv.getChestplate();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitUtils.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item);
                if (modules.contains(ModuleType.REGENERATION)) {
                    p.addPotionEffect(new PotionEffect(
                            PotionEffectType.REGENERATION,
                            21,
                            3,
                            false,
                            false,
                            false
                    ));
                    SuitUtils.removeCharge(item, 1);
                }
                if (modules.contains(ModuleType.STRENGTH)) {
                    p.addPotionEffect(new PotionEffect(
                            PotionEffectType.INCREASE_DAMAGE,
                            21,
                            1,
                            false,
                            false,
                            false
                    ));
                    SuitUtils.removeCharge(item, 1);
                }
                if (modules.contains(ModuleType.FIRE_RES)) {
                    p.addPotionEffect(new PotionEffect(
                            PotionEffectType.FIRE_RESISTANCE,
                            21,
                            1,
                            false,
                            false,
                            false
                    ));
                    SuitUtils.removeCharge(item, 1);
                }
            }
            item = inv.getLeggings();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitUtils.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item);
            }
            UUID uuid = p.getUniqueId();
            item = inv.getBoots();
            if (!SuitUtils.hasModule(item, ModuleType.FLIGHT)
                    && flying.contains(uuid) && !p.isOp()) {
                p.setAllowFlight(false);
                flying.remove(uuid);
            }
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitUtils.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item);
                if (modules.contains(ModuleType.FLIGHT)) {
                    if (!p.getAllowFlight()) {
                        p.setAllowFlight(true);
                        flying.add(uuid);
                    }
                    if (p.isFlying()) {
                        if (SuitUtils.getCharge(item) < 5) {
                            p.setAllowFlight(false);
                            flying.remove(uuid);
                        } else {
                            SuitUtils.removeCharge(item, 5);
                        }
                    }
                }
            }
        }
    }
}
