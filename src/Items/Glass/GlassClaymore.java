package Items.Glass;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class GlassClaymore extends Weapon {
    public GlassClaymore(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Glass Claymore";
        id = Item.GlassClaymore;
        image = ImageBank.itemsTiles.getSubImage(32, 80, 16, 16);
    }
}
