package Enemies;

import Core.*;
import PathFinding.PathFinder;
import TileSystem.Tile;
import TileSystem.TileMap;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ollie on 27/04/14.
 */
public class EnemyManager {

    private TileMap map;
    private int maxEnemies;
    private float difficulty;
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public long lastUpdateTime = 0;

    public EnemyManager(int maxEnemies, float difficulty, TileMap map){
        this.difficulty = difficulty;
        this.maxEnemies = maxEnemies;
        this.map = map;
    }

    public void update(TurnManager turnManager, Player player){
        long timeSinceLastUpdate = System.nanoTime() - lastUpdateTime;
        if(turnManager.hasTurnsLeft() && timeSinceLastUpdate > 150000000){
            for(Enemy e : enemies){
                e.update(map, player);
            }

            if(enemies.size() < maxEnemies){
                double r = Math.random();
                if(r < 0.07f){
                    addNewEnemy(map, player, true);
                }
            }
            turnManager.useTurn();
            lastUpdateTime = System.currentTimeMillis();
        }
    }

    private void addNewEnemy(TileMap map, Player player, boolean addItem) {
        Random r = new Random(System.nanoTime());
        while(true){
            int x = r.nextInt(map.width);
            int y = r.nextInt(map.height);
            if(map.getTileType(x, y) == Tile.TileType.STONE_FLOOR){
                if(PathFinder.findPath(x, y, player.posX, player.posY, false).length() > 9){
                    if(x != player.posX && y != player.posY && !map.getTileEnemy(x, y)){
                        if(difficulty == 1)
                            enemies.add(new GreenSlime(x, y, difficulty, addItem));
                        else
                            enemies.add(new RedSlime(x, y, difficulty, addItem));
                        map.swapHasEnemy(x, y);
                        return;
                    }
                }
            }
        }
    }

    public void addAllEnemies(TileMap map, Player player){
        while(enemies.size() < maxEnemies){
            addNewEnemy(map, player, true);
        }
    }

    public void render(Graphics g, float xOffset, float yOffset, float scale){
        for(Enemy e : enemies){
            if(FogManager.fog[e.posX][e.posY] == 4)
                e.render(g, xOffset, yOffset, scale);
        }
    }

    public Enemy getEnemy(int x, int y){
        for(Enemy e : enemies){
            if (e.posX == x && e.posY == y)
                return e;
        }
        return null;
    }

    public void removeEnemy(Enemy e){
        e.dropItems();
        map.swapHasEnemy(e.posX, e.posY);
        enemies.remove(e);
    }

}
