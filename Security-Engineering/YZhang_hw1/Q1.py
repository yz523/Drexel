plain_text = "PBFPVYFBQXZTYFPBFEQJHDXXQVAPTPQJKTOYQWIPBVWLXTOXBTFXQWAXBVCXQWAXFQJVWLEQNTOZQGGQLFXQWAKVWLXQWAEBIPBFXQVXGTVJVWLBTPQWAEBFPBFHCVLXBQUFEVWLXGDPEQVPQGVPPBFTIXPFHXZHVFAGFOTHFEFBQUFTDHZBQPOTHXTYFTODXQHFTDPTOGHFQPBQWAQJJTODXQHFOQPWTBDHHIXQVAPBFZQHCFWPFHPBFIPBQWKFABVYYDZBOTHPBQPQJTQOTOGHFQAPBFEQJHDXXQVAVXEBQPEFZBVFOJIWFFACFCCFHQWAUVWFLQHGFXVAFXQHFUFHILTTAVWAFFAWTEVOITDHFHFQAITIXPFHXAFQHEFZQWGFLVWPTOFFA"
char_set = [0]*26
count_set = [0]
count_set.clear()
temp = -1

for char in plain_text:
    char_set[ord(char)-65] += 1

for char in char_set:
    temp += 1
    count_set.append((chr(temp+65),char))

temp = -1

print("Plaintext's word count(alphabet):")
print(count_set)
print("")

sorted_set = sorted(count_set, key=lambda count_set: count_set[1], reverse = True)

print("Sorted word count(high to low):")
print(sorted_set)
print("")
sorted_list = [0]
sorted_list.clear()
for char in sorted_set:
    temp += 1
    sorted_list.append(sorted_set[temp][0])

temp = -1

print("Without numbers(high to low):")
print(sorted_list)
print("")

print("According to the english letter frequency graph from the lecture notes(high to low):")
english_letter_frequency = ["E", "T", "A", "O", "I", "N", "S", "H", "R", "D", "L", "C", "U", "M", "W", "F", "G", "P", "Y", "B", "V", "K", "X", "J", "Q", "Z"]
print(english_letter_frequency)
print("")

translation_table = [0]
translation_table.clear()

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], english_letter_frequency[temp]))

temp = -1

print("The original letter frequency substitution table is:")
print(translation_table)
print()

print("The decrypted message is:")
result = ""

for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()

print("Since F -> E, PBF is highly likely equals to THE, where P, B, T, H are also high frequency letters, therefore P -> T, B -> H")
print("Swap T and A, swap H and N. The modified letter frequency set(high to low) is:")
modified_frequency = ["E", "A", "T", "O", "I", "H", "S", "N", "R", "D", "L", "C", "U", "M", "W", "F", "G", "P", "Y", "B", "V", "K", "X", "J", "Q", "Z"]

print(modified_frequency)
print()
print("The modified translation table is:")

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print(translation_table)
print()

print("The decrypted message is:")
for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()


print("In original letter frequency, P and X have the same frequency(28), try swap them(in this case swap O and I in translation table)")
print("The modified letter frequency set(high to low) is:")
modified_frequency = ["E", "A", "T", "I", "O", "H", "S", "N", "R", "D", "L", "C", "U", "M", "W", "F", "G", "P", "Y", "B", "V", "K", "X", "J", "Q", "Z"]

print(modified_frequency)
print()
print("The modified translation table is:")

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print(translation_table)
print()

print("The decrypted message is:")
for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()

print("The OL happened many times here, base on the word frequency it highly likely equals to OF")
print("Swap L and F, the modified letter frequency set(high to low) is:")
modified_frequency = ["E", "A", "T", "I", "O", "H", "S", "N", "R", "D", "F", "C", "U", "M", "W", "L", "G", "P", "Y", "B", "V", "K", "X", "J", "Q", "Z"]
print(modified_frequency)
print()
print("The modified translation table is:")

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print(translation_table)
print()

print("The decrypted message is:")
for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()

