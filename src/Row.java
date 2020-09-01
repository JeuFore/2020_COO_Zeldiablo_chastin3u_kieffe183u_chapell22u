import java.util.ArrayList;

public class Row {

    private ArrayList<Integer> tiles;

    public Row(ArrayList<Integer> integers) {
        this.tiles = new ArrayList<Integer>();
        this.tiles = integers;
    }

    public Row() {
        this.tiles = new ArrayList<Integer>();
    }

    public int getTile(int coord) {
        try {
            return this.tiles.get(coord);
        } catch (IndexOutOfBoundsException oob) {
            return -1;
        }
        
    }

    public void addTile(int tile) {
        this.tiles.add(tile);
    }

    public void removeTile(int tile) {
        this.tiles.remove(tile);
    }
    
}