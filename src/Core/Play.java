package Core;

import Enemies.EnemyManager;
import GUI.GUI;
import GUI.MessageList.GUI_InfoList;
import Items.Enchantment;
import Items.Item;
import Items.ItemManager;
import PathFinding.GridPos;
import PathFinding.Path;
import PathFinding.PathFinder;
import TileSystem.Tile;
import GUI.*;
import TileSystem.TileMap;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;

/**
 * Created by Ollie on 26/04/14.
 */
public class Play extends BasicGameState {

    private TileMap map;
    private float positionX, positionY, zoom;
    private Player player;
    private double moveLastTime = 0;
    private EnemyManager enemyManager;
    private TurnManager turnManager;
    private int difficulty = 1;

    public static boolean reloaded;

    @Override
    public int getID() {
        return 11;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        reloaded = true;
    }

    public void reset(){
        difficulty = 1;
        zoom = 2;
        map = DungeonGenerator.CreateDungeon(40, 40, DungeonGenerator.DungeonType.PRISON, 1);
        player = new Player();
        player.setPos(20, 17);
        moveLastTime = System.nanoTime();
        PathFinder.setMap(map);
        enemyManager = new EnemyManager(13, 1, map);
        enemyManager.addAllEnemies(map, player);
        turnManager = new TurnManager();
        ItemManager.reset(player);
        ItemManager.ScatterItems(difficulty, 5, map);
        FogManager.init(40, 40);
        player.movementPhase = false;
        positionX = -player.posX*32+384;
        positionY = -player.posY*32+288;
        reloaded = false;
    }

    private void nextLevel(){
        difficulty++;
        map = DungeonGenerator.CreateDungeon(40, 40, DungeonGenerator.DungeonType.PRISON, difficulty);
        player.setPos(20, 17);
        moveLastTime = System.nanoTime();
        PathFinder.setMap(map);
        enemyManager = new EnemyManager(13, difficulty, map);
        enemyManager.addAllEnemies(map, player);
        turnManager = new TurnManager();
        ItemManager.levelItems.clear();
        ItemManager.ScatterItems(difficulty, 5, map);
        FogManager.init(40, 40);
        player.currentPath = new Path();
        positionX = -player.posX*32+384;
        positionY = -player.posY*32+288;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        map.render(graphics, positionX, positionY, zoom);
        ItemManager.renderItems(graphics, positionX, positionY, zoom);
        player.render(graphics, positionX, positionY, zoom);
        enemyManager.render(graphics, positionX, positionY, zoom);
        FogManager.render(graphics, positionX, positionY, zoom);
        GUI.render(graphics, player, positionX, positionY, zoom, difficulty);
        GUI_InfoList.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();

        if(reloaded){
            reset();
            GUI.state = GUI.GUIState.IN_GAME;
            reloaded = false;
        }

        FogManager.update(player.posX, player.posY, 4);
        Enchantment.updateFilter(i);
        GUI.update(player, stateBasedGame, gameContainer, turnManager);
        GUI_InfoList.update();

        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            stateBasedGame.enterState(0);
            stateBasedGame.getState(0).init(gameContainer, stateBasedGame);
        }

