package Items.Gold;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class GoldAxe extends Weapon{
    public GoldAxe(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Gold Axe";
        id = Item.GoldAxe;
        image = ImageBank.itemsTiles.getSubImage(48, 64, 16, 16);
    }
}
