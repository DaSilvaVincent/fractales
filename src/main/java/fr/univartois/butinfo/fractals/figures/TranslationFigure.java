/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figures;

/**
 * Le type TranslationFigure
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class TranslationFigure implements IFigures {

    /**
     * L'attribut figure
     */
    private IFigures figure;

    /**
     * L'attribut x
     */
    private double x;
    
    /**
     * L'attribut y
     */
    private double y;

    /**
     * Crée une nouvelle instance de TranslationFigure.
     * 
     * @param figure figure
     * @param x x
     * @param y y
     */
    public TranslationFigure(IFigures figure, double x, double y) {
        this.figure = figure;
        this.x = x;
        this.y = y;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getSvg()
     */
    @Override
    public String getSvg() {
        figure.setTransform(figure.getTransform().concat(" translate(" + x + "," + y + ")"));
        return figure.getSvg();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#setTranform(java.lang.String)
     */
    @Override
    public void setTransform(String s) {
        //Rien à faire ici 
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getTransform()
     */
    @Override
    public String getTransform() {
        return figure.getTransform();
    }

}
