import org.example.FileCabinet;
import org.example.Folder;
import org.example.MultiFolder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FileCabinetMockitoTest {

    @Test
    void shouldFindFolderByNameWithMockedFolder() {
        Folder folder = mock(Folder.class);
        when(folder.getName()).thenReturn("Titanic");

        FileCabinet cabinet = new FileCabinet(List.of(folder));

        Optional<Folder> result = cabinet.findFolderByName("Titanic");

        assertTrue(result.isPresent());
        assertEquals("Titanic", result.get().getName());

        verify(folder, atLeastOnce()).getName();
    }
    @Test
    void shouldCountWithNestedMockedMultiFolder() {
        Folder f1 = mock(Folder.class);
        Folder f2 = mock(Folder.class);

        MultiFolder multiFolder = mock(MultiFolder.class, withSettings().extraInterfaces(Folder.class));
        when(multiFolder.getFolders()).thenReturn(List.of(f1, f2));

        FileCabinet cabinet = new FileCabinet(List.of((Folder) multiFolder));

        int count = cabinet.count();

        assertEquals(3, count);
        verify(multiFolder).getFolders();
    }
}
