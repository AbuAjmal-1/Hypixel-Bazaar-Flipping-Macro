package com.hypixel.bazaarflip;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = HypixelBazaarFlipMod.MODID, version = HypixelBazaarFlipMod.VERSION, name = HypixelBazaarFlipMod.NAME)
public class HypixelBazaarFlipMod {
    public static final String MODID = "hypixelbazaarflip";
    public static final String NAME = "Hypixel Bazaar Flip";
    public static final String VERSION = "@VERSION@";

    @Mod.Instance(MODID)
    public static HypixelBazaarFlipMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(NAME + " is loading!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(NAME + " has been initialized!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println(NAME + " has finished loading!");
    }
}
