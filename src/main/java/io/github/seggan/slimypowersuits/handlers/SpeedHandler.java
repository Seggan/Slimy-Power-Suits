package io.github.seggan.slimypowersuits.handlers;

import io.github.seggan.slimypowersuits.SlimyPowerSuits;
import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedHandler implements Listener {

    public SpeedHandler(SlimyPowerSuits plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerSprint(PlayerToggleSprintEvent e) {
        Player p = e.getPlayer();
        ItemStack leggings = p.getInventory().getLeggings();
        if (leggings == null || leggings.getType() == Material.AIR) {
            return;
        }
        if (!SuitUtils.isPowerSuitPiece(leggings)) {
            return;
        }
        if (SuitUtils.getInstalledModules(leggings).contains(ModuleType.SPEED)) {
            if (e.isSprinting()) {
                p.addPotionEffect(new PotionEffect(
                    PotionEffectType.SPEED,
                    Integer.MAX_VALUE,
                    2,
                    false,
                    false
                ));
            } else {
                p.removePotionEffect(PotionEffectType.SPEED);
            }
        }
    }
}
