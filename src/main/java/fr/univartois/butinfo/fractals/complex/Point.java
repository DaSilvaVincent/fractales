/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */
package fr.univartois.butinfo.fractals.complex;


/**
 * Le type Point
 *
 * @author Vincent Da Silva
 *
 * @version 0.1.0
 */
public class Point {
    
    /**
     * L'attribut adaptateurComplex...
     */
    private IComplex adaptateurComplex;
    
    /**
     * Crée une nouvelle instance de Point.
     * @param adaptateurComplex adaptateurComplex
     */
    public Point(IComplex adaptateurComplex) {
        this.adaptateurComplex=adaptateurComplex;
    }
    
    /**
     * @param complexAdaptateur complexAdptateur
     * @return double
     */
    public double distanceEntre2Points(IComplex complexAdaptateur) {
        return adaptateurComplex.subtract(complexAdaptateur).abs();        
    }
    
    /**
     * @return IComplex
     */
    public IComplex asIComplex() {
        return adaptateurComplex;
    }
    
    /**
     * @return double
     */
    public double getX() {
        return adaptateurComplex.getRealPart();
    }
    
    /**
     * @return double
     */
    public double getY() {
        return adaptateurComplex.getImaginaryPart();
    }

}

