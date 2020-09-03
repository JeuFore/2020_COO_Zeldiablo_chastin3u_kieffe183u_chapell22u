package code.jeu;

import code.characters.FacingProperty;
import code.moteurJeu.moteur.CClavier;

public class MovingKeyboard implements MovingProperty {

    private static final int UP = 90;
    private static final int RIGHT = 68;
    private static final int DOWN = 83;
    private static final int LEFT = 81;
    private CClavier clavier;

    public MovingKeyboard(CClavier clavier) {
        this.clavier = clavier;
    }


    @Override
    public boolean canMove(int direction) {
        switch(direction) {
            case FacingProperty.FACING_UP:
                return this.clavier.isPressed(UP);
            case FacingProperty.FACING_RIGHT:
                return this.clavier.isPressed(RIGHT);
            case FacingProperty.FACING_DOWN:
                return this.clavier.isPressed(DOWN);
            case FacingProperty.FACING_LEFT:
                return this.clavier.isPressed(LEFT);
        }
        return false;
    }
    
}
