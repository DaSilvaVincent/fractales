/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figures;

/**
 * Le type Ligne
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class Ligne implements IFigures {

    /**
     * L'attribut x1
     */
    private double x1;
    
    /**
     * L'attribut x2
     */
    private double x2;
    
    /**
     * L'attribut y1
     */
    private double y1;
    
    /**
     * L'attribut y2
     */
    private double y2;

    /**
     * L'attribut color
     */
    private String color;

    /**
     * L'attribut transform
     */
    private String transform;

    /**
     * Crée une nouvelle instance de Cercle.
     * 
     * @param x1 x1
     * @param y1 y1
     * @param x2 x2
     * @param y2 y2
     * @param color color
     */
    public Ligne(double x1, double y1, double x2, double y2, String color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.transform = "transform=\"";
    }

    /**
     * Donne l'attribut transform de cette instance de Cercle.
     *
     * @return L'attribut transform de cette instance de Cercle.
     */
    @Override
    public String getTransform() {
        return transform;
    }

    /**
     * Modifie l'attribut transform de cette instance de Cercle.
     *
     * @param transform La nouvelle valeur de l'attribut transform pour cette instance de
     *        Cercle.
     */
    @Override
    public void setTransform(String transform) {
        this.transform = transform;
    }

    /**
     * Donne l'attribut x1 de cette instance de Ligne.
     *
     * @return L'attribut x1 de cette instance de Ligne.
     */
    public double getX1() {
        return x1;
    }

    /**
     * Modifie l'attribut x1 de cette instance de Ligne.
     *
     * @param x1 La nouvelle valeur de l'attribut x1 pour cette instance de Ligne.
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }

    /**
     * Donne l'attribut x2 de cette instance de Ligne.
     *
     * @return L'attribut x2 de cette instance de Ligne.
     */
    public double getX2() {
        return x2;
    }

    /**
     * Modifie l'attribut x2 de cette instance de Ligne.
     *
     * @param x2 La nouvelle valeur de l'attribut x2 pour cette instance de Ligne.
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }

    /**
     * Donne l'attribut y1 de cette instance de Ligne.
     *
     * @return L'attribut y1 de cette instance de Ligne.
     */
    public double getY1() {
        return y1;
    }

    /**
     * Modifie l'attribut y1 de cette instance de Ligne.
     *
     * @param y1 La nouvelle valeur de l'attribut y1 pour cette instance de Ligne.
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }

    /**
     * Donne l'attribut y2 de cette instance de Ligne.
     *
     * @return L'attribut y2 de cette instance de Ligne.
     */
    public double getY2() {
        return y2;
    }

    /**
     * Modifie l'attribut y2 de cette instance de Ligne.
     *
     * @param y2 La nouvelle valeur de l'attribut y2 pour cette instance de Ligne.
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }

    /**
     * Donne l'attribut color de cette instance de Cercle.
     *
     * @return L'attribut color de cette instance de Cercle.
     */
    public String getColor() {
        return color;
    }

    /**
     * Modifie l'attribut color de cette instance de Cercle.
     *
     * @param color La nouvelle valeur de l'attribut color pour cette instance de Cercle.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getSvg()
     */
    @Override
    public String getSvg() {
        return "<line x1=\"" + x1 + "\" y1=\"" + y1 + "\" x2=\"" + x2 + "\" y2=\"" + y2
               + "\" stroke= \"" + color + "\" stroke-width= \"1\" " + transform + "\" />";
    }

}
