#!/bin/bash

while getopts ":h:n:p:s:x:w:y:" option; do
    case "${option}" in
        h)
            h=${OPTARG}
            ;;
        n)
            n=${OPTARG}
            ;;
        p)
            p=${OPTARG}
            ;;
        s)
            s=${OPTARG}
            ;;
        x)
            x=${OPTARG}
	    ;;
        w)
            w=${OPTARG}
            ;;
        y)
            y=${OPTARG}
            ;;
    esac
done
shift $((OPTIND-1))
if [ -z "${h}" ] || [ -z "${n}" ] || [ -z "${p}" ] || [ -z "${s}" ] ||[ -z "${x}" ] ||[ -z "${w}" ] ||[ -z "${y}" ]; then
    echo "Il manque des arguments !"
    java -jar build/libs/projets-des-fractales-sae.jar --help
    exit
fi

DOSSIER=juliaGeneralise

if [ -d "$DOSSIER" ]; then
    echo "Le dossier existe ($DOSSIER)"
else
    echo "Le dossier n'existe pas ($DOSSIER). Il va être créé"
    mkdir $DOSSIER
fi
nb=0
for i in 20 40 60 80 100
do
    s=$((s+$i))
    java -jar build/libs/projets-des-fractales-sae.jar -f "juliaGeneralise" -h ${h} -n ${n} -o "$DOSSIER/juliaGeneralise-$((nb+=1))" -p ${p} -s ${s} -w ${w} -x ${x} -y ${y}
done
