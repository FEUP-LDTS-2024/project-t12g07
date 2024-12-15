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
    private Position position;
    public TowerController(Board board) {
        super(board);
        this.board = board;
        this.towerList = new ArrayList<>();
        this.selected = false;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        for (Tower tower : board.getTowers()) {
            try {
                tower.update();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        MetalTower metalTower;
        StoneTower stoneTower;
        WoodTower woodTower;
        coins = getModel().getCoins();
    }

    public List<Tower> getTowerList() {
        return towerList;
    }
}
