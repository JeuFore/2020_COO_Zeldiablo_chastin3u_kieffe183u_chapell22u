//import java.util.Scanner;

public class Jeu extends CClavier{
    
    private Joueur j;
    private Map carte;

    public Jeu(){
       // Scanner sc = new Scanner(System.in);
        this.j = new Joueur("Bruno", 0, 0);
        this.carte = new Map("../documents/map/level_2");
        //sc.close();
    }


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

    public void gererCollision(int x, int y){
        if (!carte.isInBounds(x, y)){
            j.bloquer();
        } else {
            j.debloquer();
        }
        if (carte.getTile(x, y) == 1){
            j.bloquer();
        } else {
            j.debloquer();
        }
    }

    public Joueur getJoueur(){
        return this.j;
    }

    public Map getMap(){
        return this.carte;
    }
}