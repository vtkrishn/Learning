http://regexr.com/

Regular Expressions
--------------------
Search pattern

/Rainbow/g - match Rainbow

Single Meta Character
---------------------
\d - digit from 0-9 \D - not digit
\w - any character A-Za-z0-9 - \W - anything not character
\s - whitespace, tab \S - not whitespace
. - any character

Quantifier - modifies the previous option
------------------------------------------------
* - 0 or more
+ - 1 or more
? - 0 or 1
{min, max}
{n} - number of characters

position - Anchors
--------------
^ - for starting of word
$ - for end of words
\b - for the word boundary

Character classes
--------------------------------
[] - anything inside this matches
- - exception
no need to escape inside this [a-zA-Z] means matching all
[-.] - either - or .
[^abc] - negation

grouping
----------
(\d+) - referenced as group 1
for replacing $1, or refer in the same search \1

---------------
common regex
1) ([A-Z])\w+ - to capture all words starting with A-Z
