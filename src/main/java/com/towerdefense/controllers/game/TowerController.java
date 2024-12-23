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
    private final Board board;
    long lastMovement;
    public TowerController(Board board) {
        super(board);
        this.board = board;
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 175) {
            for (Tower tower : board.getTowers()) {
                try {
                    tower.update(getModel().getEnemies());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.lastMovement = time;
        }
    }
}