package plush.plush.plush.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import plush.plush.plush.Plush;

@Environment(EnvType.CLIENT)
public class PlushieClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.INSTANCE.register(Plush.PLUSHIE, (dispatcher, context) -> new PlushieEntityRenderer(dispatcher));

}
}