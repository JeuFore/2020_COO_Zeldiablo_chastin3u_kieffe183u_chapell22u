package code.block;

public class AnimateBlock extends Block {

    // Nom du block correspond au nom du sprite
    private int animation;

    // Nombre d'animation du block
    private int nbAnimation;

    // Vie qu'enleve ou rajoute le block
    private int life;

    // Attribut qui permet de voir si le block ou piege est actif
    private boolean actif;

    /**
     * Constructeur permettant de cree des blocks ou pieges animes 
     * 
     * @param nom Nom du block correspond au nom du sprite
     * @param id Id du block correspond au id de la map
     * @param nbAnimation Nombre d'animation du block
     * @param life Vie qu'enleve ou rajoute le block
     * @param traversable Attribut qui permet de savoir si il est traversable
     */
    public AnimateBlock(String nom, int id, int nbAnimation, int life, boolean traversable, boolean visible) {
        super(nom, 0, id, traversable);
        this.animation = 0;
        this.nbAnimation = nbAnimation- 1;
        this.actif = true;
        this.life = life;
        setVisible(visible);
    }

    /**
     * Methode qui permet d'effectuer l'animation du block
     */
    public void changeNbAnimation() {
        this.animation++;
        setyAxis(this.animation);
        if (this.animation == this.nbAnimation) {
            setVisible(false);
            this.actif = false;
        }
    }

    /**
     * Methode qui permet d'activer l'animation
     */
    public void activerAnimation() {
        this.actif = false;
        this.setVisible(true);
    }

    /**
     * Methode qui permet de retourner la vie qu'enleve ou ajoute le block
     * 
     * @return Nombre de point de vie
     */
    public int getLife() {
        return this.life;
    }

    /**
     * Methode permettant de voir si le block ou piege est actif
     * 
     * @return true ou false
     */
    public boolean getActif() {
        return this.actif;
    }

}