package code.jeu;

//import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import code.characters.*;
import code.characters.Character;

import code.block.*;

public class Jeu {

    private Character j;
    private Map carte;

    private BlocksList blocksList;

    private Block actualBlock;

    /**
     * 
     * Contructeur de la classe Jeu Cela creer une map et un joueur par défaut
     */

    public Jeu() {
        // Scanner sc = new Scanner(System.in);
        this.j = new Wizard("Bob", 10, 1, 1, 10);
        File file = new File("src/map/level_3.txt");
        this.carte = new Map(file);
        this.blocksList = new BlocksList();
        this.actualBlock = new Block("Vide", 0, -1);
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
    }

    /**
     * 
     * Methode de commande lorsque l'on appuie sur les touches du clavier
     */

    public void commande(code.moteurJeu.moteur.CClavier clavier) {
        if (j instanceof PlayableCharacter) {

            if (clavier.isPressed(83)) {
                gererCollision(j.getPosition().getX(), j.getPosition().getY() - 1);
                j.move(0, 1);
                j.setFacingView(FacingProperty.FACING_UP);
            }
            if (clavier.isPressed(81)) {
                gererCollision(j.getPosition().getX() - 1, j.getPosition().getY());
                j.move(-1, 0);
                j.setFacingView(FacingProperty.FACING_LEFT);
            }
            if (clavier.isPressed(90)) {
                gererCollision(j.getPosition().getX(), j.getPosition().getY() + 1);
                j.move(0, -1);
                j.setFacingView(FacingProperty.FACING_DOWN);
            }
            if (clavier.isPressed(68)) {
                gererCollision(j.getPosition().getX() + 1, j.getPosition().getY());
                j.move(1, 0);
                j.setFacingView(FacingProperty.FACING_RIGHT);
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
        String[] tab = { "-1", "1" };
        if (!carte.isInBounds(x, y)) {
            j.bloquer(true);
        } else {
            j.bloquer(false);
        }
        if (Arrays.stream(tab).anyMatch(("" + carte.getTile(x, y).getId())::equals)) {
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
    public ArrayList<Row> getMap() {
        return this.carte.getMap();
    }

    /**
     * Methode pour gerer le passage sur une case declencheur
     * 
     * @param x,y,c
     */
    public void gererDeclencheur(int x, int y, Character character) {

        Block block = carte.getTile(character.getPosition().getX(), character.getPosition().getY());

        this.actualBlock.changerEtat();

        if(block.getActif()){
            this.actualBlock = block;
            this.actualBlock.activer();
            character.changerVie(block.getDegat());
        }

        /**
        if (this.explosion != 5)
            this.explosion++;

        if (carte.getTile(c.getPosition().getX(), c.getPosition().getY()) == 2 && this.explosion == 5) {
            c.changerVie(-2);
            System.out.println("Aie le piege... -2 points de vie.");
            this.explosion = 0;

        } else if (c instanceof NonPlayableCharacter) {
            System.out.println("Quelqu un d autre a perdu de la vie... Prenez l avantage!");
        }
        if ((carte.getTile(c.getPosition().getX(), c.getPosition().getY()) == 3)) {
            c.changerVie(2);
            if (c instanceof PlayableCharacter)
                System.out.println("Tu as trouve une fontaine de soin, +2 points de vie!");
            else if (c instanceof NonPlayableCharacter) {
                System.out.println("Attention quelqu un d autre a recupere de la vie ... ");
            }
        }

        */
    }

    public Block getActualBlock() {
        return this.actualBlock;
    }

}