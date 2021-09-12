JFLAGS = -g
JC = javac

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		HW5.java \
		OthelloMonteCarlo.java \
		OthelloMinimax.java \
		OthelloPlayer.java \
		OthelloState.java \
		OthelloMove.java \
		OthelloRandomPlayer.java \
		Test.java \
		
default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class