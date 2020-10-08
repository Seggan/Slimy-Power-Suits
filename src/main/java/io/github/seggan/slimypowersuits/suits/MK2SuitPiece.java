package io.github.seggan.slimypowersuits.suits;

import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class MK2SuitPiece extends SuitPiece {

    public MK2SuitPiece(SlimefunItemStack item, ItemStack[] recipe) {
        super(item, recipe, "power_suit_mk2");
    }

    @Override
    public int getModuleCapacity() {
        return 2;
    }

    @Override
    public int getRechargeRate() {
        return 3;
    }

    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return 25;
    }
}
