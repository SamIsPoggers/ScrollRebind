package io.github.samispoggers.scrollrebind;

import io.github.samispoggers.scrollrebind.mixin.AccessorMouseHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Every client tick: check if the scroll-up or scroll-down key is held,
 * and if so call MouseHandler.onScroll to simulate real wheel movement.
 * <p>
 * This means the assigned keys work everywhere scroll works:
 * - hotbar slot switching
 * - zooming (with zoom mods)
 * - inventory scrolling
 * - any other mod that reads scroll input
 */
@Mod.EventBusSubscriber(modid = ScrollRebind.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ScrollHandler {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return; // not in a world yet

        // consumeClick() returns true once per press (not every tick while held),
        // which matches how a single scroll wheel notch behaves.
        if (ClientSetup.scrollUpKey != null) {
            while (ClientSetup.scrollUpKey.consumeClick()) {
                ((AccessorMouseHandler) mc.mouseHandler).invokeOnScroll(mc.getWindow().getWindow(), 0.0, 1.0);
            }
        }

        if (ClientSetup.scrollDownKey != null) {
            while (ClientSetup.scrollDownKey.consumeClick()) {
                ((AccessorMouseHandler) mc.mouseHandler).invokeOnScroll(mc.getWindow().getWindow(), 0.0, -1.0);
            }
        }
    }
}
