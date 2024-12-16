package com.towerdefense.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.Castle;
import com.towerdefense.model.game.elements.Grass;
import com.towerdefense.model.game.elements.Path;
import com.towerdefense.model.game.elements.Sea;
import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.towers.Tower;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class WindowGUI implements GUI {

    private final Screen screen;

    public WindowGUI(Screen screen) {
        this.screen = screen;
    }

    public WindowGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }



    public GUI.ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.QUIT;
        if (keyStroke.getCharacter() == 'T' || keyStroke.getCharacter() == 't') return GUI.ACTION.TOWER_SELECT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawTower(Position position, Tower tower) {
        drawTower(position.getX(), position.getY(), tower.getTowerArt(), "RED");

    }

    @Override
    public void drawCastle(Position position, Castle castle) {

    }

    @Override
    public void drawEnemy(Position position, Enemy enemy) {

    }

    @Override
    public void drawPath(Position position, Path path) {

    }

    @Override
    public void drawGrass(Position position, Grass grass) {

    }

    @Override
    public void drawSea(Position position, Sea sea) {

    }

    @Override
    public void drawText(Position position, String text, String color) {
    }


    public void clear() {
        screen.clear();
    }


    public void refresh() throws IOException {
        screen.refresh();
    }


    public void close() throws IOException {
        screen.close();
    }

}
