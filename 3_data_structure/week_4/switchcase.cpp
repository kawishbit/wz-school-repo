#include <iostream>
#include <string>

int main() {
	std::cout << "\n\nData Structure - Assignment 1\n\n"
	          << "----------- WEEK 4 ----------\n\n"
	          << "Switch case implementation"
	          << "\n\n\n"
	          << std::endl;

	char grade;

	std::cout << "Enter your grade (e.g A) : ";
	std::cin >> grade;
	std::cout << "\n\n"
	          << std::endl;

	switch (std::tolower(grade)) {
		case 'a':
			std::cout << "Your score ranges in between 85 to 100"
			          << std::endl;
			break;
		case 'b':
			std::cout << "Your score ranges between 70 to 84"
			          << std::endl;
			break;
		case 'c':
			std::cout << "Your score ranges between 65 to 69"
			          << std::endl;
			break;
		case 'd':
			std::cout << "Your score ranges between 50 to 64"
			          << std::endl;
			break;
		case 'e':
			std::cout << "Your score ranges between 0 to 49"
			          << std::endl;
			break;
		case 'f':
			std::cout << "Your score is 0"
			          << std::endl;
			break;
		default:
			std::cout << "ERR: Value can only ranges between A to F"
			          << std::endl;
			break;
	}
	return 0;
}