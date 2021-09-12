#question 1 - LL(1)
#Yiyun Zhang(Benny)

test = ["read A","read B","sum := A + B","write sum","write sum / 2"]
t = []
for x in range(100):
    t.append(0)
counter=0

class tree():
    def __init__(self):
        self.left = None
        self.mid = None
        self.right = None
        self.data = None

def maketree(i):
    if i < 5:
        ss = test[i].split(" ")
        if ss[0] == "read":
            t[i] = tree()
            t[i].left = tree()
            t[i].right = tree()
            t[i].left.left = tree()
            t[i].left.right = tree()
            t[i].left.data = "stmt"
            t[i].right.data = "stme_list"
            t[i].left.left.data = ss[0]
            t[i].left.right.data = ss[1]
            print t[i].left.data," ",t[i].right.data
            print t[i].left.left.data," ",t[i].left.right.data
            print "\n"
        
        if ss[0] == "sum":
            t[i] = tree()
            t[i].left = tree()
            t[i].right = tree()
            t[i].left.left = tree()
            t[i].left.mid = tree()
            t[i].left.right = tree()
            t[i].left.data = "stmt"
            t[i].right.data = "stme_list"
            t[i].left.left.data = ss[0]
            t[i].left.mid.data = ss[1]
            t[i].left.right = tree()
            t[i].left.right.data = "expr"
            t[i].left.right.left = tree()
            t[i].left.right.left.data = "term"
            t[i].left.right.right = tree()
            t[i].left.right.right.data = "term_tail"
            t[i].left.right.left.left = tree()
            t[i].left.right.left.left.data = "factor"
            t[i].left.right.left.right = tree()
            t[i].left.right.left.right.data = "factor_tail"
            t[i].left.right.left.left.left = tree()
            t[i].left.right.left.left.left.data = ss[2]
            t[i].left.right.left.right.left = tree()
            t[i].left.right.left.right.left.data = "NULL"
            t[i].left.right.right.left = tree()
            t[i].left.right.right.left.data = "add_op"
            t[i].left.right.right.left.left = tree()
            t[i].left.right.right.left.left.data = ss[3]
            t[i].left.right.right.mid = tree()
            t[i].left.right.right.mid.data = "term"
            t[i].left.right.right.mid.left = tree()
            t[i].left.right.right.mid.left.data = "factor"
            t[i].left.right.right.mid.left.left = tree()
            t[i].left.right.right.mid.left.left.data = ss[4]
            t[i].left.right.right.mid.right = tree()
            t[i].left.right.right.mid.right.data = "factor_tail"
            t[i].left.right.right.mid.right.left = tree()
            t[i].left.right.right.mid.right.left.data = "NULL"
            t[i].left.right.right.right = tree()
            t[i].left.right.right.right.data = "term_tail"
            t[i].left.right.right.right.left = tree()
            t[i].left.right.right.right.left.data = "NULL"
            print t[i].left.data," ",t[i].right.data
            print t[i].left.left.data," ",t[i].left.mid.data," ",t[i].left.right.data
            print t[i].left.right.left.data," ",t[i].left.right.right.data
            print t[i].left.right.left.left.data," ",t[i].left.right.right.data
            print t[i].left.right.right.left.data," ",t[i].left.right.right.mid.data," ",t[i].left.right.right.right.data
            print t[i].left.right.left.left.left.data," ",t[i].left.right.left.right.left.data
            print t[i].left.right.right.left.left.data
            print t[i].left.right.right.mid.left.data," ",t[i].left.right.right.mid.right.data
            print t[i].left.right.right.right.left.data
            print t[i].left.right.right.mid.left.left.data," ", t[i].left.right.right.mid.right.left.data
            print "\n"
        
        if ss[0] == "write":
            if len(ss) == 2:
                t[i] = tree()
                t[i].left = tree()
                t[i].left.data = "stmt"
                t[i].right = tree()
                t[i].right.data = "stme_list"
                t[i].left.left = tree()
                t[i].left.left.data = "write"
                t[i].left.right = tree()
                t[i].left.right.data = "expr"
                t[i].left.right.left = tree()
                t[i].left.right.left.data = "term"
                t[i].left.right.left.left = tree()
                t[i].left.right.left.left.data = "factor"
                t[i].left.right.left.left.left = tree()
                t[i].left.right.left.left.left.data = ss[1]
                t[i].left.right.left.right = tree()
                t[i].left.right.left.right.data = "factor_tail"
                t[i].left.right.left.right.left = tree()
                t[i].left.right.left.right.left.data = "NULL"
                t[i].left.right.right = tree()
                t[i].left.right.right.data = "term_tail"
                t[i].left.right.right.left = tree()
                t[i].left.right.right.left.data = "NULL"
                print t[i].left.data," ",t[i].right.data
                print t[i].left.left.data," ",t[i].left.right.data
                print t[i].left.right.left.data," ", t[i].left.right.right.data
                print t[i].left.right.left.left.data," ",t[i].left.right.left.right.data
                print t[i].left.right.right.left.data
                print t[i].left.right.left.left.left.data," ",t[i].left.right.left.right.left.data
                print "\n"
            if len(ss) == 4:
                t[i] = tree()
                t[i].left = tree()
                t[i].left.data = "stmt"
                t[i].right = tree()
                t[i].right.data = "stme_list"
                t[i].right.left = tree()
                t[i].right.left.data = "stmt"
                t[i].right.left.left = tree()
                t[i].right.left.left.data = ss[0]
                t[i].right.left.right = tree()
                t[i].right.left.right.data = "expr"
                t[i].right.left.right.left = tree()
                t[i].right.left.right.left.data = "term"
                t[i].right.left.right.left.left = tree()
                t[i].right.left.right.left.left.data = "factor"
                t[i].right.left.right.left.left.left = tree()
                t[i].right.left.right.left.left.left.data = ss[1]
                t[i].right.left.right.left.right = tree()
                t[i].right.left.right.left.right.data = "factor_tail"
                t[i].right.left.right.left.right.left = tree()
                t[i].right.left.right.left.right.left.data = "mul_op"
                t[i].right.left.right.left.right.left.left = tree()
                t[i].right.left.right.left.right.left.left.data = ss[2]
                t[i].right.left.right.left.right.mid = tree()
                t[i].right.left.right.left.right.mid.data = "factor"
                t[i].right.left.right.left.right.mid.left = tree()
                t[i].right.left.right.left.right.mid.left.data = ss[3]
                t[i].right.left.right.left.right.right = tree()
                t[i].right.left.right.left.right.right.data = "factor_tail"
                t[i].right.left.right.left.right.right.left = tree()
                t[i].right.left.right.left.right.right.left.data = "NULL"
                t[i].right.left.right.right = tree()
                t[i].right.left.right.right.data = "term_tail"
                t[i].right.left.right.right.left = tree()
                t[i].right.left.right.right.left.data = "NULL"
                t[i].right.right = tree()
                t[i].right.right.data = "stmt_list"
                t[i].right.right.left = tree()
                t[i].right.right.left.data = "NULL"
                print t[i].left.data," ",t[i].right.data
                print t[i].right.left.data," ",t[i].right.right.data
                print t[i].right.left.left.data," ",t[i].right.left.right.data
                print t[i].right.right.left.data
                print t[i].right.left.right.left.data," ",t[i].right.left.right.right.data
                print t[i].right.left.right.left.left.data," ",t[i].right.left.right.left.right.data
                print t[i].right.left.right.right.left.data
                print t[i].right.left.right.left.left.left.data
                print t[i].right.left.right.left.right.left.data," ",t[i].right.left.right.left.right.mid.data," ",t[i].right.left.right.left.right.right.data
                print t[i].right.left.right.left.right.left.left.data," ",t[i].right.left.right.left.right.mid.left.data," ",t[i].right.left.right.left.right.right.left.data
        maketree(i+1)

maketree(counter)

mytree = tree()
mytree.left = tree()
mytree.left.data = t[0]
mytree.right = tree()
mytree.right.left = tree()
mytree.right.left.data = t[1]
mytree.right.right = tree()
mytree.right.right.left = tree()
mytree.right.right.left.data = t[2]
mytree.right.right.right = tree()
mytree.right.right.right.left = tree()
mytree.right.right.right.left.data = t[3]
mytree.right.right.right.right = tree()
mytree.right.right.right.right.data = t[4]