import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {

    private int[][] map;

    public Map(String link) {
        int[][] buff = this.load(link);
    }



    public int[][] load(String link) {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            BufferedReader buff = new BufferedReader(new FileReader(link));
            String line = buff.readLine();
            while (line != null) {
                lines.add(line);
                line = buff.readLine();
            }
            int[][] map = convertLinesToMap((String[])lines.toArray());
        }
        catch (IOException ioe) {
            System.out.println("This map does not exist");
        }
        return lines.toArray();
    }
    
    private static int[][] convertLinesToMap(String[] lines) {
        
    }

    public void update(BufferedReader)

}