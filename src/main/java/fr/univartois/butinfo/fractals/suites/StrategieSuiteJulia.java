/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Le type SuiteComplexStrategyJulia
 *
 * @author Vincent Da Silva
 *
 * @version 0.1.0
 */
public class StrategieSuiteJulia extends SuiteComplex implements ISuiteComplexStrategy{
    
    /**
     * L'attribut z
     */
    private IComplex z;
    
    /**
     * L'attribut c
     */
    private IComplex c;
    
    /**
     * Crée une nouvelle instance de SuiteComplexStrategyJulia.
     * @param n n
     * @param z z
     * @param c c
     */
    public StrategieSuiteJulia(int n, IComplex z, IComplex c) {
        super(n);
        this.z = z;
        this.c = c;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#nextValue(fr.univartois.butinfo.fractals.complex.Complex)
     */
    @Override
    public IComplex nextValue(IComplex  actuel) {
        return actuel.multiply(actuel).add(c);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#firstValue()
     */
    @Override
    public IComplex firstValue() {
        return z.multiply(z).add(c);
    }

}