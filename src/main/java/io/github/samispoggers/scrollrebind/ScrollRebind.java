package io.github.samispoggers.scrollrebind;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ScrollRebind.MOD_ID)
public class ScrollRebind {

    public static final String MOD_ID = "scrollrebind";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public ScrollRebind() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(ClientSetup::init);
        // ScrollHandler and ClientSetup register themselves via @EventBusSubscriber
    }
}
