#ifndef SORT_H
#define SORT_H

enum class SortDirection {
	ASCENDING,
	DESCENDING
};

class Sort {
  public:
	static void printArray(int array[], int& size);
	static void swapElement(int* one, int* two);
	static void mergeSort(int array[], int left, int right, SortDirection direction);
	static void mergeArrays(int array[], int start, int mid, int end, SortDirection direction);
	static void quickSort(int array[], int low, int high, SortDirection direction);
	static int partitionArray(int array[], int low, int high, SortDirection direction);
	static void selectionSort(int array[], int& size, SortDirection direction);
	static void insertionSort(int array[], int& size, SortDirection direction);
};

#endif