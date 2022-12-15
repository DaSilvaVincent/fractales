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
 * Le type ArbreFractal
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class ArbreFractal implements FractalsFigures {

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
        this.couleur1 = couleur11;
        this.setCouleur2(couleur21);
        drawTree(((int)cote)/2, ((int)cote*2)/3, -90, (int) max1);
        return new PlusieursFigures(figures).getSvg();
    }

    /**
     * @param x1 x1
     * @param y1 y1
     * @param angle angle
     * @param depth depth
     */
    private void drawTree(int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 7);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 7);
        figures.add(new Ligne(x1, y1, x2, y2, couleur1));
        drawTree(x2, y2, angle - 45, depth - 1);
        drawTree(x2, y2, angle + 45, depth - 1);
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
        //rien à faire
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
     * Donne l'attribut couleur2 de cette instance de ArbreFractal.
     *
     * @return L'attribut couleur2 de cette instance de ArbreFractal.
     */
    public String getCouleur2() {
        return couleur2;
    }

    /**
     * Modifie l'attribut couleur2 de cette instance de ArbreFractal.
     *
     * @param couleur2 La nouvelle valeur de l'attribut couleur2 pour cette instance de ArbreFractal.
     */
    public void setCouleur2(String couleur2) {
        this.couleur2 = couleur2;
    }

    /**
     * Donne l'attribut max de cette instance de ArbreFractal.
     *
     * @return L'attribut max de cette instance de ArbreFractal.
     */
    public double getMax() {
        return max;
    }

    /**
     * Modifie l'attribut max de cette instance de ArbreFractal.
     *
     * @param max La nouvelle valeur de l'attribut max pour cette instance de ArbreFractal.
     */
    public void setMax(double max) {
        this.max = max;
    }

}
