package Items.Potions;

import Core.ImageBank;

/**
 * Created by Ollie on 28/04/14.
 */
public class HealthPotion extends Potion {
    public HealthPotion(int HP) {
        super(HP, 0);
        name = "Health Potion";
        id = HealthPotion;
        image = ImageBank.itemsTiles.getSubImage(96, 0, 16, 16);
        image.setImageColor(0.7f, 0, 0);
    }
}
