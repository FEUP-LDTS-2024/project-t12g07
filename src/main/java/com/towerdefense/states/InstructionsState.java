package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.InstructionsController;
import com.towerdefense.model.menu.Instructions;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.InstructionsViewer;

public class InstructionsState extends State<Instructions> {
    public InstructionsState(Instructions model) {
        super(model);
    }

    @Override
    protected Viewer<Instructions> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<Instructions> getController() {
        return new InstructionsController(getModel());
    }
}
