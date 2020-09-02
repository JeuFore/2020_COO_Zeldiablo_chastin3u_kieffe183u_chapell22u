package code.characters;

public class Advanturer extends PlayableCharacter {

    public Advanturer(String name, int life, int x, int y) {
        super(name, life, x, y, new FacingProperty("PlayableCharacter", 0, 0));
    }

}