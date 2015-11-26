package Items.Gold;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class GoldDagger extends Weapon{

    public GoldDagger(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Gold Dagger";
        id = Item.GoldDagger;
        image = ImageBank.itemsTiles.getSubImage(0, 64, 16, 16);
    }

}
