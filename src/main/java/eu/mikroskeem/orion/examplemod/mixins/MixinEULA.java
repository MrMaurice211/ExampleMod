package eu.mikroskeem.orion.examplemod.mixins;

import net.minecraft.server.v1_12_R1.EULA;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;


/**
 * @author Mark Vainomaa
 */
@Mixin(value = EULA.class, remap = false)
public abstract class MixinEULA {
    @Shadow @Final private static Logger a;

    @Inject(method = "<init>", cancellable = true, at = @At("RETURN"))
    public void init(File file, CallbackInfo ci) {
        a.info("ExampleMod - Agreed to EULA automatically!");
    }

    /**
     * Overwrites EULA file reading and result reading method
     *
     * @author Mark Vainomaa
     * @param file
     * @return
     */
    @Overwrite
    private boolean a(File file) {
        return true;
    }

    /**
     * Overwrites EULA file writing method
     *
     * @author Mark Vainomaa
     */
    @Overwrite
    public void b() {}
}
