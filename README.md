# BraviPairingBracket
Repository that contains the pairingBracket question made by Bravi interview process


# Introduction
The program in this repository is a proposal of solution for the very known problem of the pairing brackets.

The description of the problem is: 
```
Write a function that takes a string of brackets as the input, and determines if the order of
the brackets is valid. A bracket is considered to be any one of the following characters: (, ),
{, }, [, or ].
We say a sequence of brackets is valid if the following conditions are met:
*  It contains no unmatched brackets.
*  The subset of brackets enclosed within the confines of a matched pair of brackets is
also a matched pair of brackets.

Examples:
*  (){}[] is valid
*  [{()}](){} is valid
*  []{() is not valid
*  [{)] is not valid
```

This problem is usually discussed in classes of compilers, since in the compilation process it's required that the respective programming language to have a grammar, and grammars usually threat the issue of the pairing brackets (for example, for defining if-else funcitons, or to define when a loop started-ended.)

The solution is simply stack all the open brackets, and pop then when you found an close bracket, to verify if they match.
The solution declares that the string is invalid if :
* At the end of the iteration of the string, the stack isn't empty;
* If at the match step in the solution, the open and closed bracket doesn't match. 
* If there's an invalid input (which means that the string doesn't respect the expected characters.)
* If in the loop, the program tries to pop in an empty stack. This means that it was found a closed bracket that does not have an open one to match it.


# Requirements

* Docker. The compilation of the pairingBrackets/pairingBracket.java occurs inside the docker environment. (Worked in *Docker version 18.09.7, build 2d0083d*)

# How to run it

1. Clone this repository.
2. Run the following commands in the root directory of the repository:
```
    docker build --tag "docker-pairing-brackets:latest" .
    docker run -it docker-pairing-brackets:latest
```


The tag that you define can have any name that the user wants. But they must match in the *build* and *run* commands.

Also, the run commands requires the flags *-it*, since the java program gets the respectives strings in the input/output from the terminal.

The compilation process works inside the docker, so don't worry about it.

# How it works

![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Flow Chart of the execution of the program. ")


