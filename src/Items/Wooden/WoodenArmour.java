package Items.Wooden;

import Core.ImageBank;
import Items.Armour;
import Items.Enchantment;
import Items.Item;
import org.newdawn.slick.Image;

/**
 * Created by Ollie on 02/05/14.
 */
public class WoodenArmour extends Armour{
    public WoodenArmour(int Defense, int Evade, int Strength, Enchantment enchantment, boolean isEquipped) {
        super(Defense, Evade, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Wooden Armour";
        id = Item.WoodenArmour;
        image = ImageBank.itemsTiles.getSubImage(64, 0, 16, 16);
        image.setFilter(Image.FILTER_NEAREST);
    }
}
