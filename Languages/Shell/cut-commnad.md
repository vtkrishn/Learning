#CUT options [-c(column), -f(fields), -d(delimiter), -s(print-only delimiter available), --complement]

cut the line using delimiter and fields -f and -d options
* [vtkrishn@slc05nar ~]$ echo "vi/nod" | cut -f2 -d '/'
* nod
* [vtkrishn@slc05nar ~]$ echo "vi/nod" | cut -f1 -d '/'
* vi

extract columns use -c option
* [vtkrishn@slc05nar ~]$ echo "vi/nod" | cut -c1
* v
* [vtkrishn@slc05nar ~]$ echo "vi/nod" | cut -c2
* i

extract column using ranges use - the below example will extract from 2nd column to the end
* [vtkrishn@slc05nar ~]$ echo "vi/nod" | cut -c2-
* i/nod

extract column upto to 3
* [vtkrishn@slc05nar ~]$ echo "vi/nod" | cut -c-3
* vi/

select first and third column using comma separation in -f option
* [vtkrishn@slc05nar ~]$ echo "vi/no/d" | cut -f1,3 -d '/'
* vi/d

print only if delimiter available using -s option
* [vtkrishn@slc05nar ~]$ echo "vi/no/d" | cut -f1,3 -s -d ':'
* [vtkrishn@slc05nar ~]$ echo "vi/no/d" | cut -f1,3 -s -d '/'
* vi/d

complement the fields - except the first fields
* [vtkrishn@slc05nar ~]$ echo "vi/no/d" | cut -s -f1 -s --complement -d '/'
* no/d
