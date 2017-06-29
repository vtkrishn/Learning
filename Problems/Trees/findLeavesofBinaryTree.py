class Node:
    left = None
    right = None
    val = 0
    def __init__(self,val):
        self.val = val

def findLeaves(root):
    if root is None:
        return
    findLeaves(root.left)
    findLeaves(root.right)
    if root.left == None and root.right == None:
        print (root.val)

n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n5 = Node(5)
n6 = Node(6)
n7 = Node(7)
n8 = Node(8)

n1.left = n2
n1.right = n3

n2.left = n4
n2.right = n5

n3.left = n6
n3.right = n7

n7.left = n8

findLeaves(n1)
