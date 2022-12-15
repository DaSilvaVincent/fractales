/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.Color;

/**
 * Le type CouleurDecorateur
 *
 * @author Thimothee Lepetz
 *
 * @version 0.1.0
 */
public abstract class CouleurDecorateur implements IPalette {
    
    /**
     * L'attribut palette
     */
    protected IPalette palette;
    
    /**
     * Crée une nouvelle instance de CouleurDecorateur.
     * @param palette palette
     */
    protected CouleurDecorateur(IPalette palette) {
        this.palette = palette;
    }

    @Override
    public Color color(int nbIteration, int maxIterator) {
        return palette.color(nbIteration, maxIterator);
    }
}

