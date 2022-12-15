/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits r�serv�s.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.Color;

/**
 * Le type PaletteViolet
 *
 * @author Thimothee Lepetz
 *
 * @version 0.1.0
 */
public class PaletteViolet implements IPalette{
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IPalette#setColor(java.awt.Color)
     */
    @Override
    public Color color(int nbIteration,int maxIterator) {
        if (nbIteration==maxIterator) 
            return Color.WHITE;
        if (nbIteration<=5) {
            return new Color(nbIteration*45,0,nbIteration*50);
        }
        if (nbIteration<=255) {
            return new Color(nbIteration/2,0,nbIteration);
        } else
            return new Color(nbIteration/3,100,nbIteration/2);
        
    }

}

