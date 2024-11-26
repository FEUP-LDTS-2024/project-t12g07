package com.towerdefense.model.game.board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderBoardBuilder extends BoardBuilder {
    private final int level;

    public LoaderBoardBuilder(int level) throws IOException {
        this.level = level;
    }

}