package code;

import java.awt.image.BufferedImage;
import code.moteurJeu.moteur.*;

public class JeuGraphique implements JeuAbstract{

	/**
	 * @return true si et seulement si le jeu est fini
	 */
	public boolean etreFini(){
        return false;
    }

    public String evoluer(code.moteurJeu.moteur.CClavier clavier, CSouris souris) {
        System.out.println(souris.isPressed());
        return "";
    }
}
