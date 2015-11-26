package Items.Glass;

import Core.ImageBank;
import Items.Item;
import Items.Jewelry;

/**
 * Created by Ollie on 02/05/14.
 */
public class GlassRing extends Jewelry{
    public GlassRing(int HP, int maxHP, int Attack, int Defense, int Speed, int Evade, boolean isEquipped) {
        super(HP, maxHP, Attack, Defense, Speed, Evade, isEquipped);
        name = "Glass Ring";
        id = Item.GlassRing;
        image = ImageBank.itemsTiles.getSubImage(80, 80, 16, 16);
    }
}
