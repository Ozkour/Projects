all: doc guerre.jar agricole.jar guerre2.jar agricole2.jar

doc:
	mkdir docs; javadoc -classpath src -d ./docs -subpackages game game.actions game.boards game.character game.factory game.games game.util game.tile game.strategy game.resource game.players game.util.io

cls:
	mkdir classes; javac src/game/*.java -d ./classes -cp src

guerre.jar: cls
	mkdir jar; cd classes ; jar cvfm ../jar/guerre.jar ../manifest-war game;

agricole.jar: cls
	mkdir jar; cd classes ; jar cvfm ../jar/agricole.jar ../manifest-farm game;

guerre2.jar: cls
	mkdir jar; cd classes ; jar cvfm ../jar/guerre2.jar ../manifest-war2 game;

agricole2.jar: cls
	mkdir jar; cd classes ; jar cvfm ../jar/agricole2.jar ../manifest-farm2 game;


clean:
	rm -r docs classes -f jar/*.jar

.PHONY : all clean

