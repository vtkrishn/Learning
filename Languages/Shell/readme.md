http://www.shellscript.sh

cat sample.txt | grep "vinod" | uniq | tr ' ' '\n' | cut -f 1 -d o | tr -s ' ' '\n'
