package plush.plush.plush.client;

import plush.plush.plush.PlushieEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */

public class PlushieEntityRenderer extends MobEntityRenderer<PlushieEntity, PlushieEntityModel> {

    public PlushieEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher,
                new PlushieEntityModel(),
                0.5f);
    }

    @Override
    public Identifier getTexture(PlushieEntity entity) {
        return new Identifier("plush", "textures/entity/plushie/plushie.png");
    }

}