package io.github.seggan.slimypowersuits.handlers;

import io.github.seggan.slimypowersuits.SlimyPowerSuits;
import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.cscorelib2.protection.ProtectableAction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Collections;

public class HurtHandler implements Listener {

    public HurtHandler(SlimyPowerSuits plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerHurt(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            PlayerInventory inv = p.getInventory();

            switch (e.getCause()) {
                case ENTITY_SWEEP_ATTACK:
                case PROJECTILE:
                case ENTITY_EXPLOSION:
                case BLOCK_EXPLOSION:
                case CONTACT:
                case FALLING_BLOCK:
                case THORNS:
                case ENTITY_ATTACK:
                    if (SlimefunPlugin.getProtectionManager()
                        .hasPermission(p, e.getEntity().getLocation(), ProtectableAction.PVP)) {
                        int pieces = 0;
                        int percent = 0;
                        for (ItemStack armorPiece : inv.getArmorContents()) {
                            if (SuitUtils.isPowerSuitPiece(armorPiece)) {
                                pieces += 1;
                            }
                        }
                        if (pieces == 4) {
                            percent = 30;
                        }
                        for (ItemStack armorPiece : inv.getArmorContents()) {
                            if (SuitUtils.isPowerSuitPiece(armorPiece)) {
                                int protModules = Collections.frequency(
                                    SuitUtils.getInstalledModules(armorPiece),
                                    ModuleType.RESISTANCE
                                );
                                if (protModules > 0) {
                                    SuitUtils.removeCharge(armorPiece, 1);
                                    for (int i = 0; i < protModules; i++) {
                                        percent += Math.floorDiv(100 - percent, 4);
                                    }
                                }
                            }
                        }
                        e.setDamage(((100 - percent) / (double) 100) * e.getDamage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
