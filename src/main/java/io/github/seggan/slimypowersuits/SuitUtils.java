package io.github.seggan.slimypowersuits;

import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.seggan.slimypowersuits.suits.SuitPiece;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SuitUtils {
    public static List<ModuleType> getInstalledModules(List<String> lore) {
        List<ModuleType> modules = new ArrayList<>();
        for (String moduleString : lore.subList(7, lore.size())) {
            modules.add(ModuleType.getByName(moduleString));
        }
        return modules;
    }

    public static List<ModuleType> getInstalledModules(ItemStack armor) {
        if (armor == null) {
            return new ArrayList<>();
        }
        return getInstalledModules(armor.getItemMeta().getLore());
    }

    public static boolean isPowerSuitPiece(ItemStack armor) {
        SlimefunItem item = SlimefunItem.getByItem(armor);
        if (item == null) {
            return false;
        }
        return item instanceof SuitPiece;
    }
}
