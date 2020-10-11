package io.github.seggan.slimypowersuits.lists;

import io.github.seggan.slimypowersuits.SlimyPowerSuits;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.CSCoreLibPlugin.cscorelib2.item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.cscorelib2.skull.SkullItem;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;


public final class MiscItems {

    public static final String MODULE_TEXTURE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZlYjM5ZDcxZWY4ZTZhNDI2NDY1OTMzOTNhNTc1M2NlMjZhMWJlZTI3YTBjYThhMzJjYjYzN2IxZmZhZSJ9fX0=";

    private MiscItems() {}

    public static final Category SUITS = new Category(
            new NamespacedKey(SlimyPowerSuits.getInstance(), "SLIMY_POWER_SUITS"),
            new CustomItem(SkullItem.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODA2ZmNhNWY4ZTRlNjg3ZTg3MzQ5N2Y3Y2NiY2I4MTFlODE2ZGNkOGM3MTcyM2Q0ZGE2NzgwNzRmYTcxMTdhOCJ9fX0"), "Slimy Power Suits")
    );

    public static final SlimefunItemStack ELEMENT_FORGE = new SlimefunItemStack(
        "ELEMENT_FORGE",
        Material.SMITHING_TABLE,
        "&cElement Forge",
        "",
        "&7Used to create new elements",
        "&cMultiblock Structure"
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
            "Builtin Reaction Wheels",
            "",
            "These built in reaction wheels",
            "increase your speed when you",
            "sprint. Install on leggings.",
            "5 J to initiate"
    );

    public static final SlimefunItemStack FEATHER_MODULE = new SlimefunItemStack(
            "FEATHER_FALLING_MODULE",
            MODULE_TEXTURE,
            "Nanofiber Cushion",
            "",
            "A specially designed nanofiber",
            "cushion to protect you from any",
            "fall. Install on boots.",
            "5 J/fall"
    );

    public static final SlimefunItemStack RESISTANCE_MODULE = new SlimefunItemStack(
            "RESISTANCE_MODULE",
            MODULE_TEXTURE,
            "Kinetic Reactive Alloy",
            "",
            "A light but strong alloy to",
            "protect you when battling.",
            "Install anywhere.",
            "1 J/hit"
    );

    public static final SlimefunItemStack GLOWING_MODULE = new SlimefunItemStack(
            "GLOWING_MODULE",
            MODULE_TEXTURE,
            "Entity Scanner",
            "",
            "This disperser-lens combo",
            "spreads glowstone dust onto",
            "any nearby entities. Install",
            "on helmet.",
            "5 J/scan",
            LoreBuilder.CROUCH_TO_USE
    );

    public static final SlimefunItemStack ATTRACTOR_MODULE = new SlimefunItemStack(
            "ATTRACTOR_MODULE",
            MODULE_TEXTURE,
            "Attractor Beam",
            "",
            "Created in a failed",
            "experiment to create",
            "repulsor beams, this",
            "attractor beam may come",
            "in handy when fighting.",
            "Install on chestplate.",
            "25 J/use",
            LoreBuilder.RIGHT_CLICK_TO_USE
    );

    public static final SlimefunItemStack REGENERATION_MODULE = new SlimefunItemStack(
            "REGENERATION_MODULE",
            MODULE_TEXTURE,
            "Life Support Systems",
            "",
            "These life support systems",
            "will regenerate your health.",
            "Install on chestplate.",
            "1 J/s"
    );

    public static final SlimefunItemStack STRENGTH_MODULE = new SlimefunItemStack(
            "STRENGTH_MODULE",
            MODULE_TEXTURE,
            "Integrated Hydraulics",
            "",
            "Integrated hydraulics will",
            "greatly aid you in battle.",
            "Install on chestplate.",
            "1 J/s"
    );

    public static final SlimefunItemStack FLYING_MODULE = new SlimefunItemStack(
            "FLIGHT_MODULE",
            MODULE_TEXTURE,
            "Miniaturized Jets",
            "",
            "Miniaturized jets can",
            "allow you to fly.",
            "Install on boots.",
            "5 J/s while flying"
    );
}
