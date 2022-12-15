/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;

import java.util.Objects;

import fr.univartois.butinfo.fractals.suites.ISuiteComplexStrategy;

/**
 * Le type Complex
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class Complex implements IComplex{
    /**
     * L'attribut reelle
     */
    private double reelle;

    /**
     * L'attribut imaginaire
     */
    private double imaginaire;
    
    /**
     * L'attribut strategy
     */
    private ISuiteComplexStrategy strategy;

    /**
     * Crée une nouvelle instance de Complex.
     * @param reelle reelle
     * @param imaginaire imaginaire
     */
    public Complex(double reelle, double imaginaire) {
        this.reelle=reelle;
        this.imaginaire=imaginaire;
    }
    
    
    /**
     * Donne l'attribut reelle de cette instance de Complex.
     *
     * @return L'attribut reelle de cette instance de Complex.
     */
    @Override
    public double getRealPart() {
        return reelle;
    }
    
    /**
     * Donne l'attribut imaginaire de cette instance de Complex.
     *
     * @return L'attribut imaginaire de cette instance de Complex.
     */
    @Override
    public double getImaginaryPart() {
        return imaginaire;
    }

    /**
     * @param strategy startegy
     */
    public void setStrategy(ISuiteComplexStrategy strategy) {
        this.strategy=strategy;
    }
    
    /**
     * Donne l'attribut strategy de cette instance de Complex.
     *
     * @return L'attribut strategy de cette instance de Complex.
     */
    public ISuiteComplexStrategy getStrategy() {
        return strategy;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(imaginaire, reelle);
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this==obj) return false;
        if (obj==null) return false;
        if (getClass() != obj.getClass())
            return false;
        return this.subtract((Complex) obj).abs()<0.0001;
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return reelle + " + " + imaginaire + "i";
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IComplex#abs()
     */
    @Override
    public double abs() {
        return Math.sqrt(this.getImaginaryPart()*this.getImaginaryPart()+this.getRealPart()*this.getRealPart());
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IComplex#negate()
     */
    @Override
    public IComplex negate() {
        return new Complex(-this.getRealPart(),-this.getImaginaryPart());
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IComplex#conjugate()
     */
    @Override
    public IComplex conjugate() {
        return new Complex(this.getRealPart(),-this.getImaginaryPart());
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IComplex#add(fr.univartois.butinfo.fractals.complex.IComplex)
     */
    @Override
    public IComplex add(IComplex other) {
        return new Complex(this.getRealPart()+other.getRealPart(),this.getImaginaryPart()+other.getImaginaryPart());
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IComplex#subtract(fr.univartois.butinfo.fractals.complex.IComplex)
     */
    @Override
    public IComplex subtract(IComplex other) {
        return new Complex(this.getRealPart()-other.getRealPart(),this.getImaginaryPart()-other.getImaginaryPart());
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IComplex#multiply(double)
     */
    @Override
    public IComplex multiply(double value) {
        return new Complex(this.getRealPart()*value,this.getImaginaryPart()*value);
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IComplex#multiply(fr.univartois.butinfo.fractals.complex.IComplex)
     */
    @Override
    public IComplex multiply(IComplex other) {
        return new Complex(this.getRealPart()*other.getRealPart()-this.getImaginaryPart()*other.getImaginaryPart(),
                this.getRealPart()*other.getImaginaryPart()+this.getImaginaryPart()*other.getRealPart());
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IComplex#divide(fr.univartois.butinfo.fractals.complex.IComplex)
     */
    @Override
    public IComplex divide(IComplex other) {
        return new Complex((this.getRealPart()*other.getRealPart()+this.getImaginaryPart()*other.getImaginaryPart())/(other.getRealPart()*other.getRealPart()+other.getImaginaryPart()*other.getImaginaryPart()),
                (this.getImaginaryPart()*other.getRealPart()-this.getRealPart()*other.getImaginaryPart())/(other.getRealPart()*other.getRealPart()+other.getImaginaryPart()*other.getImaginaryPart()));
    }

    
}