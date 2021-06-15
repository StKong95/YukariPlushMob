/*
package plush.plush.plush;

import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;

public class PlushieLoot {
    private static final Identifier PLUSHIE_LOOT_TABLE_ID = new Identifier("plush", "plushie");

    public static void init() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (PLUSHIE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder()
                        .withCondition((LootCondition) RandomChanceLootCondition.builder(0.1f))
                        .rolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(plush.plushie_spawn_egg));

                supplier.withPool(builder);
            }
        });
    }
}
*/
