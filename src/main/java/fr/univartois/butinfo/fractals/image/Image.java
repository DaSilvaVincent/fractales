/**
 * Ce fichier fait partie du projet projets-des-fractales-sae.
 *
 * (c) 2022 Vincent
 * Tous droits rï¿½servï¿½s.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.PlanComplex;
import fr.univartois.butinfo.fractals.complex.Point;
import fr.univartois.butinfo.fractals.complex.Translation;
import fr.univartois.butinfo.fractals.complex.Zoomer;
import fr.univartois.butinfo.fractals.figures.ArbreFractal;
import fr.univartois.butinfo.fractals.figures.FractalsFigures;
import fr.univartois.butinfo.fractals.figures.TapisSierpinski;
import fr.univartois.butinfo.fractals.figures.TapisSierpinskiGeneraliste;
import fr.univartois.butinfo.fractals.figures.TriangleSierpinski;
import fr.univartois.butinfo.fractals.suites.ChaotiqueIterator;
import fr.univartois.butinfo.fractals.suites.ComplexIterator;
import fr.univartois.butinfo.fractals.suites.ISuiteChaotiqueStrategy;
import fr.univartois.butinfo.fractals.suites.ISuiteComplexStrategy;
import fr.univartois.butinfo.fractals.suites.StrategieSuiteJulia;
import fr.univartois.butinfo.fractals.suites.StrategieSuiteMandelbrot;
import fr.univartois.butinfo.fractals.suites.SuiteCirculaire;
import fr.univartois.butinfo.fractals.suites.SuiteFeigenbaum;
import fr.univartois.butinfo.fractals.suites.SuiteGeneralisantJulia;
import fr.univartois.butinfo.fractals.suites.SuiteGeneralisantMandelbrot;

/**
 * Le type Image
 *
 * @author Dylan Martin, Vincent Da Silva, Thimothée Lepetz
 *
 * @version 0.1.0
 */
public class Image {

    /**
     * Crï¿½e une nouvelle instance de Image.
     */
    public Image() {
        super();
    }

    /**
     * L'attribut maxIt
     */
    private int maxIt;

    /**
     * L'attribut height
     */
    private int height;

    /**
     * L'attribut width
     */
    private int width;

    /**
     * L'attribut echelle
     */
    private double echelle;

    /**
     * L'attribut centre
     */
    private Point centre;

    /**
     * L'attribut suite
     */
    private ISuiteComplexStrategy suite;

    /**
     * L'attribut palette
     */
    private IPalette palette;

    /**
     * L'attribut nomFichier
     */
    private String nomFichier;

    /**
     * L'attribut planComplex
     */
    private PlanComplex planComplex;

    /**
     * L'attribut nbIt
     */
    private int nbIt;
    
    /**
     * L'attribut nomSuite
     */
    private String nomSuite;

    /**
     * Crï¿½e une nouvelle instance de Image.
     * 
     * @param builder builder
     */
    public Image(ImageBuilder builder) {
        this.setMaxIt(builder.getMaxIt());
        this.centre = builder.getCentre();
        this.echelle = builder.getEchelle();
        this.height = builder.getHeight();
        this.width = builder.getWidth();
        this.setSuite(builder.getStrategie());
        this.palette = builder.getPalette();
        this.nomFichier = builder.getNomFichier();
        this.planComplex = builder.getPlanComplex();
        this.setNbIt(builder.getNbIt());
        this.nomSuite = builder.getNomSuite();
    }
    
