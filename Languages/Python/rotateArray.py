def rotate(a,k):
    b=[a[i] for i in range(0,len(a)-k)]
    c=[a[j] for j in range(len(a)-k,len(a))]
    return c.extend(b)

a = [1,2,3,4,5,6,7]
rotate(a,4)
