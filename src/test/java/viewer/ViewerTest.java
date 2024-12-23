package com.towerdefense.viewer;

import com.towerdefense.gui.GUI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ViewerTest {
    @Test
    void testGetModel() {
        Object model = new Object();
        Viewer<Object> viewer = Mockito.mock(Viewer.class, Mockito.withSettings().useConstructor(model).defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertEquals(model, viewer.getModel(), "O método getModel deve retornar o modelo associado.");
    }

    @Test
    void testDrawCallsGuiMethods() throws Exception {
        GUI guiMock = Mockito.mock(GUI.class);
        Viewer<Object> viewer = Mockito.mock(Viewer.class, Mockito.withSettings().useConstructor(new Object()).defaultAnswer(Mockito.CALLS_REAL_METHODS));

        viewer.draw(guiMock);

        Mockito.verify(guiMock).clear();
        Mockito.verify(guiMock).refresh();
    }

    @Test
    void testDrawHandlesRuntimeException() {
        GUI guiMock = Mockito.mock(GUI.class);
        Viewer<Object> viewer = Mockito.mock(Viewer.class, Mockito.withSettings().useConstructor(new Object()).defaultAnswer(Mockito.CALLS_REAL_METHODS));

        doThrow(new RuntimeException("Test Exception")).when(guiMock).clear();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> viewer.draw(guiMock));
        assertEquals("Test Exception", exception.getMessage());
    }
}
