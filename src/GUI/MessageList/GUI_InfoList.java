package GUI.MessageList;

import GUI.GUI;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

/**
 * Created by Ollie on 07/05/14.
 */
public class GUI_InfoList {

    public static ArrayList<GUI_Message> messages = new ArrayList<GUI_Message>();

    public static void AddMessage(String message, Color color){
        GUI_Message m = new GUI_Message(message, color);
        m.startTime = System.nanoTime();
        m.duration = 5f;
        messages.add(m);
    }

    public static void update(){
        for(int i = 0; i < messages.size(); i++){
            if(System.nanoTime() - messages.get(i).startTime >= 1000000000*messages.get(i).duration){
                messages.remove(i);
                i--;
            }
        }
    }

    public static void render(Graphics g){
        int startHeight = 515 - messages.size()*15;
        for(int i = 0; i < messages.size(); i++){
            g.setColor(messages.get(i).color);
            g.drawString(messages.get(i).message, 5, startHeight+i*15);
        }
    }
}
