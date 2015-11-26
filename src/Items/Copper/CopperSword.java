package Items.Copper;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class CopperSword extends Weapon {
    public CopperSword(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Copper Sword";
        id = Item.CopperSword;
        image = ImageBank.itemsTiles.getSubImage(16, 16, 16, 16);
    }
}
