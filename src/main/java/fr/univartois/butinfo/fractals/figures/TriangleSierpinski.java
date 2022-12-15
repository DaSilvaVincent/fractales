/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figures;

import java.util.ArrayList;
import java.util.List;

/**
 * Le type TriangleSierpinski
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class TriangleSierpinski implements FractalsFigures {

    /**
     * L'attribut max
     */
    private double max;

    /**
     * L'attribut couleur2
     */
    private String couleur2;

    /**
     * L'attribut couleur1
     */
    private String couleur1;

    /**
     * L'attribut figures
     */
    private List<IFigures> figures;

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.FractalsFigures#ajoutFigures(double,
     * double, double, double)
     */
    @Override
    public String ajoutFigures(double max1, double x, double y, double cote, String couleur11, String couleur21) {
        this.figures = new ArrayList<>();
        this.setMax(max1);
        this.setCouleur1(couleur11);
        this.couleur2 = couleur21;
        triangle(cote, cote, -cote, ((int)max1));
        return new PlusieursFigures(figures).getSvg();
    }

    /**
     * @param x x
     * @param y y
     * @param s s
     * @param n n
     */
    public void triangle(double x, double y, double s, int n) {

        if (n <= 0) {
            return;
        }
        
        double x1 = x;
        double y1 = y;
        double x2 = x1 + s;
        double y2 = y1;
        double x3 = (x1 + x2) / 2.0;
        double y3 = y1 + (Math.sqrt(3) * s / 2);

        figures.add(new Ligne(x1, y1, x2, y2, couleur2));
        figures.add(new Ligne(x1, y1, x3, y3, couleur2));
        figures.add(new Ligne(x2, y2, x3, y3, couleur2));

        triangle(x1, y1, s / 2.0, n - 1);
        triangle((x1 + x2) / 2.0, (y1 + y2) / 2.0, s / 2.0, n - 1);
        triangle((x1 + x3) / 2.0, (y1 + y3) / 2.0, s / 2.0, n - 1);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getSvg()
     */
    @Override
    public String getSvg() {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#setTransform(java.lang.String)
     */
    @Override
    public void setTransform(String transform) {
        //Rien à faire ici
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getTransform()
     */
    @Override
    public String getTransform() {
        return null;
    }

    /**
     * Donne l'attribut couleur1 de cette instance de TriangleSierpinski.
     *
     * @return L'attribut couleur1 de cette instance de TriangleSierpinski.
     */
    public String getCouleur1() {
        return couleur1;
    }

    /**
     * Modifie l'attribut couleur1 de cette instance de TriangleSierpinski.
     *
     * @param couleur1 La nouvelle valeur de l'attribut couleur1 pour cette instance de TriangleSierpinski.
     */
    public void setCouleur1(String couleur1) {
        this.couleur1 = couleur1;
    }

    /**
     * Donne l'attribut max de cette instance de TriangleSierpinski.
     *
     * @return L'attribut max de cette instance de TriangleSierpinski.
     */
    public double getMax() {
        return max;
    }

    /**
     * Modifie l'attribut max de cette instance de TriangleSierpinski.
     *
     * @param max La nouvelle valeur de l'attribut max pour cette instance de TriangleSierpinski.
     */
    public void setMax(double max) {
        this.max = max;
    }
    
    /**
     * Donne l'attribut figures de cette instance de TriangleSierpinski.
     *
     * @return L'attribut figures de cette instance de TriangleSierpinski.
     */
    public List<IFigures> getFigures() {
        return figures;
    }

    
    /**
     * Modifie l'attribut figures de cette instance de TriangleSierpinski.
     *
     * @param figures La nouvelle valeur de l'attribut figures pour cette instance de TriangleSierpinski.
     */
    public void setFigures(List<IFigures> figures) {
        this.figures = figures;
    }


}
