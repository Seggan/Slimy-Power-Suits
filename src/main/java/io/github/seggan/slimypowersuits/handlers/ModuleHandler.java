package io.github.seggan.slimypowersuits.handlers;

import com.google.common.collect.Iterables;
import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.modules.Module;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.seggan.slimypowersuits.suits.SuitPiece;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ModuleHandler implements Listener {

    @EventHandler
    public void onModuleInteract(PlayerInteractEvent e) {
        if (e.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }
        PlayerInventory inv = e.getPlayer().getInventory();
        ItemStack mainHand = inv.getItemInMainHand();
        ItemStack offHand = inv.getItemInOffHand();
        if (!SuitUtils.isPowerSuitPiece(offHand)) {
            return;
        }
        ItemMeta meta = offHand.getItemMeta();
        List<String> lore = meta.getLore();
        SlimefunItem item = SlimefunItem.getByItem(offHand);
        if (SlimefunItem.getByItem(mainHand) instanceof Module) {
            int capacity = ((SuitPiece) item).getModuleCapacity();
            capacity = item.getID().contains("POWER_SUIT_CHESTPLATE_MK") ? capacity * 2 : capacity;
            if (SuitUtils.getInstalledModules(lore).size() < capacity) {
                Module module = (Module) SlimefunItem.getByItem(mainHand);
                lore.add(module.getEffect().getName());
                meta.setLore(lore);
                offHand.setItemMeta(meta);
                inv.setItemInOffHand(offHand);
                mainHand.setAmount(mainHand.getAmount() - 1);
                inv.setItemInMainHand(mainHand);
            }
        } else {
            if (!SuitUtils.getInstalledModules(lore).isEmpty()) {
                ModuleType effect = ModuleType.getByName(ModuleHandler.pop(lore));
                inv.addItem(SlimefunItem.getByID(effect.getId()).getItem());
                meta.setLore(lore);
                offHand.setItemMeta(meta);
                inv.setItemInOffHand(offHand);
            }
        }
    }

    @EventHandler
    public void onInventorySwap(InventoryClickEvent e) {
        if (e.getAction() == InventoryAction.SWAP_WITH_CURSOR) {
            Inventory inv = e.getClickedInventory();
            ItemStack item1 = e.getCurrentItem();
            ItemStack item2 = e.getCursor();
            ItemStack suit;
            ItemStack other;
            if (SuitUtils.isPowerSuitPiece(item1)) {
                suit = item1.clone();
                other = item2.clone();
            } else if (SuitUtils.isPowerSuitPiece(item2)) {
                suit = item2.clone();
                other = item1.clone();
            } else {
                return;
            }
            SlimefunItem otherItem = SlimefunItem.getByItem(other);
            ItemMeta meta = suit.getItemMeta();
            List<String> lore = meta.getLore();
            if (otherItem instanceof Module) {
                final String EMPTY_MODULE = "EMPTY_MODULE";
                e.setCancelled(true);
                SlimefunItem item = SlimefunItem.getByItem(suit);
                int capacity = ((SuitPiece) item).getModuleCapacity();
                capacity = item.getID().contains("POWER_SUIT_CHESTPLATE_MK") ? capacity * 2 : capacity;
                if (SuitUtils.getInstalledModules(lore).size() < capacity) {
                    Module module = (Module) SlimefunItem.getByItem(other);
                    lore.add(module.getEffect().getName());
                    meta.setLore(lore);
                    suit.setItemMeta(meta);
                    e.setCurrentItem(suit);
                    other.setAmount(other.getAmount() - 1);
                    e.getWhoClicked().setItemOnCursor(other);
                    inv.addItem(SlimefunItem.getByID(EMPTY_MODULE).getItem());
                } else if (otherItem.getID().equals(EMPTY_MODULE)) {
                    e.setCancelled(true);
                    if (!SuitUtils.getInstalledModules(lore).isEmpty()) {
                        ModuleType effect = ModuleType.getByName(ModuleHandler.pop(lore));
                        inv.addItem(SlimefunItem.getByID(effect.getId()).getItem());
                        meta.setLore(lore);
                        suit.setItemMeta(meta);
                        e.setCurrentItem(suit);
                        e.getWhoClicked().setItemOnCursor(SlimefunItem.getByID(EMPTY_MODULE).getItem());
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
