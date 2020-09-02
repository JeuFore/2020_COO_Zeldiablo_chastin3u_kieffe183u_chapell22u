package code.jeu;

import java.util.ArrayList;

/**
 * Classe représentant une ligne d'une carte d'un niveau
 */
public class Row {

    /**
     * Attribut représentant les cases de la ligne
     */
    private ArrayList<Integer> tiles;

    /**
     * Construit une ligne à partir des cases déjà remplies
     * @param integers cases de la ligne
     */
    public Row(ArrayList<Integer> integers) {
        this.tiles = integers;
    }

    /**
     * Constuit une ligne vide
     */
    public Row() {
        this.tiles = new ArrayList<Integer>();
    }

    /**
     * Renvoie la valeur de la case de la ligne demandée
     * @param coord index de la case dans la liste
     * @return valeur de la case (-1 si la case n'est pas trouvée)
     */
    public int getTile(int coord) {
        try {
            return this.tiles.get(coord);
        } catch (IndexOutOfBoundsException oob) {
            return -1;
        }
        
    }

    /**
     * Méthode qui ajoute une case au bout de la liste
     * @param tile valeur de la case à ajouter
     */
    public void addTile(int tile) {
        this.tiles.add(tile);
    }

    /**
     * Méthode qui supprime la dernière case de la liste
     */
    public void removeTile() {
        this.tiles.remove(this.tiles.size() - 1);
    }

    /**
     * Méthode qui retourne la taille de Row
     * @return taille de Row
     */
    public int getSize(){
        return this.tiles.size();
    }
    
}