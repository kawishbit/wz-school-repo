#include <iostream>

#include "sort.h"

int main() {
	int arr[12] = {80, 84, 100, 24, 79, 85, 91, 65, 17, 3, 1, 21};
	int arrSize = sizeof(arr) / sizeof(arr[0]);

	std::cout << "\n\nData Structure - Assignment 3\n\n"
	          << "----------- WEEK 6 ----------\n\n"
	          << "Sorting"
	          << "\n\n\n"
	          << std::endl;

	int sortingMethod = 1;
	int order = 1;
	std::cout << "Sort this array [80, 84, 100, 24, 79, 85, 91, 65, 17, 3, 1, 21] " << std::endl;
	std::cout << "Enter sorting method : "
	          << "\n1. Merge Sort\n2. Quick Sort\n3. Selection Sort\n4. Insertion Method"
	          << std::endl;
	std::cout << "Your Input :  ";
	std::cin >> sortingMethod;
	std::cout << "\n\nEnter order : "
	          << "\n1. Ascending\n2. Descending"
	          << std::endl;
	std::cout << "Your Input :  ";
	std::cin >> order;

	SortDirection direction = SortDirection::ASCENDING;
	if (order == 2) {
		direction = SortDirection::DESCENDING;
	}

	std::cout << "\n\nBefore : " << std::endl;
	Sort::printArray(arr, arrSize);
	switch (sortingMethod) {
		case 1:
			Sort::mergeSort(arr, 0, arrSize - 1, direction);
			break;
		case 2:
			Sort::quickSort(arr, 0, arrSize - 1, direction);
			break;
		case 3:
			Sort::selectionSort(arr, arrSize, direction);
			break;
		case 4:
			Sort::insertionSort(arr, arrSize, direction);
			break;
		default:
			Sort::insertionSort(arr, arrSize, direction);
			break;
	}

	std::cout << "\n\nAfter : " << std::endl;
	Sort::printArray(arr, arrSize);

	std::cout << "\n\n"
	          << std::endl;

	system("PAUSE");
	return EXIT_SUCCESS;
}