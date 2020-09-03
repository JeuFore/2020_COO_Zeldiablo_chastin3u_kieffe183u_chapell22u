package code.jeu;

import java.util.ArrayList;

import code.block.Block;
import code.block.type.*;

/**
 * Classe représentant une ligne d'une carte d'un niveau
 */
public class Row {

    /**
     * Attribut représentant les cases de la ligne
     */
    private ArrayList<Block> tiles;

    /**
     * Construit une ligne à partir des cases déjà remplies
     * 
     * @param integers cases de la ligne
     */
    public Row(ArrayList<Block> integers) {
        this.tiles = integers;
    }

    /**
     * Constuit une ligne vide
     */
    public Row() {
        this.tiles = new ArrayList<Block>();
    }

    /**
     * Renvoie la valeur de la case de la ligne demandée
     * 
     * @param coord index de la case dans la liste
     * @return valeur de la case (-1 si la case n'est pas trouvée)
     */
    public Block getTile(int coord) {
        try {
            return this.tiles.get(coord);
        } catch (IndexOutOfBoundsException oob) {
            return null;
        }

    }

    public ArrayList<Block> getTiles() {
        return tiles;
    }

    /**
     * Méthode qui ajoute une case au bout de la liste
     * 
     * @param tile valeur de la case à ajouter
     */
    public void addTile(int tile) {
        Block temp = null;
        switch (tile) {
            case 0:
                temp = new Empty();
                break;
            case 1:
                temp = new Wall();
                break;
            case 2:
                temp = new BearTrap();
                break;
            case 3:
                temp = new Heal();
                break;
            case 4:
                temp = new Fire();
                break;
            default:
                break;
        }
        this.tiles.add(temp);
    }

    /**
     * Méthode qui supprime la dernière case de la liste
     */
    public void removeTile() {
        this.tiles.remove(this.tiles.size() - 1);
    }

}