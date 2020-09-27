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

public class Module extends SlimefunItem implements NotPlaceable {
    private final ModuleType effect;
    public Module(SlimefunItemStack item, ItemStack[] recipe, ModuleType effect) {
        super(SlimyPowerSuitsItems.SUITS, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        this.effect = effect;
    }

    public ModuleType getEffect() {
        return effect;
    };

}
