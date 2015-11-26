package Core;

import GUI.GUI;
import Items.Item;
import Items.ItemManager;
import PathFinding.Path;
import org.newdawn.slick.*;

import GUI.GUIStatPopup;
import java.util.ArrayList;

/**
 * Created by Ollie on 26/04/14.
 */
public class Player {

    public int posX, posY;
    public int lastPosX, lastPosY;
    public float lerpPosX, lerpPosY;
    private Image image;
    private Image items;
    private Animation downanim;

    public String playerClass = "Warrior";

    public Stats stats;
    public float exp = 0;
    public float targetExp = 10;
    public int kills = 0;

    public boolean movementPhase = false;
    public Path currentPath;

    public Player(){
        image = ImageBank.player;
        items = ImageBank.playerItems;

        downanim = new Animation(new Image[]{image.getSubImage(0, 0, 16, 16),
                image.getSubImage(16, 0, 16, 16),
                image.getSubImage(32, 0, 16, 16),
                image.getSubImage(48, 0, 16, 16)}, 43);
        stats = new Stats(20, 20, 0, 0, 0, 0);
    }

    public void levelUp(){
        stats.maxHP += 10;
        stats.HP += 10;
    }

    public void addHealth(int health){
        if(stats.HP < stats.maxHP){
            stats.HP += health;
            GUI.addComponent(new GUIStatPopup(posX, posY - 1, "+"+health+" HP", Color.green), 1.5f);
            if(stats.HP > stats.maxHP)
                stats.HP = stats.maxHP;
        }
    }

    public void setPos(int x, int y){
        posX = x;
        posY = y;
        lerpPosX = x;
        lerpPosY = y;
    }

    public void render(Graphics g, float xOffset, float yOffset, float scale){
        if(!movementPhase){
            downanim.setCurrentFrame(0);
            downanim.stop();
        }else{
            downanim.start();
        }
        downanim.draw((lerpPosX*16*scale)+xOffset, (lerpPosY*16*scale)+yOffset, 16*scale, 16*scale);
        if(ItemManager.playerArmour != null){
            items.draw((lerpPosX*16*scale)+xOffset, (lerpPosY*16*scale)+yOffset, (lerpPosX*16*scale)+xOffset+16*scale, (lerpPosY*16*scale)+yOffset+16*scale,(ItemManager.playerArmour.id%8)*16,(ItemManager.playerArmour.id/8)*16,((ItemManager.playerArmour.id%8)*16)+16,((ItemManager.playerArmour.id/8)*16)+16);
        }
        if(ItemManager.playerWeapon != null){
            items.draw((lerpPosX*16*scale)+xOffset, (lerpPosY*16*scale)+yOffset, (lerpPosX*16*scale)+xOffset+16*scale, (lerpPosY*16*scale)+yOffset+16*scale,(ItemManager.playerWeapon.id%8)*16,(ItemManager.playerWeapon.id/8)*16,((ItemManager.playerWeapon.id%8)*16)+16,((ItemManager.playerWeapon.id/8)*16)+16);
        }
    }

}
