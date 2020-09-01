import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {

    private int[][] map;

    public Map(String link) {
        BufferedReader buff = this.load(link);
    }

    public BufferedReader load(String link) {
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(link));
        }
        catch (IOException ioe) {
            System.out.println("This map does not exist");
        }
        return buff;
    }

}