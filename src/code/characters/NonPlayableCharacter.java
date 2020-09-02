package code.characters;

public abstract class NonPlayableCharacter extends Character {
    public NonPlayableCharacter(String name, int life, int x, int y, int[] facingPropertie) {
        super(name, life, x, y, facingPropertie);
    }
}