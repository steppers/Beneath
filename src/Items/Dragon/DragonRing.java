package Items.Dragon;

import Core.ImageBank;
import Items.Item;
import Items.Jewelry;

/**
 * Created by Ollie on 02/05/14.
 */
public class DragonRing extends Jewelry{
    public DragonRing(int HP, int maxHP, int Attack, int Defense, int Speed, int Evade, boolean isEquipped) {
        super(HP, maxHP, Attack, Defense, Speed, Evade, isEquipped);
        name = "Dragon Ring";
        id = Item.DragonRing;
        image = ImageBank.itemsTiles.getSubImage(80, 96, 16, 16);
    }
}
