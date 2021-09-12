CS578 - Security Engineering - Section 001
Assignment 1
Yiyun Zhang
yz523@drexel.edu - 13104807

Question 1:

The letter frequency in the plaintext is(high to low):
[('F', 50), ('Q', 42), ('P', 28), ('X', 28), ('T', 27), ('B', 26), ('H', 25), ('V', 24), ('W', 22), ('A', 21), ('O', 15), ('E', 12), ('D', 10), ('G', 10), ('I', 10), ('L', 10), ('J', 9), ('Z', 8), ('C', 6), ('Y', 6), ('U', 4), ('K', 3), ('N', 1), ('M', 0), ('R', 0), ('S', 0)]

Without numbers it is(high to low):
['F', 'Q', 'P', 'X', 'T', 'B', 'H', 'V', 'W', 'A', 'O', 'E', 'D', 'G', 'I', 'L', 'J', 'Z', 'C', 'Y', 'U', 'K', 'N', 'M', 'R', 'S']

According to the english letter frequency graph from the lecture notes, the english letter frequency is(high to low):
['E', 'T', 'A', 'O', 'I', 'N', 'S', 'H', 'R', 'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G', 'P', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z']

Therefore, translate F -> E.

The first three letters are PBF, Since F is E it becomes PBE, and THE is the most frequent word in the beginning plus P and T, B and H's frequency are very similar.

Translate P to T and B to H, swap the corresponding letters in frequency table.

After that, by guessing some words and swapping similar frequency letters, the plaintext is decrypted, the final tranlsation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'S'), ('T', 'O'), ('B', 'H'), ('H', 'R'), ('V', 'I'), ('W', 'N'), ('A', 'D'), ('O', 'F'), ('E', 'W'), ('D', 'U'), ('G', 'B'), ('I', 'Y'), ('L', 'G'), ('J', 'L'), ('Z', 'C'), ('C', 'P'), ('Y', 'M'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

In the sets, left side is the original letter in plaintext, the right side is the output(decrypted) letter.

The final readable(decrypted) text is:
THE TIME HAS COME. THE WALRUS SAID TO TALK OF MANY THINGS OF SHOES AND SHIPS AND SEALING WAX OF CABBAGES AND KINGS AND WHY THE SA IS BOILING HOT AND WHETHER PIGS HAVE WINGS. BUT WAIT A BIT. THE OYSTERS CRIED BEFORE WE HAVE OUR CHAT. FOR SOME OF US ARE OUT OF BREATH AND ALL OF US ARE FAT. NO HURRY SAID THE CARPENTER. THEY THANKED HIM MUCH FOR THAT. A LOAF OF BREAD THE WALRUS SAID. IS WHAT WE CHIEFLY NEED PEPPER AND VINEGAR BESIDES ARE VERY GOOD INDEED. NOW IF YOURE READY OYSTERS DEAR WE CAN BEGIN TO FEED

One odd problem is in the middle of the context, "AND WHY THE SA IS BOILING HOT ", the SA here should be SEA.

Run Q1.py in python compiler to run code for this question.
======= Sample Output =======

Plaintext's word count(alphabet):
[('A', 21), ('B', 26), ('C', 6), ('D', 10), ('E', 12), ('F', 50), ('G', 10), ('H', 25), ('I', 10), ('J', 9), ('K', 3), ('L', 10), ('M', 0), ('N', 1), ('O', 15), ('P', 28), ('Q', 42), ('R', 0), ('S', 0), ('T', 27), ('U', 4), ('V', 24), ('W', 22), ('X', 28), ('Y', 6), ('Z', 8)]

Sorted word count(high to low):
[('F', 50), ('Q', 42), ('P', 28), ('X', 28), ('T', 27), ('B', 26), ('H', 25), ('V', 24), ('W', 22), ('A', 21), ('O', 15), ('E', 12), ('D', 10), ('G', 10), ('I', 10), ('L', 10), ('J', 9), ('Z', 8), ('C', 6), ('Y', 6), ('U', 4), ('K', 3), ('N', 1), ('M', 0), ('R', 0), ('S', 0)]

Without numbers(high to low):
['F', 'Q', 'P', 'X', 'T', 'B', 'H', 'V', 'W', 'A', 'O', 'E', 'D', 'G', 'I', 'L', 'J', 'Z', 'C', 'Y', 'U', 'K', 'N', 'M', 'R', 'S']

According to the english letter frequency graph from the lecture notes(high to low):
['E', 'T', 'A', 'O', 'I', 'N', 'S', 'H', 'R', 'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G', 'P', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z']

The original letter frequency substitution table is:
[('F', 'E'), ('Q', 'T'), ('P', 'A'), ('X', 'O'), ('T', 'I'), ('B', 'N'), ('H', 'S'), ('V', 'H'), ('W', 'R'), ('A', 'D'), ('O', 'L'), ('E', 'C'), ('D', 'U'), ('G', 'M'), ('I', 'W'), ('L', 'F'), ('J', 'G'), ('Z', 'P'), ('C', 'Y'), ('Y', 'B'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
ANEAHBENTOPIBEANECTGSUOOTHDAIATGKILBTRWANHRFOILONIEOTRDONHYOTRDOETGHRFCTXILPTMMTFEOTRDKHRFOTRDCNWANEOTHOMIHGHRFNIATRDCNEANESYHFONTVECHRFOMUACTHATMHAANEIWOAESOPSHEDMELISECENTVEIUSPNTALISOIBEILUOTSEIUAILMSETANTRDTGGILUOTSELTARINUSSWOTHDANEPTSYERAESANEWANTRKEDNHBBUPNLISANTATGITLILMSETDANECTGSUOOTHDHOCNTACEPNHELGWREEDYEYYESTRDVHREFTSMEOHDEOTSEVESWFIIDHRDEEDRICHLWIUSESETDWIWOAESODETSCEPTRMEFHRAILEED

Since F -> E, PBF is highly likely equals to THE, where P, B, T, H are also high frequency letters, therefore P -> T, B -> H
Swap T and A, swap H and N. The modified letter frequency set(high to low) is:
['E', 'A', 'T', 'O', 'I', 'H', 'S', 'N', 'R', 'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G', 'P', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z']

The modified translation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'O'), ('T', 'I'), ('B', 'H'), ('H', 'S'), ('V', 'N'), ('W', 'R'), ('A', 'D'), ('O', 'L'), ('E', 'C'), ('D', 'U'), ('G', 'M'), ('I', 'W'), ('L', 'F'), ('J', 'G'), ('Z', 'P'), ('C', 'Y'), ('Y', 'B'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
THETNBEHAOPIBETHECAGSUOOANDTITAGKILBARWTHNRFOILOHIEOARDOHNYOARDOEAGNRFCAXILPAMMAFEOARDKNRFOARDCHWTHEOANOMINGNRFHITARDCHETHESYNFOHAVECNRFOMUTCANTAMNTTHEIWOTESOPSNEDMELISECEHAVEIUSPHATLISOIBEILUOASEIUTILMSEATHARDAGGILUOASELATRIHUSSWOANDTHEPASYERTESTHEWTHARKEDHNBBUPHLISTHATAGIALILMSEADTHECAGSUOOANDNOCHATCEPHNELGWREEDYEYYESARDVNREFASMEONDEOASEVESWFIIDNRDEEDRICNLWIUSESEADWIWOTESODEASCEPARMEFNRTILEED

In original letter frequency, P and X have the same frequency(28), try swap them(in this case swap O and I in translation table)
The modified letter frequency set(high to low) is:
['E', 'A', 'T', 'I', 'O', 'H', 'S', 'N', 'R', 'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G', 'P', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z']

The modified translation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'I'), ('T', 'O'), ('B', 'H'), ('H', 'S'), ('V', 'N'), ('W', 'R'), ('A', 'D'), ('O', 'L'), ('E', 'C'), ('D', 'U'), ('G', 'M'), ('I', 'W'), ('L', 'F'), ('J', 'G'), ('Z', 'P'), ('C', 'Y'), ('Y', 'B'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
THETNBEHAIPOBETHECAGSUIIANDTOTAGKOLBARWTHNRFIOLIHOEIARDIHNYIARDIEAGNRFCAXOLPAMMAFEIARDKNRFIARDCHWTHEIANIMONGNRFHOTARDCHETHESYNFIHAVECNRFIMUTCANTAMNTTHEOWITESIPSNEDMELOSECEHAVEOUSPHATLOSIOBEOLUIASEOUTOLMSEATHARDAGGOLUIASELATROHUSSWIANDTHEPASYERTESTHEWTHARKEDHNBBUPHLOSTHATAGOALOLMSEADTHECAGSUIIANDNICHATCEPHNELGWREEDYEYYESARDVNREFASMEINDEIASEVESWFOODNRDEEDROCNLWOUSESEADWOWITESIDEASCEPARMEFNRTOLEED

The OL happened many times here, base on the word frequency it highly likely equals to OF
Swap L and F, the modified letter frequency set(high to low) is:
['E', 'A', 'T', 'I', 'O', 'H', 'S', 'N', 'R', 'D', 'F', 'C', 'U', 'M', 'W', 'L', 'G', 'P', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z']

The modified translation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'I'), ('T', 'O'), ('B', 'H'), ('H', 'S'), ('V', 'N'), ('W', 'R'), ('A', 'D'), ('O', 'F'), ('E', 'C'), ('D', 'U'), ('G', 'M'), ('I', 'W'), ('L', 'L'), ('J', 'G'), ('Z', 'P'), ('C', 'Y'), ('Y', 'B'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
THETNBEHAIPOBETHECAGSUIIANDTOTAGKOFBARWTHNRLIOFIHOEIARDIHNYIARDIEAGNRLCAXOFPAMMALEIARDKNRLIARDCHWTHEIANIMONGNRLHOTARDCHETHESYNLIHAVECNRLIMUTCANTAMNTTHEOWITESIPSNEDMEFOSECEHAVEOUSPHATFOSIOBEOFUIASEOUTOFMSEATHARDAGGOFUIASEFATROHUSSWIANDTHEPASYERTESTHEWTHARKEDHNBBUPHFOSTHATAGOAFOFMSEADTHECAGSUIIANDNICHATCEPHNEFGWREEDYEYYESARDVNRELASMEINDEIASEVESWLOODNRDEEDROCNFWOUSESEADWOWITESIDEASCEPARMELNRTOFEED

The HAI, IHOEI, and some words ends with I but follow with OF makes me think I is euqal to S
Swap I and S, the modified letter frequency set(high to low) is:
['E', 'A', 'T', 'S', 'O', 'H', 'I', 'N', 'R', 'D', 'F', 'C', 'U', 'M', 'W', 'L', 'G', 'P', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z']

The modified translation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'S'), ('T', 'O'), ('B', 'H'), ('H', 'I'), ('V', 'N'), ('W', 'R'), ('A', 'D'), ('O', 'F'), ('E', 'C'), ('D', 'U'), ('G', 'M'), ('I', 'W'), ('L', 'L'), ('J', 'G'), ('Z', 'P'), ('C', 'Y'), ('Y', 'B'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
THETNBEHASPOBETHECAGIUSSANDTOTAGKOFBARWTHNRLSOFSHOESARDSHNYSARDSEAGNRLCAXOFPAMMALESARDKNRLSARDCHWTHESANSMONGNRLHOTARDCHETHEIYNLSHAVECNRLSMUTCANTAMNTTHEOWSTEISPINEDMEFOIECEHAVEOUIPHATFOISOBEOFUSAIEOUTOFMIEATHARDAGGOFUSAIEFATROHUIIWSANDTHEPAIYERTEITHEWTHARKEDHNBBUPHFOITHATAGOAFOFMIEADTHECAGIUSSANDNSCHATCEPHNEFGWREEDYEYYEIARDVNRELAIMESNDESAIEVEIWLOODNRDEEDROCNFWOUIEIEADWOWSTEISDEAICEPARMELNRTOFEED

Swap equal frequency letters D, G, I and L(10) to try to make words make sense:
Swap M, B, the modified letter frequency set(high to low) is:
['E', 'A', 'T', 'S', 'O', 'H', 'R', 'I', 'N', 'D', 'F', 'C', 'U', 'B', 'W', 'L', 'G', 'P', 'Y', 'M', 'V', 'K', 'X', 'J', 'Q', 'Z']

The modified translation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'S'), ('T', 'O'), ('B', 'H'), ('H', 'R'), ('V', 'I'), ('W', 'N'), ('A', 'D'), ('O', 'F'), ('E', 'C'), ('D', 'U'), ('G', 'B'), ('I', 'W'), ('L', 'L'), ('J', 'G'), ('Z', 'P'), ('C', 'Y'), ('Y', 'M'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
THETIMEHASPOMETHECAGRUSSAIDTOTAGKOFMANWTHINLSOFSHOESANDSHIYSANDSEAGINLCAXOFPABBALESANDKINLSANDCHWTHESAISBOIGINLHOTANDCHETHERYILSHAVECINLSBUTCAITABITTHEOWSTERSPRIEDBEFORECEHAVEOURPHATFORSOMEOFUSAREOUTOFBREATHANDAGGOFUSAREFATNOHURRWSAIDTHEPARYENTERTHEWTHANKEDHIMMUPHFORTHATAGOAFOFBREADTHECAGRUSSAIDISCHATCEPHIEFGWNEEDYEYYERANDVINELARBESIDESAREVERWLOODINDEEDNOCIFWOUREREADWOWSTERSDEARCEPANBELINTOFEED

POM should be COME
Swap P and C, the modified letter frequency set(high to low) is:
['E', 'A', 'T', 'S', 'O', 'H', 'R', 'I', 'N', 'D', 'F', 'P', 'U', 'B', 'W', 'L', 'G', 'C', 'Y', 'M', 'V', 'K', 'X', 'J', 'Q', 'Z']

The modified translation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'S'), ('T', 'O'), ('B', 'H'), ('H', 'R'), ('V', 'I'), ('W', 'N'), ('A', 'D'), ('O', 'F'), ('E', 'P'), ('D', 'U'), ('G', 'B'), ('I', 'W'), ('L', 'L'), ('J', 'G'), ('Z', 'C'), ('C', 'Y'), ('Y', 'M'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
THETIMEHASCOMETHEPAGRUSSAIDTOTAGKOFMANWTHINLSOFSHOESANDSHIYSANDSEAGINLPAXOFCABBALESANDKINLSANDPHWTHESAISBOIGINLHOTANDPHETHERYILSHAVEPINLSBUTPAITABITTHEOWSTERSCRIEDBEFOREPEHAVEOURCHATFORSOMEOFUSAREOUTOFBREATHANDAGGOFUSAREFATNOHURRWSAIDTHECARYENTERTHEWTHANKEDHIMMUCHFORTHATAGOAFOFBREADTHEPAGRUSSAIDISPHATPECHIEFGWNEEDYEYYERANDVINELARBESIDESAREVERWLOODINDEEDNOPIFWOUREREADWOWSTERSDEARPECANBELINTOFEED

Swap equal frequency letters D, G, I and L(10) to try to make words make sense:
Swap G and L, the modified letter frequency set(high to low) is:
['E', 'A', 'T', 'S', 'O', 'H', 'R', 'I', 'N', 'D', 'F', 'P', 'U', 'B', 'W', 'G', 'L', 'C', 'Y', 'M', 'V', 'K', 'X', 'J', 'Q', 'Z']

The modified translation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'S'), ('T', 'O'), ('B', 'H'), ('H', 'R'), ('V', 'I'), ('W', 'N'), ('A', 'D'), ('O', 'F'), ('E', 'P'), ('D', 'U'), ('G', 'B'), ('I', 'W'), ('L', 'G'), ('J', 'L'), ('Z', 'C'), ('C', 'Y'), ('Y', 'M'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
THETIMEHASCOMETHEPALRUSSAIDTOTALKOFMANWTHINGSOFSHOESANDSHIYSANDSEALINGPAXOFCABBAGESANDKINGSANDPHWTHESAISBOILINGHOTANDPHETHERYIGSHAVEPINGSBUTPAITABITTHEOWSTERSCRIEDBEFOREPEHAVEOURCHATFORSOMEOFUSAREOUTOFBREATHANDALLOFUSAREFATNOHURRWSAIDTHECARYENTERTHEWTHANKEDHIMMUCHFORTHATALOAFOFBREADTHEPALRUSSAIDISPHATPECHIEFLWNEEDYEYYERANDVINEGARBESIDESAREVERWGOODINDEEDNOPIFWOUREREADWOWSTERSDEARPECANBEGINTOFEED

MANW should be MANY
Swap W and Y, the modified letter frequency set(high to low) is:
['E', 'A', 'T', 'S', 'O', 'H', 'R', 'I', 'N', 'D', 'F', 'P', 'U', 'B', 'Y', 'G', 'L', 'C', 'W', 'M', 'V', 'K', 'X', 'J', 'Q', 'Z']

The modified translation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'S'), ('T', 'O'), ('B', 'H'), ('H', 'R'), ('V', 'I'), ('W', 'N'), ('A', 'D'), ('O', 'F'), ('E', 'P'), ('D', 'U'), ('G', 'B'), ('I', 'Y'), ('L', 'G'), ('J', 'L'), ('Z', 'C'), ('C', 'W'), ('Y', 'M'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
THETIMEHASCOMETHEPALRUSSAIDTOTALKOFMANYTHINGSOFSHOESANDSHIWSANDSEALINGPAXOFCABBAGESANDKINGSANDPHYTHESAISBOILINGHOTANDPHETHERWIGSHAVEPINGSBUTPAITABITTHEOYSTERSCRIEDBEFOREPEHAVEOURCHATFORSOMEOFUSAREOUTOFBREATHANDALLOFUSAREFATNOHURRYSAIDTHECARWENTERTHEYTHANKEDHIMMUCHFORTHATALOAFOFBREADTHEPALRUSSAIDISPHATPECHIEFLYNEEDWEWWERANDVINEGARBESIDESAREVERYGOODINDEEDNOPIFYOUREREADYOYSTERSDEARPECANBEGINTOFEED

PHY, PE, PINGS shoule be why, we and wings
Swap P and W, the modified letter frequency set(high to low) is:
['E', 'A', 'T', 'S', 'O', 'H', 'R', 'I', 'N', 'D', 'F', 'W', 'U', 'B', 'Y', 'G', 'L', 'C', 'P', 'M', 'V', 'K', 'X', 'J', 'Q', 'Z']

The modified translation table is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'S'), ('T', 'O'), ('B', 'H'), ('H', 'R'), ('V', 'I'), ('W', 'N'), ('A', 'D'), ('O', 'F'), ('E', 'W'), ('D', 'U'), ('G', 'B'), ('I', 'Y'), ('L', 'G'), ('J', 'L'), ('Z', 'C'), ('C', 'P'), ('Y', 'M'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

The decrypted message is:
THETIMEHASCOMETHEWALRUSSAIDTOTALKOFMANYTHINGSOFSHOESANDSHIPSANDSEALINGWAXOFCABBAGESANDKINGSANDWHYTHESAISBOILINGHOTANDWHETHERPIGSHAVEWINGSBUTWAITABITTHEOYSTERSCRIEDBEFOREWEHAVEOURCHATFORSOMEOFUSAREOUTOFBREATHANDALLOFUSAREFATNOHURRYSAIDTHECARPENTERTHEYTHANKEDHIMMUCHFORTHATALOAFOFBREADTHEWALRUSSAIDISWHATWECHIEFLYNEEDPEPPERANDVINEGARBESIDESAREVERYGOODINDEEDNOWIFYOUREREADYOYSTERSDEARWECANBEGINTOFEED

The final translation table(high to low) is:
[('F', 'E'), ('Q', 'A'), ('P', 'T'), ('X', 'S'), ('T', 'O'), ('B', 'H'), ('H', 'R'), ('V', 'I'), ('W', 'N'), ('A', 'D'), ('O', 'F'), ('E', 'W'), ('D', 'U'), ('G', 'B'), ('I', 'Y'), ('L', 'G'), ('J', 'L'), ('Z', 'C'), ('C', 'P'), ('Y', 'M'), ('U', 'V'), ('K', 'K'), ('N', 'X'), ('M', 'J'), ('R', 'Q'), ('S', 'Z')]

THETIMEHASCOMETHEWALRUSSAIDTOTALKOFMANYTHINGSOFSHOESANDSHIPSANDSEALINGWAXOFCABBAGESANDKINGSANDWHYTHESAISBOILINGHOTANDWHETHERPIGSHAVEWINGSBUTWAITABITTHEOYSTERSCRIEDBEFOREWEHAVEOURCHATFORSOMEOFUSAREOUTOFBREATHANDALLOFUSAREFATNOHURRYSAIDTHECARPENTERTHEYTHANKEDHIMMUCHFORTHATALOAFOFBREADTHEWALRUSSAIDISWHATWECHIEFLYNEEDPEPPERANDVINEGARBESIDESAREVERYGOODINDEEDNOWIFYOUREREADYOYSTERSDEARWECANBEGINTOFEED

Now we have a readable text:

THE TIME HAS COME. THE WALRUS SAID TO TALK OF MANY THINGS OF SHOES AND SHIPS AND SEALING WAX OF CABBAGES AND KINGS AND WHY THE SA IS BOILING HOT AND WHETHER PIGS HAVE WINGS. BUT WAIT A BIT. THE OYSTERS CRIED BEFORE WE HAVE OUR CHAT. FOR SOME OF US ARE OUT OF BREATH AND ALL OF US ARE FAT. NO HURRY SAID THE CARPENTER. THEY THANKED HIM MUCH FOR THAT. A LOAF OF BREAD THE WALRUS SAID. IS WHAT WE CHIEFLY NEED PEPPER AND VINEGAR BESIDES ARE VERY GOOD INDEED. NOW IF YOURE READY OYSTERS DEAR WE CAN BEGIN TO FEED

[Done] exited with code=0 in 0.203 seconds

======= Sample Output End =======

Question 2:

a): 

The expected time to find a key by exhausitve search if the key-space is of size 2^88 with a computer that can test 2^40 keys each second is:
2^88 / 2^40 = 2^48 = 281474976710656 seconds = 8925512.960129883 years

b):

The expected time to find a key by exhausitve search if the key-space is of size 2^112 with a computer that can test 2^40 keys each second is:
2^112 / 2^40 = 2^72 = 4722366482869645213696 seconds = 149745258842898.44 years

c):

The expected time to find a key by exhausitve search if the key-space is of size 2^256 with a computer that can test 2^40 keys each second is:
2^256 / 2^40 = 2^216 = 105312291668557186697918027683670432318895095400549111254310977536 seconds = 3.339430862143493e+57 years

Run Q2.py in python compiler to run code for this question.
======= Sample Output =======

a:
= 2^88 / 2^40 = 2^48 = 281474976710656 seconds = 8925512.960129883 years

b:
= 2^112 / 2^40 = 2^72 = 4722366482869645213696 seconds = 149745258842898.44 years

c:
= 2^256 / 2^40 = 2^216 = 105312291668557186697918027683670432318895095400549111254310977536 seconds = 3.339430862143493e+57 years

[Done] exited with code=0 in 0.178 seconds

======= Sample Output End =======

Question 3:

The next 32 keystream bits are: 
[1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1]

After these 32 bits have been generated:
X = [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Y = [1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0]
Z = [0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1]

Run Q3.py in python compiler to run code for this question.
======= Sample Output =======

keystream bits = [1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1]

X = [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

Y = [1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0]

Z = [0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1]

[Done] exited with code=0 in 0.191 seconds

======= Sample Output End =======

Question 4:

a):

With public key is (18, 30, 7, 26), m = 6, n = 47, let private key be X:

X0 * 6 mod 47 = 18
X1 * 6 mod 47 = 30
X2 * 6 mod 47 = 7
X3 * 6 mod 47 = 26

By solving this problem using algorithm(mod inverse), the X0, X1, X2, X3 which is the private key is: 
[3, 5, 9, 20]

Therefore the conversion factor is:
6^(-1) mod 47 = 7

b):

To encrypt the message M = 1101, use public key (18, 30, 7, 26):
18 + 30 + 26 = 74

Run Q4.py in python compiler to run code for this question.
======= Sample Output =======

a.
Private key = [3, 5, 9, 20] and conversion factor = 6^(-1) mod 47 = 7

b.
The encrypted message = 18 + 30 + 26 = 74

[Done] exited with code=0 in 0.184 seconds

======= Sample Output End =======

Question 5:

No, the attack illustrated is not succeed,

Since g and p are public, they all know g and p. 
Alice know g^a mod p already and recived g^bt mod p from Trudy.
Trudy know g^a mod p from Alice and sent g^at mod p to Bob, know g^b mod p from Bob and sent g^bt mod p to Alice
Bob know g^b mod p already and receive g^at mod p

The suituation is:
Alice know: g, p, a, g^a mod p, g^bt mod p
Bob know: g, p, b, g^b mod p, g^at mod p
Trudy know: g, p, t, g^a mod p, g^b mod p, g^at mod p , pg^bt mod p

Therefore,
Alice can compute g^bt^(a) = g^bat = g^abt mod p.
Bob can compute  g^at^(b) = g^abt = g^abt mod p.
Trudy can compute g^at * g^bt = g^(at + bt) = g^(at + bt) mod p or g^a * g^b = g^(a + b) = g^(a + b) mod p, but none of them equals to g^abt mod p.
Unless Trudy can solve discret log problem or get value of a or b, there is no way to establish g^(abt) mod p in this case.