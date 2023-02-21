package elementalindustry.content;

import arc.graphics.g2d.Lines;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;

public class EIFx {
    public static Effect
        greenStar = new Effect(40f, 100f, e -> {
        color(EIPal.arcaneGreenLight);
        stroke(e.fout() * 4f);
        float circleRad = 4f + e.finpow() * 10f;
        Lines.circle(e.x, e.y, circleRad);

        color(EIPal.arcaneGreenLight);
        for(int i = 0; i < 4; i++){
            Drawf.tri(e.x, e.y, 6f, 25f * e.fout(), i*90);
        }

        color();
        for(int i = 0; i < 4; i++){
            Drawf.tri(e.x, e.y, 3f, 10f * e.fout(), i*90);
        }

        Drawf.light(e.x, e.y, circleRad * 1.6f, EIPal.arcaneGreenLight, e.fout());
    })
    ;
}
