/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits r�serv�s.
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
public class PaletteJaune implements IPalette{
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IPalette#setColor(java.awt.Color)
     */
    @Override
    public Color color(int nbIteration,int maxIterator) {
        if (nbIteration==maxIterator) 
            return new Color(0,0,0);
        if (nbIteration<=10)
            return new Color(nbIteration*2,nbIteration*2,0);
        if (nbIteration<=50)
            return new Color(nbIteration*3,nbIteration*3,0);
        if (nbIteration<=100)
            return new Color(nbIteration*2,nbIteration*2,0);
        if (nbIteration<=150 && nbIteration%2==0)
            return new Color((int)(nbIteration*1.5),(int)(nbIteration*1.5),0);
        if (nbIteration<=255)
            return new Color(nbIteration,nbIteration,0);
        else {
            return new Color(0,0,0);
        }
    }
}

