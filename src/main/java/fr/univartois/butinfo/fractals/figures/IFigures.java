/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figures;

/**
 * Le type IFigures
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public interface IFigures {

    /**
     * @return String
     */
    String getSvg();

    /**
     * @param transform transform
     */
    void setTransform(String transform);

    /**
     * @return String
     */
    String getTransform();

}
