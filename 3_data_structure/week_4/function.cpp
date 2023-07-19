#include <iostream>
int getFibonacci(int n);
const char* ordinalSuffix(int n);

int main() {
	std::cout << "\n\nData Structure - Assignment 1\n\n"
	          << "----------- WEEK 4 ----------\n\n"
	          << "Function implementation"
	          << "\n\n\n"
	          << std::endl;

	int n = 0;

	std::cout << "Find the n-th fibonacci number, enter a number (e.g 5):  ";
	std::cin >> n;

	if (n > 40) {
		std::cout << "\n\nYour n is too large";
		return 0;
	}

	std::cout << "\n\n"
	          << std::endl;

	std::cout << getFibonacci(n)
	          << " is the "
	          << n
	          << ordinalSuffix(n)
	          << " fibonacci number"
	          << std::endl;
	return 0;
}

const char* ordinalSuffix(int n) {
	static const char suffixes[][3] = {"th", "st", "nd", "rd"};
	auto ord = n % 100;
	if (ord / 10 == 1) {
		ord = 0;
	}
	ord = ord % 10;
	if (ord > 3) {
		ord = 0;
	}
	return suffixes[ord];
}

int getFibonacci(int n) {
	if (n <= 1) {
		return n;
	}

	int prev = 0, curr = 1;
	for (int i = 0; i < n - 1; i++) {
		int latest = prev + curr;
		prev = curr;
		curr = latest;
	}

	return curr;
}