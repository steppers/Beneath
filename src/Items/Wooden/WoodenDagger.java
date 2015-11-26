package Items.Wooden;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class WoodenDagger extends Weapon{

    public WoodenDagger(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Wooden Dagger";
        id = Item.WoodenDagger;
        image = ImageBank.itemsTiles.getSubImage(0, 0, 16, 16);
    }

}
