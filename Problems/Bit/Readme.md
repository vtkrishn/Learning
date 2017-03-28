#Even or Odd
(x & 1 ) == 0 -- Even

#Check nth bit is set
(x &  mask) == 1

#Set the nth bit
(x | mask)

#unset the nth bit
(x & ~mask)

#toggle the nth bit
(x ^ mask)

#turn off the right most bit
(x & x-1)
 
