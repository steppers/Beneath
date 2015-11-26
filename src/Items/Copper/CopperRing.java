package Items.Copper;

import Core.ImageBank;
import Items.Item;
import Items.Jewelry;

/**
 * Created by Ollie on 02/05/14.
 */
public class CopperRing extends Jewelry{
    public CopperRing(int HP, int maxHP, int Attack, int Defense, int Speed, int Evade, boolean isEquipped) {
        super(HP, maxHP, Attack, Defense, Speed, Evade, isEquipped);
        name = "Copper Ring";
        id = Item.CopperRing;
        image = ImageBank.itemsTiles.getSubImage(80, 16, 16, 16);
    }
}
