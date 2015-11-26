package Items.Gold;

import Core.ImageBank;
import Items.Item;
import Items.Jewelry;

/**
 * Created by Ollie on 02/05/14.
 */
public class GoldRing extends Jewelry{
    public GoldRing(int HP, int maxHP, int Attack, int Defense, int Speed, int Evade, boolean isEquipped) {
        super(HP, maxHP, Attack, Defense, Speed, Evade, isEquipped);
        name = "Gold Ring";
        id = Item.GoldRing;
        image = ImageBank.itemsTiles.getSubImage(80, 64, 16, 16);
    }
}
