package Items;

import org.newdawn.slick.Color;

/**
 * Created by Ollie on 02/05/14.
 */
public class Enchantment {

    public int maxHP;
    public int Attack;
    public int Defense;
    public int Speed;
    public int Evade;

    public String name;

    private static float col;
    private static double pulse;

    public static void updateFilter(int d){
        Enchantment.pulse += ((double)d/200);
        Enchantment.col = (float)Math.cos(Enchantment.pulse)*0.2f;
    }

    public static float getFilter(){
        return col;
    }
}
