package eu.mikroskeem.orion.examplemod.mixins;

import eu.mikroskeem.orion.examplemod.ExampleMod;
import net.minecraft.server.v1_15_R1.Entity;
import net.minecraft.server.v1_15_R1.EntityHorseAbstract;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CraftWorld.class)
public class CraftWorldMixin {

    @Inject(method = "createEntity", at = @At("HEAD"), cancellable = true, remap = false)
    public void createEntity(Location location, Class<? extends org.bukkit.entity.Entity> clazz, CallbackInfoReturnable<Entity> cir) {
        if (location == null || clazz == null) {
            throw new IllegalArgumentException("Location or entity class cannot be null");
        }
        if(EntityHorseAbstract.class.isAssignableFrom(clazz)) {
            ExampleMod.getInstance().getLogger().info("Removing abstract horse");
            cir.setReturnValue(null);
            cir.cancel();
        }
    }

}
