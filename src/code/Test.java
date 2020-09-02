package code;

public class Test {
    public static void main(String[] args) {
        Map map = new Map("../documents/map/level_1.txt");
        for(Row row: map.getMap()) {
            for(int i = 0 ; i < 5 ; i++) {
                System.out.println(row.getTile(i));
            }
        }
    }
}