    /**
     * @param nbIt1 nbIt1
     * @throws IOException exception
     */
    public void generationImageJulia(int nbIt1) throws IOException{
        Zoomer plan = new Zoomer(planComplex, echelle);
        Translation plan2 = new Translation(plan, centre.asIComplex());
        IFractalImage image = new AdaptateurImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pixel = image.getPixel(y, x);
                IComplex z = plan2.asComplex(pixel.getRow(), pixel.getColumn());
                StrategieSuiteJulia suiteJulia = new StrategieSuiteJulia(nbIt1, z, new Complex(-0.4, 0.6));
                ComplexIterator iterator = new ComplexIterator(suiteJulia);
                while (iterator.hasNext()) {
                    iterator.next();
                }
                    pixel.setColor(palette.color(iterator.getI(), nbIt1));
            }
        }  
        image.saveAs(nomFichier);
    }
    
    /**
     * @param nbIt1 nbIt1
     * @throws IOException exception
     */
    public void generationImageMandelbrot(int nbIt1) throws IOException{
        Zoomer plan = new Zoomer(planComplex, echelle);
        Translation plan2 = new Translation(plan, centre.asIComplex());
        IFractalImage image = new AdaptateurImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pixel = image.getPixel(y, x);
                IComplex z = plan2.asComplex(pixel.getRow(), pixel.getColumn());
                StrategieSuiteMandelbrot suiteMandelbrot = new StrategieSuiteMandelbrot(nbIt1, z);
                ComplexIterator iterator = new ComplexIterator(suiteMandelbrot);
                while (iterator.hasNext()) {
                    iterator.next();
                }
                    pixel.setColor(palette.color(iterator.getI(), nbIt1));
            }
        }    
        image.saveAs(nomFichier);
    }
    
    /**
     * @param nbIt1 nbIt1
     * @throws IOException exception
     */
    public void generationImageJuliaGeneralise(int nbIt1) throws IOException{
        Zoomer plan = new Zoomer(planComplex, echelle);
        Translation plan2 = new Translation(plan, centre.asIComplex());
        IFractalImage image = new AdaptateurImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pixel = image.getPixel(y, x);
                IComplex z = plan2.asComplex(pixel.getRow(), pixel.getColumn());
                IComplex c = new Complex(-0.4, 0.6);
                SuiteGeneralisantJulia suiteJuliaGeneralise = new SuiteGeneralisantJulia(nbIt1, (a,b)->a.multiply(a).add(b) ,z , c);
                ComplexIterator iterator = new ComplexIterator(suiteJuliaGeneralise);
                while (iterator.hasNext()) {
                    iterator.next();
                }
                    pixel.setColor(palette.color(iterator.getI(), nbIt1));
            }
        }  
        image.saveAs(nomFichier);
    }
    
    /**
     * @param nbIt1 nbIt1
     * @throws IOException exception
     */
    public void generationImageMandelbrotGeneralise(int nbIt1) throws IOException{
        Zoomer plan = new Zoomer(planComplex, echelle);
        Translation plan2 = new Translation(plan, centre.asIComplex());
        IFractalImage image = new AdaptateurImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pixel = image.getPixel(y, x);
                IComplex z = plan2.asComplex(pixel.getRow(), pixel.getColumn());
                SuiteGeneralisantMandelbrot suiteMandelbrot = new SuiteGeneralisantMandelbrot(nbIt1, (a,b)->(a.multiply(a).add(a)).divide((z.multiply(z).multiply(z).add(b))) ,z);
                ComplexIterator iterator = new ComplexIterator(suiteMandelbrot);
                while (iterator.hasNext()) {
                    iterator.next();
                }
                    pixel.setColor(palette.color(iterator.getI(), nbIt1));
            }
        } 
        image.saveAs(nomFichier);
    }
    
    /**
     * @param plan4 plan4
     * @param image image
     * @param nbIt1 nbIt1
     * @param x x
     * @param y y
     */
    public void calculChaotiqueFeigenbaum(Translation plan4, IFractalImage image, int nbIt1, int x,int y) {
        Pixel pixel = image.getPixel(y, x);
        IComplex z = plan4.asComplex(pixel.getRow(), pixel.getColumn());

        ISuiteChaotiqueStrategy suiteFeigenbaum = new SuiteFeigenbaum(nbIt1,new Point(z));
        ChaotiqueIterator iterator = new ChaotiqueIterator(suiteFeigenbaum);
        
        int n = 0;
        int k = 0;
        double epsilon = 0.05;
        Point point = null;
        Point lastPoint = null;
        while (iterator.hasNext()) {
            point = iterator.next();
            if (n==0) {
                lastPoint = point;
            }
            if ((Math.abs(point.getY()-lastPoint.getY()))<epsilon && k<=10) {
                k++;
                if (k==10) {
                    break;
                }
            }
            else k=0;
            
            lastPoint = point;
            pixel = plan4.asPixel(point, image);
            n++;
            if(pixel!=null) {
                pixel.setColor(palette.color(n,nbIt1));
            }
        }
    }
    
    /**
     * @param plan4 plan4
     * @param image image
     * @param nbIt1 nbIt1
     * @param x x
     * @param y y
     */
    public void calculChaotiqueCirculaire(Zoomer plan4, IFractalImage image, int nbIt1, int x,int y) {
        Pixel pixel = image.getPixel(y, x);
        IComplex z = plan4.asComplex(pixel.getRow(), pixel.getColumn());

        ISuiteChaotiqueStrategy suiteCirculaire = new SuiteCirculaire(nbIt1,new Point(z));
        ChaotiqueIterator iterator = new ChaotiqueIterator(suiteCirculaire);
        
        int n = 0;
        int k = 0;
        double epsilon = 0.05;
        Point point = null;
        Point lastPoint = null;
        while (iterator.hasNext()) {
            point = iterator.next();
            if (n==0) {
                lastPoint = point;
            }
            if ((Math.abs(point.getY()-lastPoint.getY()))<epsilon && k<=10) {
                k++;
                if (k==10) {
                    break;
                }
            }
            else k=0;
            
            lastPoint = point;
            pixel = plan4.asPixel(point, image);
            n++;
            if(pixel!=null) {
                pixel.setColor(palette.color(n,nbIt1));
            }
        }
    }
    
    /**
     * @param nbIt1 nbIt1
     * @throws IOException exception
     */
    public void generationImageCirculaire(int nbIt1) throws IOException{
        Translation plan3 = new Translation(planComplex, centre.asIComplex());
        Zoomer plan4 = new Zoomer(plan3, echelle);
        IFractalImage image = new AdaptateurImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                calculChaotiqueCirculaire(plan4, image, nbIt1, x, y);

            }
        }
        image.saveAs(nomFichier);
    }
    
    /**
     * @param nbIt1 nbIt1
     * @throws IOException exception
     */
    public void generationImageFeigenbaum(int nbIt1) throws IOException{
        Zoomer plan3 = new Zoomer(planComplex, echelle);
        Translation plan4 = new Translation(plan3, centre.asIComplex());
        IFractalImage image = new AdaptateurImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                calculChaotiqueFeigenbaum(plan4, image, nbIt1, x, y);
            }
        }
        image.saveAs(nomFichier);
    }

    /**
     * @param nbIt1 nbIt
     * @throws IOException Exception
     * 
     */
    public void generationImage(int nbIt1) throws IOException {
        if (nomSuite.equals("julia")) {
            generationImageJulia(nbIt1);
        }
     
        else if (nomSuite.equals("mandelbrot")) {
            generationImageMandelbrot(nbIt1);
        }
        
        else if (nomSuite.equals("juliaGeneralise")) {
            generationImageJuliaGeneralise(nbIt1);
        }
        
        else if (nomSuite.equals("mandelbrotGeneralise")) {
            generationImageMandelbrotGeneralise(nbIt1);
        }
        
        else if (nomSuite.equals("circulaire")) {
            generationImageCirculaire(nbIt1);
        }
        
        else if (nomSuite.equals("feigenbaum")) {
            generationImageFeigenbaum(nbIt1);
        }
        
        else if (nomSuite.equals("tapisSierpinski")) {
            FractalsFigures.imageFigures(new TapisSierpinski(), nomFichier,width,nbIt1,"BLACK","PINK");
        }
        
        else if (nomSuite.equals("tapisSierpinskiGeneralise")) {
            FractalsFigures.imageFigures(new TapisSierpinskiGeneraliste(), nomFichier, width, nbIt1,"ORANGE","BLACK");
        }
        
        else if (nomSuite.equals("triangleSierpinski")) {
            FractalsFigures.imageFigures(new TriangleSierpinski(), nomFichier, width, nbIt1,"ORANGE","GREEN");
        }
        
        else if (nomSuite.equals("arbreFractal")) {
            FractalsFigures.imageFigures(new ArbreFractal(), nomFichier,width, nbIt1,"RED","");
        }
        else {
            System.err.println("mauvais nom de suite");
        }
    }

    /**
     * Donne l'attribut maxIt de cette instance de Image.
     *
     * @return L'attribut maxIt de cette instance de Image.
     */
    public int getMaxIt() {
        return maxIt;
    }

    /**
     * Modifie l'attribut maxIt de cette instance de Image.
     *
     * @param maxIt La nouvelle valeur de l'attribut maxIt pour cette instance de Image.
     */
    public void setMaxIt(int maxIt) {
        this.maxIt = maxIt;
    }

    /**
     * Donne l'attribut suite de cette instance de Image.
     *
     * @return L'attribut suite de cette instance de Image.
     */
    public ISuiteComplexStrategy getSuite() {
        return suite;
    }

    /**
     * Modifie l'attribut suite de cette instance de Image.
     *
     * @param suite La nouvelle valeur de l'attribut suite pour cette instance de Image.
     */
    public void setSuite(ISuiteComplexStrategy suite) {
        this.suite = suite;
    }

    /**
     * Donne l'attribut nbIt de cette instance de Image.
     *
     * @return L'attribut nbIt de cette instance de Image.
     */
    public int getNbIt() {
        return nbIt;
    }

    /**
     * Modifie l'attribut nbIt de cette instance de Image.
     *
     * @param nbIt La nouvelle valeur de l'attribut nbIt pour cette instance de Image.
     */
    public void setNbIt(int nbIt) {
        this.nbIt = nbIt;
    }

}
