package code.characters;

public abstract class Character {

    private String nom;
    private int vie;

    private boolean collision;

    private Position position;

    public Character(String name, int life, int x, int y) {
        this.nom = name;
        this.vie = life;
        this.collision = false;
        this.position = new Position(x, y);
    }

    public void move(int x, int y) {
        if (!collision) {
            this.position.changerX(x);
            this.position.changerX(y);
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getNom() {
        return nom;
    }

    public boolean isCollision() {
        return collision;
    }

    public void bloquer(boolean collision) {
        this.collision = collision;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void changerVie(int n) {
        this.vie = (this.vie + n <= 0) ? 0 : n;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer("Je suis " + this.nom + ", un personnage ");
        if (this instanceof NonPlayableCharacter) {
            res.append("non jouable ");
        } else {
            res.append("jouable ");
        }
        res.append("(" + this.vie + ") ");
        res.append("de classe \"" + this.getClass().getName() + "\"");
        return res.toString();
    }

}