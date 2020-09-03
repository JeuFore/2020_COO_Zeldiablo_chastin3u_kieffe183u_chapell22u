package code.jeu;

import code.characters.FacingProperty;

public class MovingSimple implements MovingProperty {

    private int DIR;

    public MovingSimple(int direction) {
        this.DIR = direction;
    }

    @Override
    public boolean canMove(int direction) {
        switch(direction) {
            case FacingProperty.FACING_UP:
                return direction == this.DIR;
            case FacingProperty.FACING_RIGHT:
                return direction == this.DIR;
            case FacingProperty.FACING_DOWN:
                return direction == this.DIR;
            case FacingProperty.FACING_LEFT:
                return direction == this.DIR;
        }
        return false;
    }
    
}
