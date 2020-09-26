package io.github.seggan.slimypowersuits.modules;

public enum ModuleEffect {
    DUMMY("Dummy", "DUMMY_MODULE"), // used for testing purposes
    NO_FALL_DMG("Nanofiber Cushion", ""),
    RESISTANCE("Kinetic Reactive Nanofiber", ""),
    NIGHT_VISION("Night Vision Lenses", ""),
    GLOWING("Entity Scanner", ""),
    STRENGTH("Integrated Hydraulics", ""),
    KNOCKBACK("Repulsor Beams", ""),
    SPEED("Inbuilt Reaction Wheels", "");

    private final String id;
    private final String name;

    /**
     * @param name the name of the module when installed
     * @param id the id of the item representing the module
     */
    ModuleEffect(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ModuleEffect getByName(String name) {
        for (ModuleEffect effect : ModuleEffect.values()) {
            if (effect.getName().equals(name)) {
                return effect;
            }
        }
        return null;
    }
}
