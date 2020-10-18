package io.github.seggan.slimypowersuits.lists;

import io.github.seggan.slimypowersuits.modules.ModuleType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Constants {

    private Constants() {}

    public static final Set<ModuleType> HEAD_MODULES = new HashSet<>(Arrays.asList(
        ModuleType.GLOWING,
        ModuleType.RESISTANCE,
        ModuleType.DUMMY
    ));

    public static final Set<ModuleType> CHESTPLATE_MODULES = new HashSet<>(Arrays.asList(
        ModuleType.RESISTANCE,
        ModuleType.STRENGTH,
        ModuleType.ATTRACTION,
        ModuleType.REGENERATION,
        ModuleType.FIRE_RES,
        ModuleType.DUMMY
    ));

    public static final Set<ModuleType> LEGGING_MODULES = new HashSet<>(Arrays.asList(
        ModuleType.DUMMY,
        ModuleType.RESISTANCE,
        ModuleType.SPEED
    ));

    public static final Set<ModuleType> BOOT_MODULES = new HashSet<>(Arrays.asList(
        ModuleType.DUMMY,
        ModuleType.RESISTANCE,
        ModuleType.NO_FALL_DMG,
        ModuleType.FLIGHT
    ));
}
