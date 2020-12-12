
JFLAGS = -g
JC = javac

all: classes mode

mode:
	echo `chmod a+x server client protocol`

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  Server.java \
		  Client.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	echo `chmod a-x server client protocol`