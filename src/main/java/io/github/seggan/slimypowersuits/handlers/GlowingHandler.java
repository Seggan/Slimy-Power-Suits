package io.github.seggan.slimypowersuits.handlers;

import io.github.seggan.slimypowersuits.SlimyPowerSuits;
import io.github.seggan.slimypowersuits.util.SuitUtils;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GlowingHandler implements Listener {

    public GlowingHandler(SlimyPowerSuits plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onCrouch(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        ItemStack helmet = p.getInventory().getHelmet();
        if (helmet == null || helmet.getType() == Material.AIR) {
            return;
        }
        if (e.isSneaking() && SuitUtils.hasModule(helmet, ModuleType.GLOWING)) {
            if (SuitUtils.getCharge(helmet) < 5) {
                p.sendMessage(ChatColor.RED + "Not enough charge in your helmet!");
                return;
            }
            SuitUtils.removeCharge(helmet, 5);
            for (Entity entity : p.getNearbyEntities(20, 20, 20)) {
                if (entity instanceof LivingEntity) {
                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(
                        PotionEffectType.GLOWING,
                        100,
                        0,
                        false,
                        false,
                        false
                    ));
                }
            }
        }
    }
}
