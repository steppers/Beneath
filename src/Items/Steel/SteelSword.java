package Items.Steel;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class SteelSword extends Weapon {
    public SteelSword(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Steel Sword";
        id = Item.SteelSword;
        image = ImageBank.itemsTiles.getSubImage(16, 48, 16, 16);
    }
}
