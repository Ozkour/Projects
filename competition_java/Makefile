all: doc tournament league master

doc:
	cd src;javadoc -subpackages competition util -d ../docs;

classes:
	rm -rf classes;mkdir classes

cls: classes
	cd src;javac */*.java */*/*.java -d ../classes;

tournament: cls
	mkdir jar; cd classes ; jar cvfm ../jar/tournament.jar ../manifest-tournament competition util;

league: cls

	mkdir jar; cd classes; jar cvfm ../jar/league.jar ../manifest-league competition util; 

master: cls
	mkdir jar; cd classes; jar cvfm ../jar/master.jar ../manifest-master competition util; 

clean:
	rm -r docs classes -f jar/*.jar jar

.PHONY : all clean
