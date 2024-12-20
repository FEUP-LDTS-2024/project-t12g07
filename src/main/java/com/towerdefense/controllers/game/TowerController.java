package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.towers.MetalTower;
import com.towerdefense.model.game.elements.towers.StoneTower;
import com.towerdefense.model.game.elements.towers.Tower;
import com.towerdefense.model.game.elements.towers.WoodTower;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TowerController extends GameController {
    int coins;
    private final List<Tower> towerList;
    private final Board board;
    private boolean selected;
    long lastMovement;
    public TowerController(Board board) {
        super(board);
        this.board = board;
        this.towerList = new ArrayList<>();
        this.selected = false;
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        for (Tower tower : board.getTowers()) {

            if (time - lastMovement > 100) {
                ;
                try {
                    tower.update(getModel().getEnemies());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.lastMovement = time;
        }
    }

    public List<Tower> getTowerList() {
        return towerList;
    }
}