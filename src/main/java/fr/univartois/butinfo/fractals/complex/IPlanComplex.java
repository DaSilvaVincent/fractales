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
 * Le type PlanComplex
 *
 * @author Thimothée Lepetz
 *
 * @version 0.1.0
 */
public interface IPlanComplex {

    /**
     * @param row row
     * @param column column
     * 
     * @return IComplex
     */
    IComplex asComplex(int row, int column);

    /**
     * @return double
     */
    double getHeight();

    /**
     * @return double
     */
    double getWidth();
    

    /**
     * @param complex complex
     * @param image image
     * @return Pixel
     */
    Pixel asPixel(IComplex complex, IFractalImage image);

    /**
     * @param point point
     * @param image image
     * @return Pixel
     */
    Pixel asPixel(Point point, IFractalImage image);
}