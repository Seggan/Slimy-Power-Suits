package io.github.seggan.slimypowersuits.suits;

import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class MK1SuitPiece extends SuitPiece {

    public MK1SuitPiece(SlimefunItemStack item, ItemStack[] recipe) {
        super(item, recipe,"power_suit_mk1");
    }

    @Override
    public int getModuleCapacity() {
        return 1;
    }

    @Override
    public int getRechargeRate() {
        return 1;
    }

    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return 10;
    }
}
