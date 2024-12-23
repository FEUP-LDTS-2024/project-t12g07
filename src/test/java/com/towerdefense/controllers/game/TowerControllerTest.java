package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.controllers.game.TowerController;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.towers.Tower;
import com.towerdefense.model.game.elements.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TowerControllerTest {
    private static final long STEP_TIME = 200L; // Constante para tempo de step
    private Board board;
    private TowerController towerController;
    private List<Tower> towers;
    private List<Enemy> enemies;

    @BeforeEach
    void setUp() {
        // Mock do tabuleiro e listas de torres/inimigos
        board = mock(Board.class);
        towers = new ArrayList<>();
        enemies = new ArrayList<>();

        // Configuração dos mocks
        when(board.getTowers()).thenReturn(towers);
        when(board.getEnemies()).thenReturn(enemies);

        // Inicialização do controlador
        towerController = new TowerController(board);
    }

    @Test
    void shouldUpdateTowersWhenStepCalled() throws IOException {
        // Configuração: Adiciona uma torre mockada à lista
        Tower tower = mock(Tower.class);
        towers.add(tower);

        // Executa o método step
        towerController.step(mock(Game.class), GUI.ACTION.NONE, System.currentTimeMillis() + STEP_TIME);

        // Verifica se o método update foi chamado na torre, passando a lista de inimigos
        verify(tower, times(1)).update(enemies);
    }

    @Test
    void shouldNotFailWhenNoTowersPresent() throws IOException {
        // Executa o método step sem adicionar torres
        towerController.step(mock(Game.class), GUI.ACTION.NONE, System.currentTimeMillis() + STEP_TIME);

        // Garante que a lista de torres permanece vazia (nenhuma exceção ou comportamento inesperado)
        assertTrue(towers.isEmpty());
    }
}
