# Travaux Pratiques 9 : TP jeu de l'oie
**Binômes** : Crapez Mina et Kerman Nicolas

## Objectifs de ce TP
À travers une modélisation orientée objet, les objectifs de ce TP sont :

 * continuer d’apprendre à utiliser les paquetages
 * continuer d’apprendre à compiler nos classes et nos tests
 * continuer d'apprendre à exécuter nos programmes
 * continuer d'apprendre à rédiger et générer la documentation
 * continuer d'apprendre à rédiger des tests
 * continuer d'apprendre à utiliser les interfaces
 * continuer d'apprendre à utiliser l'héritage
 * apprendre à utiliser les classes abstraites

**Java** est requis pour pouvoir utiliser ce TP.

## Récupération du projet (git clone)
Vous pouvez **git clone** ce repository pour récupérer les fichiers de ce TP : 

```shell
git clone git@gitlab-etu.fil.univ-lille1.fr:crapez/crapez-kerman-poo.git
```  
Les fichiers concernés pour ce TP sont dans le dossier tp9. Les commandes ci-dessous seront à faire depuis le dossier *src* de tp9, sauf indication contraire.

## Générations des dossiers docs:
Dans le dossier **tp9/src** faire les commandes suivantes:
```shell
javadoc -d ../docs -subpackages goosegame
```

## Compilation des différentes classes 
Vous pouvez compliler les classes en utilisant les commandes suivantes : 
```shell
javac goosegame/*.java -d ../classes
```
pour compiler l'intégralité des classes. Les nouveaux fichiers seront redirigés dans le dossier classes.

## Compilation des classes de test
Vous devez utiliser le fichier jar **test4poo.jar** fourni pour pouvoir compiler les classes de test.
Pour les compiler, utilisez la commande ci-dessous à la racine du projet :
```shell
javac -classpath test4poo.jar test/goosegame/*.java
```
puis
```shell
javac -classpath test4poo.jar test/goosegame/cells/*.java
```

## Exécution des tests
Vous devez vous situer dans la racine du projet **tp9** pour utiliser ces commandes:
```shell
java -jar test4poo.jar goosegame.BasicBoardTest
java -jar test4poo.jar goosegame.GameTest
java -jar test4poo.jar goosegame.PlayerTest
java -jar test4poo.jar goosegame.cells.FirstCellTest
java -jar test4poo.jar goosegame.cells.GooseCellTest
java -jar test4poo.jar goosegame.cells.NormalCellTest
java -jar test4poo.jar goosegame.cells.TeleportCellTest
java -jar test4poo.jar goosegame.cells.TrapCellTest
java -jar test4poo.jar goosegame.cells.WaitingCellTest

```
Vous obtenez la "barre verte" synonyme de tests réussis.


## Exécution du programme principal (classe Main)
Ce programme contient une classe principale nommée GooseGameMain.
Pour l'exécuter, utilisez la commande ci-dessous dans le dossier **classes**:
```shell
java goosegame.GooseGameMain
```

## Création d'un jar exécutable
Vous devez vous situer dans le dossier **classes** pour utiliser cette commande:
```shell
jar cvfm ../goosegame.jar ../manifest-goosegame goosegame
```
Un fichier jar est apparu dans la racine du projet.


## Exécution du programme
Vous devez vous situer dans la racine du projet **tp9** pour utiliser cette commande:
```shell
java -jar goosegame.jar
```
Une partie de jeu de l'oie se lance.
