package Items;

import Core.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created by Ollie on 26/04/14.
 */
public class Item extends Core.Object {

    public static final int HealthPotion = 100;

    public static final int WoodenDagger = 0;
    public static final int WoodenSword = 1;
    public static final int WoodenClaymore = 2;
    public static final int WoodenAxe = 3;
    public static final int WoodenArmour = 4;
    public static final int WoodenRing = 5;

    public static final int CopperDagger = 8;
    public static final int CopperSword = 9;
    public static final int CopperClaymore = 10;
    public static final int CopperAxe = 11;
    public static final int CopperArmour = 12;
    public static final int CopperRing = 13;

    public static final int IronDagger = 16;
    public static final int IronSword = 17;
    public static final int IronClaymore = 18;
    public static final int IronAxe = 19;
    public static final int IronArmour = 20;
    public static final int IronRing = 21;

    public static final int SteelDagger = 24;
    public static final int SteelSword = 25;
    public static final int SteelClaymore = 26;
    public static final int SteelAxe = 27;
    public static final int SteelArmour = 28;
    public static final int SteelRing = 29;

    public static final int GoldDagger = 32;
    public static final int GoldSword = 33;
    public static final int GoldClaymore = 34;
    public static final int GoldAxe = 35;
    public static final int GoldArmour = 36;
    public static final int GoldRing = 37;

    public static final int GlassDagger = 40;
    public static final int GlassSword = 41;
    public static final int GlassClaymore = 42;
    public static final int GlassAxe = 43;
    public static final int GlassArmour = 44;
    public static final int GlassRing = 45;

    public static final int DragonDagger = 48;
    public static final int DragonSword = 49;
    public static final int DragonClaymore = 50;
    public static final int DragonAxe = 51;
    public static final int DragonArmour = 52;
    public static final int DragonRing = 53;

    public static final int DragonBoneDagger = 56;
    public static final int DragonBoneSword = 57;
    public static final int DragonBoneClaymore = 58;
    public static final int DragonBoneAxe = 59;
    public static final int DragonBoneArmour = 60;
    public static final int DragonBoneRing = 61;

    public static final int UsableType = 0;
    public static final int WeaponType = 1;
    public static final int ArmourType = 2;
    public static final int JewelryType = 3;

    public boolean isHeld = false;
    public boolean isEquipable = false;
    public boolean isEquipped = false;
    public boolean isStackable = true;
    public int quantity = 1;
    public int id;
    public int type;
    public String name;
    public Stats stats;

    public Enchantment enchantment;

    public Item(int x, int y) {
        super(x, y, true);
    }

    public void renderLevelItem(Graphics g, float xOffset, float yOffset, float scale){
        try{
            if(enchantment != null)
                image.draw((x*16*scale)+xOffset, (y*16*scale)+yOffset, 16*scale, 16*scale, new Color(1,0.75f+Enchantment.getFilter(),1));
            else
                image.draw((x*16*scale)+xOffset, (y*16*scale)+yOffset, 16*scale, 16*scale);
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
