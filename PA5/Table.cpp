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
   return NULL;   // dummy return value for stub
}

bool Table::remove(const string &key) {
   return false;  // dummy return value for stub
}

bool Table::insert(const string &key, int value) {
   int hash = hashCode(key);
   // if bucket is empty
   if (this->table[hash] == NULL) {
      this->table[hash] = new Node(key, value);
      cout << this->table[hash]->key << this->table[hash]->value << endl;
      return true;
   }
   // if bucket isnt empty
   else {
      if (lookup(key) == NULL) {  // TODO lookup 
         add(this->table[hash], key, value);
         cout << this->table[hash]->next->key << this->table[hash]->next->value << endl;
         return true;
      }
   return false;
   }
}

int Table::numEntries() const {
   return 0;      // dummy return value for stub
}


void Table::printAll() const {

}

void Table::hashStats(ostream &out) const {
  
}


// add definitions for your private methods here
