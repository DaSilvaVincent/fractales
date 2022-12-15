/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suites;

import java.util.function.BinaryOperator;

import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Le type SuiteGeneralisantMandelbrot
 *
 * @author Vincent Da Silva
 *
 * @version 0.1.0
 */
public class SuiteGeneralisantMandelbrot extends SuiteComplex implements ISuiteComplexStrategy{

    /**
     * L'attribut binOp
     */
    private BinaryOperator<IComplex> binOp;
    
    /**
     * L'attribut z
     */
    private IComplex z;
    
    /**
     * Crée une nouvelle instance de SuiteComplexStrategyJulia.
     * @param n n
     * @param binOp binOp
     * @param z z
     */
    public SuiteGeneralisantMandelbrot(int n,BinaryOperator<IComplex> binOp, IComplex z) {
        super(n);
        this.binOp = binOp;
        this.z = z;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#nextValue(fr.univartois.butinfo.fractals.complex.Complex)
     */
    @Override
    public IComplex nextValue(IComplex  actuel) {
        return binOp.apply(actuel, z);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#firstValue()
     */
    @Override
    public IComplex firstValue() {
        return binOp.apply(z, z);
    }
    
}

