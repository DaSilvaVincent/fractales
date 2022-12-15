/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.Color;

/**
 * Le type MasqueDecorateurR
 *
 * @author Thimothee Lepetz
 *
 * @version 0.1.0
 */
public class MasqueDecorateurB extends CouleurDecorateur{

    /**
     * Crée une nouvelle instance de MasqueDecorateurB.
     * @param palette palette
     */
    public MasqueDecorateurB(IPalette palette) {
        super(palette);
    }

    @Override
    public Color color(int nbIteration, int maxIterator) {
        return new Color(palette.color(nbIteration, maxIterator).getRed(),palette.color(nbIteration, maxIterator).getGreen(),0);
    }
}
