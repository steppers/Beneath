package Items.Dragon;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class DragonDagger extends Weapon{

    public DragonDagger(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Dragon Dagger";
        id = Item.DragonDagger;
        image = ImageBank.itemsTiles.getSubImage(0, 96, 16, 16);
    }

}
