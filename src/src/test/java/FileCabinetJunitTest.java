import org.example.FileCabinet;
import org.example.Folder;
import org.example.SpecificFolder;
import org.example.SpecificMultiFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class FileCabinetJunitTest {
    private FileCabinet cabinet;

    @BeforeEach
    void setUp() {
        List<Folder> folders = new ArrayList<>();
        folders.add(new SpecificFolder("Titanic", "SMALL"));
        folders.add(new SpecificFolder("Inception", "LARGE"));

        SpecificMultiFolder photoAlbum = new SpecificMultiFolder(new ArrayList<>());
        photoAlbum.getFolders().add(new SpecificFolder("Paris 2020", "MEDIUM"));
        photoAlbum.getFolders().add(new SpecificFolder("London 2019", "SMALL"));

        folders.addAll(photoAlbum.getFolders());

        cabinet = new FileCabinet(folders);
    }


    @Test
    void shouldFindFolderByNameAtTopLevel() {
        Optional<Folder> result = cabinet.findFolderByName("Titanic");
        assertTrue(result.isPresent());
        assertEquals("Titanic", result.get().getName());
    }

    @Test
    void shouldNotFindFolderByNameAtTopLevel() {
        Optional<Folder> result = cabinet.findFolderByName("should");
        assertFalse(result.isPresent());
    }


    @Test
    void shouldFindFolderByNameInMultiFolder() {
        Optional<Folder> result = cabinet.findFolderByName("Paris 2020");
        assertTrue(result.isPresent());
        assertEquals("Paris 2020", result.get().getName());
    }

    @Test
    void shouldFindFoldersBySizeCaseSingleMatch() {
        List<Folder> smallFolders = cabinet.findFoldersBySize("LARGE");
        assertEquals(1, smallFolders.size());
        assertEquals("Inception", smallFolders.getFirst().getName());
    }

    @Test
    void shouldFindFoldersBySizeCaseMultipleMatches() {
        List<Folder> smallFolders = cabinet.findFoldersBySize("SMALL");
        assertEquals(2, smallFolders.size());
        assertTrue(smallFolders.stream().anyMatch(f -> f.getName().equals("Titanic")));
        assertTrue(smallFolders.stream().anyMatch(f -> f.getName().equals("London 2019")));
    }
    @Test
    void shouldCountAllFoldersIncludingNested() {
        int count = cabinet.count();
        assertEquals(4, count);
    }
}
