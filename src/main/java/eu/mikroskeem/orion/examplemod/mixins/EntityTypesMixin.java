package eu.mikroskeem.orion.examplemod.mixins;

import eu.mikroskeem.orion.examplemod.ExampleMod;
import net.minecraft.server.v1_15_R1.Entity;
import net.minecraft.server.v1_15_R1.EntityTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityTypes.class)
public class EntityTypesMixin {

    @Inject(method = "a(Ljava/lang/String;Lnet/minecraft/server/v1_15_R1/EntityTypes$a;)Lnet/minecraft/server/v1_15_R1/EntityTypes;", at = @At("HEAD"), cancellable = true, remap = false)
    private static <T extends Entity> void a(String s, EntityTypes.a<T> entitytypes_a, CallbackInfoReturnable<EntityTypes<T>> cir) {
        if(s.contains("horse")) {
            ExampleMod.getInstance().getLogger().info("Removing registering of horse");
            cir.setReturnValue(null);
            cir.cancel();
        }
    }

}
