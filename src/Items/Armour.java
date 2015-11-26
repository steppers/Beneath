package Items;

import Core.Stats;
import Items.Item;

/**
 * Created by Ollie on 28/04/14.
 */
public class Armour extends Item {

    public Armour(int Defense, int Evade, boolean isEquipped){
        super(0, 0);
        this.isEquipped = isEquipped;
        type = ArmourType;
        isEquipable = true;
        isStackable = false;
        stats = new Stats(0, 0, 0, Defense, 0, Evade);
    }
}
