package code.block;

public abstract class Block {

    private String nom;


    private int id;

    private boolean traversable;

    public Block(String nom, int id, boolean traversable) {
        this.nom = nom;
        this.id = id;
        this.traversable = traversable;
    }

    public boolean isTraversable() {
        return this.traversable;
    }

    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String toString() {
        return "Le block " + this.nom + " fait dégats et a pour id " + this.id;
    }

}