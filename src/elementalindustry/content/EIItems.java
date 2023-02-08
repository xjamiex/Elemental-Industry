package elementalindustry.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class EIItems {
    public static Item
            infusedDarkEnergy, nightCrystal
    ;

    public static void load() {
        infusedDarkEnergy = new Item("infused-dark-energy", Color.valueOf("604875")) {{
            radioactivity = 4f;
            explosiveness = 10f;
            charge = 15f;
            flammability = 5f;
        }};

        nightCrystal = new Item("night-crystal", Color.valueOf("4b33b5")) {{
            radioactivity = 2f;
        }};

    }
}
