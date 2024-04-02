package luke.wombat.entities;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelQuadruped;
import net.minecraft.core.util.helper.MathHelper;

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
		this.head.rotateAngleX = headPitch / 57.29578F;
		this.head.rotateAngleY = headYaw / 57.29578F;
		this.body.rotateAngleX = 1.570796F;
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbYaw;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbYaw;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
		this.nose.rotateAngleX = headPitch / 57.29578F;
		this.nose.rotateAngleY = headYaw / 57.29578F;
	}

}
