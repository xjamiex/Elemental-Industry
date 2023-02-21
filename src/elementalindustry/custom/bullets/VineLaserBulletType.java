package elementalindustry.custom.bullets;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.util.Tmp;
import elementalindustry.content.EIPal;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.gen.Bullet;
import mindustry.graphics.Drawf;

public class VineLaserBulletType extends LaserBulletType {
    public VineLaserBulletType(float damage) {
        super(damage);
    }

    public VineLaserBulletType() {
        this(1);
    }

    @Override
    public void draw(Bullet b) {
        float realLength = b.fdata;

        float f = Mathf.curve(b.fin(), 0f, 0.2f);
        float baseLen = realLength * f;
        float cwidth = width;
        float compound = 1f;

        Lines.lineAngle(b.x, b.y, b.rotation(), baseLen);
        for(Color color : colors){
            Draw.color(color);
            Lines.stroke((cwidth *= lengthFalloff) * b.fout());
            Lines.lineAngle(b.x, b.y, b.rotation(), baseLen, false);
            Tmp.v1.trns(b.rotation(), baseLen);
            Drawf.tri(b.x + Tmp.v1.x, b.y + Tmp.v1.y, Lines.getStroke(), cwidth * 2f + width / 2f, b.rotation());

            for(int i : Mathf.signs){
                Drawf.tri(b.x, b.y, sideWidth * b.fout() * cwidth, sideLength * compound, b.rotation() + sideAngle * i);
            }

            compound *= lengthFalloff;
        }
        for(int i = 0; i < 32; i = i + 2) {
            Lines.stroke(b.fout() * 10);
            Draw.color(EIPal.arcaneGreenLight);
            Lines.circle(b.x, b.y, b.fout() * 25 - (i * 5));
        }
        Draw.reset();

        Tmp.v1.trns(b.rotation(), baseLen * 1.1f);
        Drawf.light(b.x, b.y, b.x + Tmp.v1.x, b.y + Tmp.v1.y, width * 1.4f * b.fout(), colors[0], 0.6f);
    }
}
