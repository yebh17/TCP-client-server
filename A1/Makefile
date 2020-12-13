JFLAGS = -g
JC = javac
REMOVE = $(RM) *.class
MODE_EXEC = chmod a+x server client protocol checkJava.sh
MODE_RESET = chmod a-x server client protocol checkJava.sh

all: mode checkJava classes

mode:
	$(MODE_EXEC)

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Server.java \
	Client.java

default: classes

classes: $(CLASSES:.java=.class)

checkJava:
	./checkJava.sh

clean:
	$(REMOVE)
	$(MODE_RESET)
