/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.Point;

/**
 * Le type SuiteCirculaire
 *
 * @author Vincent Da Silva
 *
 * @version 0.1.0
 */
public class SuiteCirculaire extends SuiteChaotique implements ISuiteChaotiqueStrategy{
    
    /**
     * L'attribut point...
     */
    private Point point = null;
    
    /**
     * Crée une nouvelle instance de SuiteComplexStrategyJulia.
     * @param n n
     * @param point point
     */
    public SuiteCirculaire(int n,Point point) {
        super(n);
        this.point = point;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#nextValue(fr.univartois.butinfo.fractals.complex.Complex)
     */
    @Override
    public Point nextValue(Point actuel) {
        double x = actuel.getX();
        double y = actuel.getY()+((actuel.getX()*(Math.sin(2*Math.PI*actuel.getY()))) /2*Math.PI)+((double)1/3);
        IComplex complex = new Complex(x,y);
        point = new Point(complex);
        return point;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#firstValue()
     */
    @Override
    public Point firstValue() {
        return point;
    }

}

