package io.github.seggan.slimypowersuits.handlers;

import io.github.seggan.slimypowersuits.SlimyPowerSuits;
import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class FallHandler implements Listener {

    public FallHandler(SlimyPowerSuits plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerFall(EntityDamageEvent e) {
        if ((e.getEntity() instanceof Player)) {
            if (e.getCause() != EntityDamageEvent.DamageCause.FALL) return;
            Player p = (Player) e.getEntity();
            ItemStack boots = p.getInventory().getBoots();
            if (SuitUtils.hasModule(boots, ModuleType.NO_FALL_DMG)) {
                if (SuitUtils.getCharge(boots) >= 5) {
                    SuitUtils.removeCharge(boots, 5);
                    e.setDamage(0);
                }
            }
        }
    }
}
