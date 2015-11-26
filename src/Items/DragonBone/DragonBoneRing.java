package Items.DragonBone;

import Core.ImageBank;
import Items.Item;
import Items.Jewelry;

/**
 * Created by Ollie on 02/05/14.
 */
public class DragonBoneRing extends Jewelry{
    public DragonBoneRing(int HP, int maxHP, int Attack, int Defense, int Speed, int Evade, boolean isEquipped) {
        super(HP, maxHP, Attack, Defense, Speed, Evade, isEquipped);
        name = "Dragon Bone Ring";
        id = Item.DragonBoneRing;
        image = ImageBank.itemsTiles.getSubImage(80, 112, 16, 16);
    }
}
