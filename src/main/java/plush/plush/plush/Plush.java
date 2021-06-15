package plush.plush.plush;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Plush implements ModInitializer {
    public static final String MODID = "plush";

    public static final String PLUSHIE_NAME = "plushie";
    public static final String PLUSHIE_SPAWN_EGG = "plushie_spawn_egg";

    public static final EntityType<PlushieEntity> PLUSHIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MODID, PLUSHIE_NAME),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,
                    PlushieEntity::new).dimensions(EntityDimensions.fixed(0.8f, 1.0f)).build()
    );


    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(PLUSHIE, PlushieEntity.createPlushieAttributes());

        Registry.register(Registry.ITEM, new Identifier(MODID, PLUSHIE_SPAWN_EGG), new SpawnEggItem(PLUSHIE, 0xef3dff, 0x000000, new Item.Settings().group(ItemGroup.MISC)));
        //PlushieLoot.init();

    }

}



