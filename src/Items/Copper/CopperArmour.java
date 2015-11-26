package Items.Copper;

import Core.ImageBank;
import Items.Armour;
import Items.Enchantment;
import Items.Item;
import org.newdawn.slick.Image;

/**
 * Created by Ollie on 02/05/14.
 */
public class CopperArmour extends Armour{
    public CopperArmour(int Defense, int Evade, int Strength, Enchantment enchantment, boolean isEquipped) {
        super(Defense, Evade, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Copper Armour";
        id = Item.CopperArmour;
        image = ImageBank.itemsTiles.getSubImage(64, 16, 16, 16);
        image.setFilter(Image.FILTER_NEAREST);
    }
}
