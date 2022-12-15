/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;

import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;

/**
 * Le type Zoomer
 *
 * @author Dylan Martin, Thimothée Lepetz
 *
 * @version 0.1.0
 */
public class Zoomer extends PlanComplex {

    /**
     * L'attribut decore
     */
    private PlanComplex decore;

    /**
     * L'attribut zoom
     */
    private double zoom;

    /**
     * Crée une nouvelle instance de Zoomer.
     * @param decore decore
     * @param zoom zoom
     * 
     */
    public Zoomer(PlanComplex decore, double zoom) {
        super(decore.getHeight(), decore.getWidth());
        this.decore = decore;
        this.zoom = zoom;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.PlanComplex#asComplex(int, int)
     */
    /**
     * @param row ligne
     * @param column collone
     * 
     * @return un IComplex
     */
    @Override
    public IComplex asComplex(int row, int column) {
        return decore.asComplex(row, column).multiply(zoom);
    }

    @Override
    public Pixel asPixel(IComplex complex,IFractalImage image) {
        return decore.asPixel(complex.divide(new Complex(zoom,0)), image);
    }
    
    @Override
    public Pixel asPixel(Point point,IFractalImage image) {
        return decore.asPixel(new Point(new Complex(point.getX()/zoom,point.getY()/zoom)), image);
    }
}
