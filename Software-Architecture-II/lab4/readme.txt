Yiyun Zhang(Benny)
yz523
lab4

=====================Programming=====================
To run this program, import the NumberFeederClient and OddFinderServer folders to Eclipse.
Run the OddFinderServer first, the console will show 'waiting for connection'.
Then run the NumberFeederClient, the console will ask your inputs.
To create the ArrayList, you can type the numbers in a single line and separate then with a single space(" ").
Any non‐integer input will be ignored.
The input is a string, the client convert it into an ArrayList, and sent it to the server.
The server receive the ArrayList and do the modification, and return an ArrayList to the client.
In the end, the client output the total number of odd numbers in the ArrayList and output them to the console.

=====================Sample Output1=====================
Enter the array list:
>1 2 3 4 5
1 3 5 
There are 3 odd numbers

=====================Sample Output2=====================
Enter the array list:
>5 6 7 a b c
5 7 
There are 2 odd numbers

=====================Sample Output3=====================
Enter the array list:
>123 456 789 1 2 3 4 6 8 9 8 87 877 324 354 98 6789 678 53 421
123 789 1 3 9 87 877 6789 53 421 
There are 10 odd numbers