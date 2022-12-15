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
 * @author Dylan Martin, Thimothée Lepetz
 *
 * @version 0.1.0
 */
public class PlanComplex implements IPlanComplex {

    /**
     * L'attribut height
     */
    private double height;

    /**
     * L'attribut width
     */
    private double width;

    /**
     * Crée une nouvelle instance de PlanComplex.
     * 
     * @param height height
     * @param width width
     */
    public PlanComplex(double height, double width) {
        this.height = height;
        this.width = width;
    }

    /**
     * Donne l'attribut height de cette instance de PlanComplex.
     *
     * @return L'attribut height de cette instance de PlanComplex.
     */
    @Override
    public double getHeight() {
        return height;
    }

    /**
     * Donne l'attribut width de cette instance de PlanComplex.
     *
     * @return L'attribut width de cette instance de PlanComplex.
     */
    @Override
    public double getWidth() {
        return width;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPlanComplex#asComplex(int, int)
     */
    @Override
    public IComplex asComplex(int row, int column) {
        double re = (column + .5) - (width / 2.);
        double im = (height / 2.) - (row + .5);
        return new Complex(re, im);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPlanComplex#asPixel(fr.univartois.butinfo.fractals.complex.IComplex)
     */
    @Override
    public Pixel asPixel(IComplex complex, IFractalImage image) {
        int x= (int) (complex.getRealPart() - .5 + (width / 2.));
        int y= (int) ((height / 2.) - .5 - complex.getImaginaryPart());
        if (x>=image.getWidth() || y>=image.getHeight()) 
            return null;
        if (x<0|| y<0) 
            return null;
        return new Pixel(image,y,x);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPlanComplex#asPixel(fr.univartois.butinfo.fractals.image.Pixel)
     */
    @Override
    public Pixel asPixel(Point point, IFractalImage image) {
        int x= (int) (point.getX() - .5 + (width / 2.));
        int y= (int) ((height / 2.) - .5 - point.getY());
        if (x>=image.getWidth() || y>=image.getHeight()) 
            return null;
        if (x<0|| y<0) 
            return null;
        return new Pixel(image,y,x);
    }
    
}
