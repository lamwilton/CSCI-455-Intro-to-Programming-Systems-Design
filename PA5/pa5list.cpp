// Name:
// USC NetID:
// CS 455 PA5
// Fall 2019

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {
   const string s = "Number";
   //Node* list = new Node(s, 3);
   Node* list = NULL;
   Node* head = list;
   add(head, s, 4);
   insertFront(head, s, 2);
   insertFront(head, s, 1);
   add(head, s, 5);
   list = head;
   cout << list->key << list->value << endl;
   list = list->next;
   cout << list->key << list->value << endl;
   list = list->next;
   cout << list->key << list->value << endl;
   list = list->next;
   cout << list->key << list->value << endl;

   return 0;
}
