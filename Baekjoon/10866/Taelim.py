class Deque():
    def __init__(self):
        self.num_lst = []
        
    def cmd(self, cmd, num=0):
        if cmd == 'push_back':
            self.num_lst.append(num)
        elif cmd == 'push_front':
            self.num_lst.insert(0, num)
        elif cmd == 'pop_front':
            result = -1 if len(self.num_lst) == 0 else self.num_lst.pop(0)
            return result
        elif cmd == 'pop_back':
            result = -1 if len(self.num_lst) == 0 else self.num_lst.pop(-1)
            return result
        elif cmd == 'size':
            return len(self.num_lst)
        elif cmd == 'empty':
            if len(self.num_lst) > 0:
                return 0
            else:
                return 1
        elif cmd == 'front':
            result =  -1 if len(self.num_lst) == 0 else self.num_lst[0]
            return result
        elif cmd == 'back':
            result =  -1 if len(self.num_lst) == 0 else self.num_lst[-1]
            return result

N = int(input())
deque = Deque()
for _ in range(N):
    input_text = input().split(" ")
    result = 0
    if len(input_text) == 2:
        result = deque.cmd(input_text[0], int(input_text[1]))
    else:
        result = deque.cmd(input_text[0])
    if result is not None:
        print(result)
            