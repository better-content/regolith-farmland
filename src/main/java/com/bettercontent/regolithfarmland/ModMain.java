package com.bettercontent.regolithfarmland;

import com.bettercontent.regolithfarmland.compat.RegolithFarmlandPalette;
import com.bettercontent.regolithfarmland.compat.RegolithFarmlandTilling;
import com.bettercontent.regolithfarmland.gametest.SourceberryFarmlandGameTests;
import net.minecraftforge.event.RegisterGameTestsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModMain.MOD_ID)
public final class ModMain {
    public static final String MOD_ID = "regolith_farmland";

    public ModMain() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        RegolithFarmlandPalette.BLOCKS.register(bus);
        RegolithFarmlandPalette.ITEMS.register(bus);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(RegolithFarmlandTilling.class);
        bus.addListener(this::registerTests);
    }
    private void registerTests(RegisterGameTestsEvent event) {
        event.register(SourceberryFarmlandGameTests.class);
    }
}
