## Rendu v4 du TP Pong - Kerman Nicolas

La version réseau a été créée, avec toute la synchronisation nécessaire, les envois à l'autre client en passant par le serveur.

### How to :

Pour lancer le jeu, on se place dans le dossier client/ et on lance 
```
npm install
npm run build
```

Puis on se place dans le dossier serveur/ et on lance
```
npm install
npm run start
```

### Fonctionnement du jeu :

Le jeu ne peut se lancer que lorsque 2 clients sont connectés. Les joueurs sont avertis s'ils sont `Player 1` ou `Player 2`. Si un 3e joueur arrive, il est déconnecté et un message lui est envoyé.

Les raquettes sont synchronisées de 2 manières. Tout d'abord à chaque mouvement du paddle, l'autre client reçoit un message pour que son paddle2 entre en mouvement. Cela provoquait quelques dysfonctionnements lorsque la raquette était déplacée rapidement. Pour remédier à cela, j'ai envoyé la position y du paddle à l'autre client et mis à jour son paddle2 à chaque mouvement. La 2e synchronisation devrait être suffisante mais il était demandé à la base de mouvoir les paddles selon la 1ère méthode, je l'ai donc laissée.

La balle est synchronisée à chaque fois qu'elle rebondit sur une raquette, et chaque fois qu'elle atteint le millieu du canvas.