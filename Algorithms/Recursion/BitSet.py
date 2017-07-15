recursive
def bitSet(n,c):
    if n == 0:
        return c;
    if n%2 == 1:
        c = c + 1
    return bitSet(n>>1,c)
bitSet(27,0)
----------------------
def bitSet(n):
    rem = n;
    mod = 0;
    count = 0;
    while(rem > 0):
        if rem%2 == 1:
          count = count +1
        rem = rem>>1;
    return count

bitSet(27)
