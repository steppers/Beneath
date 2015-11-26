package Enemies;

import Core.ImageBank;
import Core.Stats;
import Items.Item;
import Items.ItemCreator;
import org.newdawn.slick.Image;

import java.util.Random;

/**
 * Created by Ollie on 27/04/14.
 */
public class RedSlime extends Enemy {

    public RedSlime(int posX, int posY, float difficulty, boolean item) {
        super(posX, posY, difficulty);
        setImage(ImageBank.redSlime);
        name = "Red Slime";

        exp = (int)(3*difficulty/2);
        Random r = new Random(System.nanoTime());
        int i = r.nextInt(5);
        if(i == 0 && item){
            items = new Item[]{ItemCreator.CreateEquippable((int)difficulty)};
        }
        stats = new Stats((int)(20*difficulty/3)+2, (int)(20*difficulty/3)+2, (int)(2+difficulty/3)+1, 0, (int)(1*difficulty/3), 1);
        moveSpeed = 1;
    }
}