print("The HAI, IHOEI, and some words ends with I but follow with OF makes me think I is euqal to S")
print("Swap I and S, the modified letter frequency set(high to low) is:")
modified_frequency = ["E", "A", "T", "S", "O", "H", "I", "N", "R", "D", "F", "C", "U", "M", "W", "L", "G", "P", "Y", "B", "V", "K", "X", "J", "Q", "Z"]
print(modified_frequency)
print()
print("The modified translation table is:")

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print(translation_table)
print()

print("The decrypted message is:")
for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()

print("Swap equal frequency letters D, G, I and L(10) to try to make words make sense:")
print("Swap M, B, the modified letter frequency set(high to low) is:")
modified_frequency = ["E", "A", "T", "S", "O", "H", "R", "I", "N", "D", "F", "C", "U", "B", "W", "L", "G", "P", "Y", "M", "V", "K", "X", "J", "Q", "Z"]
print(modified_frequency)
print()
print("The modified translation table is:")

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print(translation_table)
print()

print("The decrypted message is:")
for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()

print("POM should be COME")
print("Swap P and C, the modified letter frequency set(high to low) is:")
modified_frequency = ["E", "A", "T", "S", "O", "H", "R", "I", "N", "D", "F", "P", "U", "B", "W", "L", "G", "C", "Y", "M", "V", "K", "X", "J", "Q", "Z"]
print(modified_frequency)
print()
print("The modified translation table is:")

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print(translation_table)
print()

print("The decrypted message is:")
for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()

print("Swap equal frequency letters D, G, I and L(10) to try to make words make sense:")
print("Swap G and L, the modified letter frequency set(high to low) is:")
modified_frequency = ["E", "A", "T", "S", "O", "H", "R", "I", "N", "D", "F", "P", "U", "B", "W", "G", "L", "C", "Y", "M", "V", "K", "X", "J", "Q", "Z"]
print(modified_frequency)
print()
print("The modified translation table is:")

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print(translation_table)
print()

print("The decrypted message is:")
for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()

print("MANW should be MANY")
print("Swap W and Y, the modified letter frequency set(high to low) is:")
modified_frequency = ["E", "A", "T", "S", "O", "H", "R", "I", "N", "D", "F", "P", "U", "B", "Y", "G", "L", "C", "W", "M", "V", "K", "X", "J", "Q", "Z"]
print(modified_frequency)
print()
print("The modified translation table is:")

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print(translation_table)
print()

print("The decrypted message is:")
for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()

print("PHY, PE, PINGS shoule be why, we and wings")
print("Swap P and W, the modified letter frequency set(high to low) is:")
modified_frequency = ["E", "A", "T", "S", "O", "H", "R", "I", "N", "D", "F", "W", "U", "B", "Y", "G", "L", "C", "P", "M", "V", "K", "X", "J", "Q", "Z"]
print(modified_frequency)
print()
print("The modified translation table is:")

for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print(translation_table)
print()

print("The decrypted message is:")
for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print()

result = ""
translation_table.clear()

modified_frequency = ["E", "A", "T", "S", "O", "H", "R", "I", "N", "D", "F", "W", "U", "B", "Y", "G", "L", "C", "P", "M", "V", "K", "X", "J", "Q", "Z"]


for char in sorted_list:
    temp += 1
    translation_table.append((sorted_list[temp], modified_frequency[temp]))

temp = -1

print("The final translation table(high to low) is:")
print(translation_table)
print("")

for char in plain_text:
    for letter in translation_table:
        if char == letter[0]:
            result += letter[1]

print(result)
print("")
print("Now we have a readable text:")
print("THE TIME HAS COME. THE WALRUS SAID TO TALK OF MANY THINGS OF SHOES AND SHIPS AND SEALING WAX OF CABBAGES AND KINGS AND WHY THE SA IS BOILING HOT AND WHETHER PIGS HAVE WINGS. BUT WAIT A BIT. THE OYSTERS CRIED BEFORE WE HAVE OUR CHAT. FOR SOME OF US ARE OUT OF BREATH AND ALL OF US ARE FAT. NO HURRY SAID THE CARPENTER. THEY THANKED HIM MUCH FOR THAT. A LOAF OF BREAD THE WALRUS SAID. IS WHAT WE CHIEFLY NEED PEPPER AND VINEGAR BESIDES ARE VERY GOOD INDEED. NOW IF YOURE READY OYSTERS DEAR WE CAN BEGIN TO FEED")