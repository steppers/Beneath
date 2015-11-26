package Items.DragonBone;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class DragonBoneDagger extends Weapon{

    public DragonBoneDagger(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Dragon Bone Dagger";
        id = Item.DragonBoneDagger;
        image = ImageBank.itemsTiles.getSubImage(0, 112, 16, 16);
    }

}
