package com.towerdefense.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
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
        KeyStroke keyStroke = screen.pollInput(); // Get the next key stroke
        if (keyStroke == null) return GUI.ACTION.NONE; // No input

        // Handle special keys
        KeyType keyType = keyStroke.getKeyType();
        if (keyType == KeyType.Escape) return GUI.ACTION.QUIT;
        if (keyType == KeyType.ArrowUp) return GUI.ACTION.UP;
        if (keyType == KeyType.ArrowRight) return GUI.ACTION.RIGHT;
        if (keyType == KeyType.ArrowDown) return GUI.ACTION.DOWN;
        if (keyType == KeyType.ArrowLeft) return GUI.ACTION.LEFT;
        if (keyType == KeyType.Enter) return GUI.ACTION.SELECT;

        // Handle printable characters
        Character character = keyStroke.getCharacter();
        if (character != null) {
            if (character == 'T' || character == 't') return GUI.ACTION.TOWER_SELECT;
        }

        return GUI.ACTION.NONE; // Default action for unsupported inputs
    }

    @Override
    public void drawTower(Position position, Tower tower) {
        drawCharacter(position.getX(), position.getY(), tower.getTowerArt(), "#FFD700");
    }

    @Override
    public void drawCastle(Position position, Castle castle) {
        drawCharacter(position.getX(), position.getY(), castle.getCastleArt(), "#FFD700");
    }

    @Override
    public void drawEnemy(Position position, Enemy enemy) {
        drawCharacter(position.getX(), position.getY(), enemy.getEnemyArt(), "#CC0000");
    }

    @Override
    public void drawPath(Position position, Path path) {
        drawCharacter(position.getX(), position.getY(), path.getPathArt(), "#CC0000");
    }

    @Override
    public void drawGrass(Position position, Grass grass) {
        drawCharacter(position.getX(), position.getY(), grass.getGrassArt(), "#CC0000");
    }

    @Override
    public void drawSea(Position position, Sea sea) {
        drawCharacter(position.getX(), position.getY(), sea.getSeaArt(), "#CC0000");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, String[] c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
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
