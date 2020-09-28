package io.github.seggan.slimypowersuits;

import dev.j3fftw.litexpansion.Items;
import dev.j3fftw.litexpansion.machine.MetalForge;
import io.github.seggan.slimypowersuits.handlers.ModuleHandler;
import io.github.seggan.slimypowersuits.handlers.PowerSuitHandler;
import io.github.seggan.slimypowersuits.modules.Module;
import io.github.seggan.slimypowersuits.modules.ModuleType;
import io.github.seggan.slimypowersuits.suits.MK1SuitPiece;
import io.github.seggan.slimypowersuits.suits.SuitPiece;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bstats.bukkit.Metrics;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class SlimyPowerSuits extends JavaPlugin implements SlimefunAddon {
    private static SlimyPowerSuits instance = null;
    @Override
    public void onEnable() {
        getLogger().info("Slimy Power Suits enabled.");

        instance = this;

        Metrics metrics = new Metrics(this, 8980);

        getServer().getPluginManager().registerEvents(new ModuleHandler(), this);
        getServer().getPluginManager().registerEvents(new PowerSuitHandler(), this);

        SlimyPowerSuitsItems.SUITS.register();

        registerItems();

        new BukkitRunnable() {
            @Override
            public void run() {
                runArmorTask();
            }
        }.runTaskTimer(this, 100, 20);
        // starts 5 seconds later to not cause a slowdown while sf is loading
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return null;
    }

    public static SlimyPowerSuits getInstance() {
        return instance;
    }

    private void registerItems() {
        // Register items
        registerBasicItem(SlimyPowerSuitsItems.UNPATENTABLIUM, MetalForge.RECIPE_TYPE, new ItemStack[]{
                Items.MAG_THOR, Items.UU_MATTER, Items.MAG_THOR,
                Items.UU_MATTER, Items.IRIDIUM, Items.UU_MATTER,
                Items.MAG_THOR, Items.UU_MATTER, Items.MAG_THOR
        });

        registerBasicItem(SlimyPowerSuitsItems.SUIT_AI, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                Items.ADVANCED_MACHINE_BLOCK, Items.IRIDIUM_PLATE, Items.ADVANCED_MACHINE_BLOCK,
                Items.IRIDIUM_PLATE, Items.ELECTRONIC_CIRCUIT, Items.IRIDIUM_PLATE,
                Items.ADVANCED_MACHINE_BLOCK, Items.IRIDIUM_PLATE, Items.ADVANCED_MACHINE_BLOCK
        });

        registerBasicItem(SlimyPowerSuitsItems.SUIT_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimyPowerSuitsItems.UNPATENTABLIUM, SlimyPowerSuitsItems.UNPATENTABLIUM, SlimyPowerSuitsItems.UNPATENTABLIUM,
                SlimyPowerSuitsItems.UNPATENTABLIUM, SlimefunItems.NETHER_STAR_REACTOR, SlimyPowerSuitsItems.UNPATENTABLIUM,
                SlimyPowerSuitsItems.UNPATENTABLIUM, SlimefunItems.POWER_CRYSTAL, SlimyPowerSuitsItems.UNPATENTABLIUM,
        });

        // register modules
        new Module(SlimyPowerSuitsItems.DUMMY_MODULE, new ItemStack[]{
                null, null, null,
                null, new ItemStack(Material.BARRIER), null,
                null, null, null
        }, ModuleType.DUMMY).register(this);

        registerBasicItem(SlimyPowerSuitsItems.EMPTY_MODULE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                Items.MAG_THOR, Items.IRIDIUM_PLATE, Items.MAG_THOR,
                Items.IRIDIUM_PLATE, SlimyPowerSuitsItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
                Items.MAG_THOR, Items.IRIDIUM_PLATE, Items.MAG_THOR
        });

        new Module(SlimyPowerSuitsItems.SPEED_MODULE, new ItemStack[]{
                new ItemStack(Material.SLIME_BALL), Items.ADVANCED_ALLOY, new ItemStack(Material.SLIME_BALL),
                Items.ADVANCED_ALLOY, SlimyPowerSuitsItems.EMPTY_MODULE, Items.ADVANCED_ALLOY,
                new ItemStack(Material.SLIME_BALL), Items.ADVANCED_ALLOY, new ItemStack(Material.SLIME_BALL)
        }, ModuleType.SPEED).register(this);

        new Module(SlimyPowerSuitsItems.RESISTANCE_MODULE, new ItemStack[]{
                Items.IRIDIUM_PLATE, Items.UU_MATTER, Items.IRIDIUM_PLATE,
                Items.UU_MATTER, SlimyPowerSuitsItems.EMPTY_MODULE, Items.UU_MATTER,
                Items.IRIDIUM_PLATE, Items.UU_MATTER, Items.IRIDIUM_PLATE
        }, ModuleType.RESISTANCE).register(this);

        new Module(SlimyPowerSuitsItems.FEATHER_MODULE, new ItemStack[]{
                new ItemStack(Material.FEATHER), Items.RAW_CARBON_MESH, new ItemStack(Material.FEATHER),
                Items.RAW_CARBON_MESH, SlimyPowerSuitsItems.EMPTY_MODULE, Items.RAW_CARBON_MESH,
                new ItemStack(Material.FEATHER), Items.RAW_CARBON_MESH, new ItemStack(Material.FEATHER)
        }, ModuleType.NO_FALL_DMG).register(this);

        // register suits
        registerArmor(1, SlimyPowerSuitsItems.MK1_HELMET, new ItemStack[]{
                Items.IRIDIUM_PLATE, SlimyPowerSuitsItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
                Items.ADVANCED_CIRCUIT, SlimefunItems.SCUBA_HELMET, Items.ADVANCED_CIRCUIT,
                Items.IRIDIUM_PLATE, Items.RAW_CARBON_MESH, Items.IRIDIUM_PLATE
        });

        registerArmor(1, SlimyPowerSuitsItems.MK1_CHESTPLATE, new ItemStack[]{
                Items.IRIDIUM_PLATE, SlimyPowerSuitsItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
                SlimefunItems.POWER_CRYSTAL, SlimefunItems.HAZMAT_CHESTPLATE, SlimefunItems.POWER_CRYSTAL,
                Items.IRIDIUM_PLATE, SlimyPowerSuitsItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE
        });

        registerArmor(1, SlimyPowerSuitsItems.MK1_LEGGINGS, new ItemStack[]{
                Items.IRIDIUM_PLATE, SlimyPowerSuitsItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
                Items.RAW_CARBON_FIBRE, SlimefunItems.HAZMAT_LEGGINGS, Items.RAW_CARBON_FIBRE,
                Items.IRIDIUM_PLATE, Items.COPPER_CABLE, Items.IRIDIUM_PLATE
        });

        registerArmor(1, SlimyPowerSuitsItems.MK1_BOOTS, new ItemStack[]{
                Items.IRIDIUM_PLATE, SlimyPowerSuitsItems.SUIT_GENERATOR, Items.IRIDIUM_PLATE,
                Items.ADVANCED_ALLOY, SlimefunItems.HAZMAT_BOOTS, Items.ADVANCED_ALLOY,
                Items.IRIDIUM_PLATE, Items.ADVANCED_ALLOY, Items.IRIDIUM_PLATE
        });
    }

    private void registerBasicItem(SlimefunItemStack item, RecipeType recipe, ItemStack[] items) {
        new SlimefunItem(SlimyPowerSuitsItems.SUITS, item, recipe, items).register(this);
    }

    private void registerArmor(int mark, SlimefunItemStack item, ItemStack[] items) {
        if (mark == 1) {
            new MK1SuitPiece(item, items).register(this);
        }
    }

    private void runArmorTask() {
        for (Player p : getServer().getOnlinePlayers()) {
            PlayerInventory inv = p.getInventory();

            ItemStack item = inv.getHelmet();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitPiece.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item.getItemMeta().getLore());
            }
            item = inv.getChestplate();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitPiece.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item.getItemMeta().getLore());
            }
            item = inv.getLeggings();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitPiece.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item.getItemMeta().getLore());
            }
            item = inv.getBoots();
            if (SuitUtils.isPowerSuitPiece(item)) {
                SuitPiece.charge(item);
                List<ModuleType> modules = SuitUtils.getInstalledModules(item.getItemMeta().getLore());
            }
        }
    }
}
