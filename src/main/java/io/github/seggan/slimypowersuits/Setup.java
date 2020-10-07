package io.github.seggan.slimypowersuits;

import dev.j3fftw.litexpansion.Items;
import dev.j3fftw.litexpansion.machine.MetalForge;
import io.github.seggan.slimypowersuits.handlers.FallHandler;
import io.github.seggan.slimypowersuits.handlers.GlowingHandler;
import io.github.seggan.slimypowersuits.handlers.HurtHandler;
import io.github.seggan.slimypowersuits.handlers.ModuleHandler;
import io.github.seggan.slimypowersuits.handlers.SpeedHandler;
import io.github.seggan.slimypowersuits.lists.MiscItems;
import io.github.seggan.slimypowersuits.lists.SuitItems;
import io.github.seggan.slimypowersuits.modules.Module;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.seggan.slimypowersuits.suits.MK1SuitPiece;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Setup {

    static void registerItems(SlimyPowerSuits plugin) {
        // Register items
        registerBasicItem(plugin, MiscItems.UNPATENTABLIUM, MetalForge.RECIPE_TYPE, new ItemStack[]{
            Items.MAG_THOR, Items.UU_MATTER, Items.MAG_THOR,
            Items.UU_MATTER, Items.IRIDIUM, Items.UU_MATTER,
            Items.MAG_THOR, Items.UU_MATTER, Items.MAG_THOR
        });

        registerBasicItem(plugin, MiscItems.SUIT_AI, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Items.ADVANCED_MACHINE_BLOCK, Items.IRIDIUM_PLATE, Items.ADVANCED_MACHINE_BLOCK,
            Items.IRIDIUM_PLATE, Items.ELECTRONIC_CIRCUIT, Items.IRIDIUM_PLATE,
            Items.ADVANCED_MACHINE_BLOCK, Items.IRIDIUM_PLATE, Items.ADVANCED_MACHINE_BLOCK
        });

        registerBasicItem(plugin, MiscItems.SUIT_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            MiscItems.UNPATENTABLIUM, MiscItems.UNPATENTABLIUM, MiscItems.UNPATENTABLIUM,
            MiscItems.UNPATENTABLIUM, SlimefunItems.NETHER_STAR_REACTOR, MiscItems.UNPATENTABLIUM,
            MiscItems.UNPATENTABLIUM, SlimefunItems.POWER_CRYSTAL, MiscItems.UNPATENTABLIUM,
        });

        // register modules
        new Module(MiscItems.DUMMY_MODULE, new ItemStack[]{
            null, null, null,
            null, new ItemStack(Material.BARRIER), null,
            null, null, null
        }, ModuleType.DUMMY).register(plugin);

        registerBasicItem(plugin, MiscItems.EMPTY_MODULE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Items.MAG_THOR, Items.IRIDIUM_PLATE, Items.MAG_THOR,
            Items.IRIDIUM_PLATE, MiscItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
            Items.MAG_THOR, Items.IRIDIUM_PLATE, Items.MAG_THOR
        });

        new Module(MiscItems.SPEED_MODULE, new ItemStack[]{
            new ItemStack(Material.SLIME_BALL), Items.ADVANCED_ALLOY, new ItemStack(Material.SLIME_BALL),
            Items.ADVANCED_ALLOY, MiscItems.EMPTY_MODULE, Items.ADVANCED_ALLOY,
            new ItemStack(Material.SLIME_BALL), Items.ADVANCED_ALLOY, new ItemStack(Material.SLIME_BALL)
        }, ModuleType.SPEED).register(plugin);

        new Module(MiscItems.RESISTANCE_MODULE, new ItemStack[]{
            Items.IRIDIUM_PLATE, Items.UU_MATTER, Items.IRIDIUM_PLATE,
            Items.UU_MATTER, MiscItems.EMPTY_MODULE, Items.UU_MATTER,
            Items.IRIDIUM_PLATE, Items.UU_MATTER, Items.IRIDIUM_PLATE
        }, ModuleType.RESISTANCE).register(plugin);

        new Module(MiscItems.FEATHER_MODULE, new ItemStack[]{
            new ItemStack(Material.FEATHER), Items.RAW_CARBON_MESH, new ItemStack(Material.FEATHER),
            Items.RAW_CARBON_MESH, MiscItems.EMPTY_MODULE, Items.RAW_CARBON_MESH,
            new ItemStack(Material.FEATHER), Items.RAW_CARBON_MESH, new ItemStack(Material.FEATHER)
        }, ModuleType.NO_FALL_DMG).register(plugin);

        new Module(MiscItems.GLOWING_MODULE, new ItemStack[]{
            new ItemStack(Material.GLOWSTONE_DUST), SlimefunItems.WITHER_PROOF_GLASS, new ItemStack(Material.GLOWSTONE_DUST),
            SlimefunItems.WITHER_PROOF_GLASS, MiscItems.EMPTY_MODULE, SlimefunItems.WITHER_PROOF_GLASS,
            new ItemStack(Material.GLOWSTONE_DUST), SlimefunItems.WITHER_PROOF_GLASS, new ItemStack(Material.GLOWSTONE_DUST)
        }, ModuleType.GLOWING).register(plugin);

        // register suits
        registerArmor(plugin, 1, SuitItems.MK1_HELMET, new ItemStack[]{
            Items.IRIDIUM_PLATE, MiscItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
            Items.ADVANCED_CIRCUIT, SlimefunItems.SCUBA_HELMET, Items.ADVANCED_CIRCUIT,
            Items.IRIDIUM_PLATE, Items.RAW_CARBON_MESH, Items.IRIDIUM_PLATE
        });

        registerArmor(plugin, 1, SuitItems.MK1_CHESTPLATE, new ItemStack[]{
            Items.IRIDIUM_PLATE, MiscItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
            SlimefunItems.POWER_CRYSTAL, SlimefunItems.HAZMAT_CHESTPLATE, SlimefunItems.POWER_CRYSTAL,
            Items.IRIDIUM_PLATE, MiscItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE
        });

        registerArmor(plugin, 1, SuitItems.MK1_LEGGINGS, new ItemStack[]{
            Items.IRIDIUM_PLATE, MiscItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
            Items.RAW_CARBON_FIBRE, SlimefunItems.HAZMAT_LEGGINGS, Items.RAW_CARBON_FIBRE,
            Items.IRIDIUM_PLATE, Items.COPPER_CABLE, Items.IRIDIUM_PLATE
        });

        registerArmor(plugin, 1, SuitItems.MK1_BOOTS, new ItemStack[]{
            Items.IRIDIUM_PLATE, MiscItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
            Items.ADVANCED_ALLOY, SlimefunItems.HAZMAT_BOOTS, Items.ADVANCED_ALLOY,
            Items.IRIDIUM_PLATE, Items.ADVANCED_ALLOY, Items.IRIDIUM_PLATE
        });
    }

    public static void registerListeners(SlimyPowerSuits plugin) {
        plugin.getServer().getPluginManager().registerEvents(new ModuleHandler(), plugin);
        new HurtHandler(plugin);
        new SpeedHandler(plugin);
        new GlowingHandler(plugin);
        new FallHandler(plugin);
    }

    private static void registerBasicItem(SlimyPowerSuits plugin, SlimefunItemStack item, RecipeType recipe, ItemStack[] items) {
        new SlimefunItem(MiscItems.SUITS, item, recipe, items).register(plugin);
    }

    private static void registerArmor(SlimyPowerSuits plugin, int mark, SlimefunItemStack item, ItemStack[] items) {
        if (mark == 1) {
            new MK1SuitPiece(item, items).register(plugin);
        }
    }
}
