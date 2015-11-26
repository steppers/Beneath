package Items.Iron;

import Core.ImageBank;
import Items.Item;
import Items.Jewelry;

/**
 * Created by Ollie on 02/05/14.
 */
public class IronRing extends Jewelry{
    public IronRing(int HP, int maxHP, int Attack, int Defense, int Speed, int Evade, boolean isEquipped) {
        super(HP, maxHP, Attack, Defense, Speed, Evade, isEquipped);
        name = "Iron Ring";
        id = Item.IronRing;
        image = ImageBank.itemsTiles.getSubImage(80, 32, 16, 16);
    }
}