        if(GUI.state != GUI.GUIState.DEAD){
            earlyPlayerUpdate();
            enemyManager.update(turnManager, player);
            updatePlayer(input, stateBasedGame, gameContainer);
        }
    }

    private void updatePlayer(Input input, StateBasedGame sbg, GameContainer gc) throws SlickException{
        if(player.stats.HP <= 0){
            player.stats.HP = 0;
            GUI.state = GUI.GUIState.DEAD;
        }

        if(player.exp >= player.targetExp){
            player.targetExp *= 2;
            player.levelUp();
            GUI.addComponent(new GUIStatPopup(player.posX, player.posY - 2, "Lvl UP!", Color.green), 1.5f);
        }

        if(GUI.state == GUI.GUIState.IN_GAME && !turnManager.hasTurnsLeft()){
            if(input.isMousePressed(0)){
                int x, y;
                x = (int)(player.lerpPosX + input.getMouseX()/32 - 11.5f);
                y = (int)(player.lerpPosY + input.getMouseY()/32 - 8.375f);
                if(x >= 0 && x < 40 && y >= 0 && y < 40){
                    boolean i = map.getTileSolid(x, y);
                    if(!i && input.getMouseY() < 542 && input.getMouseY() > 52 && FogManager.fog[x][y] != 2){
                        player.currentPath = PathFinder.findPath(player.posX, player.posY, x, y, false);
                        player.movementPhase = true;
                    }
                    if(Math.abs(x - player.posX) <= 1 && Math.abs(y - player.posY) <= 1){
                        player.movementPhase = ItemManager.useItem(ItemManager.playerWeapon, x, y, enemyManager, turnManager);
                    }
                }
            }
            if(input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP)){
                if(!map.getTileEnemy(player.posX, player.posY-1) && !map.getTileSolid(player.posX, player.posY-1) && !player.movementPhase){
                    player.currentPath = new Path();
                    player.lastPosY = player.posY;
                    player.posY--;
                    turnManager.addEnemyTurns(1);
                    moveLastTime = System.nanoTime();
                    player.movementPhase = true;
                }
            }
            if(input.isKeyPressed(Input.KEY_S) || input.isKeyPressed(Input.KEY_DOWN)){
                if(!map.getTileEnemy(player.posX, player.posY+1) && !map.getTileSolid(player.posX, player.posY+1) && !player.movementPhase){
                    player.currentPath = new Path();
                    player.lastPosY = player.posY;
                    player.posY++;
                    turnManager.addEnemyTurns(1);
                    moveLastTime = System.nanoTime();
                    player.movementPhase = true;
                }
            }
            if(input.isKeyPressed(Input.KEY_A) || input.isKeyPressed(Input.KEY_LEFT)){
                if(!map.getTileEnemy(player.posX-1, player.posY) && !map.getTileSolid(player.posX-1, player.posY) && !player.movementPhase){
                    player.currentPath = new Path();
                    player.lastPosX = player.posX;
                    player.posX--;
                    turnManager.addEnemyTurns(1);
                    moveLastTime = System.nanoTime();
                    player.movementPhase = true;
                }
            }
            if(input.isKeyPressed(Input.KEY_D) || input.isKeyPressed(Input.KEY_RIGHT)){
                if(!map.getTileEnemy(player.posX+1, player.posY) && !map.getTileSolid(player.posX+1, player.posY) && !player.movementPhase){
                    player.currentPath = new Path();
                    player.lastPosX = player.posX;
                    player.posX++;
                    turnManager.addEnemyTurns(1);
                    moveLastTime = System.nanoTime();
                    player.movementPhase = true;
                }
            }
            if(!player.movementPhase){
                player.lerpPosX = player.posX;
                player.lerpPosY = player.posY;
                positionX = -player.lerpPosX*32+384;
                positionY = -player.lerpPosY*32+288;
                Item i = ItemManager.getItem(player.posX, player.posY);
                if(i != null){
                    GUI.isOverItem = true;
                }else{
                    GUI.isOverItem = false;
                }

                if(input.isKeyPressed(Input.KEY_SPACE)){
                    if(player.stats.HP < player.stats.maxHP){
                        Random r = new Random(System.nanoTime());
                        if(r.nextFloat() < 0.04f){
                            player.addHealth(1);
                        }
                    }
                    turnManager.addEnemyTurns(1);
                    player.movementPhase = false;
                }
            }
            if(player.movementPhase){
                Item i = ItemManager.getItem(player.posX, player.posY);
                if(i != null){
                    GUI.isOverItem = true;
                }else{
                    GUI.isOverItem = false;
                }
                if(System.nanoTime() - moveLastTime >= 130000000){
                    GridPos n = player.currentPath.getNextNode();
                    if(n != null){
                        if(!map.getTileEnemy(n.x, n.y)){
                            player.currentPath.removeLastNode();
                            player.lastPosX = player.posX;
                            player.lastPosY = player.posY;
                            player.posX = n.x;
                            player.posY = n.y;
                            turnManager.addEnemyTurns(1);
                            moveLastTime = System.nanoTime();
                            if(player.stats.HP < player.stats.maxHP){
                                Random r = new Random(System.nanoTime());
                                if(r.nextFloat() < 0.04f){
                                    player.addHealth(1);
                                }
                            }
                        }else{
                            player.currentPath = new Path();
                            player.movementPhase = false;
                        }
                    }else{
                        player.lastPosX = player.posX;
                        player.lastPosY = player.posY;
                        player.movementPhase = false;
                        if(map.getTileType(player.posX, player.posY) == Tile.TileType.STAIRS_DOWN){
                            nextLevel();
                        }
                    }
                }
            }
        }
    }

    private void earlyPlayerUpdate(){
        if(player.movementPhase){
            double lerpFactor = (System.nanoTime() - moveLastTime) / 130000000;
            player.lerpPosX = lerp(player.lastPosX, player.posX, (float)lerpFactor);
            player.lerpPosY = lerp(player.lastPosY, player.posY, (float)lerpFactor);
            positionX = -player.lerpPosX*32+384;
            positionY = -player.lerpPosY*32+288;
        }
    }

    public float lerp(float a, float b, float t) {
        if (t < 0)
            return a;
        return a + t * (b - a);
    }
}
