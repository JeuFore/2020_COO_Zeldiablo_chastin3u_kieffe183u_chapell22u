package code.block;

import code.block.type.Border;

public abstract class Block {

    // Nom du block correspond au nom du sprite
    private String nom;

    // Permet de savoir si le block est visible ou non
    private boolean visible;

    // Id du block correspond au id de la map
    private int id;

    // Attribut qui permet de savoir si il est traversable
    private boolean traversable;

    // Permet de savoir l'axe Y du sprite utilise
    private int yAxis;

    // Objet permettant de delimiter les bordures de la map
    public static final Block border = new Border();

    /**
     * 
     * @param nom Nom du block correspond au nom du sprite
     * @param yAxis Permet de savoir l'axe Y du sprite utilise
     * @param id Id du block correspond au id de la map
     * @param traversable Attribut qui permet de savoir si il est traversable
     */
    public Block(String nom, int yAxis, int id, boolean traversable) {
        this.nom = nom;
        this.id = id;
        this.traversable = traversable;
        this.visible = true;
        this.yAxis = yAxis;
    }

    /**
     * Methode permettant de savoir si un block est traversable ou non
     * 
     * @return attribut traversable
     */
    public boolean isTraversable() {
        return this.traversable;
    }

    /**
     * Methode permettant de definir la traversable
     * 
     * @param traversable true pour traverser et false au contraire
     */
    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    /**
     * Getter de l'id
     * 
     * @return id du block
     */
    public int getId() {
        return this.id;
    }

    /**
     * Methode permettant de definir la visibilite du block
     * 
     * @param actif boolean
     */
    public void setVisible(boolean actif) {
        this.visible = actif;
    }

    /**
     * Setter de yAxis
     * 
     * @param yAxis axe y du sprite utilise
     */
    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    /**
     * Getter de visible
     * 
     * @return visible ou non
     */
    public boolean getVisible(){
        return this.visible;
    }

    /**
     * Getter de nom
     * 
     * @return nom du block
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Getter de yAxis
     * 
     * @return axe y du sprite utilise
     */
    public int getyAxis() {
        return this.yAxis;
    }

    /**
     * Methode toString qui affiche informations du block
     * 
     * @return nom, degat et id 
     */
    public String toString() {
        return "Le block " + this.nom + " fait dégats et a pour id " + this.id;
    }

}