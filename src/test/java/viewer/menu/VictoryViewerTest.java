package org.example.viewer;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.menu.Victory;
import com.towerdefense.viewer.menu.VictoryViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class VictoryViewerTest {
    private Victory victory;
    private VictoryViewer victoryViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        victory = Mockito.mock(Victory.class);
        victoryViewer = new VictoryViewer(victory);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDrawElements() {
        when(victory.getCastleSize()).thenReturn(3);
        when(victory.getCastle(anyInt())).thenReturn("Castle Line");
        when(victory.getEntry1()).thenReturn("Victory Entry 1");
        when(victory.getEntry2()).thenReturn("Victory Entry 2");
        when(victory.getTitleSize()).thenReturn(2);
        when(victory.getTitle(anyInt())).thenReturn("Victory Title");

        victoryViewer.drawElements(gui);

        verify(gui).drawText(argThat(position -> position.getX() == 72 && position.getY() == 21), eq("Castle Line"), eq("#3884ff"));
        verify(gui).drawText(argThat(position -> position.getX() == 72 && position.getY() == 22), eq("Castle Line"), eq("#3884ff"));
        verify(gui).drawText(argThat(position -> position.getX() == 72 && position.getY() == 23), eq("Castle Line"), eq("#3884ff"));

        verify(gui).drawText(argThat(position -> position.getX() == 35 && position.getY() == 16), eq("Victory Entry 1"), eq("#3884ff"));
        verify(gui).drawText(argThat(position -> position.getX() == 52 && position.getY() == 28), eq("Victory Entry 2"), eq("#3884ff"));

        verify(gui).drawText(argThat(position -> position.getX() == 45 && position.getY() == 10), eq("Victory Title"), eq("#3884ff"));
        verify(gui).drawText(argThat(position -> position.getX() == 45 && position.getY() == 11), eq("Victory Title"), eq("#3884ff"));
        
        verify(gui, times(7)).drawText(any(Position.class), anyString(), anyString());
    }
}
