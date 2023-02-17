package elementalindustry.content;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.Sounds;

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
        }};
    }
