SRC_DIR = src
BIN_DIR = bin
CLASSPATH_FILE = .classpath
JUNIT_JAR = ../junit-platform-console-standalone-1.9.3.jar

CLASSPATH := $(shell python3 parse_classpath.py):$(BIN_DIR):$(JUNIT_JAR)

SOURCES := $(shell find $(SRC_DIR) -name "*.java")

.PHONY: all compile test clean

all: compile test

compile:
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) -classpath "$(CLASSPATH)" $(SOURCES)

test: compile
	java -classpath "$(CLASSPATH)" org.junit.platform.console.ConsoleLauncher --class-path "$(BIN_DIR)" --scan-class-path

clean:
	rm -rf $(BIN_DIR)
