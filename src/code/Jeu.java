package code;
//import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class Jeu extends CClavier{
    
    private Joueur j;
    private Map carte;

    /**
     * 
     * Contructeur de la classe Jeu
     * Cela creer une map et un joueur par défaut 
     */
    public Jeu(){
       // Scanner sc = new Scanner(System.in);
        this.j = new Joueur("Bruno", 0, 0);
        File file = new File("map/tests/level_3.txt");
        this.carte = new Map(file);
        //sc.close();
    }

    /**
     * 
     * Contructeur de la classe Jeu
     * Cela creer charge une map selon la file donnee
     */
    public Jeu(File file){
         this.j = new Joueur("Bruno", 0, 0);
         this.carte = new Map(file);
     }


    /**
     * 
     * Methode de commande lorsque l'on appuie sur les touches du clavier
     */
    public void commande(){
            if(isPressed(122)){
                gererCollision(j.getPositionX(), j.getPositionY()+1);
                j.move(0, 1);
            }
            if(isPressed(113)){
                gererCollision(j.getPositionX()-1, j.getPositionY());
                j.move(-1,0);
            }
            if(isPressed(115)){
                gererCollision(j.getPositionX(), j.getPositionY()-1);
                j.move(0, -1);
            }
            if(isPressed(100)){
                gererCollision(j.getPositionX()+1, j.getPositionY());
                j.move(1, 0);
            }
    }

    /**
     * Methode qui test la collision de la case avec le joueur 
     * @param x,y les attributs de la case a tester 
     * 
     */
    public void gererCollision(int x, int y){
        String[] tab = {"-1","1"};
        if (!carte.isInBounds(x, y)){
            j.bloquer(true);
        } else {
            j.bloquer(false);
        }
        if (Arrays.stream(tab).anyMatch(("" + carte.getTile(x, y))::equals)){
            j.bloquer(true);
        } else {
            j.bloquer(false);
        }
    }

    /**
     * Methode de getter du joueur 
     * @return le joueur de Jeu
     */
    public Joueur getJoueur(){
        return this.j;
    }

    /**
     * Methode de getter de la map
     * @return la Map du jeu  
     */
    public Map getMap(){
        return this.carte;
    }
}