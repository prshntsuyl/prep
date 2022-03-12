from collections import deque
from mimetypes import init

from black import main


def stackUsage():
    # Initializes the stack
    stack = []
# Pushing 5 into the stack
    stack.append(5)
# Look at the top item of the stack and print it
    print(stack[-1])
# Removing the top item from the stack
    stack.pop()


def queueDs():
    # Initialize a new deque
    queue = deque()
# Add 2 to the end of the deque
    queue.append(2)
# Add 4 to the front of the deque
    queue.appendleft(4)
# Look at the end of the deque and print it
    print(queue[-1])
# Look at the front of the deque and print it
    print(queue[0])
# Remove the end of the deque
    queue.pop()
# Remove the front of the deque
    queue.popleft()


def hashmapDs():
    # Initialize a new hash map
    hashmap = {}
# Set the entry represented by "John" to 28
    hashmap["John"] = 28
# Check if "John" is in the hash map
    if "John" in hashmap:
        # Print the entry represented by "John"
        print(hashmap["John"])


hashmapDs()
queueDs()
stackUsage()


class LinkedListNode:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next

nextNode = LinkedListNode(11)
lln = LinkedListNode(1231, nextNode)        
print(f'answer:', lln.next.val)
print(f'answer:', lln.val)


s = set()
s.add(1)
s.add(2)
s.add(3)
s.add(4)
s.add(5)
print(f'set values:: ', s)



class TreeNode:
    '''
    binary tree node
    '''
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None



class TreeNodeN:
    '''
    n-ary treeNode
    '''
    def __init__(self, val):
        self.val = val
        self.childrens = []


treeNode = TreeNodeN(123123)
treeNode.val = 1231

print(treeNode.val)


a = [1,2,3,4]
print(a[-1])
print(a[1:2])
print(a[:3])
print(a[3:])


nums = [0, 10, 20, 30, 40, 50]
for i, num in enumerate(nums):
    print(f'Index and Num is ', i, num)


