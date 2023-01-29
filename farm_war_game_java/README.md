l2s4-projet-2021



# Equipe

- Gaëlle Fret
- Nicolas Kerman
- Mina Crapez
- Jeanne Lauwers

# Sujet


[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)


# Ce qui a été ajouté au cahier des charges :

 - Une HumanStrategy a été créée afin de laisser aux joueurs la liberté de choisir leurs actions.
 - 2 nouvelles classes FarmGameMain2.java et WarGameMain2.java ont été créées, elles héritent de FarmGameMain.java et WarGameMain.java afin de rajouter notre HumanStrategy
  dans de nouveaux jar.
 - 2 nouveaux jar "agricole2.jar" et "guerre2.jar" permettent de lancer une partie où un choix entre une RandomStategy ou une HumanStrategy est proposé.

# Organisation des sources du projet :

Dans le package game :

 - Action.java
 - Board.java
 - Factory.java
 - FarmGameMain.java
 - Game.java
 - NPC.java
 - Player.java
 - Resources.java
 - Strategy.java
 - Tile.java
 - WalkingTile.java
 - WarGameMain.java

  - Dans la package actions :
   - DeployArmy.java
   - DeployFarmer.java
   - SkipYourTurnFarm.java
   - SkipYourTurnWar.java
   - ExchangeResourcesFarm.java
   - ExchangeResourcesWar.java

  - Dans le package boards :
   - BasicBoard.java

  - Dans le package character :
   - Army.java
   - Farmer.java


 - Dans le package factory :
   - FarmFactory.java
   - WarFactory.java

 - Dans le package games :
   - FarmGame.java
   - WarGame.java

 - Dans le package players :
   - FarmPlayer.java
   - WarPlayer.java

 - Dans le package resources :
   - Rock.java
   - Sand.java
   - Wheat.java
   - Wood.java


 - Dans le package Strategy :
   - HumanStrategy.java
   - HumanStrategyFarm.java
   - HumanStrategyWar.java
   - RandomStrategy.java
   - RandomStrategyWar.java
   - RandomStrategyFarm.java

 - Dans le package tile :
   - Desert.java
   - Forest.java
   - Grassland.java
   - Mountain.java
   - Ocean.java
   - TileExceptOcean.java

 - Dans le package util :
   - BusyTileException.java
   - NotEnoughFoodException.java
   - NotEnoughGoldException.java
   - NotEnoughStockException.java
   - Position.java
   - TooMuchSoldierException.java

   - Dans le package io :
    - Input.java





# Livrables


## Livrable 1

### Atteinte des objectifs

Modélisation des personnages :

Nous avons réfléchi à l'aspect global des jeux, en modélisant la plupart des classes qui nous seront nécessaires.
Nous avons modélisé les classes Army (personnage du jeu de guerre) et Farmer (personnage du jeu agricole) qui héritent d'une classe NPC (personnage non joueur).

Nous avons choisi que la classe Npc serait abstraite car il s'y trouve des méthodes comme collect() et destroy() (abstraites egalement) qui devront être codées
de différentes manières dans Farmer et Army.
De plus, cette configuration nous permmet de créer de nouveaux types de NPC si l'on veut complexifier nos modes de jeux ou rajouter des modes.

La classe abstraite NPC contient :
 - un attribut gold qui permettra de stocker l'argent gagné par les npc durant le jeu (le salaire pour les farmer ou l'argent gagné lorsqu'une aarmée remporte une bataille),
 - un attribut position qui permet de savoir sur quelle tuile se trouve un NPC,
 - un attribut player qui permmet de savoir à quel joueur appartient le NPC,

 - un constructeur,
 - les getter et setter des différents attributs,
 - une méthode collect() qui permet de récolter les ressources de la tuile sur laquelle le NPC est positionné,
 - une méthode destroy() qui permet de détruire le NPC si jamais le joueur ne peut lui payer de salaire (pour Farmer) ou ne peut le nourrir (pour Army).

La classe Army contient :
 - un attribut nbSoldiers, le nombre de soldats dans l'armée (de 0 à 5),

 - un constructeur,
 - le getter et setter de l'attribut,
 - une méthode decrease() qui permet de diviser par deux le nombre de soldats d'une armée si elle perd un combat,
 - une méthode compare(Army) qui permet de comparer la taille de deux armées en vue d'un combat,
 - les méthodes toString() et equals().

La classe Farmer contient :
 - un constructeur,
 - les méthodes equals() et toString().

### Difficultés restantes à résoudre

Les test ne sont pas exécutables tant que toutes les classes ne sont pas créées, nous n'avons donc pas pu tester notre code.



## Livrable 2

### Atteinte des objectifs

Modélisation du plateau :

Nous avons commencé à modéliser le plateau et les tuiles.

Nous avons commencé par modéliser les tuiles du plateau.
Pour cela nous avons construit une classe abstraite Tile, elle est donc mère de 5 autres classes.
Cest classes correspondent au différents types de terrains que nous allons rencontrer dans les jeux : Desert, Mountain, Ocean, Forest, Grassland.

Dans la classe Tile :
 - un attribut npc, le NPC présent sur la tuile,
 - un attribut maintainingCost, un entier nous permettant de savoir le coût d'entretien des npc en fonction des tuiles,
 - un attribut walking, un booléen qui est à True si la tuile est terrestre,

 - un constructeur,
 - les getter et setter des attributs,
 - une méthode maintain() qui permettra de nourrir ou de payer un npc.

Nous avons créé une enum WalkingTile qui nous permettra d'utiliser un random plus facilement sur les types de tuiles. En effet cette enum contient les Tile Forest, Grassland, Desert, Mountain.
De plus, cette enum nous permet aussi de construire les tuiles. Néanmoins nous ne sommes pas sûr de cette solution (cf la partie difficultés).

Dans les sous-classes Desert et Mountain, nous avons décidé de mettre un attribut MAX_SOLDIER, qui permet de modéliser les contraintes de la quantité de soldats d'une Army sur les cases.

Pour le plateau nous avons choisi de créer une classe abstraite Board contenant :
 - un attribut length pour la longueur du plateau,
 - un attribut width pour la largeur du plateau,
 - un attribut theTiles, une matrice des tuiles constituant le plateau,

 - un constructeur qui prend en paramètre la largeur et la hauteur du plateau,
 - les getter de width et length,
 - un getSize pour récupérer le nombre total de tuiles du plateau,
 - un getTile qui prend en paramètre des coordonnées i et j pour récupérer une tuile à une position donnée,
 - une méthode initBoard() qui est abstraite car elle sera différente suivant le type de Board que l'on voudra créer.

