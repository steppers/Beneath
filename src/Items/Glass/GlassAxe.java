package Items.Glass;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class GlassAxe extends Weapon{
    public GlassAxe(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Glass Axe";
        id = Item.GlassAxe;
        image = ImageBank.itemsTiles.getSubImage(48, 80, 16, 16);
    }
}
