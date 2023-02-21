package elementalindustry.content;

import arc.graphics.Blending;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.part.HaloPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.part.ShapePart;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class EIUnitTypes {
    public static UnitType
        arcane
    ;

    public static void load() {
        arcane = new UnitType("arcane") {{
            health = 64000;
            armor = 12;
            drag = 0.2f;
            accel = 0.23f;
            flying = true;
            speed = 0.56f;
            rotateSpeed = 0.25f;

            engineColor = Pal.heal;
            engineSize = 15;
            engineOffset = 45;
            constructor = UnitEntity::create;

            lowAltitude = true;

            parts.addAll(
                    new RegionPart("-top") {{
                        under = false;
                        outline = true;
                        moveY = 10.5f;
                        progress = PartProgress.warmup;
                    }},
                    new RegionPart("-top-second") {{
                        under = false;
                        outline = true;
                        moveY = 7f;
                        progress = PartProgress.warmup;
                    }},
                    new RegionPart("-wing") {{
                        under = false;
                        outline = true;
                        moveY = 3.5f;
                        progress = PartProgress.warmup;
                    }},
                    new RegionPart("-glow") {{
                        under = true;
                        outline = true;
                        moveY = 0f;
                        progress = PartProgress.warmup;
                        heatColor = EIPal.arcaneGreenLight;
                        heatProgress = PartProgress.warmup;
                        drawRegion = false;
                        blending = Blending.additive;
                    }},
                    new ShapePart() {{
                        circle = true;
                        hollow = true;
                        radiusTo = 20f;
                        stroke = 2;
                        strokeTo = 5;
                        color = EIPal.arcaneGreenLight;
                        colorTo = EIPal.arcaneGreenLight;
                    }},
                    new ShapePart() {{
                        circle = true;
                        hollow = true;
                        radius = 6;
                        radiusTo = 10f;
                        stroke = 2;
                        strokeTo = 5;
                        color = EIPal.arcaneGreenLight;
                        colorTo = EIPal.arcaneGreenLight;
                    }},
                    new ShapePart() {{
                        sides = 3;
                        hollow = true;
                        color = EIPal.arcaneGreenLight;
                        colorTo = EIPal.arcaneGreenLight;
                        radius = 0;
                        radiusTo = 17f;
                        rotateSpeed = 5;
                        stroke = 2;
                        strokeTo = 5;
                    }}
            );

            weapons.add(new Weapon("elemental-industry-small-missile-launcher") {{
                x = 24;
                y = 30;
                mirror = true;
                alternate = true;
                top = false;
                reload = 8f;
                inaccuracy = 2f;

                bullet = EIBullets.smallGreenMissile;
            }});
            weapons.add(new Weapon("elemental-industry-small-missile-launcher-2") {{
                x = 30;
                y = 0;
                mirror = true;
                alternate = true;
                top = false;
                reload = 10f;
                inaccuracy = 6f;

                bullet = EIBullets.smallGreenMissile;
            }});
            weapons.add(new Weapon("elemental-industry-small-missile-launcher-3") {{
                x = 22;
                y = -30;
                mirror = true;
                alternate = true;
                top = false;
                reload = 13f;
                inaccuracy = 5f;

                bullet = EIBullets.smallGreenMissile;
            }});
            weapons.add(new Weapon("elemental-industry-green-laser"){{
                x = 0;
                y = -5;
                mirror = false;
                reload = 250;
                bullet = EIBullets.bigGreenLaser;

                shootStatusDuration = 60f * 2f;
                shootStatus = StatusEffects.unmoving;

                shootSound = Sounds.laserbig;
            }});

        }};
    }
}
