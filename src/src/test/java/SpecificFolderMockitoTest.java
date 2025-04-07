import org.example.Folder;
import org.example.SpecificFolder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecificFolderMockitoTest {

    @Test
    void testMockedFolderBehavior() {
        Folder folder = mock(Folder.class);
        when(folder.getName()).thenReturn("Mock Folder");
        when(folder.getSize()).thenReturn("SMALL");

        assertEquals("Mock Folder", folder.getName());
        assertEquals("SMALL", folder.getSize());

        verify(folder).getName();
        verify(folder).getSize();
    }

    @Test
    void testInteractionWithRealInstanceViaInterface() {
        Folder folder = new SpecificFolder("Real One", "MEDIUM");

        assertEquals("Real One", folder.getName());
        assertEquals("MEDIUM", folder.getSize());
    }
}
