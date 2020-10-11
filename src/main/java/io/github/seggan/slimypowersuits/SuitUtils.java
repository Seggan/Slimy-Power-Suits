package io.github.seggan.slimypowersuits;

import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.seggan.slimypowersuits.suits.SuitPiece;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SuitUtils {

    private SuitUtils() {}

    public static List<ModuleType> getInstalledModules(List<String> lore) {
        List<ModuleType> modules = new ArrayList<>();
        for (String moduleString : lore.subList(7, lore.size())) {
            modules.add(ModuleType.getByName(moduleString));
        }
        return modules;
    }

    public static List<ModuleType> getInstalledModules(ItemStack armor) {
        if (armor == null || !isPowerSuitPiece(armor)) {
            return new ArrayList<>();
        }
        ItemMeta meta = armor.getItemMeta();
        if (meta == null) {
            return new ArrayList<>();
        }
        List<String> lore = meta.getLore();
        if (lore == null) {
            return new ArrayList<>();
        } else {
            return getInstalledModules(lore);
        }
    }

    public static boolean isPowerSuitPiece(ItemStack armor) {
        SlimefunItem item = SlimefunItem.getByItem(armor);
        return item instanceof SuitPiece;
    }

    public static boolean hasModule(ItemStack armor, ModuleType module) {
        if (isPowerSuitPiece(armor)) {
            return getInstalledModules(armor).contains(module);
        } else {
            return false;
        }
    }

    public static void charge(ItemStack itemStack) {
        SlimefunItem suitItem = SlimefunItem.getByItem(itemStack);
        if (!(suitItem instanceof SuitPiece)) {
            return;
        }
        ((Rechargeable) suitItem).addItemCharge(itemStack, ((SuitPiece) suitItem).getRechargeRate());
    }

    public static double getCharge(ItemStack itemStack) {
        SlimefunItem suitItem = SlimefunItem.getByItem(itemStack);
        if (!(suitItem instanceof SuitPiece)) {
            return 0.0;
        }
        return ((Rechargeable) suitItem).getItemCharge(itemStack);
    }

    public static void removeCharge(ItemStack itemStack, int amount) {
        SlimefunItem suitItem = SlimefunItem.getByItem(itemStack);
        if (!(suitItem instanceof SuitPiece)) {
            return;
        }
        ((Rechargeable) suitItem).removeItemCharge(itemStack, amount);
    }
}
