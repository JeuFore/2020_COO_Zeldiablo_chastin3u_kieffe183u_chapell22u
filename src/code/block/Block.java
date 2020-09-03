package code.block;

public abstract class Block {

    private String nom;

    private boolean visible;

    private int id;

    private boolean traversable;

    private int yAxis;

    public Block(String nom, int yAxis, int id, boolean traversable) {
        this.nom = nom;
        this.id = id;
        this.traversable = traversable;
        this.visible = true;
        this.yAxis = yAxis;
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

    public void setVisible(boolean actif) {
        this.visible = actif;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public boolean getVisible(){
        return this.visible;
    }

    public String getNom() {
        return this.nom;
    }

    public int getyAxis() {
        return this.yAxis;
    }

    public String toString() {
        return "Le block " + this.nom + " fait dégats et a pour id " + this.id;
    }

}