package elementalindustry.content;

import arc.audio.Sound;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;
import mindustry.world.meta.BuildVisibility;

public class EIBlocks {
    public static Block
            //turret
            psycheotris
    ;

    public static void load() {
        psycheotris = new PowerTurret("psycheotris") {{
            health = 4300;
            size = 4;
            armor = 5;
            recoil = 0.34f;
            drawer = new DrawTurret() {{
                parts.add(new RegionPart("-front") {{
                    under = false;
                    outline = true;
                    moveY = 5f;
                    progress = PartProgress.reload;
                }});

                parts.add(new RegionPart("-left-wing") {{
                    under = false;
                    outline = true;
                    moveY = -3f;
                    moveX = -5f;
                    progress = PartProgress.reload;
                }});

                parts.add(new RegionPart("-right-wing") {{
                    under = false;
                    outline = true;
                    moveY = -3f;
                    moveX = 5f;
                    progress = PartProgress.reload;
                }});
            }};

            range = 500;
            shootSound = Sounds.shootBig;
            reload = 100;

            hasPower = true;
            consumesPower = true;
            consumePower(8f);
            requirements(Category.turret, BuildVisibility.shown, ItemStack.with(Items.lead, 430, Items.silicon, 450, Items.plastanium, 280, EIItems.infusedDarkEnergy, 100, EIItems.nightCrystal, 80));

            shootType = new MissileBulletType(5, 64) {{
                sprite = "elemental-industry-orb-bullet";
                lifetime = 100;
                reflectable = true;
                ammoMultiplier = 2;
                trailColor = Color.valueOf("6773f5");
                frontColor = Color.valueOf("6773f5");
                backColor = Color.valueOf("4935bd");
                shrinkY = shrinkX = 0;

                width = 40;
                height = 40;
                trailWidth = 5;
                trailLength = 40;
                hitEffect = despawnEffect = new MultiEffect(
                    new ParticleEffect() {{
                        colorFrom = Color.valueOf("6773f5");
                        colorTo = Color.valueOf("4935bd");
                        particles = 50;
                        sizeFrom = 5;
                        sizeTo = 1;
                        sizeInterp = Interp.exp10In;
                        lifetime = 200f;
                    }}
                );
            }};

            shootEffect = new ParticleEffect() {{
                colorFrom = Color.valueOf("6773f5");
                colorTo = Color.valueOf("4935bd");
                particles = 34;
                sizeFrom = 4;
                sizeTo = 1;
                sizeInterp = Interp.exp10In;
                cone = 50f;
                lifetime = 80f;
            }};
        }};
    }
}
