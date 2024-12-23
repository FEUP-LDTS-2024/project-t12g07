package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Warning;
import com.towerdefense.model.game.elements.towers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TowerShopControllerTest {
    private TowerShopController controller;
    private Board boardMock;

    @BeforeEach
    void setUp() {
        boardMock = mock(Board.class);
        controller = new TowerShopController(boardMock);
    }

    @Test
    void testPlaceTowerOnNonGrass() {
        Tower woodTower = new WoodTower(5, 5);

        when(boardMock.isGrass(woodTower.getPosition())).thenReturn(false);

        controller.placeTower(woodTower);

        verify(boardMock, never()).getTowerShop();
        verify(boardMock, never()).getTowers();
        verify(boardMock).setWarning(Mockito.any(Warning.class));
    }

    @Test
    void testPlaceTowerOnOccupiedPosition() {
        Tower woodTower = new WoodTower(5, 5);

        when(boardMock.isGrass(woodTower.getPosition())).thenReturn(true);
        when(boardMock.isTower(woodTower.getPosition())).thenReturn(true);

        controller.placeTower(woodTower);

        verify(boardMock, never()).getTowerShop();
        verify(boardMock, never()).getTowers();
        verify(boardMock).setWarning(Mockito.any(Warning.class));
    }
}
