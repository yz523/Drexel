from collections import Counter

X = [1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1]
Y = [1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1]
Z = [1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0]
m = 0
bit = []

for c in range(0,32):
    maj = [X[8],Y[10],Z[10]]

    ctr = Counter(maj)

    m = ctr.most_common(1)[0][0]

    if X[8] == m:
        t = X[13] ^ X[16] ^ X[17] ^ X[18]
        X.insert(0,t)
        X.pop()

    if Y[10] == m:
        t = Y[20] ^ Y[21]
        Y.insert(0,t)
        Y.pop()
    
    if Z[10] == m:
        t = Z[7] ^ Z[20] ^ Z[21] ^ Z[22]
        Z.insert(0,t)
        Z.pop()

    bit.append(X[18] ^ Y[21] ^ Z[22])

print("keystream bits =", bit)
print()
print("X =", X)
print()
print("Y =", Y)
print()
print("Z =", Z)