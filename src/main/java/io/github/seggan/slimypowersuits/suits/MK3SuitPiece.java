package io.github.seggan.slimypowersuits.suits;

import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class MK3SuitPiece extends SuitPiece {

    public MK3SuitPiece(SlimefunItemStack item, ItemStack[] recipe) {
        super(3, item, recipe, "power_suit_mk3");
    }

    @Override
    public int getModuleCapacity() {
        return 3;
    }

    @Override
    public int getRechargeRate() {
        return 8;
    }

    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return 50;
    }
}
