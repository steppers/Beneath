package Enemies;

import Core.ImageBank;
import Core.Stats;
import Items.*;

import java.util.Random;

/**
 * Created by Ollie on 27/04/14.
 */
public class GreenSlime extends Enemy {

    public GreenSlime(int posX, int posY, float difficulty, boolean item) {
        super(posX, posY, difficulty);
        setImage(ImageBank.greenSlime);
        name = "Green Slime";

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
