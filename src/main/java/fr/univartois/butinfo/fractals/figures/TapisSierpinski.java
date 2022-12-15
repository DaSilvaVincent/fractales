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
 * Le type TapisSierpinski
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class TapisSierpinski implements FractalsFigures {

    /**
     * L'attribut max
     */
    private double max;

    /**
     * L'attribut couleur2
     */
    private String couleur2;
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.FractalsFigures#ajoutFigures(double,
     * double, double, double)
     */
    @Override
    public String ajoutFigures(double max1, double x, double y, double cote, String couleur1, String couleur21) {
        this.max = max1;
        this.couleur2 = couleur21;
        List<IFigures> figures = new ArrayList<>();
        figures.add(new Carre(x, y, cote, couleur1));
        sierpinski(figures, ((int) x), ((int) y), ((int) cote), ((int) cote),0);
        return new PlusieursFigures(figures).getSvg();
    }

    /**
     * @param figures figures
     * @param xHG xHG
     * @param yHG yHG
     * @param largeur largeur
     * @param hauteur hauteur
     * @param n n
     */
    private void sierpinski(List<IFigures> figures, double xHG, double yHG, double largeur, double hauteur,double n) {
        if (n<max) {
            double w = largeur / 3;
            double h = hauteur / 3;
            figures.add(new Carre(xHG + w, yHG + h, w, couleur2));
            for (int k = 0; k < 9; k++)
                if (k != 4) {
                    int i = k / 3;
                    int j = k % 3;
                    sierpinski(figures, xHG + i * w, yHG + j * h, w, h,n+1);
                }
        }
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

}
