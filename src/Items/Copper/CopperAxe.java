package Items.Copper;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class CopperAxe extends Weapon{
    public CopperAxe(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Copper Axe";
        id = Item.CopperAxe;
        image = ImageBank.itemsTiles.getSubImage(48, 16, 16, 16);
    }
}
