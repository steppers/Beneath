package GUI.MessageList;

import org.newdawn.slick.Color;

/**
 * Created by Ollie on 07/05/14.
 */
public class GUI_Message {

    public Color color;
    public float duration;
    public float startTime;
    public String message;

    public GUI_Message(String Message, Color c){
        color = c;
        message = Message;
    }
}
