// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2019


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

typedef Node * ListType;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

// Adds a node to the end of the list

void add(ListType &list, const string &theKey, int theValue) {
   if (list == NULL) {
      list = new Node(theKey, theValue);
      return;
   }
   // Move to last element of the list
   Node *temp = list;
   while (temp->next != NULL) {
      temp = temp->next;
   }
   temp->next = new Node(theKey, theValue);
}

// Inserts to front of list
void insertFront(ListType &list, const string &theKey, int theValue) {
   ListType temp = list;
   ListType newNode = new Node(theKey, theValue, temp);
   list = newNode; // Updates the list pointer
}
