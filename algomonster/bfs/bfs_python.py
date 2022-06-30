from collections import deque
from pprint import pp

something = deque([0,1,2,3,4,5]);

dict_var = dict({'one': 1, 'two': 2, 'three': 3})
print('length of dict is:: ', len(dict_var));

print(dict_var['one']);
print(dict_var['two']);
print(dict_var['three']);


new_var = list([0,1,2,3,4,5])
print('count!!!');
print(len(new_var));
new_var.append(1231);
print(*new_var);

asd = {1,2,23,333, 333, 333}
print('somthing!!!!');
print(len(asd));

# print(something.p(opleft());
print(something.popleft());

sets = set({1,2,23,333, 333, 333})
print(sets);

print(len(something));

def bfs_by_queue(root):
    queue = deque([root]) # at least one element in the queue to kick start bfs
    while len(queue) > 0: # as long as there is element in the queue 
        node = queue.popleft() # dequeue
        for child in node.children: # enqueue children
            if OK(child): # early return if problem condition met
                return FOUND(child)
            queue.append(child)
    return NOT_FOUND


