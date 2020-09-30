package io.github.seggan.slimypowersuits.suits;

import io.github.seggan.slimypowersuits.SlimyPowerSuits;
import io.github.seggan.slimypowersuits.lists.MiscItems;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectiveArmor;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.implementation.items.armor.SlimefunArmorPiece;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public abstract class SuitPiece extends SlimefunArmorPiece implements ProtectiveArmor, Rechargeable {
    private final NamespacedKey key;
    private final int mark;

    public SuitPiece(int mark, SlimefunItemStack item, ItemStack[] recipe, String key) {
        super(MiscItems.SUITS, item, RecipeType.ARMOR_FORGE, recipe, null);

        this.key = new NamespacedKey(SlimyPowerSuits.getInstance(), key);
        this.mark = mark;
    }

    public abstract int getModuleCapacity();

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

    public int getMark() {
        return mark;
    }

    public static void charge(ItemStack itemStack) {
        SlimefunItem suitItem = SlimefunItem.getByItem(itemStack);
        if (!(suitItem instanceof SuitPiece)) {
            return;
        }
        int charge = 0;
        switch (((SuitPiece) suitItem).getMark()) {
            case 1:
                charge = 1;
                break;
            case 2:
                charge = 3;
                break;
            case 3:
                charge = 8;
                break;
            default:
                return;
        }
        ((Rechargeable) suitItem).addItemCharge(itemStack, charge);
    }
}