Nous avons créé une classe BasicBoard qui hérite de Board. Dans celle-ci nous nous allons créer une plateau aléatoirement comme indiqué dans le sujet. Néanmoins, nous pourrons toujours initialiser différemments d'autres plateaux par la suite.
Cette classe est composée de :
 - un attribut alea pour pouvoir choisir aléatoirement une tuile,

 - un constructeur qui prend les mêmes paramètres que Board,
 - une méthode randomTile() qui choisit une tuile aléatoire entre Desert, Forest, Mountain et Grassland,
 - une méthode randomTilePosition() qui choisit aléatoirement une position pour mettre une walkingTile,
 - une méthode isAlone(int, int) qui prend en paramètre des coordonnées et permet de vérifier si les cases autour de la nouvelle tuile placée sont toutes maritimes ou non,
 - une méthode getTileAround(int, int) qui renvoie une liste de toutes les positions des tuiles autour de la tuile nouvellement placée,
 - une méthode nextRandomTilePosition(List<List<int>>) qui renvoie une position aléatoire entre les cases adjacentes de la tuile nouvellement placée,
 - une méthode initBoard() : pour initialiser notre plateau, nous le remplissons d'abord de tuiles Ocean. Ensuite tant qu'il n'y a pas 1/3 des cases qui sont terrestres nous choisissons une case au hasard. Nous regardons autour si c'est la seule case terrestre parmi ses cases adjacentes. Si oui, nous choisissons une des 4 cases adjacentes aléatoirement et la remplaçons par une case terrestre. Sinon on rechoisit une case Ocean aléatoirement et on recommence le processus.


### Difficultés restantes à résoudre

Nous éprouvons des difficultés pour la création du board avec les tuiles en aléatoire.
Notre enum nous permet de choisir des tuiles aléatoirement plus facilement. Mais nous éprouvement des difficultés à concevoir comment construire les tuiles.

Il faut créer les exceptions si les tuiles ne rentrent pas dans le plateau et si une tuile est déjà entourée totalement de tuiles terrestres.



## Livrable 3

### Atteinte des objectifs

Modélisation des actions :

Nous avons modéliser une interface Action :
 - elle comporte 2 méthodes :
   -> dealActionFarm() : une methode pour executer l'action avec les règles du jeu d'agriculture.
   -> dealActionWar() : une methode pour executer l'action avec les règles du jeu de guerre.

3 classes implémentent cette interface :
 - DeployNPC :
   -> sa méthode dealActionFarm() : va permettre de déployer un farmer sur une case, donc rajouter le territoire sur lequel il est au joueur.
   -> sa methode dealActionWar() : va permettre de déployer une Army avec le nombre de soldat que le joueur souhaite, peut déclencher un combat si l'armée est placée à côté d'une armée ennemie.

 - SkipYourTurn :
   -> sa methode dealActionFarm() : donne de l'or au joueur en fonction des territoires qu'il possède.
   -> sa methode dealActionWar() : il passe simplement son tour.

 - ExchangeResources :
   -> sa methode dealActionFarm() : permet d'échanger les ressources qu'il possède contre de l'or (l'or gagné dépend du type des ressources).
   -> sa methode dealActionWar() : échange toutes les ressources (blé et bois) du joueur contre de la nourriture automatiquement.


### Difficultés éprouvées lors de ce livrable

- modélisation des actions en tant qu'interface, nous pensions juste créer des méthodes directement dans Game au début de notre réflexion.
--> Mr Routier nous a amené l'idée de créer une interface.


### Difficultés restantes à résoudre

- gérer le menu des actions dans Game, comment faire choisir au joueur quelle action il veut faire ?
 -> dépendra de la stratégie du joueur (classe encore non modélisée)





## Livrable 4

### Atteinte des objectifs

Modélisation complète:

Nous avons continué notre réflexion sur le code de la classe abstraite Game et nous lui avons créé 2 sous-classes: WarGame et FarmGame.
Ces classes contiennent les actions propres au jeu ainsi qu'une méthode "play()" servant à lancer la partie.

La classe abstraite Game est composée de:
 - un attribut nbTurns pour le nombre de tours dans la partie.
 - un attribut thePlayers étant la liste des joueurs.
 - un attribut board, le plateau de jeu.

 - un constructeur qui prend en paramètre un plateau de jeu.
 - les getter des attributs.
 - une méthode addPlayer(Player) permettant de rajouter un joueur à la partie.
 - une methode setNbTurns() pour mettre à jour le nombre de tour qu'il reste dans la partie.
 - une méthode play() pour lancer la partie.
 - une méthode allTerritoriesConquered() qui renvoie un booléen nous disant si tous les territoires sont conquis ou non.
 - une méthode abstraite maintain() permettant de donner le maintaining cost de nourriture ou d'or au NPC.
 - une méthode playOneRound(Player) qui nous permet de jouer un tour de la partie.
 - une méthode collectResources(Player) permettant de donner au joueur les ressources des tuiles sur lesquels ses NPC sont situés.
 - une méthode determineWinner permettant de définir le (ou les) gagnant(s) en fonction des critères du jeu.
 - une méthode abstraite getScores() qui renvoie la liste des scores des joueurs.
 - une méthode canSurvive() qui nous permet de savoir si le npc du joueur peut survivre.
 - une méthode abstraite getStock() qui permet de savoir si les joueurs ont assez de ressources pour leur npc.

La sous-classe WarGame est composée de:
 - un attribut static final DEATH_GOLD qui est l'or gagné par le joueur si une armée meurt.

 - un constructeur qui prend en paramètre le plateau de jeu.
 - une méthode deathMoney(Player) donnant le DEATH_GOLD au joueur si une de ses armées ne survie pas.
 - une méthode getStock() qui renvoie le stock en nourriture du joueur.
 - une méthode adjacentEnnemies(Tile) permettant de savoir si une armée est sur une tuile adjacente à la notre.
 - une méthode convertInFood(Resources) qui convertit les ressources en nourriture.
 - une méthode maintain() permettant de nourrir les armées.
 - une méthode fight(NPC, NPC) gérant un combat entre deux armées.
 - une méthode getScores() qui renvoie les scores des joueurs selon les règles du jeu de guerre.


La sous-classe FarmGame est composée de:
 - un constructeur qui prend un paramètre le plateau de jeu.
 - une méthode maintain() permettant de donner les salaires aux différents agriculteurs d'un joueur.
 - une méthode getStock() qui renvoie le stock de gold du joueur.
 - une méthode getScores() qui renvoie les scores des joueurs selon les règles du jeu d'agriculture.


Nous avons également continué de réfléchir à la modélisation du Player en lui ajoutant 2 sous-classes WarPlayer et FarmPlayer, symbolisant un joueur participant respectivement à un jeu de guerre ou d'agriculture.

