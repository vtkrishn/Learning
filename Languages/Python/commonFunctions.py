def _all(elementList):
    for element in elementList:
        if not element:
            return False
    return True
#------------------------------------
def _any(elementList):
    for element in elementList:
        if element:
            return True
    return False
#------------------------------------
def _abs(value):
    if value < 0:
        return -value
    return value
#------------------------------------
def _isinstance(a,b):
    return type(a) == b
#------------------------------------
def _binary(value):
    lst = []
    x = _bin(value,lst)
    #return "".join(str(s) for s in lst)
    return "".join(lst)

def _bin(value,lst):
    if(value == 0):
        return 0
    mod = value%2
    rem = value>>1
    x = mod + _bin(rem,lst)
    lst = lst.append(str(mod))
    return x
#------------------------------------
    


elementList = [True, True, False]
print(_all(elementList))
elementList = [True, True, True]
print(_all(elementList))
#------------------------------------
elementList = [False, False, False]
print(_any(elementList))
elementList = [False, False, True]
print(_any(elementList))
#------------------------------------
print(_abs(-55))
#------------------------------------
print(_isinstance({},list))
print(_isinstance([],tuple))
print(_isinstance((),tuple))
print(_isinstance("",str))
print(_isinstance('',str))
print(_isinstance((u''),int))
print(_isinstance(.456,float))
print(_isinstance({},dict))
#------------------------------------
print(_binary(17))
