package code.jeu;

//import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

import code.characters.*;
import code.characters.Character;
import code.moteurJeu.FrameListener;
import code.moteurJeu.moteur.CClavier;
import code.moteurJeu.moteur.MoteurGraphique;
import code.block.*;

public class Jeu implements FrameListener {

    private Character j;
    private Map carte;

    private AnimateBlock actualBlock;
    private CClavier clavier;

    /**
     * 
     * Contructeur de la classe Jeu Cela creer une map et un joueur par défaut
     */

    public Jeu() {
        // Scanner sc = new Scanner(System.in);
        this.j = new Wizard("Bob", 10, 1,1, 10);
        File file = new File("src/map/level_1.txt");
        this.carte = new Map(file);
        this.carte.verify();
        this.actualBlock = null;
        this.clavier = new CClavier();
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

    public void setClavier(CClavier clavier) {
        this.clavier = clavier;
    }

    /**
     * 
     * Methode de commande lorsque l'on appuie sur les touches du clavier
     */       	
        
    public void commande(Character c, MovingProperty movingProperty) {
        if (movingProperty.canMove(FacingProperty.FACING_DOWN)) {
            this.move(0, 1, FacingProperty.FACING_DOWN, (c == null) ? j : c);
        }
        if (movingProperty.canMove(FacingProperty.FACING_LEFT)) {
            this.move(-1, 0, FacingProperty.FACING_LEFT, (c == null) ? j : c);
        }
        if (movingProperty.canMove(FacingProperty.FACING_UP)) {
            this.move(0, -1, FacingProperty.FACING_UP, (c == null) ? j : c);
        }
        if (movingProperty.canMove(FacingProperty.FACING_RIGHT)) {
            this.move(1, 0, FacingProperty.FACING_RIGHT, (c == null) ? j : c);
        }
        if (clavier.isPressed(32)) {
            carte.gererAttaque(j.getPosition().getX(), j.getPosition().getY(), j);
            System.out.println(this.carte.getCharacters().get(0).getVie());
        }
        gererDeclencheur(j.getPosition().getX(), j.getPosition().getY(), this.j);
    }

    private void move(int x, int y, int facingProperty, Character c) {
        gererCollision(c.getPosition().getX() + x, c.getPosition().getY() + y, (c == null) ? j : c);
        c.move(x, y);
        c.setFacingView(facingProperty);
    }

    /**
     * Methode qui test la collision de la case avec le joueur
     * 
     * @param x,y les attributs de la case a tester
     * 
     */
    public void gererCollision(int x, int y, Character c) {
        if (c == null) {
            j.bloquer((! carte.isInBounds(x, y)) || (!carte.getTile(x, y).isTraversable()));
        } else {
            c.bloquer((! carte.isInBounds(x, y)) || (!carte.getTile(x, y).isTraversable()));
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
            if (animateBlock.getActif()) {
                animateBlock.activerAnimation();
                this.actualBlock = animateBlock;
                character.changerVie(animateBlock.getLife());
                if (animateBlock instanceof Trap)
                    character.setStun(((Trap) animateBlock).getStun());
            }
        }

        if (this.actualBlock != null)
            if (this.actualBlock.getVisible())
                this.actualBlock.changeNbAnimation();
            else if (!this.actualBlock.getActif())
                character.setStun(false);
    }

    public AnimateBlock getActualBlock() {
        return this.actualBlock;
    }

    @Override
    /**
     * Méthode qui se déclenche à chaque frame
     */
    public void frameUpdate() {
        ArrayList<Character> chars = this.getMap().getCharacters();
        for(Character c: chars) {
            if (c instanceof NonPlayableCharacter) {
                NonPlayableCharacter npc = (NonPlayableCharacter) c;
                if (MoteurGraphique.getFrame() % 5 == 0) {
                    final int rand = (int)Math.floor(Math.random() * 4);
                    this.commande(npc, new MovingSimple(rand));
                }
            }
        }
    }

}