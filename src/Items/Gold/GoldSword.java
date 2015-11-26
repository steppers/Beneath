package Items.Gold;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class GoldSword extends Weapon {
    public GoldSword(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Gold Sword";
        id = Item.GoldSword;
        image = ImageBank.itemsTiles.getSubImage(16, 64, 16, 16);
    }
}
