import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {

    private ArrayList<Row> map;

    public Map(String link) {
        this.map = load(link);
    }

    public ArrayList<Row> getMap() {
        return this.map;
    }

    public boolean isInBounds(int x, int y) {
        try {
            Row row = this.map.get(y);
            int tile = row.getTile(x);
            if (tile == -1) throw new IndexOutOfBoundsException();
            return true;
        }
        catch (IndexOutOfBoundsException oob) {
            return false;
        }
    }

    public int getTile(int x, int y) {
        if (isInBounds(x, y)) {
            Row row = this.map.get(y);
            return row.getTile(x);
        }
        else {
            return -1;
        }
    }

    public static ArrayList<Row> load(String link) {
        ArrayList<Row> map = null;
        try {
            ArrayList<String> lines = new ArrayList<String>();
            BufferedReader buff = new BufferedReader(new FileReader(link));
            String line = buff.readLine();
            while (line != null) {
                lines.add(line);
                line = buff.readLine();
            }
            buff.close();
            map = convertLinesToMap((String[])lines.toArray());
        }
        catch (IOException ioe) {
            System.out.println("This map does not exist");
        }
        catch (NumberFormatException nfe) {
            System.out.println("There is a problem in the level structure");
        }
        return map;
    }
    
    private static ArrayList<Row> convertLinesToMap(String[] lines) throws NumberFormatException {
        ArrayList<Row> rows = new ArrayList<Row>();
        for(String line : lines) {
            String[] chars = line.split(",");
            Row row = new Row();
            for(String character : chars) {
                row.addTile(Integer.parseInt(character));
            }
            rows.add(row);
        }
        return rows;
    }

}