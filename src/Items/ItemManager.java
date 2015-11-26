package Items;

import Core.AudioBank;
import Core.Player;
import Core.TurnManager;
import Enemies.Enemy;
import Enemies.EnemyManager;
import GUI.GUI;
import GUI.GUIStatPopup;
import GUI.MessageList.GUI_InfoList;
import Items.Dragon.DragonAxe;
import Items.DragonBone.DragonBoneAxe;
import Items.Glass.GlassArmour;
import Items.Glass.GlassDagger;
import Items.Steel.SteelArmour;
import Items.Steel.SteelSword;
import Items.Wooden.WoodenAxe;
import Items.Wooden.WoodenClaymore;
import Items.Wooden.WoodenDagger;
import Items.Wooden.WoodenSword;
import TileSystem.Tile;
import TileSystem.TileMap;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ollie on 27/04/14.
 */
public class ItemManager {

    public static ArrayList<Item> levelItems = new ArrayList<Item>();
    public static ArrayList<Item> inventoryItems = new ArrayList<Item>();
    public static Item playerWeapon = new WoodenDagger(4, 1, 9, null, true);
    public static Item playerArmour = null;
    public static Item playerJewel1 = null;
    public static Item playerJewel2 = null;
    public static final int maxInventory = 16;

    public static Player player;

    private static Random r = new Random(System.nanoTime());

    public static void reset(Player player){
        playerWeapon = new WoodenDagger(4, 1, 9, null, true);
        player.stats.add(playerWeapon.stats);
        playerArmour = null;
        playerJewel1 = null;
        playerJewel2 = null;
        inventoryItems.clear();
        levelItems.clear();
        ItemManager.player = player;
    }

    public static boolean useItem(Item item, int x, int y, EnemyManager em, TurnManager tm){
        if(item == playerWeapon){
            Enemy e = em.getEnemy(x, y);
            if(e != null){
                if(playerWeapon != null){
                    float dodge = r.nextInt(50);
                    if(dodge > e.stats.Evade){
                        int damage = r.nextInt(Math.abs(player.stats.Attack - e.stats.Defense/2)+1)+player.stats.Attack/2;
                        e.stats.HP -= damage;
                        GUI.addComponent(new GUIStatPopup(e.posX, e.posY-1,"-"+damage, Color.orange), 1.5f);
                        AudioBank.playEffect(AudioBank.Hit1);
                        GUI_InfoList.AddMessage("You hit " + e.name + ".", Color.green);
                    }else{
                        GUI.addComponent(new GUIStatPopup(e.posX, e.posY-1,"Dodge", Color.orange), 1.5f);
                        GUI_InfoList.AddMessage(e.name + " dodged your attack.", Color.red);
                    }
                }else{
                    int damage = r.nextInt(1)+1;
                    float dodge = r.nextInt(50);
                    if(dodge < 42){
                        e.stats.HP -= damage;
                        GUI.addComponent(new GUIStatPopup(e.posX, e.posY-1,"-"+1, Color.orange), 1.5f);
                        AudioBank.playEffect(AudioBank.Hit1);
                        GUI_InfoList.AddMessage("You hit " + e.name + ".", Color.green);
                    }else{
                        GUI.addComponent(new GUIStatPopup(e.posX, e.posY-1,"Dodge", Color.orange), 1.5f);
                        GUI_InfoList.AddMessage(e.name + " dodged your attack.", Color.red);
                    }
                }
                if(e.stats.HP <= 0){
                    GUI.addComponent(new GUIStatPopup(player.posX, player.posY-1,"+"+em.getEnemy(x, y).exp+" XP", Color.green), 1.5f);
                    player.exp += em.getEnemy(x, y).exp;
                    player.kills++;
                    em.removeEnemy(e);
                    GUI_InfoList.AddMessage("You killed " + e.name + ".", Color.green);
                }
                if(playerWeapon != null){
                    tm.addEnemyTurns(player.stats.Speed);
                }else{
                    tm.addEnemyTurns(1);
                }
                e.state = Enemy.AIState.ATTACKING;
                em.lastUpdateTime = System.nanoTime();
                return false;
            }
            return true;
        }
        return false;
    }

