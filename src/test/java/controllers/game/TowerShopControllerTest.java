package controllers.game;

import com.towerdefense.controllers.game.TowerShopController;
import com.towerdefense.model.game.elements.TowerShop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Warning;
import com.towerdefense.model.game.elements.towers.*;


import static org.junit.jupiter.api.Assertions.*;

class TowerShopControllerTest {
    private TowerShopController controller;
    private Board mockBoard;
    private Game mockGame;
    private GUI mockGUI;
    private TowerShop mockTowerShop;
    private WoodTower mockWoodTower;
    private StoneTower mockStoneTower;
    private MetalTower mockMetalTower;

    @BeforeEach
    void setUp() {

        mockBoard = Mockito.mock(Board.class);
        mockGame = Mockito.mock(Game.class);
        mockGUI = Mockito.mock(GUI.class);
        mockTowerShop = Mockito.mock(TowerShop.class);


        controller = new TowerShopController(mockBoard);


        Mockito.when(mockBoard.getTowerShop()).thenReturn(mockTowerShop);


        mockWoodTower = Mockito.mock(WoodTower.class);
        mockStoneTower = Mockito.mock(StoneTower.class);
        mockMetalTower = Mockito.mock(MetalTower.class);
    }

    @Test
    void testStep_withTowerSelect() throws Exception {

        Mockito.when(mockTowerShop.isSelected1()).thenReturn(true);


        controller.step(mockGame, GUI.ACTION.TOWER_SELECT, 1000);


        Mockito.verify(mockTowerShop, Mockito.times(1)).nextEntry();
    }

    @Test
    void testPlaceTower_withNotEnoughMoney() {

        Mockito.when(mockTowerShop.isSelected1()).thenReturn(true);
        Mockito.when(mockTowerShop.purchaseTower(Mockito.any(WoodTower.class))).thenReturn(false);


        controller.placeTower(mockWoodTower);


        Mockito.verify(mockBoard, Mockito.times(1)).setWarning(Mockito.any(Warning.class));
    }

    @Test
    void testPlaceTower_withTowerAlreadyThere() {

        Mockito.when(mockBoard.isTower(Mockito.any())).thenReturn(true);


        controller.placeTower(mockWoodTower);


        Mockito.verify(mockBoard, Mockito.times(1)).setWarning(Mockito.any(Warning.class));
    }

    @Test
    void testPlaceTower_outsideGrass() {

        Mockito.when(mockBoard.isGrass(Mockito.any())).thenReturn(false);


        controller.placeTower(mockWoodTower);


        Mockito.verify(mockBoard, Mockito.times(1)).setWarning(Mockito.any(Warning.class));
    }
}
