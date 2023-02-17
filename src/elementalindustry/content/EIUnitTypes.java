package elementalindustry.content;

import arc.graphics.Color;
import mindustry.entities.part.HaloPart;
import mindustry.entities.part.RegionPart;
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
            parts.add(new RegionPart("-glow") {{
                under = true;
                outline = true;
                moveY = 0f;
                progress = PartProgress.warmup;
            }});
            parts.add(new RegionPart("-wing") {{
                under = false;
                outline = true;
                moveY = 3.5f;
                progress = PartProgress.warmup;
            }});
            parts.add(new RegionPart("-top-second") {{
                under = false;
                outline = true;
                moveY = 7f;
                progress = PartProgress.warmup;
            }});
            parts.add(new RegionPart("-top") {{
                under = false;
                outline = true;
                moveY = 10.5f;
                progress = PartProgress.warmup;
            }});

            parts.add(new HaloPart(){{

            }});

            weapons.add(new Weapon("elemental-industry-arcane-railgun") {{
                reload = 5000;
            }});
        }};
    }
}
