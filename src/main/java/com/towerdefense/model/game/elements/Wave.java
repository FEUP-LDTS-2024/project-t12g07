package com.towerdefense.model.game.elements;

import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.enemies.Giant;
import com.towerdefense.model.game.elements.enemies.Goblin;
import com.towerdefense.model.game.elements.enemies.Knight;

import java.util.ArrayList;
import java.util.List;

public class Wave extends Element {
    private int wave = 0 ;
    private List<Enemy> enemyList;

    public int getWave(){
        return wave;
    }

    public Wave(int x, int y){
        super(x,y);
        this.enemyList = new ArrayList<>();
    }

    public List<Enemy> spawn(int wave){
        if (wave == 1) {
            for (int i = 0; i < 4; i++){
                Enemy enemy;
                enemy = new Goblin(- i * 12, 25);
                enemyList.add(enemy);
            }
        }

        else if (wave == 2) {
            for (int i = 0; i < 4; i++){
                Enemy enemy;
                enemy = new Knight(-i * 12, 25);
                enemyList.add(enemy);
            }
        }

        else if (wave == 3) {
            for (int i = 0; i < 4; i++){
                Enemy enemy;
                enemy = new Giant(-i * 12, 25);
                enemyList.add(enemy);
            }
        }

        else {
            for (int i = 0; i < 4; i++) {
                int enemyTypeIndex = 1 + (int) (Math.random() * 3);
                Enemy enemy = switch (enemyTypeIndex) {
                    case 1 -> new Goblin(-i * 12, 25);
                    case 2 -> new Knight(-i * 12, 25);
                    case 3 -> new Giant(-i * 12, 25);
                    default -> null;
                };
                enemyList.add(enemy);
            }
        }
        return enemyList;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void updateWave(){
        wave++;
    }
}
