package de.florianmichael.viaforge.mixin.impl;

import de.florianmichael.viaforge.GuiProtocolSelector;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {
        GuiMainMenu.class, GuiMultiplayer.class, GuiScreenServerList.class
})
public class MixinGuiMainMenuGuiMultiplayerGuiServerList extends GuiScreen {

    @Inject(method = "initGui", at = @At("RETURN"))
    public void hookCustomButton(CallbackInfo ci) {
        buttonList.add(new GuiButton(1337, 5, 6, 98, 20, "ViaForge"));
    }

    @Inject(method = "actionPerformed", at = @At("RETURN"))
    public void handleCustomButtonAction(GuiButton p_actionPerformed_1_, CallbackInfo ci) {
        if (p_actionPerformed_1_.id == 1337) {
            mc.displayGuiScreen(new GuiProtocolSelector(this));
        }
    }
}
