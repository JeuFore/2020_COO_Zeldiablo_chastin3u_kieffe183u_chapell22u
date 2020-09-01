import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

public class TestMap {

    private File getFile(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        return file;
    }

    @Test
    public void test_Map_bugged() {
        Map map = new Map(getFile("map/level_1_bug.txt"));
        assertEquals("Cela devrait être null", null, map.getMap());
    }

    @Test
    public void test_Map_not_found() {
        Map map = new Map("map/level_not_found.txt");
        assertEquals("Cela devrait être null", null, map.getMap());
    }

    @Test
    public void test_Map() {
	    File file = getFile("map/level_1.txt");
        Map map = new Map(file);
        ArrayList<Row> rows = map.getMap();
        for(Row row : rows) {
            for(int i = 0 ; i < 5 ; i++) {
                assertEquals("Cela devrait être 0", 0, row.getTile(i));
            }
        }
    }
}