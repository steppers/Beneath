package Items.Steel;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class SteelAxe extends Weapon{
    public SteelAxe(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Steel Axe";
        id = Item.SteelAxe;
        image = ImageBank.itemsTiles.getSubImage(48, 48, 16, 16);
    }
}
