// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2019

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {
   table = new ListType[HASH_SIZE]();
   hashSize = HASH_SIZE;
}


Table::Table(unsigned int hSize) {
   table = new ListType[hSize]();
   hashSize = hSize;
}


int * Table::lookup(const string &key) {
   int hash = hashCode(key);
   ListType result = find(this->table[hash], key);
   // Return NULL if not found
   if (result == NULL) {
      return NULL;
   }
   return &result->value; // returns the address of that int
}

bool Table::remove(const string &key) {
   int hash = hashCode(key);
   ListType result = find(this->table[hash], key);   
   bool del = listRemove(result, key);
   // After delete, if list in that bucket is empty, remove the list
   if (result == NULL) {
      this->table[hash] = NULL;
   }
   return del;
}

bool Table::insert(const string &key, int value) {
   int hash = hashCode(key);
   // if bucket is empty
   if (this->table[hash] == NULL) {
      this->table[hash] = new Node(key, value);
      return true;
   }
   // if bucket isnt empty
   else {
      if (lookup(key) == NULL) {  // Add only if I cannot find the key in LL
         add(this->table[hash], key, value);
         return true;
      }
   return false;
   }
}

int Table::numEntries() const {
   int num = 0;
   for (int i = 0; i < hashSize; i++) {
      num += numElements(this->table[i]);
   }
   return num;
}


void Table::printAll() const {
   for (int i = 0; i < hashSize; i++) {
      listPrintAll(this->table[i]);
   }
}

void Table::hashStats(ostream &out) const {
  
}


// add definitions for your private methods here
