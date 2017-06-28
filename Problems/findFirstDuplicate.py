def getIndex(arr):
    for i in range(0,len(arr)):
        ai = abs(arr[i])-1
        if arr[ai] > 0:
            arr[ai] = -arr[ai]
        else:
            return ai+1
    return -1

arr = [1,2,3,3,4,5,2]
#arr = [2,4,3,5,1]
print(getIndex(arr))
