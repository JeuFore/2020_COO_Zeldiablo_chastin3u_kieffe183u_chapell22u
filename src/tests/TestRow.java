package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import code.block.Block;
import code.block.Empty;
import code.block.Wall;
import code.jeu.Row;

public class TestRow {

    private static ArrayList<Block> getStart() {
        ArrayList<Block> list = new ArrayList<Block>();
        list.add(new Empty());
        list.add(new Empty());
        list.add(new Wall());
        list.add(new Empty());
        list.add(new Wall());
        return list;
    }

    @Test
    public void test_getTile() {
        ArrayList<Block> list = getStart();
        Row row = new Row(list);
        assertEquals("Cela devrait être 0", 0, row.getTile(0).getId());
        assertEquals("Cela devrait être 0", 0, row.getTile(1).getId());
        assertEquals("Cela devrait être 1", 1, row.getTile(2).getId());
        assertEquals("Cela devrait être 0", 0, row.getTile(3).getId());
        assertEquals("Cela devrait être 1", 1, row.getTile(4).getId());
    }

    @Test
    public void test_getTile_Out_Of_Bounds() {
        ArrayList<Block> list = getStart();
        Row row = new Row(list);
        assertEquals("Cela devrait être null", null, row.getTile(-1));
        assertEquals("Cela devrait être null", null, row.getTile(5));
    }

    @Test
    public void test_addTile() {
        ArrayList<Block> list = getStart();
        Row row = new Row(list);
        row.addTile(0);
        row.addTile(1);
        assertEquals("Cela devrait être 0", 0, row.getTile(5).getId());
        assertEquals("Cela devrait être 1", 1, row.getTile(6).getId());
    }

    @Test
    public void test_removeTile() {
        ArrayList<Block> list = getStart();
        Row row = new Row(list);
        row.removeTile();
        row.removeTile();
        assertEquals("Cela devrait être null", null, row.getTile(4));
        assertEquals("Cela devrait être null", null, row.getTile(3));
    }
}