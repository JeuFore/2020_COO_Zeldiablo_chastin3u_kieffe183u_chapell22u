package code.block;

public class Trap extends AnimateBlock {

    private boolean stone;

    public Trap(String nom, int id, int nbAnimation, int life, boolean traversable, boolean stone) {
        super(nom, id, nbAnimation, life, traversable);
        this.stone = stone;
    }

    public boolean getStone() {
        return this.stone;
    }

}