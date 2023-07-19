#include "sort.h"

#include <cmath>
#include <iostream>
#include <vector>

void Sort::printArray(int array[], int& size) {
	for (int i = 0; i < size; i++)
		std::cout << array[i] << " ";
	std::cout << std::endl;
}

void Sort::swapElement(int* one, int* two) {
	int temp = *one;
	*one = *two;
	*two = temp;
}

void Sort::mergeSort(int array[], int left, int right, SortDirection direction) {
	if (left < right) {
		int middle = floor(left + ((right - left) / 2));

		Sort::mergeSort(array, left, middle, direction);
		Sort::mergeSort(array, middle + 1, right, direction);

		Sort::mergeArrays(array, left, middle, right, direction);
	}
}

void Sort::mergeArrays(int array[], int start, int mid, int end, SortDirection direction) {
	int tempArray1Size = mid - start + 1;
	int tempArray2Size = end - mid;

	std::vector<int> tempArray1(tempArray1Size), tempArray2(tempArray2Size);

	for (int i = 0; i < tempArray1Size; i++)
		tempArray1[i] = array[start + i];
	for (int j = 0; j < tempArray2Size; j++)
		tempArray2[j] = array[mid + 1 + j];

	int tempArray1Position, tempArray2Position, mainArrayPosition;
	tempArray1Position = 0;
	tempArray2Position = 0;
	mainArrayPosition = start;

	bool sortingCondition;

	while (tempArray1Position < tempArray1Size && tempArray2Position < tempArray2Size) {
		switch (direction) {
			case SortDirection::ASCENDING:
				sortingCondition = tempArray1[tempArray1Position] <= tempArray2[tempArray2Position];
				break;
			case SortDirection::DESCENDING:
				sortingCondition = tempArray1[tempArray1Position] > tempArray2[tempArray2Position];
				break;
			default:
				sortingCondition = tempArray1[tempArray1Position] <= tempArray2[tempArray2Position];
				break;
		}

		if (sortingCondition) {
			array[mainArrayPosition] = tempArray1[tempArray1Position];
			tempArray1Position++;
		} else {
			array[mainArrayPosition] = tempArray2[tempArray2Position];
			tempArray2Position++;
		}
		mainArrayPosition++;
	}

	while (tempArray1Position < tempArray1Size) {
		array[mainArrayPosition] = tempArray1[tempArray1Position];
		tempArray1Position++;
		mainArrayPosition++;
	}

	while (tempArray2Position < tempArray2Size) {
		array[mainArrayPosition] = tempArray2[tempArray2Position];
		tempArray2Position++;
		mainArrayPosition++;
	}
}

void Sort::quickSort(int array[], int low, int high, SortDirection direction) {
	if (low < high) {
		int pi = Sort::partitionArray(array, low, high, direction);

		Sort::quickSort(array, low, pi - 1, direction);

		Sort::quickSort(array, pi + 1, high, direction);
	}
}

int Sort::partitionArray(int array[], int low, int high, SortDirection direction) {
	int pivot = array[high];

	bool sortingCondition;
	int leftFlag = (low - 1);
	for (int j = low; j < high; j++) {
		switch (direction) {
			case SortDirection::ASCENDING:
				sortingCondition = array[j] <= pivot;
				break;
			case SortDirection::DESCENDING:
				sortingCondition = array[j] > pivot;
				break;
			default:
				sortingCondition = array[j] <= pivot;
				break;
		}
		if (sortingCondition) {
			leftFlag++;

			Sort::swapElement(&array[leftFlag], &array[j]);
		}
	}

	Sort::swapElement(&array[leftFlag + 1], &array[high]);

	return (leftFlag + 1);
}

void Sort::selectionSort(int array[], int& size, SortDirection direction) {
	bool sortingCondition;
	if (size <= 1) return;
	for (int mainStep = 0; mainStep < size - 1; mainStep++) {
		int keyValueIndex = mainStep;
		for (int i = mainStep + 1; i < size; i++) {
			switch (direction) {
				case SortDirection::ASCENDING:
					sortingCondition = array[i] < array[keyValueIndex];
					break;
				case SortDirection::DESCENDING:
					sortingCondition = array[i] >= array[keyValueIndex];
					break;
				default:
					sortingCondition = array[i] < array[keyValueIndex];
					break;
			}
			if (sortingCondition)
				keyValueIndex = i;
		}

		Sort::swapElement(&array[keyValueIndex], &array[mainStep]);
	}
}
void Sort::insertionSort(int array[], int& size, SortDirection direction) {
	for (int mainStep = 1; mainStep < size; mainStep++) {
		int key = array[mainStep];
		int j = mainStep - 1;

		while ((direction == SortDirection::ASCENDING ? key < array[j] : key > array[j]) && j >= 0) {
			array[j + 1] = array[j];
			--j;
		}

		array[j + 1] = key;
	}
}
