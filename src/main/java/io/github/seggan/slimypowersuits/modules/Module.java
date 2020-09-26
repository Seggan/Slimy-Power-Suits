package io.github.seggan.slimypowersuits.modules;

import io.github.seggan.slimypowersuits.SlimyPowerSuitsItems;
import io.github.seggan.slimypowersuits.SuitUtils;
import io.github.seggan.slimypowersuits.suits.SuitPiece;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Module extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {
    private final ModuleEffect effect;
    public Module(SlimefunItemStack item, ItemStack[] recipe, ModuleEffect effect) {
        super(SlimyPowerSuitsItems.SUITS, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        this.effect = effect;
    }

    public ModuleEffect getEffect() {
        return effect;
    };

    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            PlayerInventory inv = e.getPlayer().getInventory();
            ItemStack mainHand = inv.getItemInMainHand();

            if (!(SlimefunItem.getByItem(mainHand) instanceof Module)) {
                return;
            }
            SlimefunItem item = SlimefunItem.getByItem(inv.getItemInOffHand());
            if (item instanceof SuitPiece) {
                ItemMeta meta = inv.getItemInOffHand().getItemMeta();
                List<String> lore = meta.getLore();
                int capacity = ((SuitPiece) item).getModuleCapacity();
                capacity = item.getID().contains("POWER_SUIT_CHESTPLATE_MK") ? capacity * 2 : capacity;
                if (SuitUtils.getInstalledModules(lore).size() < capacity) {
                    Module module = (Module) SlimefunItem.getByItem(mainHand);
                    lore.add(module.getEffect().getName());
                    meta.setLore(lore);
                    inv.getItemInOffHand().setItemMeta(meta);
                    mainHand.setAmount(mainHand.getAmount() - 1);
                    inv.setItemInMainHand(mainHand);
                } else {
                    e.getPlayer().sendMessage("OOps");
                }
            }
        };
    }

}
