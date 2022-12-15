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
 * Le type Translation
 *
 * @author Thimothée Lepetz
 *
 * @version 0.1.0
 */
public class Translation extends PlanComplex {

    /**
     * L'attribut decore
     */
    private IPlanComplex decore;

    /**
     * L'attribut complex
     */
    private IComplex complex;

    /**
     * Crée une nouvelle instance de Translation.
     * @param decore decore 
     * @param complex complex
     */
    public Translation(IPlanComplex decore, IComplex complex) {
        super(decore.getHeight(), decore.getWidth());
        this.decore = decore;
        this.complex = complex;
    }

    /**
     * @param row - ligne
     * @param column - column
     * 
     * @return un IComplex
     */
    @Override
    public IComplex asComplex(int row, int column) {
        return decore.asComplex(row, column).add(complex);
    }

    @Override
    public Pixel asPixel(IComplex leComplex,IFractalImage image) {
        return decore.asPixel(leComplex.subtract(complex), image);
    }
    
    @Override
    public Pixel asPixel(Point point,IFractalImage image) {
        return decore.asPixel(new Point(new Complex(point.getX()-complex.getRealPart(),point.getY()-complex.getImaginaryPart())), image);
    }
}
