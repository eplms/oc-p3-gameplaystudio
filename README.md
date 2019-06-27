# oc-p3-gameplaystudio

## Description
oc-p3-gameplaystudio est une application de jeu.
Elle permet de jouer à deux jeux :
- Mastermind
- Recherche +/-
Ces jeux sont accessibles dans 3 modes différents (Challenger / Défenseur / Duel )

## Compilation
Pour compiler avec maven, saisir la commande suivante le dossier dans lequel vous avez chargé le code source: mvn clean puis mvn install
 

Pour lancer le jeu, à partir du dossier dans lequel le code a été chargé, puis

- aller dans le dossier target en saisissant : cd target
- saisir ensuite :


 pour Linux/OS :    java -cp classes/:./lib/* com.oc.main.Main
	
 pour windows :     java -cp classes/;./lib/* com.oc.main.Main 

## Configuration
Le fichier config.properties permet d'avoir accès aux éléments configurables :
- La taille de la combinaison.
- Le nombre de tentatives autorisées.
- L'activation du mode développeur (affichage de la combinaison secrète en mode Defenseur et en mode Duel).

## Versions
Version 1.0

(oc-p3-gameplaystudio utilise la version 12 de Java.)

## Auteur
Emmanuel Plumas - Juin 2019
