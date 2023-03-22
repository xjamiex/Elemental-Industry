package elementalindustry.content;

import arc.audio.Sound;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class EIBlocks {
    public static Block
            //turret
            psycheotris,
            //swarmer
            swarmling, hive, colony, society, civilisation,
            flame, blaze
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
            requirements(Category.turret, BuildVisibility.shown, with(Items.copper, 1200, Items.lead, 1100, Items.silicon, 760, Items.plastanium, 430, EIItems.infusedDarkEnergy, 230, EIItems.nightCrystal, 120));

            shootType = EIBullets.psycheotrisStar;
        }};
        swarmling = new ItemTurret("swarmling") {{
            requirements(Category.turret, with(Items.graphite, 100, Items.titanium, 560, Items.coal, 450));
            ammo(
                    Items.coal, new MissileBulletType(5f, 5){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        splashDamageRadius = 30f;
                        splashDamage = 30f * 1.5f;
                        ammoMultiplier = 5f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.blasted;
                        statusDuration = 60f;
                    }},
                    Items.pyratite, new MissileBulletType(5f, 10){{
                        frontColor = Pal.lightishOrange;
                        backColor = Pal.lightOrange;
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        homingPower = 0.08f;
                        splashDamageRadius = 20f;
                        splashDamage = 30f * 1.5f;
                        makeFire = true;
                        ammoMultiplier = 5f;
                        hitEffect = Fx.blastExplosion;
                        status = StatusEffects.burning;
                    }}
            );

            shootY = 12f;
            reload = 12f;
            inaccuracy = 8f;
            range = 340f;
            consumeAmmoOnce = false;
            size = 1;
            health = 560;
            shootSound = Sounds.missile;
            envEnabled |= Env.space;

            coolant = consumeCoolant(0.3f);
        }};

        hive = new ItemTurret("hive") {{
            requirements(Category.turret, with(Items.graphite, 100, Items.titanium, 560, Items.plastanium, 450, Items.silicon, 540, Items.copper, 650));
            ammo(
                    Items.blastCompound, new MissileBulletType(5f, 35){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        splashDamageRadius = 30f;
                        splashDamage = 30f * 1.5f;
                        ammoMultiplier = 5f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.blasted;
                        statusDuration = 60f;
                    }},
                    Items.pyratite, new MissileBulletType(5f, 25){{
                        frontColor = Pal.lightishOrange;
                        backColor = Pal.lightOrange;
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        homingPower = 0.08f;
                        splashDamageRadius = 20f;
                        splashDamage = 30f * 1.5f;
                        makeFire = true;
                        ammoMultiplier = 5f;
                        hitEffect = Fx.blastExplosion;
                        status = StatusEffects.burning;
                    }},
                    Items.surgeAlloy, new MissileBulletType(5f, 46){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        splashDamageRadius = 25f;
                        splashDamage = 25f * 1.4f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;
                        ammoMultiplier = 4f;
                        lightningDamage = 10;
                        lightning = 4;
                        lightningLength = 6;
                    }}
            );

            shoot = new ShootAlternate(){{
                shots = 6;
                barrels = 5;
                spread = 3.5f;
                shotDelay = 3.2f;
            }};

            shootY = 12f;
            reload = 26f;
            inaccuracy = 8f;
            range = 340f;
            consumeAmmoOnce = false;
            size = 3;
            health = 2300;
            shootSound = Sounds.missile;
            envEnabled |= Env.space;

            coolant = consumeCoolant(0.3f);
        }};

        colony = new ItemTurret("colony") {{
            requirements(Category.turret, with(Items.graphite, 460, Items.titanium, 800, Items.plastanium, 760, Items.silicon, 980, Items.copper, 1100, Items.phaseFabric, 380));
            ammo(
                    Items.blastCompound, new MissileBulletType(3f, 64){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        splashDamageRadius = 30f;
                        splashDamage = 30f * 1.5f;
                        ammoMultiplier = 5f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.blasted;
                        statusDuration = 60f;
                        lifetime = 140f;

                        fragBullets = 2;
                        fragBullet = new MissileBulletType(2f, 12) {{
                            width = 8f;
                            height = 8f;
                            shrinkY = 0f;
                            splashDamageRadius = 25f;
                            splashDamage = 25f * 1.4f;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                            ammoMultiplier = 4f;
                            lightningDamage = 10;
                            lightning = 4;
                            lightningLength = 6;
                        }};
                    }},
                    Items.pyratite, new MissileBulletType(3f, 64){{
                        frontColor = Pal.lightishOrange;
                        backColor = Pal.lightOrange;
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        homingPower = 0.08f;
                        splashDamageRadius = 20f;
                        splashDamage = 30f * 1.5f;
                        makeFire = true;
                        ammoMultiplier = 5f;
                        hitEffect = Fx.blastExplosion;
                        status = StatusEffects.burning;
                        lifetime = 140f;

                        fragBullets = 2;
                        fragBullet = new MissileBulletType(2f, 12) {{
                            width = 8f;
                            height = 8f;
                            shrinkY = 0f;
                            splashDamageRadius = 25f;
                            splashDamage = 25f * 1.4f;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                            ammoMultiplier = 4f;
                            lightningDamage = 10;
                            lightning = 4;
                            lightningLength = 6;
                        }};
                    }},
                    Items.surgeAlloy, new MissileBulletType(3f, 75){
                        {
                            width = 8f;
                            height = 8f;
                            shrinkY = 0f;
                            splashDamageRadius = 25f;
                            splashDamage = 25f * 1.4f;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                            ammoMultiplier = 4f;
                            lightningDamage = 10;
                            lightning = 4;
                            lightningLength = 6;
                            lifetime = 140f;

                            fragBullets = 2;
                            fragBullet = new MissileBulletType(2f, 12) {{
                                width = 8f;
                                height = 8f;
                                shrinkY = 0f;
                                splashDamageRadius = 25f;
                                splashDamage = 25f * 1.4f;
                                hitEffect = Fx.blastExplosion;
                                despawnEffect = Fx.blastExplosion;
                                ammoMultiplier = 4f;
                                lightningDamage = 10;
                                lightning = 4;
                                lightningLength = 6;
                            }};
                        }}
            );

            shoot = new ShootAlternate(){{
                shots = 10;
                barrels = 10;
                spread = 3.5f;
                shotDelay = 3.2f;
            }};

            shootY = 12f;
            reload = 60f;
            inaccuracy = 8f;
            range = 420f;
            consumeAmmoOnce = false;
            size = 4;
            health = 4220;
            shootSound = Sounds.missile;
            envEnabled |= Env.space;

            coolant = consumeCoolant(0.3f);
        }};

        society = new ItemTurret("society") {{
            requirements(Category.turret, with(Items.graphite, 670, Items.titanium, 1100, Items.plastanium, 1430, Items.silicon, 1622, Items.copper, 1980, Items.phaseFabric, 760, Items.surgeAlloy, 470));
            ammo(
                    Items.blastCompound, new MissileBulletType(5f, 128){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        splashDamageRadius = 30f;
                        splashDamage = 30f * 1.5f;
                        ammoMultiplier = 5f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.blasted;
                        statusDuration = 60f;
                        lifetime = 180f;
                    }},
                    Items.surgeAlloy, new MissileBulletType(3f, 75){
                        {
                            width = 8f;
                            height = 8f;
                            shrinkY = 0f;
                            splashDamageRadius = 25f;
                            splashDamage = 25f * 1.4f;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                            ammoMultiplier = 4f;
                            lightningDamage = 10;
                            lightning = 4;
                            lightningLength = 6;
                            lifetime = 180f;
                        }}
            );

            shoot = new ShootAlternate(){{
                shots = 17;
                barrels = 17;
                spread = 2.5f;
                shotDelay = 3.2f;
            }};

            shootY = 12f;
            reload = 26f;
            inaccuracy = 8f;
            range = 480f;
            consumeAmmoOnce = false;
            size = 5;
            scaledHealth = 710;
            shootSound = Sounds.missile;
            envEnabled |= Env.space;
            health = 7330;

            coolant = consumeCoolant(0.3f);
        }};

         civilisation = new ItemTurret("civilisation") {{
            requirements(Category.turret, with(Items.graphite, 1360, Items.titanium, 1930, Items.plastanium, 1650, Items.silicon, 2430, Items.copper, 2980, Items.phaseFabric, 1430, Items.surgeAlloy, 1220, Items.blastCompound, 1220));
            ammo(
                    Items.surgeAlloy, new MissileBulletType(2f, 250){
                        {
                            width = 32f;
                            height = 32f;
                            shrinkY = 0f;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                            ammoMultiplier = 4f;
                            lightningDamage = 10;
                            lightning = 4;
                            lightningLength = 6;
                            lifetime = 180f;

                            fragBullets = 8;
                            fragBullet = new MissileBulletType(1f, 200){
                                {
                                    width = 16f;
                                    height = 16f;
                                    shrinkY = 0f;
                                    hitEffect = Fx.blastExplosion;
                                    despawnEffect = Fx.blastExplosion;
                                    ammoMultiplier = 4f;
                                    lightningDamage = 10;
                                    lightning = 4;
                                    lightningLength = 6;
                                    lifetime = 180f;

                                    fragBullets = 6;
                                    fragBullet =new MissileBulletType(0.75f, 60){
                                        {
                                            width = 8f;
                                            height = 8f;
                                            shrinkY = 0f;
                                            hitEffect = Fx.blastExplosion;
                                            despawnEffect = Fx.blastExplosion;
                                            ammoMultiplier = 4f;
                                            lightningDamage = 10;
                                            lightning = 4;
                                            lightningLength = 6;
                                            lifetime = 180f;

                                            fragBullets = 4;
                                            fragBullet = new MissileBulletType(0.5f, 30){
                                                {
                                                    width = 8f;
                                                    height = 8f;
                                                    shrinkY = 0f;
                                                    hitEffect = Fx.blastExplosion;
                                                    despawnEffect = Fx.blastExplosion;
                                                    ammoMultiplier = 4f;
                                                    lightningDamage = 10;
                                                    lightning = 4;
                                                    lightningLength = 6;
                                                    lifetime = 180f;
                                                }};
                                        }};
                                }};
                        }}
            );

            shootY = 12f;
            reload = 450f;
            inaccuracy = 8f;
            range = 480f;
            consumeAmmoOnce = false;
            ammoPerShot = 10;
            size = 6;
            shootSound = Sounds.shootBig;
            envEnabled |= Env.space;
            health = 9980;

            coolant = consumeCoolant(0.3f);
        }};

        flame = new ItemTurret("flame"){{
            requirements(Category.turret, with(Items.copper, 120, Items.graphite, 240, Items.silicon, 540));
            ammo(
                    Items.coal, new BulletType(2f, 23f){{
                        ammoMultiplier = 3f;
                        hitSize = 7f;
                        lifetime = 18f;
                        pierce = true;
                        collidesAir = false;
                        statusDuration = 60f * 4;
                        shootEffect = new MultiEffect(new ParticleEffect() {{
                            colorFrom = Pal.lightFlame;
                            colorTo = Pal.darkFlame;
                            particles = 15;
                            sizeFrom = 2;
                            sizeTo = 1;
                            sizeInterp = Interp.exp10In;
                            lifetime = 50f;
                            length = 100f;
                            cone = 25;
                        }},
                        new ParticleEffect() {{
                            colorFrom = Pal.lightishGray;
                            colorTo = Pal.darkishGray;
                            particles = 15;
                            sizeFrom = 1;
                            sizeTo = 0.5f;
                            sizeInterp = Interp.exp10In;
                            lifetime = 40f;
                            length = 80f;
                            cone = 25;
                        }});
                        hitEffect = Fx.hitFlameSmall;
                        despawnEffect = Fx.none;
                        status = StatusEffects.burning;
                        keepVelocity = false;
                        hittable = false;
                    }},
                    Items.pyratite, new BulletType(3f, 113f){{
                        ammoMultiplier = 6f;
                        hitSize = 7f;
                        lifetime = 18f;
                        pierce = true;
                        collidesAir = false;
                        statusDuration = 60f * 10;
                        shootEffect = new ParticleEffect() {{
                            colorFrom = Pal.lightFlame;
                            colorTo = Pal.darkFlame;
                            particles = 15;
                            sizeFrom = 2;
                            sizeTo = 1;
                            sizeInterp = Interp.exp10In;
                            lifetime = 50f;
                            length = 100f;
                            cone = 25;
                        }};
                        despawnEffect = Fx.none;
                        status = StatusEffects.burning;
                        hittable = false;

                    }},
                    Items.blastCompound, new BulletType(2f, 150f){{
                        ammoMultiplier = 6f;
                        hitSize = 7f;
                        lifetime = 18f;
                        pierce = true;
                        collidesAir = false;
                        statusDuration = 60f * 10;
                        shootEffect = new ParticleEffect() {{
                            colorFrom = Pal.lightFlame;
                            colorTo = Pal.darkFlame;
                            particles = 15;
                            sizeFrom = 2;
                            sizeTo = 1;
                            sizeInterp = Interp.exp10In;
                            lifetime = 50f;
                            length = 100f;
                            cone = 25;
                        }};
                        despawnEffect = Fx.none;
                        status = StatusEffects.burning;
                        hittable = false;

                    }}
            );
            recoil = 0f;
            reload = 4f;
            coolantMultiplier = 1.5f;
            range = 100f;
            shootCone = 35f;
            targetAir = false;
            ammoUseEffect = Fx.none;
            health = 400;
            shootSound = Sounds.flame;
            coolant = consumeCoolant(0.1f);
            size = 2;
        }};

        blaze = new ItemTurret("blaze"){{
            requirements(Category.turret, with(Items.copper, 220, Items.graphite, 360, Items.silicon, 650, Items.plastanium, 130));
            ammo(
                    Items.pyratite, new BulletType(5f, 183f){{
                        ammoMultiplier = 6f;
                        hitSize = 7f;
                        lifetime = 24f;
                        pierce = true;
                        collidesAir = false;
                        statusDuration = 60f * 10;
                        shootEffect = new ParticleEffect() {{
                            colorFrom = Pal.lightFlame;
                            colorTo = Pal.darkFlame;
                            particles = 15;
                            sizeFrom = 2;
                            sizeTo = 1;
                            sizeInterp = Interp.exp10In;
                            lifetime = 50f;
                            length = 100f;
                            cone = 25;
                        }};
                        despawnEffect = Fx.none;
                        status = StatusEffects.burning;
                        hittable = false;

                    }},
                    Items.blastCompound, new BulletType(2f, 199f){{
                        ammoMultiplier = 6f;
                        hitSize = 7f;
                        lifetime = 24f;
                        pierce = true;
                        collidesAir = false;
                        statusDuration = 60f * 10;
                        shootEffect = new ParticleEffect() {{
                            colorFrom = Pal.lightFlame;
                            colorTo = Pal.darkFlame;
                            particles = 28;
                            sizeFrom = 2;
                            sizeTo = 1;
                            sizeInterp = Interp.exp10In;
                            lifetime = 50f;
                            length = 100f;
                            cone = 25;
                        }};
                        despawnEffect = Fx.none;
                        status = StatusEffects.burning;
                        hittable = false;

                    }}
            );
            recoil = 0f;
            reload = 4f;
            coolantMultiplier = 1.5f;
            range = 100f;
            shootCone = 35f;
            targetAir = false;
            ammoUseEffect = Fx.none;
            health = 400;
            shootSound = Sounds.flame;
            coolant = consumeCoolant(0.1f);
            size = 3;
        }};
    }
}
