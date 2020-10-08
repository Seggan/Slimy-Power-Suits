package io.github.seggan.slimypowersuits.modules;

import io.github.seggan.slimypowersuits.lists.MiscItems;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class Module extends SlimefunItem implements NotPlaceable {
    private final ModuleType effect;
    public Module(SlimefunItemStack item, ItemStack[] recipe, ModuleType effect) {
        super(MiscItems.SUITS, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        this.effect = effect;
    }

    public ModuleType getEffect() {
        return effect;
    }

}
