package Items.Iron;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class IronAxe extends Weapon{
    public IronAxe(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Iron Axe";
        id = Item.IronAxe;
        image = ImageBank.itemsTiles.getSubImage(48, 32, 16, 16);
    }
}
