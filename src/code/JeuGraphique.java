package code;

import code.moteurJeu.moteur.*;

public class JeuGraphique implements JeuAbstract{

    private Jeu jeu;

    public JeuGraphique(Jeu j){
        this.jeu = j;
    }

	/**
	 * @return true si et seulement si le jeu est fini
	 */
	public boolean etreFini(){
        return false;
    }

    public String evoluer(code.moteurJeu.moteur.CClavier clavier, CSouris souris) {
        this.jeu.commande(clavier);
        return "";
    }
}
