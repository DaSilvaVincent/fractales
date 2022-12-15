/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.Color;

/**
 * Le type IPalette
 *
 * @author Dylan Martin
 *
 * @version 0.1.0
 */
public interface IPalette {

    /**
     * @param nbIteration nbIteration
     * @param maxIterator maxIterator
     * @return Color
     */
    Color color(int nbIteration, int maxIterator);

}
