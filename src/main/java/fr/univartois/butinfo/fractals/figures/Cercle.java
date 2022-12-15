/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figures;

/**
 * Le type Cercle
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class Cercle implements IFigures {

    /**
     * L'attribut x
     */
    private double x;

    /**
     * L'attribut y
     */
    private double y;

    /**
     * L'attribut rayon
     */
    private double rayon;

    /**
     * L'attribut color
     */
    private String color;

    /**
     * L'attribut transform
     */
    private String transform;

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getSvg()
     */

    /**
     * Crée une nouvelle instance de Cercle.
     * 
     * @param x x
     * @param y y
     * @param rayon rayon
     * @param color color
     */
    public Cercle(double x, double y, double rayon, String color) {
        super();
        this.x = x;
        this.y = y;
        this.rayon = rayon;
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
     * Donne l'attribut x de cette instance de Cercle.
     *
     * @return L'attribut x de cette instance de Cercle.
     */
    public double getX() {
        return x;
    }

    /**
     * Modifie l'attribut x de cette instance de Cercle.
     *
     * @param x La nouvelle valeur de l'attribut x pour cette instance de Cercle.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Donne l'attribut y de cette instance de Cercle.
     *
     * @return L'attribut y de cette instance de Cercle.
     */
    public double getY() {
        return y;
    }

    /**
     * Modifie l'attribut y de cette instance de Cercle.
     *
     * @param y La nouvelle valeur de l'attribut y pour cette instance de Cercle.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Donne l'attribut rayon de cette instance de Cercle.
     *
     * @return L'attribut rayon de cette instance de Cercle.
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * Modifie l'attribut rayon de cette instance de Cercle.
     *
     * @param rayon La nouvelle valeur de l'attribut rayon pour cette instance de Cercle.
     */
    public void setRayon(double rayon) {
        this.rayon = rayon;
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
        return "<circle cx= \"" + x + "\" cy= \"" + y + "\" r= \""
               + rayon + "\" fill= \"" + color + "\" stroke-width= \"5\" " + transform + "\" />";
    }

}
