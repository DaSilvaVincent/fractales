/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Point;

/**
 * Le type ISuiteChaotiqueStrategy
 *
 * @author Vincent Da Silva
 *
 * @version 0.1.0
 */
public interface ISuiteChaotiqueStrategy extends Iterable<Point>, ISuite {
    
    /**
     * @param actuel actuel
     * @return Point
     */
    public Point nextValue(Point actuel);
    
    /**
     * @return Point
     */
    public Point firstValue();
    
}

