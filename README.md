# Algos_BST

Write a program to generate a optimal binary search tree for the given (ordered) keys and the number of times each key is searched.
You may reuse the pseudocode algorithms provided in lecture notes.
In the class, we worked with probability of searching for each item. Here, we have the number of times each item is searched - which makes for easier integer comparison/arithmetic. Simply treat this number as the probability.
In addition, your program must contain the logic to generate and output the optimal binary search tree (see below), from the dynamic programming table.

INPUT(s):

Read the inputs from a file named "input.txt".
The first line will have the number of elements (an integer).
Thereafter, each line will contain the 'number of times that element is searched' (an integer, simply treat this as the probability).
For example:

8
10
20
40
30
10
20
40
30

No other characters will be present in the file.
Note that your program must NOT take command line inputs.

OUTPUT(s):

The program should output the dynamic programming table.
It should also output a optimal binary search tree (see below).

The name of your output file should be <your uah login>.txt.
For example, mine will be sadasis.txt.

Note that the output should be properly formatted for easy readability. Use the sample output format given below.
For proper formatting/alignment purposes, you can assume that:
1. the number of elements to be <= 99. So, you will need a maximum of 2 characters to print the element index.
2. the probabilities for each node to be <= 999. So, you will need a maximum of 3 characters for each probability.

Note that the values in the table could be much larger than 3 digits/characters!

SAMPLE OUTPUT:

Table:
 -   01 02 03 04 05 06 07 08
01
02
03
04
05
06
07
08

Binary Tree:

Do it like the folder view (file/directory structure shown like a tree) in a file explorer. Basically, "output" the nodes in "pre-order".
For example, in Page 225 of the book, for the binary tree in exercise 6.3.1 (a), (the tree with nodes [2, 3, 5, 6, 8]) it will be output as:

5
    3
        2
        -
    6
        -
        8
