public_key = [18, 30, 7, 26]
private_key = []
conversion_factor = 0
M = [1,1,0,1]
m = 6
n = 47
result = 0
temp = -1

if (m^(-1) % n) < m:
    conversion_factor = (m^(-1) % n)
else:
    conversion_factor = int(n / m)

def modinv(x,m,n):
    for i in range(0, pow(key, 2)):
        if(i * m % n) == x:
            return i
    return 1

for key in public_key:
    private_key.append(modinv(key,m,n))

# x * 6 mod 47 = 18

print("a.")
print("Private key =", private_key, "and conversion factor = 6^(-1) mod 47 =", conversion_factor)
print()

print("b.")
print("The encrypted message =", end =" ")

for i in M:
    temp += 1
    if i == 1 and temp == 0:
        result += public_key[temp]
        print(public_key[temp],end =" ")

    if i == 1 and temp > 0:
        result += public_key[temp]
        print("+", public_key[temp], end =" ")

print("=", result)

