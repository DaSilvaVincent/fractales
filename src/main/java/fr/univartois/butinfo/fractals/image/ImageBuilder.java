/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import fr.univartois.butinfo.fractals.complex.PlanComplex;
import fr.univartois.butinfo.fractals.complex.Point;
import fr.univartois.butinfo.fractals.suites.ISuiteComplexStrategy;

/**
 * Le type ImageBuilder
 *
 * @author Dylan Martin
 *
 * @version 0.1.0
 */
public class ImageBuilder {

    /**
     * Crée une nouvelle instance de ImageBuilder.
     */
    public ImageBuilder() {
        //Rien à faire
    }

    /**
     * L'attribut maxIt
     */
    private int maxIt;

    /**
     * Donne l'attribut maxIt de cette instance de ImageBuilder.
     *
     * @return L'attribut maxIt de cette instance de ImageBuilder.
     */
    public int getMaxIt() {
        return maxIt;
    }

    /**
     * Modifie l'attribut maxIt de cette instance de ImageBuilder.
     *
     * @param maxIt La nouvelle valeur de l'attribut maxIt pour cette instance de
     *        ImageBuilder.
     */
    public void setMaxIt(int maxIt) {
        this.maxIt = maxIt;
    }

    /**
     * L'attribut height
     */
    private int height;

    /**
     * L'attribut width
     */
    private int width;

    /**
     * L'attribut nomSuite
     */
    private String nomSuite;
    
    
    /**
     * Donne l'attribut nomSuite de cette instance de ImageBuilder.
     *
     * @return L'attribut nomSuite de cette instance de ImageBuilder.
     */
    public String getNomSuite() {
        return nomSuite;
    }

    
    /**
     * Modifie l'attribut nomSuite de cette instance de ImageBuilder.
     *
     * @param nomSuite La nouvelle valeur de l'attribut nomSuite pour cette instance de ImageBuilder.
     */
    public void setNomSuite(String nomSuite) {
        this.nomSuite = nomSuite;
    }

    /**
     * L'attribut echelle
     */
    private double echelle;

    /**
     * L'attribut centre
     */
    private Point centre;

    /**
     * L'attribut strategie
     */
    private ISuiteComplexStrategy strategie;

    /**
     * L'attribut palette
     */
    private IPalette palette;

    /**
     * L'attribut nomFichier
     */
    private String nomFichier;

    /**
     * L'attribut planComplex
     */
    private PlanComplex planComplex;

    /**
     * L'attribut nbIt
     */
    private int nbIt;

    /**
     * Donne l'attribut nbIt de cette instance de ImageBuilder.
     *
     * @return L'attribut nbIt de cette instance de ImageBuilder.
     */
    public int getNbIt() {
        return nbIt;
    }

    /**
     * Modifie l'attribut nbIt de cette instance de ImageBuilder.
     *
     * @param nbIt La nouvelle valeur de l'attribut nbIt pour cette instance de
     *        ImageBuilder.
     */
    public void setNbIt(int nbIt) {
        this.nbIt = nbIt;
    }

    /**
     * Donne l'attribut planComplex de cette instance de ImageBuilder.
     *
     * @return L'attribut planComplex de cette instance de ImageBuilder.
     */
    public PlanComplex getPlanComplex() {
        return planComplex;
    }

    /**
     * Modifie l'attribut planComplex de cette instance de ImageBuilder.
     *
     * @param planComplex La nouvelle valeur de l'attribut planComplex pour cette instance
     *        de ImageBuilder.
     */
    public void setPlanComplex(PlanComplex planComplex) {
        this.planComplex = planComplex;
    }

    /**
     * Donne l'attribut height de cette instance de ImageBuilder.
     *
     * @return L'attribut height de cette instance de ImageBuilder.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Modifie l'attribut height de cette instance de ImageBuilder.
     *
     * @param height La nouvelle valeur de l'attribut height pour cette instance de
     *        ImageBuilder.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Donne l'attribut width de cette instance de ImageBuilder.
     *
     * @return L'attribut width de cette instance de ImageBuilder.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Modifie l'attribut width de cette instance de ImageBuilder.
     *
     * @param width La nouvelle valeur de l'attribut width pour cette instance de
     *        ImageBuilder.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Donne l'attribut echelle de cette instance de ImageBuilder.
     *
     * @return L'attribut echelle de cette instance de ImageBuilder.
     */
    public double getEchelle() {
        return echelle;
    }

    /**
     * Modifie l'attribut echelle de cette instance de ImageBuilder.
     *
     * @param d La nouvelle valeur de l'attribut echelle pour cette instance de
     *        ImageBuilder.
     */
    public void setEchelle(double d) {
        this.echelle = d;
    }

    /**
     * Donne l'attribut centre de cette instance de ImageBuilder.
     *
     * @return L'attribut centre de cette instance de ImageBuilder.
     */
    public Point getCentre() {
        return centre;
    }

    /**
     * Modifie l'attribut centre de cette instance de ImageBuilder.
     *
     * @param centre La nouvelle valeur de l'attribut centre pour cette instance de
     *        ImageBuilder.
     */
    public void setCentre(Point centre) {
        this.centre = centre;
    }

    /**
     * Donne l'attribut strategie de cette instance de ImageBuilder.
     *
     * @return L'attribut strategie de cette instance de ImageBuilder.
     */
    public ISuiteComplexStrategy getStrategie() {
        return strategie;
    }

    /**
     * Modifie l'attribut strategie de cette instance de ImageBuilder.
     *
     * @param strategie La nouvelle valeur de l'attribut strategie pour cette instance de
     *        ImageBuilder.
     */
    public void setStrategie(ISuiteComplexStrategy strategie) {
        this.strategie = strategie;
    }

    /**
     * Donne l'attribut palette de cette instance de ImageBuilder.
     *
     * @return L'attribut palette de cette instance de ImageBuilder.
     */
    public IPalette getPalette() {
        return palette;
    }

    /**
     * Modifie l'attribut palette de cette instance de ImageBuilder.
     *
     * @param palette La nouvelle valeur de l'attribut palette pour cette instance de
     *        ImageBuilder.
     */
    public void setPalette(IPalette palette) {
        this.palette = palette;
    }

    /**
     * Donne l'attribut nomFichier de cette instance de ImageBuilder.
     *
     * @return L'attribut nomFichier de cette instance de ImageBuilder.
     */
    public String getNomFichier() {
        return nomFichier;
    }

    /**
     * Modifie l'attribut nomFichier de cette instance de ImageBuilder.
     *
     * @param nomFichier La nouvelle valeur de l'attribut nomFichier pour cette instance
     *        de ImageBuilder.
     */
    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

}
