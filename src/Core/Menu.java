package Core;

import GUI.GUI;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Ollie on 26/04/14.
 */
public class Menu extends BasicGameState {

    private String Play = "Play";
    private Rectangle playRect = new Rectangle(385, 400, 35, 15);
    private String Options = "Options";
    private Rectangle optionsRect = new Rectangle(377, 430, 50, 15);
    private String About = "About";
    private Rectangle aboutRect = new Rectangle(386, 460, 33, 15);
    private String Exit = "Quit";
    private Rectangle quitRect = new Rectangle(385, 490, 35, 15);

    private enum menuState{
        MAIN,
        OPTIONS,
        ABOUT
    }

    private menuState state = menuState.MAIN;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        GUI.state = GUI.GUIState.MAIN_MENU;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        GUI.state = GUI.GUIState.MAIN_MENU;
        GUI.render(graphics, null, 0, 0, 1, 1);
        switch (state){
            case MAIN:
                graphics.drawString(Play, 390, 400);
                graphics.drawString(Options, 377, 430);
                graphics.drawString(About, 386, 460);
                graphics.drawString(Exit, 390, 490);
                break;
            case OPTIONS:
                if(Core.Options.sound){
                    graphics.setColor(Color.green);
                    graphics.drawString("Sound: enabled", 340, 460);
                }else{
                    graphics.setColor(Color.red);
                    graphics.drawString("Sound: disabled", 340, 460);
                }
                graphics.setColor(Color.black);
                graphics.drawString("<- Back", 375, 490);
                break;
            case ABOUT:
                graphics.drawString("Created by Steppers", 320, 430);
                graphics.drawString("for the Ludumdare-29", 320, 445);
                graphics.drawString("72-hour Game Jam.", 320, 460);
                graphics.drawString("<- Back", 375, 490);
                break;
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        Vector2f mousePos = new Vector2f(input.getMouseX(), input.getMouseY());
        GUI.update(null, stateBasedGame, gameContainer, null);

        switch (state){
            case MAIN:
                if(input.isMousePressed(0)){
                    if(playRect.contains(mousePos.x, mousePos.y)){
                        AudioBank.playEffect(AudioBank.Select1);
                        stateBasedGame.getState(11).init(gameContainer, stateBasedGame);
                        stateBasedGame.enterState(11);
                    }
                    if(optionsRect.contains(mousePos.x, mousePos.y)){
                        AudioBank.playEffect(AudioBank.Select1);
                        state = menuState.OPTIONS;}
                    if(aboutRect.contains(mousePos.x, mousePos.y)){
                        AudioBank.playEffect(AudioBank.Select1);
                        state = menuState.ABOUT;}
                    if(quitRect.contains(mousePos.x, mousePos.y)){
                        AudioBank.playEffect(AudioBank.Select1);
                        gameContainer.exit();}
                }
                break;
            case OPTIONS:
                if(input.isMousePressed(0)){
                    if(quitRect.contains(mousePos.x, mousePos.y)){
                        AudioBank.playEffect(AudioBank.Select1);
                        state = menuState.MAIN;
                    }
                    if(aboutRect.contains(mousePos.x, mousePos.y)){
                        Core.Options.sound = !Core.Options.sound;
                        AudioBank.playEffect(AudioBank.Select1);
                    }
                }
                break;
            case ABOUT:
                if(input.isMousePressed(0)){
                    if(quitRect.contains(mousePos.x, mousePos.y)){
                        AudioBank.playEffect(AudioBank.Select1);
                        state = menuState.MAIN;}
                }
                break;
        }
    }
}
