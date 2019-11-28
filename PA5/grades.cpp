// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2019

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

using namespace std;

int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }


   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*
   
   grades->insert("John", 29);
   grades->insert("Mary", 49);
   grades->insert("Ben", 39);
   grades->insert("Ben1", 23);
   grades->insert("Ben2", 24);
   grades->insert("Ben3", 25);
   grades->insert("Ben4", 26);
   cout << "Inserting dupe: " << grades->insert("Ben", 60) << endl;
   
   grades->printAll();
   
   int * result = grades->lookup("Ben");
   if (result != NULL) {
      cout << *result << endl;
   }
   cout << "Number of entry: " << grades->numEntries() << endl;
   
   cout << "Removing Mary: " << grades->remove("Mary") << endl;
   cout << "Removing Ben: " << grades->remove("Ben") << endl;
   cout << "Removing Peter: " << grades->remove("Peter") << endl;
   grades->printAll();
   
   
   return 0;
}
