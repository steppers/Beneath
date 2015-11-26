package Items.DragonBone;

import Core.ImageBank;
import Items.Enchantment;
import Items.Item;
import Items.Weapon;

/**
 * Created by Ollie on 02/05/14.
 */
public class DragonBoneClaymore extends Weapon {
    public DragonBoneClaymore(int Attack, int Speed, int Strength, Enchantment enchantment, boolean isEquipped){
        super(Attack, Speed, isEquipped);
        this.enchantment = enchantment;
        this.stats.Strength = Strength;
        name = "Dragon Bone Claymore";
        id = Item.DragonBoneClaymore;
        image = ImageBank.itemsTiles.getSubImage(32, 112, 16, 16);
    }
}
