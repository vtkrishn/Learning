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

list slise format
(list elments)[1,3]
