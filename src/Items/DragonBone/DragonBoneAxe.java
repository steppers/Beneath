package Items.DragonBone;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class DragonBoneAxe extends Weapon{
    public DragonBoneAxe(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Dragon Bone Axe";
        id = Item.DragonBoneAxe;
        image = ImageBank.itemsTiles.getSubImage(48, 112, 16, 16);
    }
}
