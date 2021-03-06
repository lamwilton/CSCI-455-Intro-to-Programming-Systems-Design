// Name: Ting Fung Lam
// USC NetID: tingfunl
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
   while (true) {
      cout << "cmd>";
      string cmd = "";
      cin >> cmd;
      if (cmd == "insert") {
         string name = "";
         int score = 0;
         cin >> name;
         cin >> score;
         if (grades->lookup(name)) {
            cout << "Name already present" << endl;
         }
         else {
            grades->insert(name, score);
         }
      }
      else if (cmd == "change") {
         string name = "";
         int score = 0;
         cin >> name;
         cin >> score;
         bool del = grades->remove(name);
         if (!del) {
            cout << "Student is not in the table" << endl;
         }
         else {
            grades->insert(name, score);
         }
      }
      else if (cmd == "lookup") {
         string name = "";
         cin >> name;
         int* result = grades->lookup(name);
         if (result != NULL) {
            cout << *result << endl;
         }
         else {
            cout << "Student is not in the table" << endl;
         }
      }
      else if (cmd == "remove") {
         string name = "";
         cin >> name;
         bool del = grades->remove(name);
         if (!del) {
            cout << "Student is not in the table" << endl;
         }
      }
      else if (cmd == "print") {
         grades->printAll();
      }
      else if (cmd == "size") {
         cout << grades->numEntries() << endl;
      }
      else if (cmd == "stats") {
         grades->hashStats(cout);
      }
      else if (cmd == "help") {
         cout << "insert=Insert name; change=Change score; lookup=Lookup name; remove= Remove student; print=Print all names;"
            << "size=Print number of entries; stats=Print stats of hash table; help=Command summary; quit=Exit program" << endl;
      }

      else if (cmd == "quit") {
         return 0;
      }
      else {
         cout << "ERROR: invalid command" << endl;
         cout << "insert=Insert name; change=Change score; lookup=Lookup name; remove= Remove student; print=Print all names;" 
            << "size=Print number of entries; stats=Print stats of hash table; help=Command summary; quit=Exit program" << endl;
      }
   }
   
   return 0;
}
