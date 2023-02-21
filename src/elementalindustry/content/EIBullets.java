package elementalindustry.content;

import arc.graphics.Color;
import arc.math.Interp;
import elementalindustry.custom.bullets.VineLaserBulletType;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;

public class EIBullets {
    public static BulletType
            psycheotrisStar = new MissileBulletType(5, 257) {{
            sprite = "elemental-industry-orb-bullet";
            lifetime = 60;
            reflectable = true;
            ammoMultiplier = 2;
            trailColor = Color.valueOf("9c68fc");
            frontColor = Color.valueOf("9c68fc");
            backColor = Color.valueOf("994df0");
            shrinkY = shrinkX = -10;

            hitSound = despawnSound = Sounds.artillery;
            status = StatusEffects.sporeSlowed;
            statusDuration = 20 * 5;

            width = 4;
            height = 4;
            trailWidth = 5;
            trailLength = 40;
            hitSound = Sounds.explosion;

            hitEffect = despawnEffect = new MultiEffect(
                    new ParticleEffect() {{
                        colorFrom = Color.valueOf("9c68fc");
                        colorTo = Color.valueOf("994df0");
                        particles = 15;
                        sizeFrom = 5;
                        sizeTo = 1;
                        sizeInterp = Interp.exp10In;
                        lifetime = 200f;
                        length = 40f;
                    }},
                    new WaveEffect() {{
                        lifetime = 125f;
                        colorFrom = Color.valueOf("9c68fc");
                        colorTo = Color.valueOf("994df0");
                        strokeFrom = 20;
                        strokeTo = 0;
                        interp = Interp.exp5Out;
                        sizeTo = 26f;
                    }},
                    new WaveEffect() {{
                        lifetime = 125f;
                        colorFrom = Color.valueOf("9c68fc");
                        colorTo = Color.valueOf("994df0");
                        strokeFrom = 20;
                        strokeTo = 0;
                        interp = Interp.exp5Out;
                        sides = 4;
                        sizeTo = 26f;
                    }}
            );
            shootEffect = new ParticleEffect() {{
                colorFrom = Color.valueOf("9c68fc");
                colorTo = Color.valueOf("994df0");
                particles = 34;
                sizeFrom = 8;
                sizeTo = 1;
                sizeInterp = Interp.exp10In;
                cone = 50f;
                lifetime = 80f;
                length = 20f;
            }};
        }},

        smallGreenMissile = new MissileBulletType(7, 50) {{
            frontColor = backColor = trailColor = EIPal.arcaneGreenLight;
            shrinkY = shrinkX = 0;
            sprite = "elemental-industry-diamond-bullet";
            height = 10;
            width = 10;

            shootEffect = EIFx.greenStar;

            hitSound = Sounds.malignShoot;
            hitEffect = despawnEffect = new ParticleEffect() {{
                colorFrom = EIPal.arcaneGreenLight;
                colorTo = EIPal.arcaneGreenLight;
                particles = 10;
                sizeFrom = 5;
                sizeTo = 1;
                sizeInterp = Interp.exp10In;
                lifetime = 80f;
                length = 70f;
            }};
        }},

        bigGreenLaser = new VineLaserBulletType(680) {{
            length = 620;
            width = 40;
            lifetime = 140f;
            colors = new Color[] {EIPal.arcaneGreenDark, EIPal.arcaneGreenLight, Color.white};

            shootEffect = new ParticleEffect() {{
                colorFrom = EIPal.arcaneGreenLight;
                colorTo = EIPal.arcaneGreenLight;
                particles = 10;
                sizeFrom = 20;
                sizeTo = 1;
                sizeInterp = Interp.exp10In;
                lifetime = 80f;
                length = 70f;
            }};
        }}
    ;
}
