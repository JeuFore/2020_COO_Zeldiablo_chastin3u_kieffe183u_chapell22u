package code.characters;

public abstract class NonPlayableCharacter extends Character {
    public NonPlayableCharacter(String name, int life, int x, int y, FacingProperty facingProperty) {
        super(name, life, x, y, facingProperty);
    }
}