/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Le type StrategieSuiteMandelbrot
 *
 * @author Vincent Da Silva, Thimothée Lepetz
 *
 * @version 0.1.0
 */
public class StrategieSuiteMandelbrot extends SuiteComplex implements ISuiteComplexStrategy {

    /**
     * L'attribut z
     */
    private IComplex z;

    /**
     * Crée une nouvelle instance de SuiteComplexStrategyJulia.
     * 
     * @param n n
     * @param z z
     */
    public StrategieSuiteMandelbrot(int n, IComplex z) {
        super(n);
        this.z = z;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#nextValue(fr.
     * univartois.butinfo.fractals.complex.Complex)
     */
    @Override
    public IComplex nextValue(IComplex actuel) {
        return actuel.multiply(actuel).add(z);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#firstValue()
     */
    @Override
    public IComplex firstValue() {
        return z.multiply(z).add(z);
    }

}
