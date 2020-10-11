package io.github.seggan.slimypowersuits.modules;

public enum ModuleType {
    DUMMY("Dummy", "DUMMY_MODULE"), // used for testing purposes
    NO_FALL_DMG("Nanofiber Cushion", "FEATHER_FALLING_MODULE"),
    RESISTANCE("Kinetic Reactive Alloy", "RESISTANCE_MODULE"),
    NIGHT_VISION("Night Vision Lenses", ""),
    GLOWING("Entity Scanner", "GLOWING_MODULE"),
    STRENGTH("Integrated Hydraulics", "STRENGTH_MODULE"),
    ATTRACTION("Attractor Beam", "ATTRACTOR_MODULE"),
    SPEED("Inbuilt Reaction Wheels", "SPEED_MODULE"),
    REGENERATION("Life Support Systems", "REGENERATION_MODULE"),
    FLIGHT("Miniaturized Jets", "FLIGHT_MODULE");

    private final String id;
    private final String name;

    /**
     * @param name the name of the module when installed
     * @param id the id of the item representing the module
     */
    ModuleType(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ModuleType getByName(String name) {
        for (ModuleType effect : ModuleType.values()) {
            if (effect.getName().equals(name)) {
                return effect;
            }
        }
        return null;
    }
}
