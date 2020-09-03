package code.jeu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import code.block.Block;
import code.characters.Character;

/**
 * Classe représentant une carte d'un niveau
 */
public class Map {

    /**
     * variable qui contient la carte d'un niveau
     */
    private ArrayList<Row> map;

    /**
     * Variable qui contient les personnages sur cette map
     */
    private ArrayList<Character> characters;

    /**
     * Construit un niveau a partir d'une chaine de caracteres indiquant le fichier
     * du niveau
     * 
     * @param link chaine de caracteres indiquant le fichier du niveau
     */
    public Map(String link) {
        try {
            this.setCharacters(new ArrayList<Character>());
            File file = new File(link);
            this.map = load(file);
        } catch (NullPointerException exception) {
            System.out.println("The String you gave is null");
        }
    }

    /**
     * Getter de characters
     * 
     * @return les personnages de cette carte
     */
    public ArrayList<Character> getCharacters() {
        return this.characters;
    }

    /**
     * Setter de characters
     * 
     * @param characters personnages
     */
    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    /**
     * Construit un niveau a partir d'une file contenant le niveau
     * 
     * @param file file contenant le niveau
     */
    public Map(File file) {
        this.setCharacters(new ArrayList<Character>());
        this.map = load(file);
    }

    /**
     * Getter de map
     * 
     * @return la map
     */
    public ArrayList<Row> getMap() {
        return this.map;
    }

    /**
     * Méthode renvoyant true si les coordonnées passées en paramètres sont bien à
     * l'intérieur de la carte
     * 
     * @param x coordonnée x
     * @param y coordonnée y
     * @return true si les coordonnées sont dans la map
     */
    public boolean isInBounds(int x, int y) {
        try {
            Row row = this.map.get(y);
            int tile = row.getTile(x).getId();
            if (tile == -1)
                throw new IndexOutOfBoundsException();
            return true;
        } catch (IndexOutOfBoundsException oob) {
            return false;
        }
    }

    /**
     * Retourne la valeur de la case demandée
     * 
     * @param x coordonnée x
     * @param y coordonnée y
     * @return valeur de la case
     */
    public Block getTile(int x, int y) {
        if (isInBounds(x, y)) {
            Row row = this.map.get(y);
            return row.getTile(x);
        } else {
            return null;
        }
    }

    /**
     * Méthode qui charge un niveau à partir d'un fichier
     * 
     * @param file fichier contenant le niveau
     * @return la map
     */
    public static ArrayList<Row> load(File file) {
        ArrayList<Row> map = null;
        try {
            ArrayList<String> lines = new ArrayList<String>();
            BufferedReader buff = new BufferedReader(new FileReader(file));
            String line = buff.readLine();
            while (line != null) {
                lines.add(line);
                line = buff.readLine();
            }
            buff.close();
            map = convertLinesToMap(Arrays.asList(lines.toArray()).toArray(new String[lines.toArray().length]));
        } catch (IOException ioe) {
            System.out.println("This map does not exist");
        } catch (NumberFormatException nfe) {
            System.out.println("There is a problem in the level structure");
        }
        return map;
    }

    /**
     * Méthode qui convertit un tableau de chaîne de caractères dans le format d'un
     * niveau
     * 
     * @param lines chaînes de caractères
     * @return niveau
     */
    private static ArrayList<Row> convertLinesToMap(String[] lines) throws NumberFormatException {
        ArrayList<Row> rows = new ArrayList<Row>();
        for (String line : lines) {
            String[] chars = line.split(",");
            Row row = new Row();
            for (String character : chars) {
                row.addTile(Integer.parseInt(character));
            }
            rows.add(row);
        }
        return rows;
    }

    /**
     * Methode qui verifie si tous les personnages ne sont pas dans les murs. Si oui, renvoie false et supprime le personnage qui bloque.
     * @return true si tous les monstres sont bien placés
     */
    public boolean verify() {
        ArrayList<Character> tempChars = new ArrayList<Character>();
        for(Character c : this.characters) {
            final Block temp = this.getTile(c.getPosition().getX(), c.getPosition().getY());
            if (! temp.isTraversable()) {
                tempChars.add(c);
            }
        }
        for(Character c : tempChars) {
            this.characters.remove(c);
        }
        return tempChars.size() > 0;
    }

}