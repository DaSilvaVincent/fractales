/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figures;

/**
 * Le type Rectangle
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class Rectangle implements IFigures {

    /**
     * L'attribut x
     */
    private double x;

    /**
     * L'attribut y
     */
    private double y;

    /**
     * L'attribut height
     */
    private double height;

    /**
     * L'attribut width
     */
    private double width;

    /**
     * L'attribut color
     */
    private String color;

    /**
     * L'attribut transform
     */
    private String transform;

    /**
     * Crée une nouvelle instance de Rectangle.
     * 
     * @param x x
     * @param y y
     * @param height height
     * @param width width
     * @param color wolor
     */
    public Rectangle(double x, double y, double height, double width, String color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
        this.transform = "transform=\"";
    }

    /**
     * Donne l'attribut x de cette instance de Rectangle.
     *
     * @return L'attribut x de cette instance de Rectangle.
     */
    public double getX() {
        return x;
    }

    /**
     * Modifie l'attribut x de cette instance de Rectangle.
     *
     * @param x La nouvelle valeur de l'attribut x pour cette instance de Rectangle.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Donne l'attribut y de cette instance de Rectangle.
     *
     * @return L'attribut y de cette instance de Rectangle.
     */
    public double getY() {
        return y;
    }

    /**
     * Modifie l'attribut y de cette instance de Rectangle.
     *
     * @param y La nouvelle valeur de l'attribut y pour cette instance de Rectangle.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Donne l'attribut height de cette instance de Rectangle.
     *
     * @return L'attribut height de cette instance de Rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Modifie l'attribut height de cette instance de Rectangle.
     *
     * @param height La nouvelle valeur de l'attribut height pour cette instance de
     *        Rectangle.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Donne l'attribut width de cette instance de Rectangle.
     *
     * @return L'attribut width de cette instance de Rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Modifie l'attribut width de cette instance de Rectangle.
     *
     * @param width La nouvelle valeur de l'attribut width pour cette instance de
     *        Rectangle.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Donne l'attribut color de cette instance de Rectangle.
     *
     * @return L'attribut color de cette instance de Rectangle.
     */
    public String getColor() {
        return color;
    }

    /**
     * Modifie l'attribut color de cette instance de Rectangle.
     *
     * @param color La nouvelle valeur de l'attribut color pour cette instance de
     *        Rectangle.
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
        return "<rect x= \"" + x + "\" y= \"" + y + "\" width= \"" + width + "\" height= \""
               + height + "\" fill= \"" + color + "\" stroke-width= \"5\" " + transform + "\" />";
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#setTransform(java.lang.String)
     */
    @Override
    public void setTransform(String transform) {
        this.transform=transform;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getTransform()
     */
    @Override
    public String getTransform() {
        return this.transform;
    }

}
