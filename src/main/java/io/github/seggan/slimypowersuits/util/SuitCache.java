package io.github.seggan.slimypowersuits.util;

import io.github.seggan.slimypowersuits.lists.Constants;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * The {@link SuitCache} stores power suit data about a player.
 *
 * @see ModuleType
 * @see PlayerProfile
 *
 * @author Seggan
 */
public class SuitCache {
    private static final HashMap<UUID, SuitCache> caches = new HashMap<>();

    private ModuleType activeModule = null;
    private final ArrayList<ModuleType> activeModules = new ArrayList<>();

    private SuitCache() {}


    public ModuleType getActiveModule() {
        return activeModule;
    }

    private static void createNew(Player p) {
        SuitCache cache = new SuitCache();
        cache.refresh(p);
        caches.put(p.getUniqueId(), cache);
    }

    private static Runnable doCalculations() {
        return () -> {

        };
    }

    public static SuitCache find(OfflinePlayer p) {
        if (p.isOnline()) {
            UUID uuid = p.getUniqueId();
            if (!caches.containsKey(uuid)) {
                createNew((Player) p);
            }
            return caches.get(uuid);
        } else {
            return null;
        }
    }

    public void refresh(Player p) {
        PlayerInventory inv = p.getInventory();

        activeModules.clear();

        List<ModuleType> modules = SuitUtils.getInstalledModules(inv.getHelmet());
        modules.removeIf(i -> !Constants.HEAD_MODULES.contains(i));
        activeModules.addAll(modules);

        modules = SuitUtils.getInstalledModules(inv.getChestplate());
        modules.removeIf(i -> !Constants.CHESTPLATE_MODULES.contains(i));
        activeModules.addAll(modules);

        modules = SuitUtils.getInstalledModules(inv.getChestplate());
        modules.removeIf(i -> !Constants.LEGGING_MODULES.contains(i));
        activeModules.addAll(modules);

        modules = SuitUtils.getInstalledModules(inv.getChestplate());
        modules.removeIf(i -> !Constants.BOOT_MODULES.contains(i));
        activeModules.addAll(modules);
    }
}
