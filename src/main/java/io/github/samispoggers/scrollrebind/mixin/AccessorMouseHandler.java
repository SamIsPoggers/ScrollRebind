package io.github.samispoggers.scrollrebind.mixin;

import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MouseHandler.class)
public interface AccessorMouseHandler {

    @Invoker("onScroll")
    void invokeOnScroll(long windowId, double xOffset, double yOffset);
}