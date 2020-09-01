public class Joueur {

    private int positionX;
    private int positionY;

    public Joueur(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

    public void moove(int newX, int newY){
        this.positionX = newX;
        this.positionY = newY;
    }

    public int getPositionX(){
        return this.positionX;
    }

    public void setPositionX(int x){
        this.positionX = x;
    }

    public int getPositionY(){
        return this.positionY;
    }

    public void setPositionY(int y){
        this.positionY = y;
    }

}