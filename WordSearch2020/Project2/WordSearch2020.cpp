#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <fstream>
#include <string>
#define MAXWords 100
using namespace std;
int getHowManyWords(ifstream &file) {
	
	string line;
	
	int length = 0;
	for (int i = 0; i < MAXWords; i++) {
		
		if (!file.eof()) {
			length++;
			getline(file, line);
		}
	}


	return length;
}
int readFile(ifstream& file,  string* words) {
	
	string line;

	int length = 0;
	for (int i = 0; i < MAXWords;i++) {
		//cout << !file.eof() << endl;
		if (!file.eof()) {
			length++;
			getline(file, line);
		//	cout << "What word: " << line<<endl;
			words[i]=line;
			
		}
	}


	return length;
}
void putWords(char board[20][20], char board_[20][20],string* words,int size) {
	int length = words[0].length();
	bool found=true;
	bool wordCheck = true;
	int numW=0;
	
	while (numW!=size) {
		int direction = rand() % 8;
		int yStart = rand() % 20;
		int xStart = rand() % 20;
		wordCheck = true;
		found = true;
		//cout<<"What xStart: " << xStart<<" yStart: " <<yStart<<" word list: "<<numW<< endl;
		if (direction ==0 && xStart+length<20) { // x+

			for (int i = 0; i < length; i++) {
				//cout << "What letter: " <<  << endl;

				if (board_[yStart][xStart + i] != '_') {
					wordCheck = false;
					break;
				}
				

			}
			if (wordCheck) {
				for (int i = 0; i < length; i++) {
					//cout << "What letter: " <<  << endl;

					board[yStart][xStart + i] = words[numW].at(i);
					found = false;
				

				}
				numW++;
				length = words[numW].length();
			}
		}
		if (direction == 1 && xStart - length > 0) {// x-
			for (int i = 0; i < length; i++) {
				//cout << "What letter: " <<  << endl;

				if (board_[yStart][xStart - i] != '_') {
					wordCheck = false;
					break;
				}


			}
			if (wordCheck) {
				for (int i = 0; i < length; i++) {
					//cout << "What letter: " <<  << endl;

					board[yStart][xStart - i] = words[numW].at(i);
					found = false;
					
				}
				numW++;
				length = words[numW].length();
			}
		}
		if (direction == 2 && yStart + length < 20) {//y+
			for (int i = 0; i < length; i++) {
				//cout << "What letter: " <<  << endl;

				if (board_[yStart+i][xStart] != '_') {
					wordCheck = false;
					break;
				}


			}
			if (wordCheck) {
				for (int i = 0; i < length; i++) {
					//cout << "What letter: " <<  << endl;

					board[yStart + i][xStart] = words[numW].at(i);
					found = false;
				
				}
				numW++;
				length = words[numW].length();
			}
		}
		if (direction == 3 && yStart - length > 0) {//y-
			for (int i = 0; i < length; i++) {
				//cout << "What letter: " <<  << endl;

				if (board_[yStart-i][xStart] != '_') {
					wordCheck = false;
					break;
				}


			}
			if (wordCheck) {
				for (int i = 0; i < length; i++) {
					//cout << "What letter: " <<  << endl;

					board[yStart - i][xStart] = words[numW].at(i);
					found = false;
					
				}
				numW++;
				length = words[numW].length();
			}
		}
		if (direction == 4 && yStart + length < 20 && xStart +length<20) {// + +
			for (int i = 0; i < length; i++) {
				//cout << "What letter: " <<  << endl;

				if (board_[yStart+i][xStart + i] != '_') {
					wordCheck = false;
					break;
				}


			}
			if (wordCheck) {
				for (int i = 0; i < length; i++) {
					//cout << "What letter: " <<  << endl;

					board[yStart + i][xStart + i] = words[numW].at(i);
					found = false;
					
				}
				numW++;
				length = words[numW].length();
			}
		}
		if (direction == 5 && yStart - length > 0 && xStart - length > 0) {// - -
			for (int i = 0; i < length; i++) {
				//cout << "What letter: " <<  << endl;

				if (board_[yStart-i][xStart -i] != '_') {
					wordCheck = false;
					break;
				}


			}
			if (wordCheck) {
				for (int i = 0; i < length; i++) {
					//cout << "What letter: " <<  << endl;

					board[yStart - i][xStart - i] = words[numW].at(i);
					found = false;
					
				}
				numW++;
				length = words[numW].length();
			}
		}
		if (direction == 6 && yStart + length < 20 && xStart - length > 0) {// + -
			for (int i = 0; i < length; i++) {
				//cout << "What letter: " <<  << endl;

				if (board_[yStart+i][xStart - i] != '_') {
					wordCheck = false;
					break;
				}


			}
			if (wordCheck) {
				for (int i = 0; i < length; i++) {
					//cout << "What letter: " <<  << endl;

					board[yStart + i][xStart - i] = words[numW].at(i);
					found = false;
					
				}
				numW++;
				length = words[numW].length();
			}
		}
		if (direction == 7 && yStart - length > 0 && xStart + length < 20) {// - +
			for (int i = 0; i < length; i++) {
				//cout << "What letter: " <<  << endl;

				if (board_[yStart-i][xStart + i] != '_') {
					wordCheck = false;
					break;
				}


			}
			if (wordCheck) {
				for (int i = 0; i < length; i++) {
					//cout << "What letter: " <<  << endl;

					board[yStart - i][xStart + i] = words[numW].at(i);
					found = false;
					
				}
				numW++;
				length = words[numW].length();
			}
		}

	}
}
void makeSearch(char board[20][20], char board_[20][20]) {
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 20; j++) {
			board_[i][j] = '_';
		}
	}
}
void updateSearch(char board[20][20]) {
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 20; j++) {
			if (board[i][j]=='_') {
				board[i][j] = 'A' + (rand() % 26);
			}
		}
	}
}
void printBoard(char board[20][20]) {
	/*for (int i = 0; i < 20; i++) {
		cout << i << " ";
	}*/
	cout << endl;
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 20; j++) {

			cout << board[i][j] << " ";
			if (j == 19) {
				cout << endl;
			}

		}
	}
}
void addWords(char board[20][20]) {
	string test = "hello";
	//cout<<test.at(1);
}
int main() {
int x, y;
	cin >> x;
	cin >> y;
	char board[20][20];
	char board_[20][20];
	srand(time(NULL));
	makeSearch(board,board_);
	ifstream file;
	file.open("wordsearch1.txt");
	addWords(board);
	int length = getHowManyWords(file);
	string *words = new string[length];
	file.seekg(0, file.beg);
	readFile(file, words);
	cout << "Word list: " << endl;
	for (int i = 0; i < length; i++) {
		cout<<words[i]<<endl;
	}
	putWords(board_,board_, words,length);
	//printBoard(board_);
	updateSearch(board_);
	printBoard(board_);
	while (1) {

	}
	return 0;

}