package Items.Steel;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class SteelDagger extends Weapon{

    public SteelDagger(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Steel Dagger";
        id = Item.SteelDagger;
        image = ImageBank.itemsTiles.getSubImage(0, 48, 16, 16);
    }

}
