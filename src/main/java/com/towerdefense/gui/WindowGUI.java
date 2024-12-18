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
import com.towerdefense.model.game.elements.*;
import com.towerdefense.model.game.elements.Cursor;
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

    private AWTTerminalFontConfiguration loadSquareFont() throws FontFormatException, IOException {
        // Use system-installed Consolas font
        Font font = new Font("Consolas", Font.PLAIN, 19);

        // Ensure the font is registered in the graphics environment (not always necessary for built-in fonts)
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        // Configure the terminal to use the Consolas font
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(font);
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
        drawCharacter(position.getX(), position.getY(), tower.getTowerArt(), tower.getColor(), "#a5d179");
    }

    @Override
    public void drawCastle(Position position, Castle castle) {
        drawCharacter(position.getX(), position.getY(), castle.getCastleArt(), "#474747", "#a5d179");
    }

    @Override
    public void drawTowerShop(Position position, TowerShop towerShop) {
        drawCharacter(position.getX(), position.getY(), towerShop.getSideBarArt(), "#FFFFFF", "BLACK");
        drawCharacter(position.getX() + 4, position.getY() + 8 , towerShop.getTowerShopArt1(), "#9e5c2c", "BLACK");
        drawCharacter(position.getX() + 4, position.getY() + 15, towerShop.getTowerShopArt2(), "#b5ada3", "BLACK");
        drawCharacter(position.getX() + 4, position.getY() + 22 , towerShop.getTowerShopArt3(), "#5f767a", "BLACK");
    }

    @Override
    public void drawEnemy(Position position, Enemy enemy) {
        drawCharacter(position.getX(), position.getY(), enemy.getEnemyArt(), enemy.getColor(), "#a6a6a6");
    }

    @Override
    public void drawPath(Position position, Path path) {
        drawCharacter(position.getX(), position.getY(), path.getPathArt(), "#7f807e","#a6a6a6");
    }

    @Override
    public void drawGrass(Position position, Grass grass) {
        drawCharacter(position.getX(), position.getY(), grass.getGrassArt(), "#158f22", "#a5d179");
    }

    @Override
    public void drawSea(Position position, Sea sea) {
        drawCharacter(position.getX(), position.getY(), sea.getSeaArt(), "#3884ff", "#79a1d1");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, String[] c, String color, String backgroundColor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.setBackgroundColor(TextColor.Factory.fromString(backgroundColor)); // Set background color
        for (int i = 0; i < c.length; i++) {
            tg.putString(x, y + i + 1, c[i]); // Print each string on a new line
        }
    }

    public void drawCursor(Position position, Cursor cursor) {
        drawCharacter(position.getX(), position.getY(), cursor.getCursorArt(), "#ff0000", "WHITE");
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
