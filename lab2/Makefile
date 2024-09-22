JUNIT_JAR = ../junit-platform-console-standalone-1.9.3.jar
BEAVER_ANT_JAR = lib/beaver-ant.jar
BEAVER_RT_JAR = lib/beaver-rt.jar
OUT_DIR = out
CP = .:$(JUNIT_JAR):$(BEAVER_ANT_JAR):$(BEAVER_RT_JAR)

all: build compile test

build:
	ant -f build.xml

compile: build
	javac -cp .:$(JUNIT_JAR):$(BEAVER_ANT_JAR):$(BEAVER_RT_JAR) \
		-d $(OUT_DIR) \
    src/test/ParserTests.java \
    gen/lexer/Lexer.java \
    gen/parser/Parser.java

test: compile
	java -jar $(JUNIT_JAR) \
    --class-path $(OUT_DIR):$(BEAVER_ANT_JAR):$(BEAVER_RT_JAR)\
    --scan-class-path

clean:
	rm -rf $(OUT_DIR)