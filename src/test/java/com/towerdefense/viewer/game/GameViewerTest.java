package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.*;
import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.towers.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class GameViewerTest {
    private Board board;
    private GUI gui;
    private GameViewer gameViewer;

    @BeforeEach
    void setUp() {
        board = mock(Board.class);
        gui = mock(GUI.class);
        gameViewer = new GameViewer(board);
    }

    @Test
    void testDrawElements() {
        when(board.getGrass()).thenReturn(Arrays.asList(mock(Grass.class)));
        when(board.getPath()).thenReturn(Arrays.asList(mock(Path.class)));
        when(board.getSea()).thenReturn(Arrays.asList(mock(Sea.class)));
        when(board.getTowers()).thenReturn(Arrays.asList(mock(Tower.class)));
        when(board.getTowerShop()).thenReturn(mock(TowerShop.class));
        when(board.getCursor()).thenReturn(mock(Cursor.class));
        when(board.getEnemies()).thenReturn(Arrays.asList(mock(Enemy.class)));
        when(board.getWarning()).thenReturn(mock(Warning.class));
        when(board.getCastle()).thenReturn(mock(Castle.class));

        gameViewer.drawElements(gui);

        verify(board).getGrass();
        verify(board).getPath();
        verify(board).getSea();
        verify(board).getTowers();
        verify(board).getTowerShop();
        verify(board).getCursor();
        verify(board).getEnemies();
        verify(board).getWarning();
        verify(board).getCastle();
    }
}
