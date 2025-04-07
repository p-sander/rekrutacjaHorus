import org.example.SpecificFolder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecificFolderJunitTest {

    @Test
    void testConstructorAndGetters() {
        SpecificFolder folder = new SpecificFolder("My Documents", "LARGE");

        assertEquals("My Documents", folder.getName());
        assertEquals("LARGE", folder.getSize());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        SpecificFolder folder = new SpecificFolder();
        assertNotNull(folder);
    }

    @Test
    void testEqualsAndHashCode() {
        SpecificFolder folder1 = new SpecificFolder("Photos", "MEDIUM");
        SpecificFolder folder2 = new SpecificFolder("Photos", "MEDIUM");

        assertEquals(folder1.getName(), folder2.getName());
        assertEquals(folder1.getSize(), folder2.getSize());
    }
}
