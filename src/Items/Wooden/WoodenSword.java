package Items.Wooden;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class WoodenSword extends Weapon {
    public WoodenSword(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Wooden Sword";
        id = Item.WoodenSword;
        image = ImageBank.itemsTiles.getSubImage(16, 0, 16, 16);
    }
}
