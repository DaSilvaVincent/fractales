/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figures;

/**
 * Le type Carre
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class Carre extends Rectangle {

    /**
     * Crée une nouvelle instance de Carre.
     * 
     * @param x x
     * @param y y
     * @param cote cote
     * @param color color
     */
    public Carre(double x, double y, double cote, String color) {
        super(x, y, cote, cote, color);
    }

}
