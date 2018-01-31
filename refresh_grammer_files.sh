# 1. Buildes tokens and java files based on grammer file.
java -jar ./lib/antlr-4.5.1-complete.jar ./src/main/resources/Select.g4 -visitor -package org.tools.csv.format.grammar -no-listener &&

# 2. Remove the older grammer files.
rm ./src/main/java/org/tools/csv/format/grammar/*

# 3 Move token files to proper location
mv ./src/main/resources/*.tokens ./src/main/java/org/tools/csv/format/grammar/ &&

# 4 Move java files to proper location
mv ./src/main/resources/*.java ./src/main/java/org/tools/csv/format/grammar/
