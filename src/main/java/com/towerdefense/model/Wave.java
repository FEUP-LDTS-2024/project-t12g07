package com.towerdefense.model;

import com.towerdefense.model.game.elements.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    private List<Enemy> enemyList;

    private boolean waveCompleted;

    Level level ;
    public Wave(){
        this.enemyList= new ArrayList<>();
        this.waveCompleted=false;
    }

    public List<Enemy> spawn(int level){
        return enemyList;
    }

    public boolean isCompleted(){
        return waveCompleted;
    }
    public List<Enemy> getEnemyList() {
        return enemyList;
    }
}
