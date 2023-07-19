#include <iostream>

void printArray(int array[], int& size);
void findDuplicates(int array[], int& size);
int main() {
	int arrayLength;
	std::cout << "\n\nData Structure - Mid Term\n\n"
	          << "----------- WEEK 8 ----------\n\n"
	          << "Array Checker"
	          << "\n\n\n"
	          << std::endl;

	std::cout << "Enter the length of your array: ";
	std::cin >> arrayLength;
	int* userArray = new int(arrayLength);

	for (int i = 0; i < arrayLength; i++) {
		std::cout << "Enter the value of index " << i << " : ";
		std::cin >> userArray[i];
	}

	std::cout << "\n\nYour Array : \n"
	          << std::endl;
	printArray(userArray, arrayLength);
	std::cout << "\n\n"
	          << std::endl;
	findDuplicates(userArray, arrayLength);
	std::cout << "\n\n"
	          << std::endl;

	std::cin.clear();
	std::cin.get();
	system("pause");
	return 0;
}

void findDuplicates(int array[], int& size) {
	bool found = false;
	for (int i = 0; i < size; i++) {
		for (int j = i + 1; j < size; j++) {
			if (array[i] == array[j]) {
				std::cout << "Duplicate found on indices " << i << " and " << j << std::endl;
				found = true;
			}
		}
	}

	if (!found) {
		std::cout << "Duplicates Not Found" << std::endl;
	}
}

void printArray(int array[], int& size) {
	for (int i = 0; i < size; i++)
		std::cout << array[i] << " ";
	std::cout << std::endl;
}