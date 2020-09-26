package io.github.seggan.slimypowersuits.handlers;

import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.modules.ModuleEffect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PowerSuitHandler implements Listener {

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
        if (SuitUtils.getInstalledModules(p.getInventory().getLeggings()).contains(ModuleEffect.SPEED)) {
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
