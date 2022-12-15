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
public class MasqueDecorateurG extends CouleurDecorateur{

    /**
     * Crée une nouvelle instance de MasqueDecorateurG.
     * @param palette palette
     */
    public MasqueDecorateurG(IPalette palette) {
        super(palette);
    }

    @Override
    public Color color(int nbIteration, int maxIterator) {
        return new Color(palette.color(nbIteration, maxIterator).getRed(),0,palette.color(nbIteration, maxIterator).getBlue());
    }
}
