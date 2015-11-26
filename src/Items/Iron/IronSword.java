package Items.Iron;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class IronSword extends Weapon {
    public IronSword(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Iron Sword";
        id = Item.IronSword;
        image = ImageBank.itemsTiles.getSubImage(16, 32, 16, 16);
    }
}
