#include <iostream>

bool isPrime(int num);
int main() {
	std::cout << "\n\nData Structure - Assignment 1\n\n"
	          << "----------- WEEK 4 ----------\n\n"
	          << "For loop implementation"
	          << "\n\n\n"
	          << std::endl;

	int limit = 0;

	std::cout << "How many fizzbuzz do you wanna print? (e.g 100):  ";
	std::cin >> limit;
	std::cout << "\n\n"
	          << std::endl;

	for (int i = 1; i <= limit; i++) {
		if ((i % 3 == 0) && (i % 5 == 0))
			std::cout << "FizzBuzz";
		else if (i % 3 == 0)
			std::cout << "Fizz";
		else if (i % 5 == 0)
			std::cout << "Buzz";
		else
			std::cout << i;

		std::cout << std::endl;
	}

	return 0;
}
