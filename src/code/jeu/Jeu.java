package code.jeu;

//import java.util.Scanner;
import java.io.File;
import code.characters.*;
import code.characters.Character;
import code.block.*;

public class Jeu {

    private Character j;
    private Map carte;

    private AnimateBlock actualBlock;

    /**
     * 
     * Contructeur de la classe Jeu Cela creer une map et un joueur par défaut
     */

    public Jeu() {
        // Scanner sc = new Scanner(System.in);
        this.j = new Advanturer("Bob", 10, 1, 1);
        File file = new File("src/map/level_1.txt");
        this.carte = new Map(file);
        this.carte.verify();
        this.actualBlock = null;
        // sc.close();
    }

    /**
     * 
     * Contructeur de la classe Jeu Cela creer charge une map selon la file donnee
     * ainsi qu'un joueur
     */
    public Jeu(File file, Character joueur) {
        this.j = joueur;
        this.carte = new Map(file);
        this.carte.verify();
    }

    /**
     * 
     * Methode de commande lorsque l'on appuie sur les touches du clavier
     */

    public void commande(code.moteurJeu.moteur.CClavier clavier) {
       if (j instanceof PlayableCharacter) {

            if (clavier.isPressed(83)) {
                gererCollision(j.getPosition().getX(), j.getPosition().getY() + 1);
                j.move(0, 1);
                j.setFacingView(FacingProperty.FACING_DOWN);
            }
            if (clavier.isPressed(81)) {
                gererCollision(j.getPosition().getX() - 1, j.getPosition().getY());
                j.move(-1, 0);
                j.setFacingView(FacingProperty.FACING_LEFT);
            }
            if (clavier.isPressed(90)) {
                gererCollision(j.getPosition().getX(), j.getPosition().getY() - 1);
                j.move(0, -1);
                j.setFacingView(FacingProperty.FACING_UP);
            }
            if (clavier.isPressed(68)) {
                gererCollision(j.getPosition().getX() + 1, j.getPosition().getY());
                j.move(1, 0);
                j.setFacingView(FacingProperty.FACING_RIGHT);
            }
            if (clavier.isPressed(32)) {
            	carte.gererAttaque(j.getPosition().getX(), j.getPosition().getY(), j);
            }
        } else if (j instanceof NonPlayableCharacter) {

        }
        gererDeclencheur(j.getPosition().getX(), j.getPosition().getY(), this.j);
    }

    /**
     * Methode qui test la collision de la case avec le joueur
     * 
     * @param x,y les attributs de la case a tester
     * 
     */
    public void gererCollision(int x, int y) {
        if (!carte.isInBounds(x, y)) {
            j.bloquer(true);
        } else {
            j.bloquer(false);
        }
        if (!carte.getTile(x, y).isTraversable()) {
            j.bloquer(true);
        } else {
            j.bloquer(false);
        }
    }

    /**
     * Methode de getter du character
     * 
     * @return le character de Jeu
     */
    public Character getCharacter() {
        return this.j;
    }

    /**
     * Methode de getter de la map
     * 
     * @return la Map du jeu
     */
    public Map getMap() {
        return this.carte;
    }

    /**
     * Methode pour gerer le passage sur une case declencheur
     * 
     * @param x,y,c
     */
    public void gererDeclencheur(int x, int y, Character character) {

        Block block = carte.getTile(character.getPosition().getX(), character.getPosition().getY());

        if (block instanceof AnimateBlock) {
            AnimateBlock animateBlock = ((AnimateBlock) block);
            if (animateBlock.getAnimate() == 0) {
                this.actualBlock = animateBlock;
                animateBlock.activerAnimation();
                character.changerVie(animateBlock.getLife());
            } else
                animateBlock.changeNbAnimation();
        }
    }

    public AnimateBlock getActualBlock() {
        return this.actualBlock;
    }

}