package Items.Steel;

import Core.ImageBank;
import Items.Item;
import Items.Jewelry;

/**
 * Created by Ollie on 02/05/14.
 */
public class SteelRing extends Jewelry{
    public SteelRing(int HP, int maxHP, int Attack, int Defense, int Speed, int Evade, boolean isEquipped) {
        super(HP, maxHP, Attack, Defense, Speed, Evade, isEquipped);
        name = "Steel Ring";
        id = Item.SteelRing;
        image = ImageBank.itemsTiles.getSubImage(80, 48, 16, 16);
    }
}
