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
 * Le type SuiteGeneralisantJulia
 *
 * @author Vincent Da Silva
 *
 * @version 0.1.0
 */
public class SuiteGeneralisantJulia extends SuiteComplex implements ISuiteComplexStrategy{

    /**
     * L'attribut binOp
     */
    private BinaryOperator<IComplex> binOp;
    
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
     * @param binOp binOp
     * @param z z
     * @param c c
     */
    public SuiteGeneralisantJulia(int n,BinaryOperator<IComplex> binOp, IComplex z, IComplex c) {
        super(n);
        this.binOp = binOp;
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
        return binOp.apply(actuel, c);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.ISuiteComplexStrategy#firstValue()
     */
    @Override
    public IComplex firstValue() {
        return binOp.apply(z, c);
    }

}