    public static void PickupItem(Item item){
        if(item.isStackable){
            for(Item i : inventoryItems){
                if(i.id == item.id){
                    i.quantity++;
                    levelItems.remove(item);
                    AudioBank.playEffect(AudioBank.Pickup1);
                    GUI_InfoList.AddMessage("You picked up " + item.name + ".", Color.yellow);
                    return;
                }
            }
            if(inventoryItems.size() < maxInventory){
                inventoryItems.add(item);
                levelItems.remove(item);
                AudioBank.playEffect(AudioBank.Pickup1);
                GUI_InfoList.AddMessage("You picked up " + item.name + ".", Color.yellow);
            }
        }else if(inventoryItems.size() < maxInventory){
            inventoryItems.add(item);
            levelItems.remove(item);
            GUI_InfoList.AddMessage("You picked up " + item.name + ".", Color.yellow);
            AudioBank.playEffect(AudioBank.Pickup1);
        }else if(inventoryItems.size() >= maxInventory){
            GUI.addComponent(new GUIStatPopup(0, 0, "", Color.white), 1);
            GUI_InfoList.AddMessage("Inventory FULL!!", Color.red);
            return;
        }
    }

    public static boolean addEquippedToInventory(Item i){
        if(inventoryItems.size() < maxInventory){
            player.stats.subtract(i.stats);
            if(i.enchantment != null){
                player.stats.Attack -= i.enchantment.Attack;
                player.stats.Evade -= i.enchantment.Evade;
                player.stats.Defense -= i.enchantment.Defense;
                player.stats.maxHP -= i.enchantment.maxHP;
            }
            i.isEquipped = false;
            inventoryItems.add(i);
            AudioBank.playEffect(AudioBank.Pickup1);
            return true;
        }
        return false;
    }

