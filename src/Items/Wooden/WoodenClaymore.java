package Items.Wooden;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class WoodenClaymore extends Weapon {
    public WoodenClaymore(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Wooden Claymore";
        id = Item.WoodenClaymore;
        image = ImageBank.itemsTiles.getSubImage(32, 0, 16, 16);
    }
}
