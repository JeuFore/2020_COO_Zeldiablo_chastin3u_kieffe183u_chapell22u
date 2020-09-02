package code;

public class Joueur extends CClavier {

    private final int POINT_DE_VIE = 10;

    private String nom;
    private int vie;
    private int mana;
    private int xp;
    private boolean collision;

    private int facing;

    private int positionX;
    private int positionY;

    /**
     * Constructeur de joueur qui initialise le nom, les pv, mana, xp et coordonnées
     * du joueur
     * 
     * @param nom Nom du joueur
     * @param x   Coordonnée X du joueur
     * @param y   Coordonnée Y du joueur
     */
    public Joueur(String n, int x, int y) {
        this.nom = n;
        this.vie = POINT_DE_VIE;
        this.mana = 0;
        this.xp = 0;
        this.positionX = x;
        this.positionY = y;
        this.facing = 3;
    }

    /**
     * Methode de deplacement du joueur
     * 
     * @param x
     * @param y
     */
    public void move(int x, int y) {
        if (!collision) {
            this.positionX += x;
            this.positionY += y;
        }
    }

    /**
     * Méthode qui change la vie du joueur
     * 
     * @param n Nombre de points de vie ajouter ou enlever du joueur
     */
    public void changerVie(int n) {
        if ((this.vie + n) <= 0)
            this.vie = 0;
        else
            this.vie += n;
    }

    /**
     * Méthode qui change le mana du joueur
     * 
     * @param n Nombre de points de mana ajouter ou enlever du joueur
     */
    public void changerMana(int n) {
        if ((this.mana + n) <= 0)
            this.mana = 0;
        else
            this.mana += n;
    }

    /**
     * Méthode qui change l'xp du joueur
     * 
     * @param n Nombre de points de xp ajouter ou enlever du joueur
     */
    public void changerXp(int n) {
        if ((this.xp + n) <= 0)
            this.xp = 0;
        else
            this.xp += n;
    }

    /**
     * Méthode qui donne la vie du joueur
     * 
     * @return l'attribut vie
     */
    public int getVie() {
        return this.vie;
    }

    /**
     * Méthode qui donne le mana du joueur
     * 
     * @return l'attribut mana
     */
    public int getMana() {
        return this.mana;
    }

    /**
     * Méthode qui donne l'xp du joueur
     * 
     * @return l'attribut xp
     */
    public int getXp() {
        return this.xp;
    }

    /**
     * Methode qui rend la position en X du joueur
     * 
     * @return
     */
    public int getPositionX() {
        return this.positionX;
    }

    /**
     * Methode setter de la position X du joueur
     * 
     * @param x
     */
    public void setPositionX(int x) {
        this.positionX = x;
    }

    /**
     * Methode qui rend la position Y du joueur
     * 
     * @return
     */
    public int getPositionY() {
        return this.positionY;
    }

    /**
     * Methode setter de la position Y du joueur
     * 
     * @param y
     */
    public void setPositionY(int y) {
        this.positionY = y;
    }

    /**
     * Metgode qui rend le nom du joueur
     * 
     * @return le nom du joueur
     */
    public String getNom() {
        return this.nom;
    }

    public int getFacing(){
        return this.facing;
    }

    public void setFacing(int f){
        this.facing = f;
    }

    public void bloquer(boolean bool) {
        this.collision = bool;
    }

    public boolean getCollision(){
        return this.collision;
    }

    /**
     * Méthode qui affiche touts les attributs du joueur
     */
    public String toString() {
        return "Le joueur " + this.nom + " a\n - " + this.vie + " points de vie\n - " + this.mana
                + " points de mana\n - " + this.xp + " points d'xp\n - Coordonnées(" + this.positionX + ", "
                + this.positionY + ")";
    }

}