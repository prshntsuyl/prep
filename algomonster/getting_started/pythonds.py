from collections import deque


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
