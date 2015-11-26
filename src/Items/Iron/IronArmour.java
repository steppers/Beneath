package Items.Iron;

import Core.ImageBank;
import Items.Armour;
import Items.Enchantment;
import Items.Item;
import org.newdawn.slick.Image;

/**
 * Created by Ollie on 02/05/14.
 */
public class IronArmour extends Armour{
    public IronArmour(int Defense, int Evade, int Strength, Enchantment enchantment, boolean isEquipped) {
        super(Defense, Evade, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Iron Armour";
        id = Item.IronArmour;
        image = ImageBank.itemsTiles.getSubImage(64, 32, 16, 16);
        image.setFilter(Image.FILTER_NEAREST);
    }
}
