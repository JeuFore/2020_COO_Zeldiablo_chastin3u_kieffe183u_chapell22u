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
    private int facing;

    /**
     * Propriétés permettant de retrouver le sprite pour l'affichage
     */
    private int[] facingPropertie;

    /**
     * Construit un Personnage
     * @param name nom
     * @param life points de vie
     * @param x position x
     * @param y position y
     * @param facingPropertie propriétés de l'affichage
     */
    public Character(String name, int life, int x, int y, int[] facingPropertie) {
        this.nom = name;
        this.vie = life;
        this.collision = false;
        this.position = new Position(x, y);
        this.facingPropertie = facingPropertie;
        this.facing = 3 + facingPropertie[0];
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
        if (this.vie + n <= 0) {
            this.vie = 0;
        } else {
            this.vie += n;
        }
    }

    /**
     * Getter de facing
     * @return facing
     */
    public int getFacing() {
        return this.facing;
    }

    /**
     * Setter de facing
     * @param f facing
     */
    public void setFacing(int f) {
        this.facing = f + this.facingPropertie[0];
    }

    /**
     * Retourne l'ID du facing
     * @return ID du facing
     */
    public int getfacingId() {
        return this.facingPropertie[1];
    }

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