def compute(begin, end, wordlist):
    result = []
    temp = list(begin)
    for i in range(len(temp)):
        for j in range(97, 113):
            temp[i] = chr(j)
            val = ''.join(temp)
            if val in wordlist:
                result.append(val)
                wordlist.remove(val)
        temp = list(begin)
    print result
    return result[0],wordlist

begin = 'hit'
end = 'cog'
wl = ['hot', 'dot', 'lot', 'log', 'dog']
while len(wl) > 0:
    begin,wl = compute(begin, end, wl)
if begin == end:
    print begin