package elementalindustry.content;

import arc.audio.Sound;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
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
                    progress = PartProgress.warmup;
                }});

                parts.add(new RegionPart("-wing") {{
                    x = 0;
                    y = 0;
                    under = false;
                    outline = true;
                    moveY = -3f;
                    moveX = -5f;
                    progress = PartProgress.warmup;
                    mirror = true;
                    turretShading = true;
                }});
            }};

            range = 300;
            shootSound = Sounds.malignShoot;
            reload = 100;

            hasPower = true;
            consumesPower = true;
            consumePower(10f);
            requirements(Category.turret, BuildVisibility.shown, ItemStack.with(Items.copper, 1200, Items.lead, 1100, Items.silicon, 760, Items.plastanium, 430, EIItems.infusedDarkEnergy, 230, EIItems.nightCrystal, 120));

            shootType = EIBullets.psycheotrisStar;
        }};
    }
}
