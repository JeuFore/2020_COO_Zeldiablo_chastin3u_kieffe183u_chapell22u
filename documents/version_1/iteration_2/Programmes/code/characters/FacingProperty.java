package code.characters;

public class FacingProperty {

    private int view;
    private String spriteName;
    private int idXaxis;
    private int idYaxis;

    public FacingProperty(String n, int x, int y) {
        this.view = 7;
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

    public void setView(int v) {
        this.view = v + this.idYaxis;
    }
}