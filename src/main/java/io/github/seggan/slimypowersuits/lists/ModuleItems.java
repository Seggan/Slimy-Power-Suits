package io.github.seggan.slimypowersuits.lists;

import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public final class ModuleItems {

    public static final String MODULE_TEXTURE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZlYjM5ZDcxZWY4ZTZhNDI2NDY1OTMzOTNhNTc1M2NlMjZhMWJlZTI3YTBjYThhMzJjYjYzN2IxZmZhZSJ9fX0=";

    private ModuleItems() {
    }

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
        "Mini Jets",
        "",
        "Mini jets can",
        "allow you to fly.",
        "Install on boots.",
        "5 J/s while flying"
    );
    public static final SlimefunItemStack FIRE_RES_MODULE = new SlimefunItemStack(
        "FIRE_RESISTANCE_MODULE",
        MODULE_TEXTURE,
        "Heat Sinks",
        "",
        "These heat sinks will",
        "protect your from fire and lava.",
        "Install on chestplate."
    );
}
