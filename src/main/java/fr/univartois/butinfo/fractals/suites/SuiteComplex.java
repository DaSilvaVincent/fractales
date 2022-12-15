/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suites;

import java.util.Iterator;

import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Le type SuiteComplex
 *
 * @author Vincent Da Silva
 *
 * @version 0.1.0
 */
public class SuiteComplex implements ISuiteComplexStrategy{
    
    /**
     * L'attribut strategy
     */
    private ISuiteComplexStrategy strategy;
    
    /**
     * L'attribut n
     */
    private int n;
    
    /**
     * Crée une nouvelle instance de SuiteComplex.
     * @param n n
     */
    //N premiers termes
    public SuiteComplex(int n) {
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
    public Iterator<IComplex> iterator() {
        return new ComplexIterator(this);
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#nextValue(fr.univartois.butinfo.fractals.complex.Complex)
     */
    @Override
    public IComplex nextValue(IComplex  actuel) {
        return strategy.nextValue(actuel);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#firstValue()
     */
    @Override
    public IComplex firstValue() {
        return strategy.firstValue();
    }
}