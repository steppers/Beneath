package Items.Glass;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class GlassSword extends Weapon {
    public GlassSword(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Glass Sword";
        id = Item.GlassSword;
        image = ImageBank.itemsTiles.getSubImage(16, 80, 16, 16);
    }
}
