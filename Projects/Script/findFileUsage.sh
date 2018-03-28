#!/bin/bash
#$1 is the destination folder in which you have to get the details of the files that needs to be searched
ls -a $1 | grep '.java' | cut -f1 -d'.' > /home/vtkrishn/utilFiles.txt

FILE="/home/vtkrishn/utilFiles.txt"
LOCATION="location from where this needs to be run"

while read LINE
do
echo $LINE
echo "start -----------------"
echo "model = " `find $LOCATION -type f -name '*.xml' -o -name '*.java' | xargs grep -n $LINE | grep -v 'classes' | grep -v 'modelTest' | wc -l`
echo "modelTest = " `find $LOCATION -type f -name '*.xml' -o -name '*.java' | xargs grep -n $LINE | grep -v 'classes' | grep 'Test' | wc -l`
echo "end -----------------"
done <$FILE
