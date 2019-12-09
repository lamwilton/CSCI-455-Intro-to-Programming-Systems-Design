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
   
   if (list == NULL) {
      Node* newNode = new Node(midVal);
      list = newNode;
      return;
   }
   
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
   Node* newNode = new Node(midVal, curr->next);
   curr->next = newNode;
}


ListType merge(ListType list1, ListType list2) {
   // Merging list2 into list1
   // If both are empty lists
   if (list1 == NULL && list2 == NULL) {
      return NULL;
   }
   // If list1 is empty
   if (list1 == NULL) {
      return list2;
   }
   ListType head = list1;
   ListType prev = list1;

   while (list1 != NULL || list2 != NULL) {
      // if list1 is ending
      if (list1 == NULL) {
         prev->next = list2;
         return head;
      }
      // if list2 is ending
      if (list2 == NULL) {
         return head;
      }

      if (list1 != NULL && list2 != NULL) {
         if (list2->data < list1->data) {
            // if the smallest number is in list2
            if (prev == list1) {
               prev = list2;
               list2 = list2->next;
               prev->next = list1;
               head = prev;
            }
            else {               
               prev->next = list2;
               prev = prev->next;
               list2 = list2->next;
               prev->next = list1;
            }
         }
         else {
            if (prev != list1) {
               prev = prev->next;
            }
            list1 = list1->next;
         }
      }
   }
      
   return head;
}



