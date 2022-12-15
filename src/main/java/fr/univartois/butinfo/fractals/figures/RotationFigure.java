/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figures;

/**
 * Le type RotationFigure
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public class RotationFigure implements IFigures {

    /**
     * L'attribut figure
     */
    private IFigures figure;

    /**
     * L'attribut rotate
     */
    private double rotate;

    /**
     * Crée une nouvelle instance de RotationFigure.
     *
     * @param figure figure
     * @param rotate rotate
     */
    public RotationFigure(IFigures figure, double rotate) {
        this.figure = figure;
        this.rotate = rotate;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#getSvg()
     */
    @Override
    public String getSvg() {
        figure.setTransform(figure.getTransform().concat(" rotate("+rotate+")"));
        return figure.getSvg();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figures.IFigures#setTranform(java.lang.String)
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
