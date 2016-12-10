#TR options [-s(squeeze) , -d(delete) , -c(complement)] [set1](source format) [set2](target format)

convert specific lower to upper
* [vtkrishn@slc05nar ~]$ echo vinod | tr vin VIN
* VINod

convert all any lower to upper
* [vtkrishn@slc05nar ~]$ echo vinod | tr a-z A-Z
* VINOD

converting braces
* [vtkrishn@slc05nar ~]$ echo "{vinod}" | tr '{}' '()'
* (vinod)

converting white space to tab space
* [vtkrishn@slc05nar ~]$ echo "vino d" | tr ' ' '\t'
* vino    d

converting white space to new line
* [vtkrishn@slc05nar ~]$ echo "vino d" | tr ' ' '\n'
* vino
* d

squeeze number of space with -s option
* [vtkrishn@slc05nar ~]$ echo "vino        d" | tr -s ' ' '\t'
* vino    d

delete a character using -d option
* [vtkrishn@slc05nar ~]$ echo "vino d" | tr -d  ' '
* vinod

to delete all the digits from the string
* [vtkrishn@slc05nar ~]$ echo "my username is 432234" | tr -d 0-9
* my username is

to delete only characters with a-z and space
* [vtkrishn@slc05nar ~]$ echo "my username is 432234" | tr -d 'a-z '
* 432234

to delete except digitst - complement using -c option
* [vtkrishn@slc05nar ~]$ echo "my username is 432234" | tr -cd '0-9\n'
* 432234

to delete all digits from the string
[vtkrishn@slc05nar ~]$ echo "vinod      123" | tr -d "[:digit:]"
vinod     

  [:alnum:]       all letters and digits
  [:alpha:]       all letters
  [:blank:]       all horizontal whitespace
  [:cntrl:]       all control characters
  [:digit:]       all digits
  [:graph:]       all printable characters, not including space
  [:lower:]       all lower case letters
  [:print:]       all printable characters, including space
  [:punct:]       all punctuation characters
  [:space:]       all horizontal or vertical whitespace
  [:upper:]       all upper case letters
  [:xdigit:]      all hexadecimal digits
