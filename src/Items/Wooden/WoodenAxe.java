package Items.Wooden;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class WoodenAxe extends Weapon{
    public WoodenAxe(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Wooden Axe";
        id = Item.WoodenAxe;
        image = ImageBank.itemsTiles.getSubImage(48, 0, 16, 16);
    }
}
