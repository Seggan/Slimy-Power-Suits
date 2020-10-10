package io.github.seggan.slimypowersuits.suits;

import io.github.seggan.slimypowersuits.SlimyPowerSuits;
import io.github.seggan.slimypowersuits.lists.MiscItems;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectiveArmor;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.implementation.items.armor.SlimefunArmorPiece;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class SuitPiece extends SlimefunArmorPiece implements ProtectiveArmor, Rechargeable {
    private final NamespacedKey key;

    protected SuitPiece(SlimefunItemStack item, ItemStack[] recipe, String key) {
        super(MiscItems.SUITS, item, RecipeType.ARMOR_FORGE, recipe, null);

        this.key = new NamespacedKey(SlimyPowerSuits.getInstance(), key);
        ItemMeta meta = getItem().getItemMeta();
        meta.setUnbreakable(true);
        getItem().setItemMeta(meta);
    }

    public abstract int getModuleCapacity();
    public abstract int getRechargeRate();

    @Override
    public boolean isFullSetRequired() {
        return true;
    }

    @Override
    public ProtectionType[] getProtectionTypes() {
        return new ProtectionType[]{ProtectionType.BEES, ProtectionType.RADIATION};
    }

    @Override
    public NamespacedKey getArmorSetId() {
        return key;
    }

}
