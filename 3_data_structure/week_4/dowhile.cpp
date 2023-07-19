#include <iostream>

bool isPrime(int num);
int main() {
	std::cout << "\n\nData Structure - Assignment 1\n\n"
	          << "----------- WEEK 4 ----------\n\n"
	          << "Do while implementation"
	          << "\n\n\n"
	          << std::endl;

	int limit = 0;
	int num = 0;

	std::cout << "Enter your odd number limit (e.g 100):  ";
	std::cin >> limit;
	std::cout << "\n\n"
	          << std::endl;

	do {
		if (num % 2 == 0) {
			std::cout << num
			          << " is not odd!"
			          << std::endl;
		} else {
			std::cout << num
			          << " is odd!"
			          << std::endl;
		}
		num++;
	} while (num <= limit);

	return 0;
}
