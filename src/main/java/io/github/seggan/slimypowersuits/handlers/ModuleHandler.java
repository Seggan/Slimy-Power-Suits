package io.github.seggan.slimypowersuits.handlers;

import com.google.common.collect.Iterables;
import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.modules.Module;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.seggan.slimypowersuits.suits.SuitPiece;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ModuleHandler implements Listener {

    @EventHandler
    public void onModuleInteract(PlayerInteractEvent e) {
        if (!((e.getAction() == Action.RIGHT_CLICK_BLOCK) || e.getAction() == Action.LEFT_CLICK_AIR)) {
            return;
        }
        PlayerInventory inv = e.getPlayer().getInventory();
        if (!(inv.getItemInMainHand().getType() == Material.AIR)) {
            return;
        }
        ItemStack mainHand = inv.getItemInMainHand();
        ItemStack offhand = inv.getItemInOffHand();
        if (SlimefunItem.getByItem(offhand) instanceof SuitPiece) {
            ItemStack[] armorContents = inv.getArmorContents();
            ItemMeta meta = offhand.getItemMeta();
            List<String> lore = meta.getLore();
            if (SlimefunItem.getByItem(mainHand) instanceof Module) {
                SlimefunItem item = SlimefunItem.getByItem(offhand);
                int capacity = ((SuitPiece) item).getModuleCapacity();
                capacity = item.getID().contains("POWER_SUIT_CHESTPLATE_MK") ? capacity * 2 : capacity;
                if (SuitUtils.getInstalledModules(lore).size() < capacity) {
                    Module module = (Module) SlimefunItem.getByItem(mainHand);
                    lore.add(module.getEffect().getName());
                    meta.setLore(lore);
                    offhand.setItemMeta(meta);
                    inv.setItemInOffHand(offhand);
                    mainHand.setAmount(mainHand.getAmount() - 1);
                    inv.setItemInMainHand(mainHand);
                    inv.setArmorContents(armorContents);
                    e.setCancelled(true);
                } else {
                    if (SuitUtils.getInstalledModules(lore).size() > 0) {
                        ModuleType effect = ModuleType.getByName(ModuleHandler.pop(lore));
                        inv.addItem(SlimefunItem.getByID(effect.getId()).getItem());
                        meta.setLore(lore);
                        offhand.setItemMeta(meta);
                        inv.setItemInOffHand(offhand);
                        inv.setArmorContents(armorContents);
                    } else {
                        e.getPlayer().sendMessage("OPPPP");
                    }
                }
            }
        }
    }

    private static String pop(List<String> collection) {
        String last = Iterables.getLast(collection);
        collection.remove(last);
        return last;
    }
}
