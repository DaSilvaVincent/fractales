/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.Color;

/**
 * La classe Pixel permet d'accéder facilment à un pixel d'une image afin de pouvoir en
 * calculer la couleur.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class Pixel {

    /**
     * L'image dont ce pixel est extrait.
     */
    private final IFractalImage image;

    /**
     * La ligne de l'image où se trouve ce pixel.
     */
    private final int row;

    /**
     * La colonne de l'image où se trouve ce pixel.
     */
    private final int column;

    /**
     * Crée une nouvelle instance de Pixel.
     *
     * @param image L'image dont le pixel est extrait.
     * @param row La ligne de l'image où se trouve le pixel.
     * @param column La colonne de l'image où se trouve le pixel.
     */
    public Pixel(IFractalImage image, int row, int column) {
        this.image = image;
        this.row = row;
        this.column = column;
    }

    /**
     * Donne la ligne de l'image où se trouve ce pixel.
     *
     * @return La ligne de l'image où se trouve ce pixel.
     */
    public int getRow() {
        return row;
    }

    /**
     * Donne la colonne de l'image où se trouve ce pixel.
     *
     * @return La colonne de l'image où se trouve ce pixel.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Donne l'image à laquelle appartient ce pixel.
     *
     * @return L'image à laquelle appartient ce pixel.
     */
    public IFractalImage getImage() {
        return image;
    }

    /**
     * Modifie la couleur de ce pixel.
     *
     * @param color La nouvelle couleur pour ce pixel.
     */
    public void setColor(Color color) {
        image.setColor(column, row, color);
    }

}
