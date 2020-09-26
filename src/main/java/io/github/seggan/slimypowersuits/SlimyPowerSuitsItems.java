package io.github.seggan.slimypowersuits;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;


public final class SlimyPowerSuitsItems {
    public static final String MODULE_TEXTURE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZlYjM5ZDcxZWY4ZTZhNDI2NDY1OTMzOTNhNTc1M2NlMjZhMWJlZTI3YTBjYThhMzJjYjYzN2IxZmZhZSJ9fX0=";
    public static final Category SUITS = new Category(
            new NamespacedKey(SlimyPowerSuits.getInstance(), "SLIMY_POWER_SUITS"),
            new CustomItem(Material.IRON_CHESTPLATE, "&7Slimy Power Suits")
    );

    public static final SlimefunItemStack SUIT_AI = new SlimefunItemStack(
            "POWER_SUIT_AI",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGM5MzY1NjQyYzZlZGRjZmVkZjViNWUxNGUyYmM3MTI1N2Q5ZTRhMzM2M2QxMjNjNmYzM2M1NWNhZmJmNmQifX19",
            "&9Power Suit AI",
            "",
            "&7The object that contains",
            "&7a power suit's AI."
    );

    public static final SlimefunItemStack UNPATENTABLIUM = new SlimefunItemStack(
            "UNPATENTABLIUM",
            Material.LIGHT_BLUE_DYE,
            "&bUnpatentablium",
            "",
            "&7For some reason, the",
            "&7Feds wouldn't let you",
            "&7patent this powerful",
            "&7power source."
    );

    public static final SlimefunItemStack SUIT_GENERATOR = new SlimefunItemStack(
            "SUIT_GENERATOR",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTFkNWExZmY3Zjk3NmMxYzJlYmQ0ZWY5YTkwYWQ5MTQ2Nzk1YzFjNDRmZGFlNjI5NjQ5NDg0MzRhNzI1NyJ9fX0=",
            "&6Power Suit Generator",
            "",
            "&7The central power",
            "&7source of any power",
            "&7suit."
    );

    public static final SlimefunItemStack MODULE_INSTALLER = new SlimefunItemStack(
            "MODULE_INSTALLER",
            Material.SMITHING_TABLE,
            "&2Module Installer",
            "",
            "&7This machine is used",
            "&7 for installing modules",
            "&7on power suits.",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(32)
    );

    public static final SlimefunItemStack DUMMY_MODULE = new SlimefunItemStack(
            "DUMMY_MODULE",
            MODULE_TEXTURE,
            "Dummy Module",
            "",
            "A module used for",
            "testing purposes."
    );

    public static final SlimefunItemStack EMPTY_MODULE = new SlimefunItemStack(
            "EMPTY_MODULE",
            MODULE_TEXTURE,
            "Empty Module"
    );

    public static final SlimefunItemStack SPEED_MODULE = new SlimefunItemStack(
            "SPEED_MODULE",
            MODULE_TEXTURE,
            "Builtin Reaction Wheel Module",
            "",
            "These built in reaction wheels",
            "increase your speed when you",
            "sprint."
    );

    public static final SlimefunItemStack MK1_HELMET = new SlimefunItemStack(
            "POWER_SUIT_HELMET_MK1",
            Material.LEATHER_HELMET, Color.WHITE,
            "&4Power Suit Helmet Mark 1",
            "",
            "&7A powerful piece of armor",
            "&7that is designed to be modified.",
            "&7Slots: 1",
            LoreBuilder.powerPerSecond(1),
            LoreBuilder.powerCharged(0, 25),
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
            LoreBuilder.powerCharged(0, 25),
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
            LoreBuilder.powerCharged(0, 25),
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
            LoreBuilder.powerCharged(0, 25),
            "&7Installed modules:"
    );
}
