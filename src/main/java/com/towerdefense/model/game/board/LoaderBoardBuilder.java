package com.towerdefense.model.game.board;

import com.towerdefense.model.game.elements.Grass;
import com.towerdefense.model.game.elements.Path;
import com.towerdefense.model.game.elements.Sea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderBoardBuilder extends BoardBuilder {
    private final int level;
    private final List<String> lines;

    public LoaderBoardBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderBoardBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }



    @Override
    protected List<Grass> createGrass() {
        List<Grass> grass = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'G') grass.add(new Grass(x, y));
        }

        return grass;
    }

    @Override
    protected List<Sea> createSea() {
        List<Sea> sea = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'S') sea.add(new Sea(x, y));
        }

        return sea;
    }

    @Override
    protected List<Path> createPath() {
        List<Path> path = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'P') path.add(new Path(x, y));
        }
        return path;
    }

}