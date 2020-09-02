package code.characters;

public class Position {

    private int x, y;

    public Position(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public Position() {
        this.setX(0);
        this.setY(0);
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void changerX(int x) {
        this.x += x;
    }

    public void changerY(int y) {
        this.y += y;
    }

    
    
}