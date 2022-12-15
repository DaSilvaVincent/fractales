/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figures;

/**
 * Le type Triangle
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class Triangle implements IFigures {

    /**
     * L'attribut x
     */
    private double x;

    /**
     * L'attribut y
     */
    private double y;

    /**
     * L'attribut size
     */
    private double size;

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
     * @param size size
     * @param color color
     */
    public Triangle(double x, double y, double size, String color) {
        this.x = x;
        this.y = y;
        this.size = size;
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

    /**
     * Donne l'attribut size de cette instance de Triangle.
     *
     * @return L'attribut size de cette instance de Triangle.
     */
    public double getSize() {
        return size;
    }

    /**
     * Modifie l'attribut size de cette instance de Triangle.
     *
     * @param size La nouvelle valeur de l'attribut size pour cette instance de Triangle.
     */
    public void setSize(double size) {
        this.size = size;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getSvg()
     */
    @Override
    public String getSvg() {
        return "<polygon points=\""+size+","+size+", 0,"+size+" "+size/2+",0 \" fill= \"" + color + "\" stroke-width= \"5\" \"" + transform + "\" />";
    }

}
