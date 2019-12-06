/*  Name: Ting Fung Lam
 *  USC NetID: tingfunl
 *  CS 455 Fall 2019
 *
 *  See ecListFuncs.h for specification of each function.
 */


// for NULL
#include <cstdlib>

// in case you want to use assert statements
#include <cassert>

#include "ecListFuncs.h"

using namespace std;

#include <iostream>
void longestRun(ListType list, int & maxRunVal, int & maxRunLen) {
   maxRunVal = list->data;
   maxRunLen = 1;
   int runLen = 1;
   int runVal = list->data;
   ListType prev = list;
   while (list->next != NULL) {
      list = list->next;
      if (prev->data == list->data) {
         runLen++;
         runVal = list->data;
      }
      if (runLen > maxRunLen) {
         maxRunLen = runLen;
         maxRunVal = runVal;
      }
      if (list->next != NULL && prev->data != list->data) {
         runLen = 1;
      }
      prev = prev->next;
   }
}


void removeMultiplesOf3(ListType & list) {
   ListType curr = list;
   ListType prev = list;
   while (curr != NULL) {
      //if first one deletes
      if (prev == curr && curr->data % 3 == 0) {
         //ListType temp = curr;
         curr = curr->next;
         prev = prev->next;
         list = list->next;
         //delete temp;
      }
      // if not first one deletes
      else if (prev != curr && curr->data % 3 == 0) {
         //ListType temp = curr;
         prev->next = curr->next;
         //delete temp;
         curr = prev->next;
      }
      // if no need to delete
      else {
         if (prev != curr) {
            prev = prev->next;
         }
         curr = curr->next;
      }
   }
         

}


void insertMiddle(ListType & list, int midVal) {
   int length = 0;
   ListType curr = list;
   // Get length
   while (curr != NULL) {
      length++;
      curr = curr->next;
   }
   int mid = length / 2;
   curr = list;
   for (int i = 0; i < mid - 1; i++) {
      curr = curr->next;
   }
   // Insert
}


ListType merge(ListType list1, ListType list2) {
   return NULL;  // dummy code so starter code compiles
}



