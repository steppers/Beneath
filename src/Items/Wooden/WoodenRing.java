package Items.Wooden;

import Core.ImageBank;
import Items.Item;
import Items.Jewelry;

/**
 * Created by Ollie on 02/05/14.
 */
public class WoodenRing extends Jewelry{
    public WoodenRing(int HP, int maxHP, int Attack, int Defense, int Speed, int Evade, boolean isEquipped) {
        super(HP, maxHP, Attack, Defense, Speed, Evade, isEquipped);
        name = "Wooden Ring";
        id = Item.WoodenRing;
        image = ImageBank.itemsTiles.getSubImage(80, 0, 16, 16);
    }
}
