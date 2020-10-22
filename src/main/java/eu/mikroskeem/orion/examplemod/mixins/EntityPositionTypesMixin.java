package eu.mikroskeem.orion.examplemod.mixins;

import eu.mikroskeem.orion.examplemod.ExampleMod;
import net.minecraft.server.v1_15_R1.EntityInsentient;
import net.minecraft.server.v1_15_R1.EntityPositionTypes;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.HeightMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPositionTypes.class)
public class EntityPositionTypesMixin {

    @Inject(method = "a(Lnet/minecraft/server/v1_15_R1/EntityTypes;Lnet/minecraft/server/v1_15_R1/EntityPositionTypes$Surface;Lnet/minecraft/server/v1_15_R1/HeightMap$Type;Lnet/minecraft/server/v1_15_R1/EntityPositionTypes$b;)V",
            at = @At("HEAD"), cancellable = true, remap = false)
    private static <T extends EntityInsentient> void a(EntityTypes<T> var0, EntityPositionTypes.Surface var1, HeightMap.Type var2, EntityPositionTypes.b<T> var3, CallbackInfo ci) {
        if (var0 == null) {
            ExampleMod.getInstance().getLogger().info("Cancelling call");
            ci.cancel();
        }
//            ExampleMod.getInstance().getLogger().info(var0.f());
//        else
//            ExampleMod.getInstance().getLogger().info("var0 == null");
    }

}
