package Items.Glass;

import Core.ImageBank;
import Items.Armour;
import Items.Enchantment;
import Items.Item;
import org.newdawn.slick.Image;

/**
 * Created by Ollie on 02/05/14.
 */
public class GlassArmour extends Armour{
    public GlassArmour(int Defense, int Evade, int Strength, Enchantment enchantment, boolean isEquipped) {
        super(Defense, Evade, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Glass Armour";
        id = Item.GlassArmour;
        image = ImageBank.itemsTiles.getSubImage(64, 80, 16, 16);
        image.setFilter(Image.FILTER_NEAREST);
    }
}
