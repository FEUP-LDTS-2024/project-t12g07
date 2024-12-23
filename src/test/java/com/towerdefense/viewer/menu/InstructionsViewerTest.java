package com.towerdefense.viewer.menu;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.menu.Instructions;
import com.towerdefense.viewer.menu.InstructionsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class InstructionsViewerTest {
    private Instructions instructions;
    private InstructionsViewer instructionsViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        instructions = Mockito.mock(Instructions.class);
        instructionsViewer = new InstructionsViewer(instructions);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDrawElements() {
        when(instructions.getTitleSize()).thenReturn(2);
        when(instructions.getTitle(anyInt())).thenReturn("Title");
        when(instructions.getNumberEntries()).thenReturn(3);
        when(instructions.getEntry(anyInt())).thenReturn("Entry");
        when(instructions.getControlTitle()).thenReturn("Controls");
        when(instructions.getControlEntriesSize()).thenReturn(2);
        when(instructions.getControlEntries(anyInt())).thenReturn("Control Entry");
        when(instructions.getBack()).thenReturn("Back");

        instructionsViewer.drawElements(gui);

        verify(gui, times(2)).drawText(any(Position.class), eq("Title"), eq("#fc9023"));
        verify(gui, times(3)).drawText(any(Position.class), eq("Entry"), eq("#fcc623"));
        verify(gui, times(1)).drawText(any(Position.class), eq("Controls"), eq("#fc9023"));
        verify(gui, times(2)).drawText(any(Position.class), eq("Control Entry"), eq("#fcc623"));
        verify(gui, times(1)).drawText(any(Position.class), eq("Back"), eq("#fc9023"));

        verify(gui, times(9)).drawText(any(Position.class), anyString(), anyString());
    }
}
