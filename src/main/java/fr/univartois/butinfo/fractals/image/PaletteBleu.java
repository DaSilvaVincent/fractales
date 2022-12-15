/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.Color;

/**
 * Le type PaletteBleu
 *
 * @author Thimothee Lepetz
 *
 * @version 0.1.0
 */
public class PaletteBleu implements IPalette{
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IPalette#setColor(java.awt.Color)
     */
    @Override
    public Color color(int nbIteration,int maxIterator) {
        
        if (nbIteration==maxIterator) 
            return Color.BLACK;
        if (nbIteration<=255)
            return new Color(0,nbIteration/2,nbIteration);
        else {
            return new Color(100,nbIteration/2,nbIteration/2);
        }
    }
}

