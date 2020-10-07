package io.github.seggan.slimypowersuits.handlers;

import io.github.seggan.slimypowersuits.SlimyPowerSuits;
import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallHandler implements Listener {

    public FallHandler(SlimyPowerSuits plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPLayerFall(EntityDamageEvent e) {
        if ((e.getEntity() instanceof Player) && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            Player p = (Player) e.getEntity();
            if (SuitUtils.hasModule(p.getInventory().getBoots(), ModuleType.NO_FALL_DMG)) {
                e.setDamage(0);
            }
        }
    }
}
