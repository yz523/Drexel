Yiyun Zhang(Benny)
yz523
Project 2 (Project A)

=====================Programming=====================
To run this program, import the CyberneticAutomatonP2 folder to Eclipse.
Run the PartA.java, PartB.java and PartC.java file for three parts' tests, the program will output the results.
PartA is replicate the experimental results of first-order delayed conditioning
PartB is replicate the experimental results of Second-order delayed conditioning
PartC is replicate the experimental results of Extinction in 2nd order conditioning
The curves of each trail batch are also attached.
PartA.png is the result of PartA, first-order delayed conditioning
PartB.png is the result of PartB, Second-order delayed conditioning
PartC.png is the result of PartC, Extinction in 2nd order conditioning
Each letter I used here represent to one symbol used in the text book example.
For example 0 is represent q0 and 'a' represent UCS+, etc...
The explanation is also in the end of the output.

=====================PartA=====================
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

=====================PartB=====================
State for step 0: 
[0, a, 1, 1, b, 2, 2, c, 0]
(initial state)
State table:
0 a 1 
1 b 2 
2 c 0 
Input set: 
[3, d, 4, a, 5, e, 6, b, 6, c, 7, f, 8, d, 9, g, X, e]
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
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5, 5, b, 6, 6, c, 0, 0, f, 7]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
5 b 6 
6 c 0 
0 f 7 
Current state: 7
State for step 6: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5, 5, b, 6, 6, c, 0, 0, f, 7, 7, d, 8]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
5 b 6 
6 c 0 
0 f 7 
7 d 8 
Current state: 8
State for step 7: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5, 5, b, 6, 6, c, 0, 0, f, 7, 7, d, 8, 8, g, 9]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
5 b 6 
6 c 0 
0 f 7 
7 d 8 
8 g 9 
Current state: 9
State for step 8: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5, 5, b, 6, 6, c, 0, 0, f, 7, 7, d, 8, 8, g, 9, 9, e, X]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
5 b 6 
6 c 0 
0 f 7 
7 d 8 
8 g 9 
9 e X 
Current state: X
State for step 9: 
[0, a, 1, 1, b, 2, 2, c, 0, 0, d, 3, 3, a, 4, 4, e, 5, 5, b, 6, 6, c, 0, 0, f, 7, 7, d, 8, 8, g, 9, 9, e, X, X, c, 0]
State table:
0 a 1 
1 b 2 
2 c 0 
0 d 3 
3 a 4 
4 e 5 
5 b 6 
6 c 0 
0 f 7 
7 d 8 
8 g 9 
9 e X 
X c 0 
Current state: 0
End
0 = q0
1 = q1
2 = q2
3 = q3
...
X = q10

a = UCS+
b = UCS-
c = E
d = CS1+
e = CS1-
f = CS2+
g = CS2-
Therefore the final transition table is:
q0 UCS+ q1
q1 UCS- q2
q2 E q0
q0 CS1+ q3
q3 UCS+ q4
q4 CS1- q5
q5 UCS- q6
q6 E q0
q0 CS2+ q7
q7 CS1+ q8
q8 CS2- q9
q9 CS1- q10
q10 E q0

=====================PartC=====================
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
