JFLAGS = -g
JC = javac
REMOVE = $(RM) *.class
MODE_EXEC = chmod a+x server client protocol
MODE_RESET = chmod a-x server client protocol

all: checkJava classes mode

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

checkJava::
      ifeq ($(shell java -version 2>&1|grep java >/dev/null; printf $$?),0)
	  @echo "Good! found java"
      else
           $(error "No java installed!, please install java")
      endif

clean:
	$(REMOVE)
	$(MODE_RESET)
	