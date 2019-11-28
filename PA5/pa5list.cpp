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
typedef Node * ListType;

int main() {
   const string s = "Number";
   Node* list = NULL;
   Node* head = list;
   add(head, "dog", 4);
   //insertFront(head, "boy", 2);
   //insertFront(head, "apple", 1);
   //add(head, "egg", 5);
   
   const string e = "apple";
   ListType search = find(head, e);
   if (search != NULL) {
      cout << "Found, searching for: " << search->key << " Value: " << search->value << endl;
   }
   else {
      cout << "Not found, searching for:" << e << endl;
   }
   listPrintAll(head);
   cout << endl;
   
   cout << "Number of elements: " << numElements(head) << endl;
   cout << endl;
   
   cout << "Deleting" << endl;
   bool del = listRemove(head, "dog");
   cout << "Deleted? " << del << endl;
   listPrintAll(head);
   cout << head << endl;
   return 0;
}
