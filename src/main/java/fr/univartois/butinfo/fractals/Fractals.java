/**
 * Ce logiciel est distribu� � des fins �ducatives.
 *
 * Il est fourni "tel quel", sans garantie d�aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualit� marchande, d�ad�quation
 * � un usage particulier et d�absence de contrefa�on.
 * En aucun cas, les auteurs ou titulaires du droit d�auteur ne seront
 * responsables de tout dommage, r�clamation ou autre responsabilit�, que ce
 * soit dans le cadre d�un contrat, d�un d�lit ou autre, en provenance de,
 * cons�cutif � ou en relation avec le logiciel ou son utilisation, ou avec
 * d�autres �l�ments du logiciel.
 *
 * (c) 2022 Romain Wallon - Universit� d'Artois.
 * Tous droits r�serv�s.
 */

package fr.univartois.butinfo.fractals;

import java.io.IOException;
import java.io.PrintWriter;
import fr.cril.cli.ClassParser;
import fr.cril.cli.CliArgsParser;
import fr.cril.cli.CliOptionDefinitionException;
import fr.cril.cli.CliUsageException;
import fr.cril.cli.annotations.Args;
import fr.cril.cli.annotations.Description;
import fr.cril.cli.annotations.LongName;
import fr.cril.cli.annotations.ShortName;
import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.PlanComplex;
import fr.univartois.butinfo.fractals.complex.Point;
import fr.univartois.butinfo.fractals.image.Image;
import fr.univartois.butinfo.fractals.image.ImageBuilder;
import fr.univartois.butinfo.fractals.image.PaletteBlanche;
import fr.univartois.butinfo.fractals.image.PaletteBleu;
import fr.univartois.butinfo.fractals.image.PaletteJaune;
import fr.univartois.butinfo.fractals.image.PaletteVerte;
import fr.univartois.butinfo.fractals.image.PaletteViolet;

