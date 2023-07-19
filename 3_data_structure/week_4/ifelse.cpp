#include <iostream>

int main() {
	std::cout << "\n\nData Structure - Assignment 1\n\n"
	          << "----------- WEEK 4 ----------\n\n"
	          << "If else implementation"
	          << "\n\n\n"
	          << std::endl;

	int firstNum = 0;
	int secondNum = 0;

	std::cout << "Compare two numbers (e.g : 10 20) : ";
	std::cin >> firstNum >> secondNum;
	std::cout << "\n\n"
	          << std::endl;

	if (firstNum == secondNum) {
		std::cout << firstNum
		          << " is equal to "
		          << secondNum
		          << std::endl;
	} else if (firstNum > secondNum) {
		std::cout << firstNum
		          << " is greater than "
		          << secondNum
		          << std::endl;
	} else {
		std::cout << firstNum
		          << " is less than "
		          << secondNum
		          << std::endl;
	}

	return 0;
}