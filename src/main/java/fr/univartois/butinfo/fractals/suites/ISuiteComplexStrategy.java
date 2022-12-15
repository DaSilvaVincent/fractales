/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Le type ISuiteComplexStrategy
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public interface ISuiteComplexStrategy extends Iterable<IComplex>, ISuite{
    
    /**
     * @param actuel actuel
     * @return IComplex
     */
    public IComplex  nextValue(IComplex actuel);
    
    /**
     * @return IComplex
     */
    public IComplex  firstValue();
    
}