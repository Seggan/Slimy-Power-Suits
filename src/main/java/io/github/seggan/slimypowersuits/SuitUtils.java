package io.github.seggan.slimypowersuits;

import io.github.seggan.slimypowersuits.modules.ModuleEffect;
import io.github.seggan.slimypowersuits.suits.SuitPiece;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SuitUtils {
    public static List<ModuleEffect> getInstalledModules(List<String> lore) {
        List<ModuleEffect> modules = new ArrayList<>();
        for (String moduleString : lore.subList(7, lore.size())) {
            modules.add(ModuleEffect.getByName(moduleString));
        }
        return modules;
    }

    public static List<ModuleEffect> getInstalledModules(ItemStack armor) {
        return getInstalledModules(armor.getItemMeta().getLore());
    }

    public static boolean isPowerSuitPiece(ItemStack armor) {
        return SlimefunItem.getByItem(armor) instanceof SuitPiece;
    }
}
