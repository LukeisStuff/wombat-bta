package luke.wombat.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelQuadruped;
import net.minecraft.core.util.helper.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelWombat extends ModelQuadruped {
    public Cube nose;

    public ModelWombat() {
        this(0.0F);
    }

    public ModelWombat(float f) {
        super(6, f);
        this.head.addBox(-4.0F, -2.0F, -10.0F, 8, 8, 8, f);
        this.head.setRotationPoint(0.0F, 12.0F, -6.0F);
        this.nose = new Cube(16, 16);
        this.nose.addBox(-2.0F, 2.0F, -11.0F, 4, 3, 1);
        this.nose.setRotationPoint(0.0F, 12.0F, -6.0F);
    }


    @Override
    public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
        this.head.render(scale);
        this.body.render(scale);
        this.leg1.render(scale);
        this.leg2.render(scale);
        this.leg3.render(scale);
        this.leg4.render(scale);
        this.nose.render(scale);
    }

    public void setRotationAngles(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
        this.head.xRot = headPitch / 57.29578F;
        this.head.yRot = headYaw / 57.29578F;
        this.body.xRot = 1.570796F;
        this.leg1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
        this.leg2.xRot = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbYaw;
        this.leg3.xRot = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbYaw;
        this.leg4.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
        this.nose.xRot = headPitch / 57.29578F;
        this.nose.yRot = headYaw / 57.29578F;
    }

}
