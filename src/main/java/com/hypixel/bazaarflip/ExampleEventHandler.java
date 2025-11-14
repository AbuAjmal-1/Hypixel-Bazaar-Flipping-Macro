package com.hypixel.bazaarflip;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Example event handler demonstrating how to listen to game events.
 * 
 * To use this, register it in HypixelBazaarFlipMod.init():
 * MinecraftForge.EVENT_BUS.register(new ExampleEventHandler());
 */
public class ExampleEventHandler {
    
    private int tickCounter = 0;
    
    /**
     * Called every client tick (20 times per second when game is running at normal speed).
     * This is useful for checking game state or performing periodic actions.
     */
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        // Only process on the END phase to avoid double processing
        if (event.phase != TickEvent.Phase.END) return;
        
        tickCounter++;
        
        // Every 100 ticks (5 seconds), log a message
        if (tickCounter >= 100) {
            tickCounter = 0;
            
            Minecraft mc = Minecraft.getMinecraft();
            if (mc.thePlayer != null) {
                // Example: You could check if player is on Hypixel here
                // Example: You could check if player is in a GUI here
                // Example: You could perform automated actions here
            }
        }
    }
}
