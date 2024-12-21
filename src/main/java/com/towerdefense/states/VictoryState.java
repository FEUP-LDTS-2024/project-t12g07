package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.VictoryController;
import com.towerdefense.model.menu.Victory;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.VictoryViewer;

public class VictoryState extends State<Victory> {
    public VictoryState(Victory model) {
        super(model);
    }

    @Override
    protected Viewer<Victory> getViewer() {
        return new VictoryViewer(getModel());
    }

    @Override
    protected Controller<Victory> getController() {
        return new VictoryController(getModel());
    }
}