    public static void Equip(Item i){
        inventoryItems.remove(i);
        switch(i.type){
            case Item.WeaponType:
                if(playerWeapon != null){
                    player.stats.subtract(playerWeapon.stats);
                    if(playerWeapon.enchantment != null){
                        player.stats.Attack -= playerWeapon.enchantment.Attack;
                        player.stats.Evade -= playerWeapon.enchantment.Evade;
                        player.stats.Defense -= playerWeapon.enchantment.Defense;
                        player.stats.maxHP -= playerWeapon.enchantment.maxHP;
                    }
                    inventoryItems.add(playerWeapon);
                    playerWeapon.isEquipped = false;
                    player.stats.add(i.stats);
                    if(i.enchantment != null){
                        player.stats.Attack += i.enchantment.Attack;
                        player.stats.Evade += i.enchantment.Evade;
                        player.stats.Defense += i.enchantment.Defense;
                        player.stats.maxHP += i.enchantment.maxHP;
                    }
                    playerWeapon = i;
                    playerWeapon.isEquipped = true;
                }else{
                    player.stats.add(i.stats);
                    if(i.enchantment != null){
                        player.stats.Attack += i.enchantment.Attack;
                        player.stats.Evade += i.enchantment.Evade;
                        player.stats.Defense += i.enchantment.Defense;
                        player.stats.maxHP += i.enchantment.maxHP;
                    }
                    playerWeapon = i;
                    playerWeapon.isEquipped = true;
                }
                break;
            case Item.ArmourType:
                if(playerArmour != null){
                    player.stats.subtract(playerArmour.stats);
                    if(playerWeapon.enchantment != null){
                        player.stats.Attack -= playerArmour.enchantment.Attack;
                        player.stats.Evade -= playerArmour.enchantment.Evade;
                        player.stats.Defense -= playerArmour.enchantment.Defense;
                        player.stats.maxHP -= playerArmour.enchantment.maxHP;
                    }
                    inventoryItems.add(playerArmour);
                    playerArmour.isEquipped = false;
                    player.stats.add(i.stats);
                    if(i.enchantment != null){
                        player.stats.Attack += i.enchantment.Attack;
                        player.stats.Evade += i.enchantment.Evade;
                        player.stats.Defense += i.enchantment.Defense;
                        player.stats.maxHP += i.enchantment.maxHP;
                    }
                    playerArmour = i;
                    playerArmour.isEquipped = true;
                }else{
                    player.stats.add(i.stats);
                    if(i.enchantment != null){
                        player.stats.Attack += i.enchantment.Attack;
                        player.stats.Evade += i.enchantment.Evade;
                        player.stats.Defense += i.enchantment.Defense;
                        player.stats.maxHP += i.enchantment.maxHP;
                    }
                    playerArmour = i;
                    playerArmour.isEquipped = true;
                }
                break;
            case Item.JewelryType:
                if(playerJewel1 == null){
                    player.stats.add(i.stats);
                    if(i.enchantment != null){
                        player.stats.Attack += i.enchantment.Attack;
                        player.stats.Evade += i.enchantment.Evade;
                        player.stats.Defense += i.enchantment.Defense;
                        player.stats.maxHP += i.enchantment.maxHP;
                    }
                    playerJewel1 = i;
                    playerJewel1.isEquipped = true;
                }else if(playerJewel2 == null){
                    player.stats.add(i.stats);
                    if(i.enchantment != null){
                        player.stats.Attack += i.enchantment.Attack;
                        player.stats.Evade += i.enchantment.Evade;
                        player.stats.Defense += i.enchantment.Defense;
                        player.stats.maxHP += i.enchantment.maxHP;
                    }
                    playerJewel2 = i;
                    playerJewel2.isEquipped = true;
                }else if(playerJewel1 != null && playerJewel2 != null){
                    player.stats.subtract(playerJewel2.stats);
                    if(playerJewel2.enchantment != null){
                        player.stats.Attack -= playerJewel2.enchantment.Attack;
                        player.stats.Evade -= playerJewel2.enchantment.Evade;
                        player.stats.Defense -= playerJewel2.enchantment.Defense;
                        player.stats.maxHP -= playerJewel2.enchantment.maxHP;
                    }
                    inventoryItems.add(playerJewel2);
                    playerJewel2.isEquipped = false;
                    player.stats.add(i.stats);
                    if(i.enchantment != null){
                        player.stats.Attack += i.enchantment.Attack;
                        player.stats.Evade += i.enchantment.Evade;
                        player.stats.Defense += i.enchantment.Defense;
                        player.stats.maxHP += i.enchantment.maxHP;
                    }
                    playerJewel2 = i;
                    playerJewel2.isEquipped = true;
                }
                break;
        }
        AudioBank.playEffect(AudioBank.Pickup1);
    }

    public static void DropItem(Item item, int x, int y){
        item.isEquipped = false;
        inventoryItems.remove(item);
        item.x = x;
        item.y = y;
        levelItems.add(item);
    }

    public static void DropEnemyItem(Item item, int x, int y){
        item.x = x;
        item.y = y;
        levelItems.add(item);
    }

    public static Item getItem(int x, int y){
        for(Item i : levelItems){
            if(i.x == x && i.y == y)
                return i;
        }
        return null;
    }

    public static Item getInvItem(int i){
        if(i < inventoryItems.size())
            return inventoryItems.get(i);
        return null;
    }

    public static void renderItems(Graphics g, float xOffset, float yOffset, float scale){
        for(Item i : levelItems){
            i.renderLevelItem(g, xOffset, yOffset, scale);
        }
    }

    public static boolean InventoryIsFull(){
        if(inventoryItems.size() == maxInventory)
            return true;
        return false;
    }

    public static void ScatterItems(int level, int numItems, TileMap map){
        Random r = new Random(System.nanoTime());
        for(int i = 0; i < numItems; i++){
            while(true){
                int x = r.nextInt(40);
                int y = r.nextInt(40);
                if(!map.getTileSolid(x, y) && map.getTileType(x, y) != Tile.TileType.EMPTY && map.getTileType(x, y) != Tile.TileType.STONE_DOOR){
                    DropEnemyItem(ItemCreator.CreateEquippable(level), x, y);
                    break;
                }
            }
        }
    }
}
