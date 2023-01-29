# COO_rendu_groupe1


## Binôme :

  - Mina Crapez
  - Nicolas Kerman

## <u>Sujet :</u>

[Le sujet 2021](https://www.fil.univ-lille1.fr/~quinton/coo/projet/competitions.pdf)

Nous avons une compétition qui peut être de différents types : un tournoi, une ligue ou un master. Une compétition va être composée de plusieurs matchs entre nos compétiteurs, qui gagneront un point par match remporté. Une ligue, un tournoi et un master auront des spécificités différentes. 
A la fin de nos matchs, le résultat est affiché et un gagnant est désigné.

## Liens UML :

[UML](https://lucid.app/lucidchart/invitations/accept/inv_10b59468-2aa8-4800-aff1-385c14865742?viewport_loc=-11%2C-11%2C2663%2C1429%2C0_0)

Nous avons choisi lucidchart pour pouvoir créer un document partagé et pouvoir tous le modifier en temps réel.

## HowTo :

### <u>Pour récupérer le dépôt :</u>

```bash
git clone https://gitlab-etu.fil.univ-lille1.fr/crapez/coo_rendu_groupe1.git
```

### <u>Pour générer la documentation du projet :</u>

Dans le dossier *racine* entrer :
```bash
make doc
```
Nous avons une commande de Makefile produisant un dossier doc avec la documentation du projet.

### <u>Pour générer l'archvive du projet :</u>

Dans le dossier *racine* entrer :
```bash
make tournament
make league
make master
```
Nous avons une commande makefile pour produire chacune des 3 archives voulues dans un dossier jar.

### <u>Pour exécuter une archive :</u>

Dans le dossier *jar* entrer :
```bash
java -jar tournament.jar
java -jar league.jar
java -jar master.jar
```
Chacune de ces 3 commandes lancera une archive.

### <u> Pour les tests : </u>

Les tests unitaires ont été exécutés grâce à Eclipse et sont valides.
Nous avons bien utilisés Junit5 comme demandé dans la consigne.

## Livrable 1: 

### <u>UML du premier livrable:</u>

Voici notre UML après les premières semaines:

![capture](/images/livrable1.png)

Durant ce premier livrable nous avons codé:

 - Une classe **Competitor** représentant un compétiteur

 - Une classe **Match** représentant un match entre 2 compétiteurs (pour le moment le gagnant se fait de manière aléatoire, d'autres types de matchs pourraient être rajoutés)

 - Une classe **Compétition** en abstract représentant une compétition 

 - Une classe **Tournament** qui étend Compétition et représente un Tournoi

  - Une classe **League** qui étend Compétition et représente un Ligue

  - Une classe **LeagueMain**, le main d'une ligue

  - Une classe **TournamentMain**, le main d'un tournoi


Les différentes classes et leurs méthodes sont décrites dans l'UML ci-dessus. Les mains n'ont pas été mis dans l'UML.

### <u>Elements de code à retenir :</u>

  - Nous avons utilisé la notion de *tests abstraits* vue en cours afin de réaliser nos tests de Competition/League/Tournament afin d'éviter un maximum les répétitions de code.

  - Nous avons utilisé la méthode *sortByDescendingValue* de la classe MapUtil dans la méthode ranking de Competition afin de trier la map des différents compétiteurs et leur score.

  - Nous avons essayé d'utiliser au maximum des *sous-fonctions* comme notre fonction display de Competition ou dans nos mains par exemple.

### <u>Eléments de conception intéressants : </u>

  - Nous avons utilisé un attribut *currentPlayers* dans Tournament. En effet, dans Tournament lorsqu'un compétiteur perd il est éliminé et doit donc être "retiré" de la compétition. Cette liste évolue avec les résultats du jeu.

  - Competition est une *classe abstraite* et les classes League et Tournament étendent cette classe, ce qui permet la création d'autres types de compétition à l'avenir en respectant le *open-close principle*.

  - La classe Competition a pour attribut un seul match, un "type" de match pour notre compétition. Par conséquent jouer d'autres types de match dans une compétition peut se faire facilement.


## Livrable 2: 

### <u>UML du deuxième livrable :</u>

Voici notre UML après ajout de la classe Master et des classes de sélection:

![capture](/images/livrable2.jpeg)

Durant ce premier livrable nous avons codé:

- Une classe **Master** qui étend Compétiton et représente un Master

- Une classe **MasterMain**, le main d'un master

- Une classe **GlobalMain** regroupant les fonctions utilisés dans tous les mains afin d'éviter les répétitions de code

- Une interface **Selection** qui regroupera nos différentes classes de sélections permettant de sélectionner nos compétiteurs dans un master

- Une classe **SelectionFirsts** qui permettra de sélectionner les n premiers joueurs de chaque poule

- Une classe **SelectionLasts** qui permettra de sélectionner les n derniers joueurs de chaque poule

- Une classe **SelectionThirds** qui permettra de sélectionner les n meilleurs 3ème compétiteurs d'un master

Les différentes classes et leurs méthodes sont décrites dans l'UML juste au dessus. Les mains n'ont pas été mis dans l'UML.

### <u>Elements de code à retenir :</u>

  - Nous avons réussi a *créer une fonction de tri de liste en fonction de leur attribut*, cette méthode s'appelle sortGroups, elle a été placé dans MapUtil avec l'autre méthode de tri (celle sur les maps). Cette méthode nous a été très utile afin de trier les différents groupes de nos masters. Elle a été utilisé dans selectionThirds et dans playGroups, après avoir joué une league sur un groupe on trie les joueurs.

  - Nous avons utilisé *des listes de listes* dans Master, elles représentent nos différents groupe de compétiteurs. Ce n'était pas simple à coder par moments. Ce point peut également être un élément intéressant de conception.

  - Les exeptions de master ont été gérées dans la calsse MasterMain, nous n'avons donc pas de tests renvoyant d'exeptions.

### <u>Eléments de conception intéressants :</u>

  - Nous avons fait *une liste de sélecteurs* dans la classe Master pour gérer la multiplicité de sélecteurs.

  - Nous avons fait *une interface Selection* afin de pouvoir en rajouter facilement de nouvelles à l'avenir si besoin.

  - Nous avons modifié nos classes main afin d'avoir un *main "global"* contenant les fonctions utilisées dans les autres mains pour éviter la répétition de code. Cela sera très utile si d'autres types de compétitions sont créées à l'avenir.

  - Le problèmes de taille groupe étant des puissances de 2 après sélections a été géré dans le Master, master gère la création de groupe et donc aussi son équilibre en enlevant des joueurs si nous avons un problème.

  - Nous avons décider de faire 3 types de sélections, les n premiers, les n derniers et n meilleurs 3ème pour coller le plus possible à la réalité, à ce qui est effectué lors de vraies compétitions.


## Livrable 3: 

### <u>UML du deuxième livrable :</u>

Voici notre UML après ajout du package observer et ces différentes classes:

![capture](/images/livrable3.png)

Durant ce premier livrable nous avons codé:

- Une classe **MatchObserver** qui est une interface regroupant toutes les personnes observant une compétition

- Une classe **Journalist** représentant un journaliste observant notre compétition. Il donnera les résultats du match

- Une classe **Bookmaker** représentant un bookmaker observant notre compétition, il modifiera les cotes des compétiteurs en les observants.

Les différentes classes et leurs méthodes sont décrites dans l'UML ci-dessus.

### <u>Elements de code à retenir :</u>

  - Nous avons utilisé une map dans la classe **Bookmaker** afin d'associer à chaque compétiteurs sa cote.


### <u>Eléments de conception intéressants :</u>

  - Le principal élément de conception à retenir est l'utilisation du design pattern **observateur** décrit dans l'image si dessous :

![capture](/images/pattern.png)

  Notre classe *Observable* serait la classe **Compétition** (comme c'est ce qui est observé par les spectateurs), nos classes *ConcreteObservable* seront les classes **League**,**Master** et **Tournament**, notre interface *observer* serait notre classe *MatchObserver* et nos *ConcreteObserver* sont les classes **Journalist** et **Bookmaker**.