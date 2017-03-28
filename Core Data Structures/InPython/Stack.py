#!/usr/bin/python

a = []
def push(value):
    a.append(value)

def isEmpty():
    return (size == 0)

def pop():
    if(not (len(a) == 0)):
        return a.pop()
    else:
        print "No items to pop"

def peek():
    if(not (len(a) == 0)):
        print a[len(a)-1]
    else:
        print "No items to peek"


push(1)
push(2)
push(3)
peek()
peek()
pop()
peek()
pop()
peek()
pop()
peek()
pop()
peek()

        
