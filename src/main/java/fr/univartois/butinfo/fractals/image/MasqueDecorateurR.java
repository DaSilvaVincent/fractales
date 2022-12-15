/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits r�serv�s.
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
public class MasqueDecorateurR extends CouleurDecorateur{

    /**
     * Cr�e une nouvelle instance de MasqueDecorateurR.
     * @param palette palette
     */
    public MasqueDecorateurR(IPalette palette) {
        super(palette);
    }

    @Override
    public Color color(int nbIteration, int maxIterator) {
        return new Color(0,palette.color(nbIteration, maxIterator).getGreen(),palette.color(nbIteration, maxIterator).getBlue());
    }
}

