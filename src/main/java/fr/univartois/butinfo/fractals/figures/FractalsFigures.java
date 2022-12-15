/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 marti
 * Tous droits r�serv�s.
 */

package fr.univartois.butinfo.fractals.figures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Le type FractalsFigures
 *
 * @author Martin Dylan
 *
 * @version 0.1.0
 */
public interface FractalsFigures extends IFigures {

    /**
     * @param fractal fractal
     * @param name name
     * @param width width
     * @param max max
     * @param couleur1 couleur1
     * @param couleur2 couleur2
     * @throws FileNotFoundException exception
     */
    public static void imageFigures(FractalsFigures fractal, String name, double width, double max, String couleur1, String couleur2) throws FileNotFoundException {
        try (PrintWriter file = ouvrirFichier(name)){
        	file.append("<?xml version=\"1.0\" standalone=\"no\"?> \n <svg width=\"" + width + "\" height=\"" + width + "\" background=\""+couleur1+"\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\"> ");
        	file.append(fractal.ajoutFigures(max, 0, 0, width, couleur1, couleur2));
        	file.append("</svg>");
        	file.flush();
        }
    }

    /**
     * @param name name
     * @return PrintWriter
     * @throws FileNotFoundException exception
     */
    public static PrintWriter ouvrirFichier(String name) throws FileNotFoundException {
        File f = new File("./" + name + ".svg");
        return new PrintWriter(f);
    }

    /**
     * @param max max
     * @param x x
     * @param y y
     * @param cote cote
     * @param couleur1 couleur1
     * @param couleur2 couleur2
     * @return String
     */
    abstract String ajoutFigures(double max, double x, double y, double cote, String couleur1, String couleur2);

}
