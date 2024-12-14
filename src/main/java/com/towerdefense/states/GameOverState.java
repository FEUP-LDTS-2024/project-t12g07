package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.game.GameOverController;
import com.towerdefense.model.game.GameOverModel;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.game.GameOverViewer;

public class GameOverState extends State<GameOverModel> {
    public GameOverState(GameOverModel model) {
        super(model);
    }

    @Override
    protected Viewer<GameOverModel> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOverModel> getController() {
        return new GameOverController(getModel());
    }
}