La classe Player contient:
 - un attribut name représentant le nom du joueur.
 - un attribut gold représentant l'or du joueur.
 - un attribut nbResources qui est la liste des ressources du joueur.
 - un attribut territory, la liste des territoires du joueur.
 - un attribut strategy étant la stratégie du joueur.

 - un constructeur prenant en paramètre un nom et une stratégie.
 - les getter des attributs.
 - une méthode addGold(int) rajoutant une quantité d'or au player.
 - une méthode removeGold(int) enlevant de l'or au joueur.
 - une méthode addTerritory(TileExceptOcean) permettant de rajouter un territoire à un joueur.
 - une méthode removeTerritory(TileExceptOcean) permettant de retirer un territoire à un joueur.
 - une méthode addResources(Resources, int) qui ajoute une ressource donnée avec une quantité donnée à la liste de ressources du joueur.
 - une méthode removeResources(Resources) enlevant une ressource à un joueur.
 - une méthode equals().
 - une méthode toString().

La classe FarmPlayer héritant de la classe Player contient:
 - un constructeur prenant en paramètre un nom et une stratégie. Le constructeur donnera 15 de gold au FarmPlayer.

La classe WarPlayer héritant de la classe Player contient:
 - un attribut soldierStock représentant le nombre de soldats du Player.
 - un attribut foodStock représentant la quantité de nourriture possédée par le joueur.

 - un constructeur prenant en paramètre un nom et une stratégie. Un joueur du jeu de guerre commence avec 35 soldats en stock et 10 unités de nourriture en stock.
 - les getter de nos 2 nouveaux attributs.
 - une méthode removeFood(int) permettant d'enlever une quantité donnée de nourriture au joueur.
 - une méthode addFood(int) permettant d'ajouter une quantité donnée de nourriture au joueur.
 - une méthode removeSoldiers(int) enlevant les soldats déjà déployés au capital du joueur.

### Difficultés éprouvées lors de ce livrable

- Les tests sont plus difficiles à mettre en place comme nos méthodes sont plus complexes.
- Faire des oublis de méthodes peut arriver plus fréquemment comme nous utilisons énormément de classes différentes.
- Nous réalisons que nous avons des modifications dans la modélisation à faire (exemple: les ressources sont maintenant créées dans la factory), nous devons corriger notre code petit à petit sans rien oublier.

### Difficultés restantes à résoudre

- Nous devons finir de corriger notre code :
  - la méthode removeResources n'est pas au point.
  - les méthodes playOneRound dans WarGame et FarmGame non plus.



## Liens UML


https://lucid.app/lucidchart/invitations/accept/14739355-b8e0-4863-82df-0faa56605708


Modélisation des actions et des factory :

https://lucid.app/lucidchart/5b0cc126-a943-48e6-ba6a-1317e0f962ec/edit?page=0_0#

Nous avons choisi lucidchart pour pouvoir créer un document partagé et pouvoir tous le modifier en temps réel.



## Semaine 1

### L'UML

Nous avons relu le sujet ensemble et discuté des attentes.
Nous avous fait un premier jet sur la structure globale de l'UML :

 - Une classe abstraite NPC pour modéliser les personnages du jeu (car ils vont avoir des méthodes communes qui seront modélisées plus tard):
   - Un attribut position qui correspond à une tuile (pour savoir où est le npc sur le board)
   - Son constructeur
   - Un getPosition() et setPosition(Tile tile)

 - Des classes Farmer et Army qui héritent de NPC (correspondant aux deux unités possibles pour les deux modes de jeu) :
   - Leurs contructeurs
   - Un attribut en plus dans Army nbSoldiers (qui doit être entre 0 et 5)
   - getSize() pour récupérer le nombre de soldats
   - setNbSoldiers(int size) en cas de modification du nb de soldats
   - toString() et equals() pour les deux classes

 - Une classe Game vide
 - Une classe Player vide
 - Une classe abstraite Board
 - Une classe BasicBoard qui hérite de Board


### Remarques, notes et difficultés

Les tests sont difficiles voire impossibles à réaliser sans la modélisation des autres
classes.
Solution : Mr Routier nous a proposé de créer des classes fantômes pour quand même réaliser les tests même s'ils ne sont pas encore exécutables.

Nous avons également des plusieurs questions sur le fonctionnement et les règles du jeu :
 - Les règles sur le jeu de guerre : comment se passe un combat ? Nombre de guerriers inférieur à 1 pour récupérer la tuile ? Est-ce que le guerrier tout seul s'ajoute à l'armée ennemie ? ou constitue-t-il une nouvelle armée pour l'autre joueur ?
 - Est-ce que les choix des joueurs doivent-être aléatoire ?
 - Les ressources de nourrtires doivent-elles être stockées sur le joueur
 ou sur le npc ? même question pour le salaire du farmer ?
 - Comment gérer que le nombre de tours est différents dans les deux modes ?
 - Faut-il convertir les ressources dans l'immédiat ou c'est un choix du joueur ?




## Semaine 2


### L'UML

Nous avons légèrement modifié le diagramme UML grâce à l'avancement de notre réflexion :
 - Finalisation des classes NPC / Farmer / Army :
     ![UML](/images/UML_week2.png)

 - La classe Game est devenue une classe abstraite, on y a ajouté :
   - Un attribut nbTurns
   - Un attribut thePlayers : la liste des joueurs
   - un attribut board
   - Le   Dans le package boanous n'avons pas encore codé cette fonction, cela reste à faire.
 Dans le package games :

 Dans le package resource

 Dans le package tile :

 Dans le package util :constructeur
   - Les getter pour chaque attribut
   - Un addPlayer() pour les joueurs

 - Deux classes WarGame et FarmGame héritent de Game (Cela nous permet de gérer le nombre de tours changeants des différents modes et les autres règles propres à chaque jeu)

 - Modifications de la classe Player :
   - Un attribut name
   - Un attribut nbResources : une liste de liste (à revoir)
   - Le constructeur
   - les getter et les setter
   - les méthodes toString() et equals()

### Le code

Nous avons fini de coder selon notre UML les classes Farmer, Army et NPC.
Nous avons continué les tests mais éprouvons toujours des difficultés.

Les classes Player et Game sont commencées. Tests en cours également.

Nous avons aussi créé les classes fantômes décrites dans l'UML.

### Remarques, notes et difficultés

Nous n'avons pas encore coder la méthode collect() dans les NPC, nous ne savons toujours pas comment les ressources fonctionneront.

La méthode destroy() n'est pasnous n'avons pas encore codé cette fonction, cela reste à faire.réalisée non plus, on ne sait pas s'il faut totalement la supprimer ou s'il suffit de mettre l'armée à 0 soldat ou juste de faire disparaître le npc de la case.

### Réponses aux questions de la semaine dernière :

