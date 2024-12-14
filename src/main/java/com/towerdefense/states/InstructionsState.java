package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.InstructionsController;
import com.towerdefense.model.menu.InstructionsModel;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.InstructionsViewer;

public class InstructionsState extends State<InstructionsModel> {
    public InstructionsState(InstructionsModel model) {
        super(model);
    }

    @Override
    protected Viewer<InstructionsModel> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<InstructionsModel> getController() {
        return new InstructionsController(getModel());
    }
}
