package com.towerdefense.gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WindowGUITest {
    private WindowGUI windowGUI;
    private Screen screenMock;

    @BeforeEach
    void setUp() throws Exception {
        screenMock = Mockito.mock(Screen.class);
        windowGUI = new WindowGUI(80,24);
        java.lang.reflect.Field screenField = WindowGUI.class.getDeclaredField("screen");
        screenField.setAccessible(true);
        screenField.set(windowGUI, screenMock);
    }

    @Test
    void testGetNextAction() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        when(screenMock.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = windowGUI.getNextAction();

        assertEquals(GUI.ACTION.UP, action);
    }

    @Test
    void testGetNextActionForArrowDown() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        when(screenMock.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = windowGUI.getNextAction();

        assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    void testGetNextActionForCharacterT() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('T');
        when(screenMock.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = windowGUI.getNextAction();

        assertEquals(GUI.ACTION.TOWER_SELECT, action);
    }

    @Test
    void testGetNextActionNoInput() throws IOException {
        when(screenMock.pollInput()).thenReturn(null);

        GUI.ACTION action = windowGUI.getNextAction();

        assertEquals(GUI.ACTION.NONE, action);
    }

    @Test
    void testClear() throws IOException {
        windowGUI.clear();

        verify(screenMock, times(1)).clear();
    }

    @Test
    void testRefresh() throws IOException {
        windowGUI.refresh();

        verify(screenMock, times(1)).refresh();
    }

    @Test
    void testRefreshThrowsIOException() throws IOException {
        doThrow(new IOException("Test Exception")).when(screenMock).refresh();

        try {
            windowGUI.refresh();
        } catch (IOException e) {
            assertEquals("Test Exception", e.getMessage());
        }

        verify(screenMock, times(1)).refresh();
    }

    @Test
    void testClose() throws IOException {
        windowGUI.close();

        verify(screenMock, times(1)).close();
    }

}
