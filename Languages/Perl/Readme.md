Start with
```
#!/user/bin/perl -w
#simple.plx
use warnings;
use strict;

```

#output
print "vinod";
```
print '"vinod" is so good';
```
string concatenation using ,
```
print 2 , "\n";
```
; needed at each line

quote delimiter changeing using
```
print q/vinod/
print q{vinod}
print qq{vinod} #for double quotes
```
#input
```
$in = <STDIN>;
```
#Variable
```
$name = "vinod";
$age = 123;
print $name, 'is so good', $age;
```
multiple assignments
```
$a , $b = 1,2;
($x,$y) = (4,5);
($a,$b) = ($x,$y);
```

#scope
use  - my
```
$record = 25;
{
    my $record;
    $record = 50;
    print $record # prints 50
}
```
operators are all more or less same in this also

#List
```
()
print (1234,45,567);
print qw[1234,45,567];
print qw[1234 45 567];
print qw(
  1234
  45
  567
  );
```
list removes all internal brackets
To access specific element use it like
```
print (123 45 67)[2]; #prints 67
print ((123 45 67)[2]); #prints 67
```

list slice format
(list elements)[1,3]

ranges
(list elements)(1..6)

combining slice and ranges
(list elements)[1..4]

#Array
```
my @day;
@day = qw(mon tue wed thurs sat sun)
```
```
push @pile 'vinod'   # mon tue vinod
pop @pile            #mon tue
unshift @pile 'sat'    # sat mon tue
shift @pile            #mon tue
```
if array is assigned to a variable its length gets stored in the Variable

#hashes
represented as
```
%where = {
india => usa,
kashmir => chennai
}
```
variable to represent internal iterator next element
```
$_
```
