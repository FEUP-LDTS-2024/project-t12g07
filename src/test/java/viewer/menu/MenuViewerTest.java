package com.towerdefense.viewer.menu;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MenuViewerTest {

    private MenuViewer menuViewer;
    private Menu menu;
    private GUI gui;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(Menu.class);
        menuViewer = new MenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDrawElements() {
        when(menu.getCastleSize()).thenReturn(3);
        when(menu.getCastle(anyInt())).thenReturn("Castle");
        when(menu.getNumberEntries()).thenReturn(2);
        when(menu.getEntry(0)).thenReturn("Entry 1");
        when(menu.getEntry(1)).thenReturn("Entry 2");
        when(menu.isSelected(0)).thenReturn(true);
        when(menu.isSelected(1)).thenReturn(false);

        menuViewer.drawElements(gui);

        verify(gui).drawText(argThat(positionMatches(new Position(25, 6))),
                eq("   ___ ___ __  __ ___ _____ ___  _  _ ___    ___ _   _  _   ___ ___ ___   _   _  _ ___ "),
                eq("#07a609"));
        verify(gui).drawText(argThat(positionMatches(new Position(25, 7))),
                eq("  / __| __|  \\/  / __|_   _/ _ \\| \\| | __|  / __| | | |/_\\ | _ \\   \\_ _| /_\\ | \\| / __|"),
                eq("#07a609"));
        verify(gui).drawText(argThat(positionMatches(new Position(25, 8))),
                eq(" | (_ | _|| |\\/| \\__ \\ | || (_) | .` | _|  | (_ | |_| / _ \\|   / |) | | / _ \\| .` \\__ \\"),
                eq("#07a609"));
        verify(gui).drawText(argThat(positionMatches(new Position(25, 9))),
                eq("  \\___|___|_|  |_|___/ |_| \\___/|_|\\_|___|  \\___|\\___/_/ \\_\\_|_\\___/___/_/ \\_\\_|\\_|___/"),
                eq("#07a609"));

        verify(gui, times(3)).drawText(any(Position.class), eq("Castle"), eq("#07a609"));

        verify(gui).drawText(argThat(positionMatches(new Position(60, 15))), eq("Entry 1"), eq("#07a609"));
        verify(gui).drawText(argThat(positionMatches(new Position(60, 16))), eq("Entry 2"), eq("#FFFFFF"));

        verify(gui, times(9)).drawText(any(Position.class), anyString(), anyString());
    }

    private ArgumentMatcher<Position> positionMatches(Position expected) {
        return actual -> actual.getX() == expected.getX() && actual.getY() == expected.getY();
    }
}
