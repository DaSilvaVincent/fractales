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
 * Le type PlusieursFigures
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class PlusieursFigures implements IFigures {

    /**
     * L'attribut figures
     */
    private List<IFigures> figures = new ArrayList<>();

    /**
     * Crée une nouvelle instance de PlusieursFigures.
     * 
     * @param figures figures
     */
    public PlusieursFigures(List<IFigures> figures) {
        this.figures = figures;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getSvg()
     */
    @Override
    public String getSvg() {
        String svg = "<g>";
        for (IFigures figure : figures) {
            svg = svg.concat(figure.getSvg()+"\n");
        }
        return svg.concat("</g>");
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
