package io.github.samispoggers.scrollrebind;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = ScrollRebind.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    public static KeyMapping scrollUpKey;
    public static KeyMapping scrollDownKey;

    public static void init(FMLClientSetupEvent event) {
        // Nothing needed here – key registration is done in onRegisterKeyMappings
    }

    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        scrollUpKey = new KeyMapping(
                "key.scrollrebind.scroll_up",
                GLFW.GLFW_KEY_UNKNOWN,
                "key.categories.scrollrebind"
        );
        scrollDownKey = new KeyMapping(
                "key.scrollrebind.scroll_down",
                GLFW.GLFW_KEY_UNKNOWN,
                "key.categories.scrollrebind"
        );

        event.register(scrollUpKey);
        event.register(scrollDownKey);

        ScrollRebind.LOGGER.info("ScrollRebind: Registered keybindings.");
    }
}