- Les règles sur le jeu de guerre : comment se passe un combat ? Nombre de guerriers inférieur à 1 pour récupérer la tuile ? Est-ce que le guerrier tout seul s'ajoute à l'armée ennemie ? ou constitue-t-il une nouvelle armée pour l'autre joueur ?
Solution : Le nombre de guerriers doit être inférieur à 1. Lors d'un combat, il y a division par deux (decrease()), on fait donc le choix d'arrondir à l'entier inférieur. Le joueur devient donc propriétaire de la tuile et gagne de l'argent lorsque l'armée ennemie n'a plus de soldats. On ajoute si possible 1 soldats à l'armée.

- Est-ce que les choix des joueurs doivent-être aléatoire ?
Solution : Oui, dans un premier temps tout doit être géré aléatoirement.

- Les ressources de nourrtires doivent-elles être stockées sur le joueur
ou sur le npc ? même question pour le salaire du farmer ?
Solution : Elles doivent être stockées sur le joueur.
https://lucid.app/lucidchart/invitations/accept/14739355-b8e0-4863-82df-0faa56605708

- Faut-il convertir les ressources dans l'immédiat ou c'est un choix du joueur ?
Solution : C'est un choix du joueur, il ne faut pas convertir les ressources tout de suite.



## Semaine 3

### L'UML
nous n'avons pas encore codé cette fonction, cela reste à faire.

### Le code

Après les remarques du professeur, nous avons fait quelques modifications sur certaines méthodes de farmer, army et npc comme par exemple : canSurvive() qui a été déplacé dans Game. De plus, on l'a divisé en deux méthodes : canSurvive renvoie juste un booléen et la méthode qui distribue la nourriture.

Nous avons ajouté un attribut maintainingCost dans les tuiles pour connaitre le nombre de nourriture et d'argent qu'il faut donner aux npc (cela dépend de la tuile où ils se trouvent). De plus, on a déplacé les méthodes correspondantes dans Tile (et avons ainsi pu supprimer les "instanceof" présents dans le code).

### Remarques, notes et difficultés

Nous avons eu des difficultés à trouver une méthode pour initialiser le board.
L'aléatoire nous pose des problèmes, on se sait pas comment choisir des tuiles aléatoirement en utilisant notre UML actuel.

Dans la classe Game, nous avons du mal à coder la méthode adjacent ennemies qui regarde s'il y a des armées enemmies sur les cases adjacentes à notre armée.



## Semaine 4

### L'UML

