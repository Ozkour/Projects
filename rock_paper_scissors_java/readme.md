# Travaux Pratiques 7 : TP Pierre-Feuille-Ciseaux
**Binômes** : Crapez Mina et Kerman Nicolas

## Objectifs de ce TP
À travers une modélisation orientée objet, les objectifs de ce TP sont :

 * continuer d’apprendre à utiliser les paquetages
 * continuer d’apprendre à compiler nos classes et nos tests
 * continuer d'apprendre à exécuter nos programmes
 * continuer d'apprendre à rédiger et générer la documentation
 * continuer d'apprendre à rédiger des tests
 * continuer d'apprendre à utiliser les interfaces

**Java** est requis pour pouvoir utiliser ce TP.

## Récupération du projet (git clone)
Vous pouvez **git clone** ce repository pour récupérer les fichiers de ce TP : 

```shell
git clone git@gitlab-etu.fil.univ-lille1.fr:crapez/crapez-kerman-poo.git
```  
Les fichiers concernés pour ce TP sont dans le dossier tp7. Les commandes ci-dessous seront à faire depuis le dossier *src* de tp7, sauf indication contraire.

## Générations des dossiers docs:
Dans le dossier **tp7/src** faire les commandes suivantes:
```shell
javadoc -d ../docs -subpackages pfc
javadoc -d ../docs -subpackages util
```

## Compilation des différentes classes 
Vous pouvez compliler les classes en utilisant les commandes suivantes : 
```shell
javac util/*.java -d ../classes
javac pfc/*.java -d ../classes
```
pour compiler l'intégralité des classes. Les nouveaux fichiers seront redirigés dans le dossier classe.

## Compilation des classes de test
Vous devez utiliser le fichier jar **test4poo.jar** fourni pour pouvoir compiler les classes de test.
Pour les compiler, utilisez la commande ci-dessous à la racine du projet :
```shell
javac -classpath test4poo.jar test/*.java
```
## Exécution des tests
Vous devez vous situer dans la racine du projet **tp7\pfc** pour utiliser ces commandes:
```shell
java -jar test4poo.jar ChoiceTest
java -jar test4poo.jar GameTest
java -jar test4poo.jar PlayerTest
java -jar test4poo.jar AlternateStrategyTest
java -jar test4poo.jar PaperStrategyTest
java -jar test4poo.jar RockStrategyTest
java -jar test4poo.jar ScissorsStrategyTest

```
Vous obtenez la "barre verte" synonyme de tests réussis.


## Exécution du programme principal (classe Main)
Ce programme contient une classe principale nommée GameMain.
Pour l'exécuter, utilisez la commande ci-dessous dans le dossier **classes**:
```shell
java pfc.GameMain
```
Derrière cette commande vous pouvez rajouter des arguments successivement:
* le nombre de tour voulu *par défaut 10*
* le nom du joueur 1 *par défaut Pierre*
* le nom du joueur2 *par défaut Pepper*
* la strategy du joueur1 *par défaut RandomStrategy*
* la strategy du joueur2 *par défaut HumanStrategy*

**Si nous voulons ajouter une nouvelle stratégie nous n'avons pas à modifier le main! Il suffit simplement de créer une nouvelle classe dans le package pfc.strategy!**

## Création d'un jar exécutable
Vous devez vous situer dans le dossier **classes** pour utiliser cette commande:
```shell
jar cvfm ../pfc.jar ../manifest-game pfc
```
Un fichier jar est apparu dans la racine du projet.


## Exécution du programme
Vous devez vous situer dans la racine du projet **tp7\pfc** pour utiliser cette commande:
```shell
java -jar pfc.jar
```
Une partie se lance.
