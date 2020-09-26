package io.github.seggan.slimypowersuits.handlers;

import com.google.common.collect.Iterables;
import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.modules.ModuleEffect;
import io.github.seggan.slimypowersuits.suits.SuitPiece;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ModuleHandler implements Listener {

    @EventHandler
    public void onModuleRemove(PlayerRightClickEvent e) {
        PlayerInventory inv = e.getPlayer().getInventory();
        ItemStack suitStack = inv.getItemInOffHand();
        if (!(inv.getItemInMainHand().getType() == Material.AIR)) {
            return;
        }
        if (SlimefunItem.getByItem(suitStack) instanceof SuitPiece) {
            ItemMeta meta = suitStack.getItemMeta();
            assert meta != null;
            List<String> lore = meta.getLore();
            if (SuitUtils.getInstalledModules(lore).size() > 0) {
                ModuleEffect effect = ModuleEffect.getByName(ModuleHandler.pop(lore));
                inv.addItem(SlimefunItem.getByID(effect.getId()).getItem());
                meta.setLore(lore);
                suitStack.setItemMeta(meta);
                inv.setItemInOffHand(suitStack);
            } else {
                e.getPlayer().sendMessage("OPPPP");
            }
        }
    }

    private static String pop(List<String> collection) {
        String last = Iterables.getLast(collection);
        collection.remove(last);
        return last;
    }
}
