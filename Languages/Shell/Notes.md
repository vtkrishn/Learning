command | Description
---|---|
clear | clear the screen. cursor set to first, you cna still scroll to see previous
who am i | to know the time you logged in. user, terminal id, time and date
pwd | present working directory
cal | calendar , cal 7 2006
date | displays the date
touch | changes the file timestamps, it creates if the file does not exists , -c not to create, -a, -m changes only access and modification time
mkdir | make the directory
cd | change directory , cd - will go to pwd
cat | creates a file, > create a file test , < - take input from a file
mv | move file to destination , -f - force, -i - interactive,  -u update
rm | remove the file or directory , -r - recursive, -f - force, -i - interactive , -d - empty directory (rmdir)
cp | copy the file , -f -force, -r - recursive, -n - do not overwrite
ln | make links, changes gets reflected in another file , hard links , -s soft links
umask | 0022 - 4 digit number - 666 for file , 777 for directory - masking
ls | list the files , -a - hidden files , -l - long listing , -i =- print index ,  -r - reverse sort, -R - recursive , -S - sort by size, -t sort by modification time -U no sorting
chmod | change the file permission , 4 - Read, 2 - write , 1 - execute - total 7 , -f - quiet mode, -R- recursive -w - remove write, +w - add write
uname | print system information -a- all, -n - node, -m - machine, -p processor, -o os
file | determine file type - directory, or file etc
wc | word count -c bytes, -m - chars , -l - lines, -w - word -L max line length
sort | sort the lines of text files -f - ignore case, -g generic sort, -r reverse -u unique - d - dictinoary order , -M  month sort , -V version sort - b - ignore blank
cut | cut lines , -f field number -d - delimiter eg. echo sample.txt | cut -f1 -d'.'
dd | convert and copy the file -  IF= input file, OF=output file, CONV= option (lcase, ucase etc) dd if=sample.txt of=out.txt conv=ucase
man | help repository eg. man cat
banner | fancy text
compress | compress the file
cmp | compare two files
diff | compare files line by line
csplit | split the files into lines
df | system disk space usage
dir | list directory
du | disk usage
free | free memory available
head | head of the file -n number , head -5
tail | tail of the file -f - follow -n number , tail -f -5
echo | display message
kill | terminate a process
last | lists last login, reboot etc
read | read one line
ps | report process - a -e
tty | print terminal
uniq | unique lines -d - print duplicates , -u - print only unique lines -c - count
tput |
set  set something
exec |
sleep | 




Advanced Commands

grep
search for text  - n - number, -i ignore case, -c lines , -v - revese option


find


awk


sed


Script Structure

$? - to view exist status

if then elif else fi
[ ]
check of number
-lt, -gt, -le, -ge
-eq
read - should check for 2 including carriage return

//interal field separator
IFS=

-a - AND operator
-o - OR operator

-f- check for directory
-d - check for directory
-s - size greater than 0
-w - check for write permission

-n - length of the string greater than 0
-z - null check for string

case $var in
[a-z])
  //lower case check
  ;;
?)
  //one character check
  ;;
* )
  //check all
  ;;
esac

until
while [ $num -le 10]
do
 echo    
done

for item in *
do
//echo
done
