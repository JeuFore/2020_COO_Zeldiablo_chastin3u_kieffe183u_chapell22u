package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import code.characters.Monster;
import code.jeu.*;

public class TestMap {

    private File getFile(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        return file;
    }

    @Test
    public void test_Map_bugged() {
        Map map = new Map(getFile("tests/map/level_1_bug.txt"));
        assertEquals("Cela devrait être null", null, map.getMap());
    }

    @Test
    public void test_Map_not_found() {
        Map map = new Map("tests/map/level_not_found.txt");
        assertEquals("Cela devrait être null", null, map.getMap());
    }

    @Test
    public void test_Map() {
	    File file = getFile("tests/map/level_1.txt");
        Map map = new Map(file);
        ArrayList<Row> rows = map.getMap();
        for(Row row : rows) {
            for(int i = 0 ; i < 5 ; i++) {
                assertEquals("Cela devrait être 0", 0, row.getTile(i).getId());
            }
        }
    }

    @Test
    public void test_isInBounds_notfound_x() {
        Map map = new Map(getFile("tests/map/level_1.txt"));
        assertFalse(map.isInBounds(-1, 1));
        assertFalse(map.isInBounds(7, 1));
    }

    @Test
    public void test_isInBounds_notfound_y() {
        Map map = new Map(getFile("tests/map/level_1.txt"));
        assertFalse(map.isInBounds(1, -21));
        assertFalse(map.isInBounds(2, 9));
    }

    @Test
    public void test_isInBounds_found() {
        Map map = new Map(getFile("tests/map/level_1.txt"));
        assertTrue(map.isInBounds(1, 3));
        assertTrue(map.isInBounds(4, 0));
    }

    @Test
    public void test_getTile_notfound() {
        Map map = new Map(getFile("tests/map/level_1.txt"));
        assertEquals("Cela devrait être hors des bordures", null, map.getTile(0, 12));
    }

    @Test
    public void test_getTile_found() {
        Map map = new Map(getFile("tests/map/level_2.txt"));
        assertEquals("Cela devrait être valoir 0", 0, map.getTile(1, 1).getId());
        assertEquals("Cela devrait être valoir null", null, map.getTile(4, 1));
        assertEquals("Cela devrait être valoir 1", 1, map.getTile(3, 5).getId());
    }

    @Test
    public void test_verify() {
        Map map = new Map(getFile("tests/map/level_2.txt"));
        Monster robert = new Monster("Robert", 8, 1, 1);
        map.ajouterCharacter(robert);
        final boolean temp = map.verify();
        assertFalse(temp);
        assertEquals("The monster should still be there", 1, map.getCharacters().size());
    }

    @Test
    public void test_verify_in_wall() {
        Map map = new Map(getFile("tests/map/level_2.txt"));
        Monster robert = new Monster("Robert", 8, 2, 5);
        map.ajouterCharacter(robert);
        final boolean temp = map.verify();
        assertTrue(temp);
        assertEquals("The monster should have disappeared", 0, map.getCharacters().size());
    }
}