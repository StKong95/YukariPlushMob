package plush.plush.plush;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class PlushieEntity extends AnimalEntity {
    /*public EntityDimensions plushieSize = new EntityDimensions(1.0f, 1.0f, false);

    private static final float MAX_SIZE = 2.0f;
    private static final float MIN_SIZE = 0.5f;

    private final float WIDTH = 1.0f;
    private final float HEIGHT = 1.0f;
    private final float scaleFactor;*/

    public PlushieEntity(EntityType<? extends PlushieEntity> entityType, World world) {

        super(entityType, world);
        /* float scale = random.nextFloat();
        scaleFactor = Math.max(MIN_SIZE, Math.min(scale, MAX_SIZE));
        plushieSize.scaled(WIDTH * scaleFactor, HEIGHT * scaleFactor);*/
    }

    //ATTRIBUTES
    public static DefaultAttributeContainer.Builder createPlushieAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D);
    }

    //GOALS
    @Override
    protected void initGoals() {
        goalSelector.add(1, new SwimGoal(this));
        goalSelector.add(2, new EscapeDangerGoal(this, 2.0D));
        goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        goalSelector.add(4, new LookAroundGoal(this));
    }

    //BIOME SPAWN
    @SuppressWarnings("unused")
    public static boolean canSpawn(EntityType<PlushieEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return validSpawnBiomes(world, pos);
    }

    //BIOME SPAWN
    private static boolean validSpawnBiomes(WorldAccess world, BlockPos pos) {
        Optional<RegistryKey<Biome>> optional = world.method_31081(pos);
        return Objects.equals(optional, Optional.of(BiomeKeys.MOUNTAINS)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.FOREST)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.OCEAN)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.DEEP_OCEAN)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.DEEP_COLD_OCEAN)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.COLD_OCEAN)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.RIVER));
    }

    //EYE HEIGHT
    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return dimensions.height * 0.9F;
    }

    //STEP SOUND
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(getStepSound(), 0.15F, 1.0F);
    }
    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_CHICKEN_STEP;
    }

    //VOLUME
    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }


    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return Plush.PLUSHIE.create(world);
    }

}

