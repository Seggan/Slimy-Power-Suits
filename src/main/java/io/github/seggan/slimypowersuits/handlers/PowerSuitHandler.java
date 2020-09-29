package io.github.seggan.slimypowersuits.handlers;

import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;

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
        if (SuitUtils.getInstalledModules(p.getInventory().getLeggings()).contains(ModuleType.SPEED)) {
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

    @EventHandler
    public void onPlayerHurt(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            PlayerInventory inv = p.getInventory();

            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                ItemStack boots = inv.getBoots();
                if (SuitUtils.isPowerSuitPiece(boots)) {
                    if (SuitUtils.getInstalledModules(boots).contains(ModuleType.NO_FALL_DMG)) {
                        e.setDamage(0);
                    }
                }
            } else {
                int pieces = 0;
                int percent = 0;
                for (ItemStack armorPiece : inv.getArmorContents()) {
                    if (SuitUtils.isPowerSuitPiece(armorPiece)) {
                        pieces += 1;
                    }
                }
                if (pieces == 4) {
                    percent = 20;
                }
                for (ItemStack armorPiece : inv.getArmorContents()) {
                    if (SuitUtils.isPowerSuitPiece(armorPiece)) {
                        int protModules = Collections.frequency(
                                SuitUtils.getInstalledModules(armorPiece),
                                ModuleType.RESISTANCE
                        );
                        for (int i = 0; i < protModules; i++) {
                            percent += Math.floorDiv(100 - percent, 6);
                        }
                    }
                }
                e.setDamage(((100 - percent) / 100) * e.getFinalDamage());
            }
        }
    }
}
