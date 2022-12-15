/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suites;

import java.util.Iterator;
import java.util.NoSuchElementException;

import fr.univartois.butinfo.fractals.complex.Point;

/**
 * Le type ChaotiqueIterator
 *
 * @author Vincent Da Silva
 *
 * @version 0.1.0
 */
public class ChaotiqueIterator implements Iterator<Point> {

    /**
     * L'attribut suite...
     */
    private ISuiteChaotiqueStrategy suite;
    
    /**
     * L'attribut currentValue
     */
    private Point currentValue = null;
    
    /**
     * L'attribut i
     */
    //Dernier index de l'intÃ©ration
    private int i;
    
    /**
     * Crée une nouvelle instance de ComplexIterator.
     * @param newSuite newSuite
     */
    public ChaotiqueIterator(ISuiteChaotiqueStrategy newSuite) {
        suite = newSuite;
        currentValue = suite.firstValue();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        return i<suite.getN();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Iterator#next()
     */
    @Override
    public Point next() {
        if (!hasNext())
            throw new NoSuchElementException();
        if(i==0) {
            i++;
            return currentValue;
        }
        if(this.hasNext()) {
            currentValue = suite.nextValue(currentValue);
            i++;
            return currentValue;
        }
        throw new NoSuchElementException();
    }

    
    /**
     * Donne l'attribut suite de cette instance de ComplexIterator.
     *
     * @return L'attribut suite de cette instance de ComplexIterator.
     */
    public ISuiteChaotiqueStrategy getSuite() {
        return suite;
    }

    
    /**
     * Donne l'attribut currentValue de cette instance de ComplexIterator.
     *
     * @return L'attribut currentValue de cette instance de ComplexIterator.
     */
    public Point getCurrentValue() {
        return currentValue;
    }

    
    /**
     * Donne l'attribut i de cette instance de ComplexIterator.
     *
     * @return L'attribut i de cette instance de ComplexIterator.
     */
    public int getI() {
        return i;
    }
}

