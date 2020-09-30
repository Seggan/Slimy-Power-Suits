package io.github.seggan.slimypowersuits.lists;

import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Color;
import org.bukkit.Material;

public class SuitItems {
    public static final SlimefunItemStack MK1_HELMET = new SlimefunItemStack(
            "POWER_SUIT_HELMET_MK1",
            Material.LEATHER_HELMET, Color.WHITE,
            "&4Power Suit Helmet Mark 1",
            "",
            "&7A powerful piece of armor",
            "&7that is designed to be modified.",
            "&7Slots: 1",
            LoreBuilder.powerPerSecond(1),
            LoreBuilder.powerCharged(0, 10),
            "&7Installed modules:"
    );
    public static final SlimefunItemStack MK1_CHESTPLATE = new SlimefunItemStack(
            "POWER_SUIT_CHESTPLATE_MK1",
            Material.LEATHER_CHESTPLATE, Color.WHITE,
            "&4Power Suit Chestplate Mark 1",
            "",
            "&7A powerful piece of armor",
            "&7that is designed to be modified.",
            "&7Body/Arm slots: 1",
            LoreBuilder.powerPerSecond(1),
            LoreBuilder.powerCharged(0, 10),
            "&7Installed modules:"
    );
    public static final SlimefunItemStack MK1_LEGGINGS = new SlimefunItemStack(
            "POWER_SUIT_LEGGINGS_MK1",
            Material.LEATHER_LEGGINGS, Color.WHITE,
            "&4Power Suit Leggings Mark 1",
            "",
            "&7A powerful piece of armor",
            "&7that is designed to be modified.",
            "&7Slots: 1",
            LoreBuilder.powerPerSecond(1),
            LoreBuilder.powerCharged(0, 10),
            "&7Installed modules:"
    );
    public static final SlimefunItemStack MK1_BOOTS = new SlimefunItemStack(
            "POWER_SUIT_BOOTS_MK1",
            Material.LEATHER_BOOTS, Color.WHITE,
            "&4Power Suit Boots Mark 1",
            "",
            "&7A powerful piece of armor",
            "&7that is designed to be modified.",
            "&7Slots: 1",
            LoreBuilder.powerPerSecond(1),
            LoreBuilder.powerCharged(0, 10),
            "&7Installed modules:"
    );
}
