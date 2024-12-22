package org.example.viewer;

import com.towerdefense.gui.WindowGUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.menu.GameOver;
import com.towerdefense.viewer.menu.GameOverViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameOverViewerTest {
    @Test
    void testDrawElements() {
        GameOver gameover = new GameOver();
        GameOverViewer gameoverViewer = new GameOverViewer(gameover);
        WindowGUI window = Mockito.mock(WindowGUI.class);

        gameoverViewer.drawElements(window);

        verify(window, times(1)).drawText(Mockito.any(Position.class),
                Mockito.eq("Press ESC to go back to the menu"), Mockito.eq("#db1a00"));

        verify(window, times(5)).drawText(Mockito.any(Position.class),
                Mockito.anyString(), Mockito.eq("#db1a00"));
    }

}