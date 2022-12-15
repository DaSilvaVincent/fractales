#!/bin/bash

DOSSIER=triangleSierpinski

if [ -d "$DOSSIER" ]; then
    echo "Le dossier existe ($DOSSIER)"
else
    echo "Le dossier n'existe pas ($DOSSIER). Il va être créé"
    mkdir $DOSSIER
fi

java -jar build/libs/projets-des-fractales-sae.jar -f "triangleSierpinski" -h 1000 -n 7 -o "$DOSSIER/triangleSierpinski" -p "bleu" -s 0 -w 1000 -x 0 -y 0
