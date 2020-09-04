package code.characters;

public class Monster extends NonPlayableCharacter {
    public Monster(String name, int life, int x, int y) {
        super(name, life, x, y, new FacingProperty("NonPlayableCharacter", 7, 4), 3);
    }
}