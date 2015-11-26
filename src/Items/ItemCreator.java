package Items;

import Items.Copper.*;
import Items.Dragon.*;
import Items.DragonBone.*;
import Items.Glass.*;
import Items.Gold.*;
import Items.Iron.*;
import Items.Potions.HealthPotion;
import Items.Steel.*;
import Items.Wooden.*;

import java.util.Random;

/**
 * Created by Ollie on 02/05/14.
 */
public class ItemCreator {

    public static Item CreateEquippable(int level){
        Random r = new Random(System.nanoTime());
        float i = r.nextFloat();

        if(i > 0.84f)
            return new HealthPotion(300);

        Item item;

        int x;

        float y = r.nextFloat();
        if(y < 0.5f){
            x = level;
        }else if(i >= 0.5f && i < 0.75f){
            x = 1+level;
        }else if(i >= 0.75f && i < 0.88f){
            x = 2+level;
        }else{
            x = 3+level;
        }

        i = r.nextFloat();
        switch(x){
            case 1:
                if(i < 0.2f){
                    item = new WoodenDagger(4,1,9,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new WoodenSword(6,1,9,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new WoodenArmour(3,1,9,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new WoodenRing(0,0,2,0,0,0,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new WoodenClaymore(9,2,10,null,false);
                }else{
                    item = new WoodenAxe(11,2,11,null,false);
                }
                break;
            case 2:
                if(i < 0.2f){
                    item = new WoodenArmour(3,1,9,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new WoodenRing(0,0,2,0,0,0,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new WoodenClaymore(9,2,10,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new WoodenAxe(11,2,11,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new CopperDagger(7,1,10,null,false);
                }else{
                    item = new CopperSword(9,1,10,null,false);
                }
                break;
            case 3:
                if(i < 0.2f){
                    item = new WoodenClaymore(9,2,10,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new WoodenAxe(11,2,11,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new CopperDagger(7,1,10,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new CopperSword(9,1,10,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new CopperArmour(5,1,10,null,false);
                }else{
                    item = new CopperRing(0,0,3,0,0,0,false);
                }
                break;
            case 4:
                if(i < 0.2f){
                    item = new CopperArmour(5,1,10,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new CopperRing(0,0,3,0,0,0,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new CopperClaymore(12,2,11,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new CopperAxe(14,2,12,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new IronDagger(10,1,11,null,false);
                }else{
                    item = new IronSword(12,1,11,null,false);
                }
                break;
            case 5:
                if(i < 0.2f){
                    item = new CopperClaymore(12,2,11,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new CopperAxe(14,2,12,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new IronDagger(10,1,11,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new IronSword(12,1,11,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new IronArmour(7,1,11,null,false);
                }else{
                    item = new IronRing(0,0,4,0,0,0,false);
                }
                break;
            case 6:
                if(i < 0.2f){
                    item = new IronDagger(10,1,11,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new IronSword(12,1,11,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new IronArmour(7,1,11,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new IronRing(0,0,4,0,0,0,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new IronClaymore(15,2,12,null,false);
                }else{
                    item = new IronAxe(17,2,13,null,false);
                }
                break;
            case 7:
                if(i < 0.2f){
                    item = new IronArmour(7,1,11,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new IronRing(0,0,4,0,0,0,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new IronClaymore(15,2,12,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new IronAxe(17,2,13,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new SteelDagger(13,1,12,null,false);
                }else{
                    item = new SteelSword(15,1,12,null,false);
                }
                break;
            case 8:
                if(i < 0.2f){
                    item = new IronClaymore(15,2,12,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new IronAxe(17,2,13,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new SteelDagger(13,1,12,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new SteelSword(15,1,12,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new SteelArmour(9,1,12,null,false);
                }else{
                    item = new SteelRing(0,0,5,0,0,0,false);
                }
                break;
            case 9:
                if(i < 0.2f){
                    item = new SteelDagger(13,1,12,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new SteelSword(15,1,12,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new SteelArmour(9,1,12,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new SteelRing(0,0,5,0,0,0,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new SteelClaymore(18,2,13,null,false);
                }else{
                    item = new SteelAxe(20,2,14,null,false);
                }
                break;
            case 10:
                if(i < 0.2f){
                    item = new SteelArmour(9,1,12,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new SteelRing(0,0,5,0,0,0,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new SteelClaymore(18,2,13,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new SteelAxe(20,2,14,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new GoldDagger(16,1,13,null,false);
                }else{
                    item = new GoldSword(18,1,13,null,false);
                }
                break;
            case 11:
                if(i < 0.2f){
                    item = new SteelClaymore(18,2,13,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new SteelAxe(20,2,14,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new GoldDagger(16,1,13,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new GoldSword(18,1,13,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new GoldArmour(11,1,13,null,false);
                }else{
                    item = new GoldRing(0,0,6,0,0,0,false);
                }
                break;
            case 12:
                if(i < 0.2f){
                    item = new GoldDagger(16,1,13,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new GoldSword(18,1,13,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new GoldArmour(11,1,13,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new GoldRing(0,0,6,0,0,0,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new GoldClaymore(21,2,14,null,false);
                }else{
                    item = new GoldAxe(23,2,15,null,false);
                }
                break;
            case 13:
                if(i < 0.2f){
                    item = new GoldArmour(11,1,13,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new GoldRing(0,0,6,0,0,0,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new GoldClaymore(21,2,14,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new GoldAxe(23,2,15,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new GlassDagger(19,1,14,null,false);
                }else{
                    item = new GlassSword(21,1,14,null,false);
                }
                break;
            case 14:
                if(i < 0.2f){
                    item = new GoldClaymore(21,2,14,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new GoldAxe(23,2,15,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new GlassDagger(19,1,14,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new GlassSword(21,1,14,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new GlassArmour(13,1,14,null,false);
                }else{
                    item = new GlassRing(0,0,7,0,0,0,false);
                }
                break;
            case 15:
                if(i < 0.2f){
                    item = new GlassDagger(19,1,14,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new GlassSword(21,1,14,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new GlassArmour(13,1,14,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new GlassRing(0,0,7,0,0,0,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new GlassClaymore(24,2,15,null,false);
                }else{
                    item = new GlassAxe(26,2,16,null,false);
                }
                break;
            case 16:
                if(i < 0.2f){
                    item = new GlassArmour(13,1,14,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new GlassRing(0,0,7,0,0,0,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new GlassClaymore(24,2,15,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new GlassAxe(26,2,16,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new DragonDagger(22,1,15,null,false);
                }else{
                    item = new DragonSword(24,1,15,null,false);
                }
                break;
            case 17:
                if(i < 0.2f){
                    item = new GlassClaymore(24,2,15,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new GlassAxe(26,2,16,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new DragonDagger(22,1,15,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new DragonSword(24,1,15,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new DragonArmour(15,1,15,null,false);
                }else{
                    item = new DragonRing(0,0,8,0,0,0,false);
                }
                break;
            case 18:
                if(i < 0.2f){
                    item = new DragonDagger(22,1,15,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new DragonSword(24,1,15,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new DragonArmour(15,1,15,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new DragonRing(0,0,8,0,0,0,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new DragonClaymore(27,2,16,null,false);
                }else{
                    item = new DragonAxe(29,2,17,null,false);
                }
                break;
            case 19:
                if(i < 0.2f){
                    item = new DragonArmour(15,1,15,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new DragonRing(0,0,8,0,0,0,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new DragonClaymore(27,2,16,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new DragonAxe(29,2,17,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new DragonBoneDagger(25,1,16,null,false);
                }else{
                    item = new DragonBoneSword(27,1,16,null,false);
                }
                break;
            case 20:
                if(i < 0.2f){
                    item = new DragonClaymore(27,2,16,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new DragonAxe(29,2,17,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new DragonBoneDagger(25,1,16,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new DragonBoneSword(27,1,16,null,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new DragonBoneArmour(17,1,16,null,false);
                }else{
                    item = new DragonBoneRing(0,0,9,0,0,0,false);
                }
                break;
            default:
                if(i < 0.2f){
                    item = new DragonBoneDagger(25,1,16,null,false);
                }else if(i >= 0.2f && i < 0.5f){
                    item = new DragonBoneSword(27,1,16,null,false);
                }else if(i >= 0.5f && i < 0.8f){
                    item = new DragonBoneArmour(17,1,16,null,false);
                }else if(i >= 0.8f && i < 0.85f){
                    item = new DragonBoneRing(0,0,9,0,0,0,false);
                }else if(i >= 0.9f && i < 0.95f){
                    item = new DragonBoneClaymore(30,2,17,null,false);
                }else{
                    item = new DragonBoneAxe(32,2,18,null,false);
                }
                break;
        }

        i = r.nextFloat();
        if(i <= 0.05f){
            Enchantment e = new Enchantment();
            for(int a = 0; a < 6; a++){
                int b = r.nextInt(4);
                switch(b){
                    case 0:
                        e.Attack++;
                        break;
                    case 1:
                        e.Defense++;
                        break;
                    case 2:
                        e.Evade++;
                        break;
                    case 3:
                        e.maxHP++;
                        break;
                }
            }
            int biggest = 0;
            int size = e.Attack;
            if(e.Defense > size){
                biggest = 1;
                size = e.Defense;
            }
            if(e.Evade > size){
                biggest = 2;
                size = e.Evade;
            }
            if(e.maxHP > size){
                biggest = 3;
                size = e.maxHP;
            }
            //if(e.Speed > size){
            //    biggest = 4;
            //    size = e.Speed;
            //}

            switch(biggest){
                case 0:
                    e.name = "Of Slicing";
                    break;
                case 1:
                    e.name = "Of Blocking";
                    break;
                case 2:
                    e.name = "Of Dodging";
                    break;
                case 3:
                    e.name = "Of Endurance";
                    break;
                case 4:
                    e.name = "Of Agility";
                    break;
            }
            item.enchantment = e;
        }
        return item;
    }

}