Nous avons complété la classe Board :
 - Les attributs Length et Width pour la taille du board
 - Un attribut theTiles qui est composé de toutes les tuiles du board (c'est une matrice)
 - Le constructeur et les getter de width et length
 - getSize() permet d'avoir le nb de tuiles total
 - getTile() permet de récupérer une tuile selon 2 coordonnées.

Nous avons complété la classe BasicBoard :
 - Un attribut alea de type random en attribut
 - Le constructeur
 - randomTile() qui choisit une tuile aléatoire dans notre enum.
 - randomTilePosition() qui choisit aléatoirement une position pour mettre une walking tile.
 - isAlone() pour savoir si la tuile est la seule terrestre autour d'elle.
 - getTileAround() pour récupérer les tuiles adjacentes dans une liste de liste (once again à revoir)
 - nextRandomTilePosition() qui choisit une tuile random parmi les tuiles adjacentes.

Nous avons modifié la classe Player :
 - nous avons ajouté un attribut territory qui est la liste des territoires que possèdent le joueur.
 - ajout getter et setter de cet attribut

![UML](/images/UML_week4.jpeg)

### Le code

Nous avons fait un premier jet pour les codes des classes Board et BasicBoard.
Pour cela, nous avons créé une énumération en plus pour les tuiles afin de gérer l'aléatoire.

Nous avons ajouté des package pour améliorer l'organisation de notre travail.

Nous avons fini les test des classes NPC Army et Farmer.

### Remarques, notes et difficultés

Le professeur nous as indiqué que les nouvelles tuiles ne pouvaient pas être construites directement dans l'énumération mais nous pouvons créer une interface Factory qui contiendra WarFactory et FarmFactory qui serviront à construire les tuiles.

Certaines méthodes de Basic Board se ressemblent beaucoup, c'est donc à revoir.
+ le code n'est pas très beau, il faut créer une nouvelle classe Position dans le package util qui correspond aux coordonnées des tuiles.

Nous n'avons pas encore codé la fonction maintain() de Tile et on ne sait pas encore comment relier les tuiles aux ressources.



## Semaine 5

### L'UML

Nous avons créé la classe Position et complété les petites méthodes dont nous avions besoin.
Nous avons créé l'interface TileFactory avec les classes WarFactory et FarmFactory qui l'implémentent. Ainsi que toutes les méthodes pour construire les tuiles.

![UML](/images/UML_week5.png)

### Le code

Tâches réalisées cette semaine :
 - PLayer : méthode removeGold() à modifier (créer une exception NotEnoughGoldException si le joueur n'a pas assez de gold d'argent  sur lui).
 - Supprimer WalkingTile et le remplacer par TileFactory pour les deux modes de jeu (méthode du prof).
 - WarGame/FarmGame : rajouter les static final pour le coût des tuiles. (géré par les factory)
 - Changer la flèche de Resources dans l'UML.
 - Créer un package util dans lequel mettre une classe Position qui contiendra les coordonnées des Tile.
 - BasicBoard : dans les méthodes isAlone() et getTileAround() : il faut remplacer les conditions par une boucle !
 - BasicBoard : le nom de la méthode nextRandomTilePosition() n'est pas clair il faut la renommer.
 - UML : y inscrire l'enum des WalkingTile.

### Remarques, notes et difficultés


Nous n'avons toujours pas codé la méthode collect(), maintain() et adjacentEnemies() pour les mêmes difficultés rencontrées précédemment.

WalkingTile et TileFactory à déplacer dans le package tile ?

Il faut ajouter une méthode convert() afin que le joueur puisse convertir ses ressouces en or ou en unité de nourriture.

Nous n'avons pas encore codé la fonction move() dans Game, cela reste à faire.



## Semaine 6


### L'UML

![UML](/images/UML_week6.png)

Nous avons ajouté la classe Position dans le package util, ainsi que les 3 exceptions que nous avons créé pour différentes classe.
Nous avons modifié BasicBoard car en ajoutant la classe position, des méthodes étaient à revoir.
La fonction maintain() a été déplacé dans la classe Game par soucis de responsabilité de cette méthode.



### Le code


Nous avons commencé à coder le début de TileTest et DesertTest. (Mina et Nico)
Nous avons modifié BasicBoard pour finir l'ajout de la classe position (Jeanne)
Nous avons fait les tests de BasicBoard (il manque deux méthodes à tester) (Jeanne Mina et Nico).
Nous avons ajouté un attribut typeOfResources (à enlerver car getRessources le fait tout seul et doit être surchargé dans chaque classe) et d'un getter dans tile pour faire un lien entre une tuile et sa ressource.

### Remarques, notes et difficultés


Nous avons oublié de créer une méthode qui distribue la nourriture ?

Il faut modifier getTile(int, int), isAlone(int, int), nextRandomTilePosition : DONE (List<List<int>>) dans la classe Board pour qu'elle prenne en paramètre une position : DONE

Il faut créer les exceptions si les tuiles ne rentrent pas dans le plateau et si une tuile est déjà entourée totalement de tuiles terrestres.

Il y a eu une rélexion sur où mettre la méthode maintain: elle a fini par être mise dans la classe Game. Il faudra la coder la prochaine fois.

Il faut mettre la méthode resourcesCollected() de Tile en abstraite et la coder dans les sous-classes de Tile pour créer un nouvel objet ressource à chaque fois. (c'est la méthode getResources())

Pour la prochaine fois, il faudra:
- coder maintain() qui doit être surchargé dans les deux types de game
- réfléchir à la modélisation des méthodes de Game (idée: faire une interface "action" qui agira en fonction du choix du joueur, il aura une sorte de menu et
en fonction de son choix l'interface permettra de lancer la bonne méthode)
- créer les classes fantômes des actions et réfléchir à toutes les actions possibles
- créer une liste d'actions possibles dans Game (menu)
- plusieurs stratégies du player (random, human)


## Semaine 7

### L'UML


![UML](/images/UML_week7.png)

Nous avons remis à jour l'UML après quelques petites modifcations :
 - un ajout d'un attribut position à Tile
 - getResources() renvoie maintenant un nouvel objet resources à chaque appel
 - une nouvelle classe TileExceptOcean mère des 4 tuiles terrestres : Mountain, Forest, Grassland, Desert
 - l'attribut nbSoldiers de Army a été supprimé au profit d'un attribut size dans la classe npc
 - une méthode accept dans TileExceptOcean qui est surchargée dans Mountain et dans Desert
 - une variable statique dans Mountain PERLIMPINPIN qui représente les soldats en plus que l'ennemi voit et son getter dans TileExceptOcean qui est surchargé dans Mountain.
 - Nous avons mis l'attribut position de l'army à null par défaut et ajouté une méthode qui vérifie si la case peut accepter cette armée et place l'armée sur la case si c'est le cas : deployment()
De plus, nous avons commencer à modéliser les actions :
 - on a ajouté une classe action abstraite/interface
 - une classe DeployNPC
 - une classe SkipYourTurn
 - une classe ExchangeResources



### Le code


Répartition des tâches :


- Mina & Nico :
 - Done : modifier la méthode isAlone() qui refait le travail de getTileAround()
 - Done : ajouter un attribut position à Tile (donc faire les modifs dans BasicBoard et Board)
 - Done : faire les tests de la methode deployment() dans Army
 - Done : test de resources
 - Done : UML mis à jour



- Gaëlle & Jeanne :
 - Done : test de BasicBoard à finir (un petit couac dans le test de getTileAround)
         - ajout d'une classe BoardForTest avec une surcharge de la methode initBoard() pour faire fonctionner les test sans utiliser l'aléatoire.
         - ajout d'une classe TileExceptOcean qui est mere de toutes les walkingTile pour la methode getResources en abstract

 - Done : test de Tile et des sous classes.

 - Done : ajouter une valeur à une ressource (ex : une ressource de blé vaut 5 de nourriture)

 - Done : enlever RessourcesCollected (attribut) et du coup ajouté dans chaque type de tuile une méthode getResources().

 - Done : modif UML.

 - Done : coder les resources : faire un equals et faire les docs.

 - Done : max soldiers à 3 sur montagne et desert (methode accecpt + getSize dans farmer donc dans npc en bastract) (ajouter dans le code et faire les tests)
    --> nous avons ajouté un attribut size à npc (et donc supprimé nbSoldiers dans Army) car pour gérer le fait que les montagnes et les deserts ne pouvaient accueillir qu'une armée de 3 soldats, la methode accept récupère la taille du npc.

 - Done : ajout d'un attribut perlimpinpin aux TileExceptOcean + une méthode getPerlimpinpinSize() qui sert à renvoyer la taille de l'armée que voit l'ennemie.

 - Done : une méthode deployment qui sert à deployer une armée sur une tuile (nous avons supprimé le param position du constructeur de Army en le mettant par défaut à null).

 - Done : une fiche "DeroulementDePartie" qui explique en language naturel comment se déroule une partie et un récapitulatif des règles.

 - Done : ajout d'un getter pour turnGold, cet attribut a été déplacé dans TileExceptOcean,
   la valeur de l'attribut est à 1 dans TileExceptOcean mais est surchargé à 0 dans Mountain, et à 2 dans Desert

 - Done : test des setter constructeur et getter de Army et Farmer




### Remarques, notes et difficultés

Jeanne et Gaëlle :

Problème : Nous n'avons pas réussi à coder le test de suppNpc() de la classe Tile car on ne peux apparemment pas donner la valeur null à la position. Il faudrait peut-être refaire le code de la méthode ?
--> Solution de M. Routier : Si la valeur dans l'assert vaut null il faut utiliser un assertNull et non un assertEquals.

Difficultés à écrire le code pour les contraintes des tuiles (3 soldats maximum sur les cases Desert et Montagne).
--> Solution de nous : Une méthode accept() dans TileExceptOcean qui est surchargé dans Mountain et Desert.

Les tests des getter et setter de NPC sont testés dans ArmyTest, faut-il les retester dans Farmer s'il n'y a pas de surcharge ?


Mina et Nico :

L'attribut position dans Tile est inutilisé, on récupère une Tile à partir de coordonnées mais pas l'inverse.

Comment tester des méthodes d'une classe abstraite ? Dans notre cas setter/getter.
--> Solution : les tester dans les classes Army et Farmer

Les sous-classes des tests de Resources sont à supprimer puisqu'aucune méthode n'est à tester.

Certaines méthodes abstraites board sont en protected et d'autres en public. Est-ce normal ?


## Semaine 8

### L'UML


![UML](/images/UML_week8.png)

![UML](/images/UML_Actions_week8.png)


Nous avons :
 - changé le nom de collect en collectResources() dans Game et ses sous classes.
 - ajouté un attribut soldiersStock dans Player ainsi que ses getter et setter.
 - ajouté l'attribut theActions dans Game.
 - rajouté les méthodes dealActionFarm() et dealActionWar() dans l'interface Action et les classes qui l'implémente.
 - supprimé collectedResources() dans FarmGame (nous la coderons dans Game et la surchargerons dans WarGame).
 - ajouté un attribut foodStock dans Player ainsi que ses getter et setter.
 - ajouté une méthode convertInFood() qui convertit les resources en nourriture.
 - mis maintain() en abstract dans Game et du coup ajouté dans WarGame et FarmGame.
 - ajouté une méthode allTerritoriesConquered() à la place de isFinished().
 - ajouté une méthode figth() à WarGame pour dérouler un combat.
 - ajouté une méthode determineTheWinner() abstraite dans Game.
 - ajouté une interface Strategy avec deux classes RandomStrategy et HumanStrategy

 - ajouté 2 classe FarmPlayer et WarPlayer : nous avons donc déplacé les attributs foodStock et soldiersStock dans WarPlayer ainsi que leurs getter et setter
 - ajout d'un attribut à collectResources()

onnant sa liste de Tile en "TileExceptOcean"
 - Changé la map des resources de player en liste
 - ajouté un paramètre position au constructeur de Tile et répercussion sur toutes les méthodes qui utilisent des Tile
 - ajouté un paramètre currentPlayer à deathMoney de WarGame
 - mis en public les méthodes non abstraites de Game afin de les tester.
 - ajouté 2 autres classes à strategy et une méthode chooseTheAction() pour choisir l'action en fonction de la stratégie.


### Le code

Partage des tâches :

 A 4 :
 - Un main par stratégie et mode de jeu

 Jeanne & Gaëlle :

   - Done : écrire toutes les signatures de méthodes / doc de chaque méthode de Game, WarGame, FarmGame, Player, Actions et ses trois sous classes.

   - Done : création des classes Strategy / HumanStrategy et RandomStrategy.

   - Done : livrable 3 du readMe refait.

   - Done : 2 classe FarmPlayer et WarPlayer modélisé dans l'UML.

   - Done : code de la classe Player & FarmPlayer & WarPlayer finis.

   - Done : code des classes WarGame et FarmGame :
        -> supression du parametre nbturns dans le constructeur de game qui est par défaut à 10 (le mmême que pour un jeu de guerre), cet attribut est surchargé dans FarmGame pour le mettre à 6.
        -> suppression de la méthode abstraite canSurvive de Game, 2 méthodes canSurvive restent présentes dans FarmGame (prend maintenant en paramètre un FarmPlayer) et WarGame (prend en paramètre un WarPlayer pour accéder à la méthode getFoodStock())
        -> changement du parametre de convertInFood en Player et ajout d'un paramètre Player à toutes les sous classes action.
        -> suppression de la méthode abstraite maintain() de Game, 2 méthodes maintain() restent présentes dans FarmGame (prend maintenant en paramètre un FarmPlayer) et WarGame (prend en paramètre un WarPlayer pour accéder à la méthode removeFood()).
        -> ajout d'une exception à la méthode removeFood() : NotEnoughFoodException
        -> ajout d'une methode getScores() en abstract dans Game et surcharge dans les deux sous classes. la méthode determineTheWinner() n'est plus en abstraite dans Game, mais renvoie directement le gagnant grace à la méthode ci-dessus.
        -> code de la methode fight() qui a engendré une modification de la méthode accept, le paramètre est donc devenu un Integer.
        -> supression de la méthode nextPlayer() car géré automatiquement dans playOneRound()
        -> play() n'est plus une méthode abstraite (donc supprimée dans WarGame et FarmGame)


  - Done : ajout d'un attribut dans TileExceptOcean nbPoints : le nombre de points que valent les tuiles lors du calcul du gagnant. Il est par défaut à 4 et est surchargé dans Grassland et Forest, on a ajouté un getter. + tests mis à jour.

  - Done : ajout de 2 attributs farmfactory et warFactory à TileExceptOcean, ainsi que deux getter et deux méthodes abstraites getResourcesOfWar() et getResourcesOdFarm().
    -> pour éviter les instanceof dans collectResources() de Game.
    -> nous avons égalment refait tous les tests anciens et nouveaux des tuiles.

  - Done : Un ajout d'une méthode equals() à position et modif des tests de tile (once again)

  - Done : ajout d'un getter pour strategy dans Player

  - Done : code et modélisation des stratégies.
    -> suprresion de l'attribit theActions des classes Game (tout est géré dans la strategie).




 Mina & Nico :

 - Done : début du livrable 4 du readme.

 - Done: changement de tileFactory en Factory, ajout de 4 méthodes de build pour chaque ressource ainsi que dans FarmFactory et WarFactory.

 - Done : mise à jour de PlayerTest avec quelques nouvelles méthodes.

 - Done : modification de Player à cause du changement de son attribut de type map en liste, les méthodes add et remove ont été modifiées principalement.

 - Done : les méthodes non abstraites de Game ont été mises en public pour pouvoir les tester et la méthode move à été retirée.

 - Done : paramètre currentPlayer ajouté à la méthode deathMoney de WarGame.

 - Done : ajout au constructeur de Tile l'initialisation de l'attribut position et donc modification de ses sous-classes, des factory ainsi que BasicBoard afin d'initialiser l'attribut position des tuiles.

 - Done : modification des tests pour prendre en compte la création de WarPlayer et FarmPlayer.

 - Done : tests de WarPlayer.

 - Done : ajout d'une méthode equals à Tile.





### Remarques, notes et difficultés

 Il faudra faire deux constructeurs pour Player (car initilisation des attributs diff)

 Jeanne & Gaëlle :

 Peut-on laisser le constructeur de WarFactory et celui de FarmFactory vide ?

 -> Solution : on peut laisser comme ça

 Nous avons supprimé canSurvive() et maintain(), 2 méthodes abstraites de Game, mais elles apparaissent dans les deux types de game avec un type de Player différent en paramètre. Existe-t-il une autre solution ?  
 -> Solution : canSurvive() à mettre dans la super classe, getFood() et getGold() peuvent etre reuni en getStock().

 Est ce que lorsqu'une armée en bat une autre totalement, le territoire revient au joueur alors qu'aucune armée ne sera dessus.
-> Solution, l'armée ne fusionne pas, elle change juste de propriétaire.

 La méthode PlayOneRound() utilise la méthode maintain(). Or, dans les deux jeux différents, elle déclenche une exception que faire pour gérer cela ? (à part enlever les méthodes play() et playOneRound() de Game).
 -> les deux méthodes sont quasi indentiques, rajouter le cast, la monter dans la classe mere en abstraite
 -> creer une nouvelle exception NotEnoughStockException et extends les deux autres exception de celle ci.

 -> la méthode removeResources() est à revoir !!


 Mina & Nico :

  Dans collectResource() de FarmGame il y a un problème avec une variable.
    -> Solution : ajout des factory au Tile pour créer la bonne ressource.

  Dans le test de  Game il est très difficile de coder le test de allTerritoriesConquered(), il faudrait créer un plateau et le parcourir sur les tuiles qui ne sont pas des océans: cela sera complexe.

  Nous avons réfléchi s'il fallait un currentPlayer ou pas. Nous en sommes arrivé à la conclusion que non.

  Nous nous demandons quelle armée détruire ou quel ouvrier retiré si nous ne pouvons pas tous les nourrir/payer.
   -> c'est à nous de chosiir, soit détruire les dernières armées soit supp une armée en fct du nb de soldats.

  Dans Player, y a t-il un paramètre int dans addResources ? Il y en a dans l'UML mais pas le code.
  Modification de allTerritoriesConquered de Game mais test non réussi, problème de cast
  Il faudrait mettre des méthodes equals et toString dans toutes les classes, il en manque.







## Semaine 9

### L'UML

![UML](/images/UML_week9.png)

![UML](/images/UML2_week9.png)


- Nous avons créé une méthode abstrait getStock() permettant de récupérer soit les resources de nourritures ou d'or du joueur :
  -> canSurvive() est donc devenu une méthode de Game qui ne doit plus être surchargée.
  -> cela a permis de faire de maintain() une méthode de Game qui ne doit pas être surchargée non plus dans les sous classes. (pour cela nous avons du aussi modifier les exceptions)
  -> De plus, cela a permis de créer une méthode playOneRound() unique dans Game, de même on ne doit plus la surcharger dans les 2 sous classes.

- Comme nous savons maintenant que lorsqu'une armée est vaincue, une armée de 1 soldat est formée sur une case, la méthode allTerritoriesConquered() est une méthode de Game sans surcharge également.

- remodélisation complète des stratégies (cf "le code")

- Changement de la méthode adjacentEnnemies() en adjacentArmies()
  -> création d'une méthode isAlly() pour savoir si l'armée adjacente est au joueur en train de joueur ou pas.

- Remodélisation des stratégies :
  -> ajout des méthodes getY(), getX() et getCoord() qui nous donne des coordonées aléatoire et choisi par le joeur en fonction des stratégies.
  -> un attribut Game et son getter pour pouvoir utiliser les méthodes des game associées.
  -> getText() qui affiche le text qui doit s'afficher à chaque fois qu'on doit choisir une action.
  -> une méthode choice() qui permet de choisir l'action en fonction de la strat.
  -> une méthode getSizeOfArmy() qui nous donne un nombre de soldats pour la création d'une armée.

- Actions :
  -> maintenant la méthode dealAction() prends en paraamètre la game en plus pour pouvoir accéder aux bonnes méthodes.

- méthode getSizeOfArmy renommée getSizeOfNpc afin d'être universelle quelque soit le jeu.



### Le code


 Jeanne & Gaëlle :

  - Done : getResourcesOfWar et getResourcesOfWar réunies dans une meme methode + ajout attribut factory à TileExceptOcean.

  - Done : correction des classes game : maintain() cast le player en warplayer et playOneRound() passe dans Game car identique dans les 2 sous-classes

  - Done : modifier les exceptions notenoughfood/gold/stock

  - Done : stratégies à simplifier, remodélisation complète

  - Done : refaire la méthode removeResources()

  - Done : correction de tous les tests de Tile et Npc (dû au changement de constructeur de Tile)

  - Done : toutes les documentations des classes Factory

  - Done : livrable 4 mis à jour et terminé.

  - Done : ajout d'un attribut name aux factory, des getter et setter + une méthode equals().

  - Done : coder les sous classes action pour le jeu de guerre :
    -> nous avons ajouté un param tile au constructeur de Army (il n'est plus à null par défaut)
    -> nous avons ajouté des méthodes aux classes strategy :
        - getCoord() qui récupère une tuile où nous devons placer notre npc
        - getX() qui nous donne la position horizontale de la tuile
        - getY() qui nous donne la position verticale de la tuile
        - getSizeOfArmy() qui nous renvoie la taille de l'armée que l'on veut déployer
    -> nous avons enlevé l'attribut theActions des stratégie pour le mettre dans Game.
    -> nous avons donc ajouté à la méthode dealAction() un paramètre game pour récupérer les actions possibles de cette partie.



 Mina & Nico :

  - Done : relire les tests de Player :
      -> .remove sur un objet de liste et non pas un index dans Player.removeResources()
      -> tests faits pour les méthodes qui lancent des exceptions
  - Done : codes de sous classe action pour le jeu de farm


### Remarques, notes et difficultés



## Semaine 10


### L'UML

![UML](/images/UML_week10.png)

![UML](/images/UML2_week10.png)


  - ajout attribut game aux Actions
  - correction des factory : ajout attribut name et ses méthodes
  - La methode getSizeOfArmy a été renommé en getSizeOfNpc
  - dernière remodélisation des actions : l'inter face est devenue une classe abstraite :
    -> ajout de l'attribut name, getter associé + une méthode equals()
  - correction des factory: ajout attribut name et ses méthodes
  - ajout méthode setFoodStock(int x) dans WarPlayer

### Le code

 A 4 :
 - vérifier l'uml ou le générer automatique (voir mail steph)


 Jeanne & Gaëlle :


  - Done : tests des classes Game & FarmGame
  - Done : tests des actions de farm
    -> création d'une stratégie spéciale pour les tests
    -> modif des system.out.print
  - Done : Un main par mode de jeu
  - En cours : méthodes toString() pour le display + display le board à chaque tour.



 Mina & Nico :

  - Done : tests des actions de war
  - Done : test de WarGame (revoir pour l'utilisation du board + getter liste d'Action)
  - Done : correction gameTest
  - Done : ajout d'une méthode setFoodStock(int) dans WarPlayer
  - Done: correction basicboard et Tile
  - Done: correction ExchangeResourcesFarmer et ExchangeResourcesWar, la boucle n'allait pas voir toutes les valeurs comme nous modifions la liste directement dans le for
  - Done: test de ExchangeResourcesWar fait
  - Done: ajout d'une méthode equals aux actions
  - Done: tous les tests écrits à ce jour fonctionnent.



### Remarques, notes et difficultés

 Mina & Nico :

  - test de SkipYourTurnWar inutile (c'est juste un system.out.println)
  - débat sur les méthodes equals des actions à faire
  - deployArmyTest se lance mais ne fait rien
    -> il y avait une armée de 5 pour une case desert
  - classes de test pour les sous-classes de ressource utile ? car on ne fait rien de plus que ce qu'il y a dans ressources

 Jeanne & Gaëlle  :

  - méthodes getX() et getY() redondantes dans les stratégies : à revoir.
  - livrable 4 : que faut-il mettre exactement ?


## Semaine 11

### L'UML

![UML](/images/UML_week11.png)

![UML](/images/UML2_week11.png)

### Le code

 Mina & Nico :

  - Dans Strategy, correction de l'affichage, du positionnement des NPC et du problème de collision

  - Correction d'affichage avec ajout d'espace et de mise à la ligne dans diverse fonctions d'affichage, affichage plus lisible pour le plateau et le choix des actions

  - Correction d'affichage, certains textes étaient en français

  - Correction de getSizeOfNpc() dans HumanStrategyWar: la méthode ne se relançait pas si une mauvaise valeur était rentrée par le joueur

  - ajout d'une méthode getTheListOfPlayer() dans WarGameMain et FarmerGameMain afin de gérer la demande du nombre de joueurs

  - Les tests de WarGame sont quasi finis, plus que le fight a tester, corrections de code

  - makefile terminé

  - modifications des mains pour pouvoir mettre les noms des joueurs en arguments

  - gitignore rajout du dossier docs



 Jeanne & Gaëlle :

 - Fin du debogage.

 - Méthode pour display le board.

 - Méthode pour display les fights de WarGame.

 - Toutes les javadocs ont été corrigées/complétées/crées !

 - Modifications mis dans la branche secondaire :
      --> correction des equals des factory et des actions.

      --> BasicBoard : l'attribut aléa a été passé en final.

      --> Elimination de toute la duplication du code dans les Factory !
            --> Factory est passée en classe abstraite.
            --> Ajout d'attributs dans Factory pour éliminer tous les doublons de méthodes : les valeurs de conversion des ressources.
            --> Modification du constructeur : il n'y a plus de paramètre cost.
            --> la méthode getName a été remontée.
            --> Méthode setName() inutile donc enlevée.

      --> La classe Resources passe en abstraite.

      --> Strategy : les méthodes getX() et getY() ont été remontées.

      --> Dans toutes les classes abstraites : les constructeurs ont été mis en protected quand ce n'était pas le cas.

      --> Beaucoup de corrections "bêtes" : optimisation de code, visibilité de certains attributs modifiés, erreurs dans des conditions, etc.

      --> Dans Strategy : modification des "throws Exception" par "throws IOException" dans plusieurs méthodes.

      --> Dans DeployArmy, la méthodes dealAction() a été séparée en deux méthodes parce qu'elle était trop grande.
          Maintenant il y a dealAction() et checkAdjacentArmies().

      --> Ajout de méthodes equals dans les TileExceptOcean.

      --> Tous les equals des Action ont été supprimés (parce que inutile).

      --> Dans BasicBoard, correction des conditions de getTileAround().

      --> Ajout d'un equals dans WarPlayer.

      --> Dans WarPlayer, setFoodStock() corrigée.



  - Modification du main pour le jeu de guerre :
      -->  à cause de ça les deux joueurs ne jouaient pas au même jeu donc pas sur le même plateau, ce qui créait tous les beugs apparents.

  - Tous les affichages ont été affinés (le display est plus propre et lisible sur la console)

  - La méthode removeResources() a été refaite.

  - playOneRound() corrigée pour éviter la répétion de code avec WarGame
      --> Nous avons modifié maintain pour que la conversion de nourriture se fasse en plus dans le jeu de guerre.

  - Il faudrait créer deux classes HumanStrategy et RandomStrategy (pour eviter la répétition de code)
      --> DONE : en attente de l'avis du prof


  - Supression des classes créées uniquement pour les tests (BoardForTest et StrategyForTest) car on peut mettre le code directement dans les tests.
      --> DONE

  - le equals() de Strategy a été créé

  - Relecture de tous les tests :
      --> les tests des factory sont faits
      --> les tests des ressources sont faits
      --> tout a été exécuté
      --> tests des Player Board et Npc refaits (il manquait quelques méthodes de tests + des corrections)
            --> ATTENTION aux assertEquals(..., true) , on fait un assertTrue dans ce cas et inversement.
      --> fin des tests de WarGameTest réalisée (fightTest) + tests de maintain() et suppNpc() refait (fin du debogage)

  - Relecture et mise à jour de tout l'UML

  - Faire des beaux affichages qui explique chaque phase du jeu
    --> les méthodes crées :
        - displayMaintain()
        - rulesOfVictory()
        - displayTerritories()
        - displayResources()
        - getInitialSituation()
        - displayWinner()
        - getReport()
        + toutes les toString() modifiées

  - Fichiers des uml par livrable (il faut remplacer l'uml final)

  - Tous les inputs sont maintenant gérés pour ne pas déclencher d'exceptions (try catch)







### Remarques, notes et difficultés

 Mina & Nico :

  - si on écrit un truc qui nest pas 0,1,2 ou dans le choix des coordonnees qui n'est pas un nombre :
    une exception arrete totalement le jeu : il faudrait mettre un catch qui dit "nan il faut ça comme type de valeur, recommence"  
      --> problème surement avec Input.java qui déclenche une exception, il faut surement ajouter ce try catch dans le getCoord() je pense

      --> DONE

  - Pour le jeu de Farm, pour savoir qui gagne on compte l'or des ouvriers uniquement ou on additionne l'or du joueur aussi ?
    -->  réponse de Jeanne : non juste celle de chaque ouvrier

  - l'or ne s'incrémente pas correctement lors d'un combat
    --> réponse de Jeanne : l'or s'incrémente bien à l'or de l'armée qui a gagné. Le joueur lui ne doit rien gagner.

  - parfois, le jeu de guerre demande la taille d'une armée avant ET après la demande des coordonnées
    --> réponse de Jeanne : c'est parce que la tuile sur laquelle le joueur veut poser son armée, ne peut accueillir autant de soldats que le premier choix.

  - gros problème dans fight, dis qu'un joueur gagne puis met son armée à 1
    --> solution de Jeanne : le display du fight n'était pas correct.

  - Parfois le fight du jeu de guerre se lance et parfois pas, à corriger
    --> solution de Mina : un fight ne se lançait pas lorsque l'armée posée était de taille supérieure à celle adjacente à cause d'une ligne de code, en l'enlevant le fight se lance


 Jeanne & Gaëlle :

 - Il faudrait peut-être créer un input pour que les joueurs puissent choisir la taille du plateau ? (je pense que c'est défini dans le sujet il me semble)
    --> réponse de Mina et Nico : Fait (il fallait un board de 10 par 10)


 - On pourrait ajouter une classe mère pour les deux main() pour éviter la duplication de code de getTheNbOfPlayers()  


## Semaine 12

### L'UML

  - Finalisation de l'uml :
    --> ajout des mains
    --> dernière relecture

### Le code

  - Corrections des docs (la fameuse &)
  - Création des jar :
    --> agricole.jar : jeu d'agriculture en random
    --> guerre.jar : jeu de guerre en random
    --> agricole2.jar : jeu d'agriculture où l'on choisit la strategy que l'on veut utiliser (possibilité d'y jouer)
    --> guerre2.jar : jeu de guerre et même chose que pour agricole2.jar



### Remarques, notes et difficultés

- Corrections du dernier bogue avec les territoires
