package code.characters;

/**
 * Classe abstraite représentant un personnage
 */
public abstract class Character {

    /**
     * Nom du personnage
     */
    private String nom;

    /**
     * Points de vie du personnage
     */
    private int vie;

    /**
     * Est à true si le personnage ne peut pas bouger
     */
    private boolean collision;

    /**
     * Contient les coordonnées du personnage
     */
    private Position position;

    /**
     * Orientation du personnage à l'instant T
     */
    private FacingProperty facingProperty;

    /**
     * Construit un Personnage
     * @param name nom
     * @param life points de vie
     * @param x position x
     * @param y position y
     * @param facingProperty propriétés de l'affichage
     */
    public Character(String name, int life, int x, int y, FacingProperty facingProperty) {
        this.nom = name;
        this.vie = life;
        this.collision = false;
        this.position = new Position(x, y);
        this.facingProperty = facingProperty;
    }

    /**
     * Méthode qui déplace un personnage
     * @param x déplacement en x
     * @param y déplacement en y
     */
    public void move(int x, int y) {
        if (!collision) {
            this.position.changerX(x);
            this.position.changerY(y);
        }
    }

    /**
     * Getter de position
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setter de position
     * @param position position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Getter de nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de collision
     * @return collision
     */
    public boolean isCollision() {
        return collision;
    }

    /**
     * Setter de collision
     * @param collision collision
     */
    public void bloquer(boolean collision) {
        this.collision = collision;
    }

    /**
     * Getter de points de vie
     * @return points de vie
     */
    public int getVie() {
        return vie;
    }

    /**
     * Setter de points de vie
     * @param vie points de vie
     */
    public void setVie(int vie) {
        this.vie = vie;
    }

    /**
     * Setter de nom
     * @param nom nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode qui ajoute ou retranche des points de vie au personnage
     * @param n nombre de points de vie
     */
    public void changerVie(int n) {
        this.vie = Math.max(this.vie + n, 0);
    }

    /**
     * Getter de facingProperty
     * @return facingProperty
     */
    public FacingProperty getFacingProperty() {
        return this.facingProperty;
    }

    /**
     * Méthode qui permet de changer la rotation du joueur
     * @param v position
     */
    public void setFacingView(int v) {
        this.facingProperty.setView(v);
    }
    
    /**
     * Methode qui permet au character d'attaquer
     * 
     */
    
    public abstract void attaquer();

    /**
     * Méthode toString
     * @return string
     */
    @Override
    public String toString() {
        StringBuffer res = new StringBuffer("Je suis " + this.nom + ", un personnage ");
        if (this instanceof NonPlayableCharacter) {
            res.append("non jouable ");
        } else {
            res.append("jouable ");
        }
        res.append("(" + this.vie + ") ");
        res.append("de classe \"" + this.getClass().getSimpleName() + "\"");
        return res.toString();
    }

}