import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestRow {

    private static ArrayList<Integer> getStart() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        return list;
    }

    @Test
    public void test_getTile() {
        ArrayList<Integer> list = getStart();
        Row row = new Row(list);
        assertEquals("Cela devrait être 0", 0, row.getTile(0));
        assertEquals("Cela devrait être 0", 0, row.getTile(1));
        assertEquals("Cela devrait être 1", 1, row.getTile(2));
        assertEquals("Cela devrait être 0", 0, row.getTile(3));
        assertEquals("Cela devrait être 1", 1, row.getTile(4));
    }

    @Test
    public void test_getTile_Out_Of_Bounds() {
        ArrayList<Integer> list = getStart();
        Row row = new Row(list);
        assertEquals("Cela devrait être -1", -1, row.getTile(-1));
        assertEquals("Cela devrait être -1", -1, row.getTile(5));
    }

    @Test
    public void test_addTile() {
        ArrayList<Integer> list = getStart();
        Row row = new Row(list);
        row.addTile(0);
        row.addTile(1);
        assertEquals("Cela devrait être 0", 0, row.getTile(5));
        assertEquals("Cela devrait être 1", 1, row.getTile(6));
    }

    @Test
    public void test_removeTile() {
        ArrayList<Integer> list = getStart();
        Row row = new Row(list);
        row.removeTile();
        row.removeTile();
        assertEquals("Cela devrait être -1", -1, row.getTile(4));
        assertEquals("Cela devrait être -1", -1, row.getTile(3));
    }
}