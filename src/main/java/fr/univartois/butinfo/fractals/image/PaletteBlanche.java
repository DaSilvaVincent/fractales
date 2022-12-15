/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.Color;

/**
 * Le type PaletteBlanche
 *
 * @author Thimothee Lepetz
 *
 * @version 0.1.0
 */
public class PaletteBlanche implements IPalette{
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IPalette#setColor(java.awt.Color)
     */
    @Override
    public Color color(int nbIteration,int maxIterator) {
        
        if (nbIteration==maxIterator) 
            return Color.BLACK;
        if (nbIteration<=51)
            return new Color(nbIteration/5,nbIteration/5,nbIteration/5);
        if (nbIteration<=102)
            return new Color(nbIteration/4,nbIteration/4,nbIteration/4);
        if (nbIteration<=153)
            return new Color(nbIteration/3,nbIteration/3,nbIteration/3);
        if (nbIteration<=204)
            return new Color(nbIteration/2,nbIteration/2,nbIteration/2);
        if (nbIteration<=255)
            return new Color(nbIteration,nbIteration,nbIteration);
        else {
            return new Color(0,0,0);
        }
    }
}


