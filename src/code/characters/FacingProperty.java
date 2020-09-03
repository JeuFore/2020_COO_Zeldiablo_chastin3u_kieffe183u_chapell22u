package code.characters;

public class FacingProperty {

    private int view;
    private String spriteName;
    private int idXaxis;
    private int idYaxis;
    public final static int FACING_UP = 3;
    public final static int FACING_RIGHT = 2;
    public final static int FACING_LEFT = 1;
    public final static int FACING_DOWN = 0;

    public FacingProperty(String n, int x, int y) {
        this.view = FACING_DOWN;
        this.spriteName = n;
        this.idXaxis = x;
        this.idYaxis = y;
    }

    public int getId() {
        return this.idXaxis;
    }

    public int getView() {
        return this.view;
    }

    public String getSpriteName() {
        return this.spriteName;
    }

    public int getIdYaxis() {
        return this.idYaxis;
    }

    public void setView(int v) {
        this.view = v;
    }

    public String toString() {
        return this.spriteName + " en position " + this.idXaxis + ", " + this.idYaxis;
    }
}