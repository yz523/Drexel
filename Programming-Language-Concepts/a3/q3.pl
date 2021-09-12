/* question 3 - 14.3.1 & 14.9.2 */
/* Yiyun Zhang(Benny) */
:- set_prolog_flag(double_quotes, chars).

/* Figure 8.1 */
csg(C, S, G) :- C = "CS101", S=12345, G="A".
csg(C, S, G) :- C = "CS101", S=67890, G="B".
csg(C, S, G) :- C = "EE200", S=12345, G="C".
csg(C, S, G) :- C = "EE200", S=22222, G="B+".
csg(C, S, G) :- C = "CS101", S=33333, G="A-".
csg(C, S, G) :- C = "PH100", S=67890, G="C+".

/* Figure 8.2 */
pr(C, P) :- C = "CS101", P = "CS100".
pr(C, P) :- C = "EE200", P = "EE005".
pr(C, P) :- C = "EE200", P = "CS100".
pr(C, P) :- C = "CS120", P = "CS101".
pr(C, P) :- C = "CS121", P = "CS120".
pr(C, P) :- C = "CS205", P = "CS101".
pr(C, P) :- C = "CS206", P = "CS121".
pr(C, P) :- C = "CS206", P = "CS205".

/* Figure 8.2 */
student(N, I) :- N = "C. Brown", I = 12345.
student(N, I) :- N = "L. Van Pelt", I = 67890.
student(N, I) :- N = "P. Patty", I = 22222.


answer(N, C, G) :- student(N, I), csg(C, I, G).
before(C, B) :- pr(C, B).
before(C, B) :- pr(C, X), before(X, B).