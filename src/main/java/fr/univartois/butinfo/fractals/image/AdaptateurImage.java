/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Le type AdaptateurImage
 *
 * @author Dylan Martin
 *
 * @version 0.1.0
 */
public class AdaptateurImage implements IFractalImage {

    /**
     * L'attribut buffered
     */
    private BufferedImage buffered;

    /**
     * Crée une nouvelle instance de AdaptateurImage.
     * @param buffered buffered
     * 
     */
    public AdaptateurImage(BufferedImage buffered) {
        this.buffered = buffered;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#getHeight()
     */
    @Override
    public int getHeight() {
        return buffered.getHeight();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#getWidth()
     */
    @Override
    public int getWidth() {
        return buffered.getWidth();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#getPixel(int, int)
     */
    @Override
    public Pixel getPixel(int row, int column) {
        return new Pixel(this, row, column);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#setColor(int, int,
     * java.awt.Color)
     */
    @Override
    public void setColor(int row, int column, Color color) {
        int c = color.getRGB();
        buffered.setRGB(row, column, c);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#saveAs(java.lang.String)
     */
    @Override
    public void saveAs(String path) throws IOException {
        System.out.println("save "+path);
        ImageIO.write(buffered, "png", new File(path+".png"));
    }

}
