package Items.Iron;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class IronClaymore extends Weapon {
    public IronClaymore(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Iron Claymore";
        id = Item.IronClaymore;
        image = ImageBank.itemsTiles.getSubImage(32, 32, 16, 16);
    }
}
