package com.blakebr0.mysticalcustomization;

import com.blakebr0.mysticalcustomization.command.ModCommands;
import com.blakebr0.mysticalcustomization.loader.CropLoader;
import com.blakebr0.mysticalcustomization.loader.CropTierLoader;
import com.blakebr0.mysticalcustomization.loader.CropTypeLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MysticalCustomization.MOD_ID)
public class MysticalCustomization {
    public static final String MOD_ID = "mysticalcustomization";
    public static final String NAME = "Mystical Customization";

    public MysticalCustomization() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.register(this);
    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);

        CropTierLoader.onCommonSetup();
        CropTypeLoader.onCommonSetup();
        CropLoader.onCommonSetup();
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        ModCommands.onServerStarting(event.getCommandDispatcher());
    }
}
