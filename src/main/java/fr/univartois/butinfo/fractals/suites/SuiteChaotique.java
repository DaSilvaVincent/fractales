/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suites;

import java.util.Iterator;
import fr.univartois.butinfo.fractals.complex.Point;

/**
 * Le type SuiteComplexStrategyJulia
 *
 * @author Vincent Da Silva
 *
 * @version 0.1.0
 */
public class SuiteChaotique implements ISuiteChaotiqueStrategy{
    
    /**
     * L'attribut strategy
     */
    private ISuiteChaotiqueStrategy strategy;
    
    /**
     * L'attribut n
     */
    private int n;
    
    /**
     * Crée une nouvelle instance de SuiteComplex.
     * @param n n
     */
    //N premiers termes
    public SuiteChaotique(int n) {
        this.n=n;
    }
    
    /**
     * Donne l'attribut n de cette instance de SuiteComplex.
     *
     * @return L'attribut n de cette instance de SuiteComplex.
     */
    @Override
    public int getN() {
        return n;
    }
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<Point> iterator() {
        return new ChaotiqueIterator(this);
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#nextValue(fr.univartois.butinfo.fractals.complex.Complex)
     */
    @Override
    public Point nextValue(Point actuel) {
        return strategy.nextValue(actuel);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#firstValue()
     */
    @Override
    public Point firstValue() {
        return strategy.firstValue();
    }
}