package io.github.seggan.slimypowersuits.handlers;

import io.github.seggan.slimypowersuits.SlimyPowerSuits;
import io.github.seggan.slimypowersuits.util.SuitUtils;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.util.Vector;

public class AttractionHandler implements Listener {

    public AttractionHandler(SlimyPowerSuits plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEntityEvent e) {
        if ((e.getRightClicked() instanceof LivingEntity) && !(e.getRightClicked() instanceof Merchant)) {
            Player p = e.getPlayer();
            ItemStack chestplate = p.getInventory().getChestplate();
            if (SuitUtils.hasModule(chestplate, ModuleType.ATTRACTION)) {
                if (SuitUtils.getCharge(chestplate) >= 25) {
                    LivingEntity entity = (LivingEntity) e.getRightClicked();
                    Vector v = p.getLocation().toVector().subtract(entity.getLocation().toVector());
                    v = v.normalize().multiply(10);
                    entity.setVelocity(v);
                    SuitUtils.removeCharge(chestplate, 25);
                } else {
                    p.sendMessage(ChatColor.RED + "Not enough charge in your chestplate!");
                }
            }
        }
    }
}
