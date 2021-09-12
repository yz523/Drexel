Yiyun Zhang(Benny)
yz523
Project 3(Project B)

=====================Programming=====================
To run this program, import the CyberneticAutomatonP3 folder to Eclipse.
Run the PartA.java, PartB.java and PartC.java file for three parts' tests, the program will output the results.
SkinnerBox is replicate the experimental results of skinner box.
Balance is replicate the experimental results of 2-dimensional stick learning to balance
The curves of each trail batch are also attached(reward and punishment).
The different model parameters tables are also attached.
Each letter I used here represent to one symbol used in the text book example.
For example 0 is represent q0 and 'a' represent one of the states, etc...
The explanation is also in the end of the output.

=====================Skinner Box=====================
State for step 0: 
[0, a, 1, 1, b, 2, 2, c, 0]
(initial state)
State table:
0 a 1 
1 b 2 
2 c 0 
Input set: 
[3, d, 4, a, 5, e, 6, b, 6, c, 3, d, 7, e]
State for step 1: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
Current state: 3
State for step 2: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
Current state: 4
State for step 3: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
Current state: 5
State for step 4: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5, 5, b, 6]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
5 b 6 
Current state: 6
State for step 5: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5, 5, b, 6, 6, c, 0, 0, d, 3]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
5 b 6 
6 c 0 
0 d 3 
Current state: 3
State for step 6: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5, 5, b, 6, 6, c, 0, 0, d, 3, 3, e, 7]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
5 b 6 
6 c 0 
0 d 3 
3 e 7 
Current state: 7
State for step 7: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5, 5, b, 6, 6, c, 0, 0, d, 3, 3, e, 7, 7, c, 0]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
5 b 6 
6 c 0 
0 d 3 
3 e 7 
7 c 0 
Current state: 0
End
0 = q0
1 = q1
2 = q2
3 = q3
...
a = UCS+
b = UCS-
c = E
d = CS+
e = CS-
Therefore the final transition table is:
q0 UCS+ q1
q1 UCS- q2
q2 E q0
q0 CS+ q3
q3 UCS+ q4
q4 CS- q5
q5 UCS- q6
q6 E q0
q0 CS+ q3
q3 CS- q7
q7 E q0

=====================2-dimensional stick learning to balance=====================
State for step 0: 
[0, a, 1, 0, b, 2, 0, c, 3, 0, d, 4, 0, B, R, 0, F, P]
(initial state)
State table:
0 a 1 
0 b 2 
0 c 3 
0 d 4 
0 B R 
0 F P 
Input set: 
[0, b, 5, b, 6, B, 7, F]
Current state: 2
State for step 1: 
[0, a, 1, 0, b, 2, 0, c, 3, 0, d, 4, 0, B, R, 0, F, P, 2, b, 5]
State table:
0 a 1 
0 b 2 
0 c 3 
0 d 4 
0 B R 
0 F P 
2 b 5 
Current state: 5
State for step 2: 
[0, a, 1, 0, b, 2, 0, c, 3, 0, d, 4, 0, B, R, 0, F, P, 2, b, 5, 5, B, 6]
State table:
0 a 1 
0 b 2 
0 c 3 
0 d 4 
0 B R 
0 F P 
2 b 5 
5 B 6 
Current state: 6
State for step 3: 
[0, a, 1, 0, b, 2, 0, c, 3, 0, d, 4, 0, B, R, 0, F, P, 2, b, 5, 5, B, 6, 6, F, 7]
State table:
0 a 1 
0 b 2 
0 c 3 
0 d 4 
0 B R 
0 F P 
2 b 5 
5 B 6 
6 F 7 
Current state: 7
End
R = qR
0 = q0
1 = q1
2 = q2
3 = q3
...
a = PP
b = PN
c = NP
d = NN
Therefore the final transition table is:
q0 PP qR
q0 PN q1
q0 NP q2
q0 NN q3
q0 B q4
q0 F q5
q2 PN q5
q5 B q6
q6 F q7
