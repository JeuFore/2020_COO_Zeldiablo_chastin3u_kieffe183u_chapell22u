package code.block;

public class Trap extends AnimateBlock {

    private int degat;

    public Trap(String nom, int id, int degat, int nbAnimation, boolean traversable) {
        super(nom, id, nbAnimation, traversable);
        this.degat = degat;
    }

    public int getDegat() {
        return this.degat;
    }

}