public class Joueur {

    private final int POINT_DE_VIE = 10;

    private int positionX;
    private int positionY;
    private boolean collision;

    public Joueur(String nom, int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public void setPositionX(int x) {
        this.positionX = x;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public void setPositionY(int y) {
        this.positionY = y;
    }

    public int getVie(){
        return POINT_DE_VIE;
    }

}