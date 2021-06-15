package plush.plush.plush.client;

import plush.plush.plush.PlushieEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class PlushieEntityModel extends EntityModel<PlushieEntity> {
    private final ModelPart bb_main;

    public PlushieEntityModel() {
        textureWidth = 64;
        textureHeight = 64;
        bb_main = new ModelPart(this);
        bb_main.setPivot(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(24, 24).addCuboid(-4.0F, -3.0F, -3.0F, 8.0F, 3.0F, 6.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 24).addCuboid(-3.0F, -7.0F, -2.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addCuboid(-5.5F, -15.0F, -4.0F, 11.0F, 8.0F, 8.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 16).addCuboid(-5.5F, -7.0F, -4.0F, 11.0F, 5.0F, 0.0F, 0.0F, false);

        ModelPart rightarm_r1 = new ModelPart(this);
        rightarm_r1.setPivot(-4.0F, -5.0F, 0.0F);
        bb_main.addChild(rightarm_r1);
        setRotationAngle(rightarm_r1, 0.0F, 0.0F, 0.7854F);
        rightarm_r1.setTextureOffset(32, 18).addCuboid(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        ModelPart leftarm_r1 = new ModelPart(this);
        leftarm_r1.setPivot(4.0F, -5.0F, 0.0F);
        bb_main.addChild(leftarm_r1);
        setRotationAngle(leftarm_r1, 0.0F, 0.0F, -0.7854F);
        leftarm_r1.setTextureOffset(24, 18).addCuboid(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        ModelPart rightleg_r1 = new ModelPart(this);
        rightleg_r1.setPivot(-3.0F, -1.0F, -4.0F);
        bb_main.addChild(rightleg_r1);
        setRotationAngle(rightleg_r1, 0.0F, 0.3927F, 0.0F);
        rightleg_r1.setTextureOffset(38, 10).addCuboid(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        ModelPart leftleg_r1 = new ModelPart(this);
        leftleg_r1.setPivot(3.0F, -1.0F, -4.0F);
        bb_main.addChild(leftleg_r1);
        setRotationAngle(leftleg_r1, 0.0F, -0.3927F, 0.0F);
        leftleg_r1.setTextureOffset(38, 10).addCuboid(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        ModelPart righthoody_r1 = new ModelPart(this);
        righthoody_r1.setPivot(-1.5F, -4.5F, 2.5F);
        bb_main.addChild(righthoody_r1);
        setRotationAngle(righthoody_r1, 0.3927F, 0.0F, 0.0F);
        righthoody_r1.setTextureOffset(20, 27).addCuboid(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
        righthoody_r1.setTextureOffset(20, 27).addCuboid(2.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
    }
    @Override
    public void setAngles(PlushieEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }
    @Override
    public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

}