package code.block;

public abstract class Block {

    private String nom;

    private int degat;

    private int etat;

    private int id;

    private boolean actif;

    private boolean traversable;

    public Block(String nom, int degat, int id, boolean traversable) {
        this.nom = nom;
        this.degat = degat;
        this.etat = 0;
        this.id = id;
        this.actif = false;
        this.traversable = true;
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

    public int getDegat() {
        return this.degat;
    }

    public int getEtat() {
        return this.etat;
    }

    public String getNom() {
        return this.nom;
    }

    public boolean getActif() {
        return this.actif;
    }

    public void activer() {
        this.actif = true;
        this.etat = 4;
    }

    public boolean dejaActiver() {
        return !this.actif;
    }

    public void changerEtat() {
        this.etat--;
    }

    public String toString() {
        return "Le block " + this.nom + " fait " + this.degat + " dégats et a pour id " + this.id;
    }

}
