package code.block;

public class Trap extends AnimateBlock {

    private boolean stun;

    /**
     * 
     * @param nom Nom du block correspond au nom du sprite
     * @param id Id du block correspond au id de la map
     * @param nbAnimation Nombre d'animation du block
     * @param life Vie qu'enleve ou rajoute le block
     * @param traversable Attribut qui permet de savoir si il est traversable
     * @param stun Permet de savoir si un block etourdit le joueur 
     */
    public Trap(String nom, int id, int nbAnimation, int life, boolean traversable, boolean stun) {
        super(nom, id, nbAnimation, life, traversable);
        this.stun = stun;
    }

    /**
     * Methode permettant de recuperer l'attribut stun
     * 
     * @return stun
     */
    public boolean getStun() {
        return this.stun;
    }

}