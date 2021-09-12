Yiyun Zhang(Benny)
yz523
HW1

=====================Programming=====================
To run this program, import the CyberneticAutomaton folder to Eclipse.
Run the test1.java and test2.java files, the program will output the results.
I followed a state machine diagram to do my algorithm tests
The image is also attached under the folder.
One test is without new state, the other one is with that.
The test 2 is the test with new state, the result is just like the example in the book.
The figure for that example is also attached.
The model parameters are the same as table 4.1, that table image is attached as well.
The initial state machine for both test is the transition table:
a 0 a
a 1 b
b 1 c
b 0 a
c 0 c
c 1 c
The input set for test 1 is <(a,0),(a,1),(b,1)>
The input set for test 2 is <(a,0),(a,1),(b,2)>
The output for test 1 is the final state of the machine is the table without change:
a 0 a
a 1 b
b 1 c
b 0 a
c 0 c
c 1 c
The output for test 1 is the final state of the machine is the table with new a state:
a 0 a
a 1 b
b 1 c
b 0 a
c 0 c
c 1 c
b 2 d
=====================Sample Output1=====================
State for step 0: 
[a, 0, a, a, 1, b, b, 1, c, b, 0, a, c, 0, c, c, 1, c]
Input set: 
[a, 0, a, 1, b, 1]
Current state: a
Current state: b
Current state: c
End

=====================Sample Output2=====================
State for step 0: 
[a, 0, a, a, 1, b, b, 1, c, b, 0, a, c, 0, c, c, 1, c]
Input set: 
[a, 0, a, 1, b, 2]
Current state: a
Current state: b
State for step 1: 
[a, 0, a, a, 1, b, b, 1, c, b, 0, a, c, 0, c, c, 1, c, b, 2, d]
Current state: d
End