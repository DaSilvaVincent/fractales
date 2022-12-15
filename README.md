# Autour des Fractales

## Description

Ce projet fournit une implantation de base pour votre projet de SAÉ S3.A.01.
Pour pouvoir développer votre propre implantation de ce projet, vous devez
en créer une **divergence** en cliquant sur le bouton `Fork` en haut à droite
de cette page.

Lorsque ce sera fait, vous pourrez inviter les membres de votre groupe en tant
que *Developer* pour vous permettre de travailler ensemble sur ce projet.

## Exécution

Pour exécuter l'application, vous pouvez exécuter la tâche `run` de *Gradle*.
Afin de vous permettre de facilement contrôler la création des fractales depuis
la ligne de commande, la classe `fr.univartois.butinfo.fractals.Fractals` (qui
définit la méthode `main`) gère déjà pour vous les arguments de cette ligne
de commande (les options données sont stockées dans les attributs de cette
classe).
Vous pouvez en particulier l'exécuter à l'aide des options suivantes :

```
-f,--fractal-name  <name>      Spécifie le nom de la fractale à générer.
-h,--height        <pixels>    Spécifie la hauteur de l'image à générer.
-n,--nb-iterations <integer>   Spécifie le nombre d'itérations à appliquer pour générer la fractale.
-o,--output        <file>      Spécifie le nom du fichier dans lequel la fractale doit être sauvegardée.
-p,--palette-name  <name>      Spécifie le nom de la palette de couleurs à appliquer lors de la génération.
-s,--scale         <ratio>     Spécifie l'échelle à appliquer sur l'image.
-w,--width         <pixels>    Spécifie la largeur de l'image à générer.
-x,--focus-x       <real>      Spécifie le point central de l'image sur l'axe des abscisses.
-y,--focus-y       <real>      Spécifie le point central de l'image sur l'axe des ordonnées.
```

Évidemment, vous devrez compléter la classe `Fractals` pour qu'il se passe
quelque chose lors de l'exécution !

## JAR exécutable

Vous avez également la possibilité de générer un JAR à l'aide de *Gradle*, en
exécutant la tâche `jar`.
Ce JAR constitue un exécutable que vous pouvez facilement distribuer, et que
vous pouvez exécuter de la manière suivante :

```bash
java -jar build/libs/sae-2022-2023.jar --help
```

Les options acceptées par ce JAR sont les mêmes que celles décrites dans la
section précédente.

```plantuml
@startuml
package "fr.univartois.butinfo.fractals" #DDDDDD {
  class Fractals
}

package "fr.univartois.butinfo.fractals.complex" #DDDDDD {
  class Complex
  interface IComplex
  interface IPlanComplex
  class PlanComplex
  class Point
  class Translation
  class Zoomer
}

package "fr.univartois.butinfo.fractals.figures" #DDDDDD {
  class ArbreFractal
  class Carre
  class Cercle
  abstract FractalsFigures
  interface IFigures
  class Ligne
  class PlusieursFigures
  class Rectangle
  class RotationFigure
  class TapisSierpinski
  class TapisSierpinskiGeneraliste
  class TranslationFigure
  class Triangle
  class TriangleSierpinski
}

package "fr.univartois.butinfo.fractals.image" #DDDDDD {
  class AdaptateurImage
  abstract CouleurDecorateur
  interface IFractalImage
  class Image
  class ImageBuilder
  interface IPalette
  class MasqueDecorateurB
  class MasqueDecorateurG
  class MasqueDecorateurR
  class PaletteBlanche
  class PaletteBleu
  class PaletteJaune
  class PaletteVerte
  class PaletteViolet
  class Pixel
}

package "fr.univartois.butinfo.fractals.suites" #DDDDDD {
  class ChaotiqueIterator
  class ComplexIterator
  interface ISuite
  interface ISuiteChaotiqueStrategy
  interface ISuiteComplexStrategy
  class StrategieSuiteJulia
  class StrategieSuiteMandelbrot
  class SuiteChaotique
  class SuiteCirculaire
  class SuiteComplex
  class SuiteFeigenbaum
  class SuiteGeneralisantJulia
  class SuiteGeneralisantMandelbrot
  interface Iterator
  interface Iterable
}

class StrategieSuiteJulia extends SuiteComplex implements ISuiteComplexStrategy
class Complex implements IComplex
class PlanComplex implements IPlanComplex
class Translation extends PlanComplex
class Zoomer extends PlanComplex
class ArbreFractal implements FractalsFigures
class Carre extends Rectangle
class Cercle implements IFigures
interface FractalsFigures extends IFigures
class Ligne implements IFigures
class PlusieursFigures implements IFigures
class Rectangle implements IFigures
class RotationFigure implements IFigures
class TapisSierpinski implements FractalsFigures
class TapisSierpinskiGeneraliste implements FractalsFigures
class TranslationFigure implements IFigures
class Triangle implements IFigures
class TriangleSierpinski implements FractalsFigures
class AdaptateurImage implements IFractalImage
abstract class CouleurDecorateur implements IPalette
class MasqueDecorateurB extends CouleurDecorateur
class MasqueDecorateurG extends CouleurDecorateur
class MasqueDecorateurR extends CouleurDecorateur
class PaletteBlanche implements IPalette
class PaletteBleu implements IPalette
class PaletteJaune implements IPalette
class PaletteVerte implements IPalette
class PaletteViolet implements IPalette
class ChaotiqueIterator implements Iterator
class ComplexIterator implements Iterator
interface ISuiteComplexStrategy extends Iterable, ISuite
class StrategieSuiteJulia extends SuiteComplex implements ISuiteComplexStrategy
class StrategieSuiteMandelbrot extends SuiteComplex implements ISuiteComplexStrategy
class SuiteChaotique implements ISuiteChaotiqueStrategy
class SuiteCirculaire extends SuiteChaotique implements ISuiteChaotiqueStrategy
class SuiteComplex implements ISuiteComplexStrategy
class SuiteFeigenbaum extends SuiteChaotique implements ISuiteChaotiqueStrategy
class SuiteGeneralisantJulia extends SuiteComplex implements ISuiteComplexStrategy
class SuiteGeneralisantMandelbrot extends SuiteComplex implements ISuiteComplexStrategy

IPlanComplex --* PlanComplex : decorated

ComplexIterator --> SuiteComplex : "uses"
SuiteComplex --> ComplexIterator : "creates"

IPalette --* CouleurDecorateur : decorated

Point --* Complex : adaptee

AdaptateurImage *-- ImageBuilder : adaptee

IFractalImage --* ImageBuilder : builder
AdaptateurImage --> Image : "construit"

IFigures --o PlusieursFigures : children

Image *-- ISuiteComplexStrategy : strategy

Image *-- IPalette : strategy

Image *-- IFigures : strategy
@enduml
```