/**
 * La classe Fractals permet de g�n�rer des fractales depuis la ligne de commande.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class Fractals {

    /**
     * L'option permettant d'afficher l'aide de l'application.
     */
    @LongName("help")
    @Description("Affiche l'aide du g�n�rateur de fractales.")
    @Args(0)
    private boolean help;

    /**
     * L'option sp�cifiant la largeur de l'image � g�n�rer.
     */
    @ShortName("w")
    @LongName("width")
    @Description("Sp�cifie la largeur de l'image � g�n�rer.")
    @Args(value = 1, names = "pixels")
    private int width;

    /**
     * L'option sp�cifiant la hauteur de l'image � g�n�rer.
     */
    @ShortName("h")
    @LongName("height")
    @Description("Sp�cifie la hauteur de l'image � g�n�rer.")
    @Args(value = 1, names = "pixels")
    private int height;

    /**
     * L'option sp�cifiant l'�chelle � appliquer sur l'image.
     */
    @ShortName("s")
    @LongName("scale")
    @Description("Sp�cifie l'�chelle � appliquer sur l'image.")
    @Args(value = 1, names = "ratio")
    private String scaleString;

    /**
     * L'�chelle � appliquer sur l'image.
     */
    private double scale;

    /**
     * L'option sp�cifiant le point central de l'image sur l'axe des abscisses.
     */
    @ShortName("x")
    @LongName("focus-x")
    @Description("Sp�cifie le point central de l'image sur l'axe des abscisses.")
    @Args(value = 1, names = "real")
    private String focusXString;

    /**
     * Le point central de l'image sur l'axe des abscisses.
     */
    private double focusX;

    /**
     * L'option sp�cifiant le point central de l'image sur l'axe des ordonn�es.
     */
    @ShortName("y")
    @LongName("focus-y")
    @Description("Sp�cifie le point central de l'image sur l'axe des ordonn�es.")
    @Args(value = 1, names = "real")
    private String focusYString;

    /**
     * Le point central de l'image sur l'axe des ordonn�es.
     */
    private double focusY;

    /**
     * L'option sp�cifiant le nom de la fractale � g�n�rer.
     */
    @ShortName("f")
    @LongName("fractal-name")
    @Description("Sp�cifie le nom de la fractale � g�n�rer.")
    @Args(value = 1, names = "name")
    private String fractaleName;

    /**
     * L'option sp�cifiant le nombre d'it�rations � appliquer pour g�n�rer la fractale.
     */
    @ShortName("n")
    @LongName("nb-iterations")
    @Description("Sp�cifie le nombre d'it�rations � appliquer pour g�n�rer la fractale.")
    @Args(value = 1, names = "integer")
    private int nbIterations;

    /**
     * L'option sp�cifiant le nom de la palette de couleurs � appliquer lors de la g�n�ration.
     */
    @ShortName("p")
    @LongName("palette-name")
    @Description("Sp�cifie le nom de la palette de couleurs � appliquer lors de la g�n�ration.")
    @Args(value = 1, names = "name")
    private String paletteName;

    /**
     * L'option sp�cifiant le nom du fichier dans lequel la fractale doit �tre sauvegard�e.
     */
    @ShortName("o")
    @LongName("output")
    @Description("Sp�cifie le nom du fichier dans lequel la fractale doit �tre sauvegard�e.")
    @Args(value = 1, names = "file")
    private String outputFile;

    /**
     * L'instance de {@link ClassParser} permettant de lire les arguments de la
     * ligne de commande pour initialiser les attributs de cet objet.
     */
    private final ClassParser<Fractals> classParser = new ClassParser<>(Fractals.class);

    /**
     * Emp�che de cr�er une instance de Fractals en dehors de cette classe.
     */
    private Fractals() {
        // On ne fait rien ici.
    }

    /**
     * Lit les arguments donn�s dans la ligne de commande.
     *
     * @param args Les arguments de la ligne de commande.
     */
    private void parseCliArguments(String[] args) {
        var argsParser = new CliArgsParser<>(classParser);

        try {
            argsParser.parse(this, args);

            if (help) {
                // Si l'aide est demand�e, on affiche l'usage et on termine.
                usage();
                System.exit(0);
            }

            scale = Double.parseDouble(scaleString);
            focusX = Double.parseDouble(focusXString);
            focusY = Double.parseDouble(focusYString);

        } catch (CliUsageException | CliOptionDefinitionException e) {
            usage();
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Affiche l'usage de l'application sur la sortie standard des erreurs.
     */
    public void usage() {
        System.err.println("gradle run --args='[options]'");
        System.err.println("java -jar <chemin/vers/le/jar> [options]");
        classParser.printOptionUsage(new PrintWriter(System.err));
    }


    /**
     * Crée la fractale demandée dans la ligne de commande.
     * @throws IOException Exception
     */
    public void buildFractal() throws IOException {
            ImageBuilder builder = new ImageBuilder();
            builder.setCentre(new Point(new Complex(focusX,focusY)));
            builder.setEchelle(1./scale);
            builder.setMaxIt(nbIterations);
            builder.setHeight(height);
            builder.setWidth(width);
            builder.setNomFichier(outputFile);
            builder.setNomSuite(fractaleName);
            if (paletteName.equals("bleu"))
                builder.setPalette(new PaletteBleu());
            else if (paletteName.equals("verte"))
                builder.setPalette(new PaletteVerte());
            else if (paletteName.equals("violet"))
                builder.setPalette(new PaletteViolet());
            else if (paletteName.equals("blanche"))
                builder.setPalette(new PaletteBlanche());
            else if (paletteName.equals("jaune"))
                builder.setPalette(new PaletteJaune());
            else
                System.err.println("Mauvaise couleur");
            builder.setPlanComplex(new PlanComplex(builder.getHeight(),builder.getWidth()));
            new Image(builder).generationImage(builder.getMaxIt());
        }

    /**
     * Ex�cute l'application depuis la ligne de commande.
     *
     * @param args Les arguments de la ligne de commande.
     * @throws IOException Exception
     */
    public static void main(String[] args) throws IOException {
        Fractals fractals = new Fractals();
        fractals.parseCliArguments(args);
        fractals.buildFractal();
    }


}
