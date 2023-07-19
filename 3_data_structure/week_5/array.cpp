#include <iomanip>
#include <iostream>
#include <string>

struct Book {
	char title[256];
	char author[64];
	double price;
	int stock;
};

void printBook(Book &book, int &i);

int main() {
	std::cout << "\n\nData Structure - Assignment 2\n\n"
	          << "----------- WEEK 5 ----------\n\n"
	          << "Array Implementation"
	          << "\n\n\n"
	          << std::endl;

	struct Book books[10];

	int limit;
	std::cout << "Enter the number of books you want to insert (max: 10):  ";
	std::cin >> limit;

	if (limit <= 10) {
		for (int i = 0; i < limit; i++) {
			std::cout << "\n\n\nEnter Book "
			          << i + 1
			          << " data => "
			          << std::endl;
			std::cout << "Title:  ";
			std::cin.ignore(1, '\n');
			std::cin.getline(books[i].title, 256);
			std::cout << "Author:  ";
			std::cin.ignore(1, '\n');
			std::cin.getline(books[i].author, 64);
			std::cout << "Price:  ";
			std::cin >> books[i].price;
			std::cout << "Stock:  ";
			std::cin >> books[i].stock;
		}

		std::cout << "\n\n\n===============Your Books===============\n"
		          << std::endl;
		for (int i = 0; i < limit; i++) {
			printBook(books[i], i);
		}
		std::cout << "========================================\n\n"
		          << std::endl;
	}

	std::cin.get();
	return 0;
}

void printBook(Book &book, int &i) {
	std::cout << "==== Book "
	          << i + 1
	          << "==== "
	          << "\n====================="
	          << "\n Title : "
	          << book.title
	          << "\n Author : "
	          << book.author
	          << "\n Price : "
	          << std::fixed
	          << std::setprecision(2)
	          << book.price
	          << "\n Stock : "
	          << book.stock
	          << std::endl
	          << std::endl;
}