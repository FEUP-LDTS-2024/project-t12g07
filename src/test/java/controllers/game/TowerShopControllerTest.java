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
        // Mocking dependencies
        mockBoard = Mockito.mock(Board.class);
        mockGame = Mockito.mock(Game.class);
        mockGUI = Mockito.mock(GUI.class);
        mockTowerShop = Mockito.mock(TowerShop.class);

        // Instanciando o controlador
        controller = new TowerShopController(mockBoard);

        // Mocking a TowerShop no modelo
        Mockito.when(mockBoard.getTowerShop()).thenReturn(mockTowerShop);

        // Mocking o comportamento do shop para retornar uma torre válida
        mockWoodTower = Mockito.mock(WoodTower.class);
        mockStoneTower = Mockito.mock(StoneTower.class);
        mockMetalTower = Mockito.mock(MetalTower.class);
    }

    @Test
    void testStep_withTowerSelect() throws Exception {
        // Simula a ação de selecionar a torre
        Mockito.when(mockTowerShop.isSelected1()).thenReturn(true);

        // Chamando o método step com a ação TOWER_SELECT
        controller.step(mockGame, GUI.ACTION.TOWER_SELECT, 1000);

        // Verificando se o método nextEntry foi chamado
        Mockito.verify(mockTowerShop, Mockito.times(1)).nextEntry();
    }

    @Test
    void testStep_withSelectAction_andEnoughMoney() throws Exception {
        // Simula a seleção da torre e a posição no tabuleiro
        Mockito.when(mockTowerShop.isSelected1()).thenReturn(true);
        Mockito.when(mockTowerShop.purchaseTower(Mockito.any(WoodTower.class))).thenReturn(true);

        // Simula uma ação de SELECT, onde deve tentar colocar a torre
        controller.step(mockGame, GUI.ACTION.SELECT, 1000);

        // Verifica se a torre foi adicionada à lista de torres
        Mockito.verify(mockBoard.getTowers(), Mockito.times(1)).add(Mockito.any(WoodTower.class));
    }

    @Test
    void testPlaceTower_withNotEnoughMoney() {
        // Simula a seleção da torre e uma falha ao comprar a torre (sem dinheiro suficiente)
        Mockito.when(mockTowerShop.isSelected1()).thenReturn(true);
        Mockito.when(mockTowerShop.purchaseTower(Mockito.any(WoodTower.class))).thenReturn(false);

        // Método que deve gerar um warning
        controller.placeTower(mockWoodTower);

        // Verifica se o warning foi criado para falta de dinheiro
        Mockito.verify(mockBoard, Mockito.times(1)).setWarning(Mockito.any(Warning.class));
    }

    @Test
    void testPlaceTower_withTowerAlreadyThere() {
        // Simula a seleção da torre e uma posição onde já há uma torre
        Mockito.when(mockBoard.isTower(Mockito.any())).thenReturn(true);

        // Método que deve gerar um warning
        controller.placeTower(mockWoodTower);

        // Verifica se o warning foi criado para já existir torre no local
        Mockito.verify(mockBoard, Mockito.times(1)).setWarning(Mockito.any(Warning.class));
    }

    @Test
    void testPlaceTower_outsideGrass() {
        // Simula a seleção da torre e uma posição fora da área permitida
        Mockito.when(mockBoard.isGrass(Mockito.any())).thenReturn(false);

        // Método que deve gerar um warning
        controller.placeTower(mockWoodTower);

        // Verifica se o warning foi criado para posição inválida (fora da grama)
        Mockito.verify(mockBoard, Mockito.times(1)).setWarning(Mockito.any(Warning.class));
    }
}
