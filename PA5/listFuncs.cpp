// Name: Ting Fung Lam 
// USC NetID: tingfunl
// CSCI 455 PA5
// Fall 2019


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

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
   // temp is allowed to be NULL
   ListType temp = list;
   ListType newNode = new Node(theKey, theValue, temp);
   list = newNode; // Updates the list pointer
}

// Search list
// Return ListType if found, NULL otherwise
ListType find(ListType &list, const string &theKey) {
   if (list == NULL) {
      return NULL;
   }
   ListType temp = list;
   while (temp != NULL) {
      if (temp->key == theKey) {
         return temp;
      }
      temp = temp->next;
   }
   return NULL;
}

// Print all elements
void printAll(ListType &list) {
   if (list == NULL) {
      return;
   }
   ListType temp = list;
   while (temp != NULL) {
      cout << "Key: " << temp->key << " Value: " << temp->value << endl;
      temp = temp->next;
   }
}

// Return number of elements
int numElements (ListType &list) {
   ListType temp = list;
   int num = 0;
   while (temp != NULL) {
      num++;
      temp = temp->next;
   }
   return num;
}

// Deletes element according to key, returns true if success
bool listRemove(ListType &list, const string &theKey) {
   // Empty list
   if (list == NULL) {
      return false;
   }
   ListType temp = list;
   // If the first one is the one to delete
   if (temp->key == theKey) {
      list = list->next; // Update head ptr, Could be NULL if only one element
      delete temp;
      return true;
   }
   // Make a pointer previous of the temp
   ListType prev = temp;
   while (temp != NULL && temp->key != theKey) {
      prev = temp;
      temp = temp->next;
   }
   // If not found
   if (temp == NULL) {
      return false;
   }
   // Change the previous next pointer to temp's next, then delete temp
   prev->next = temp->next;
   delete temp;
   return true;
}