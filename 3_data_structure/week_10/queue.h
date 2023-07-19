#include <iostream>

class Queue {
  private:
	const static int size = 10;
	int items[size], front, rear;

  public:
	Queue() {
		front = -1;
		rear = -1;
	}

	bool isFull() {
		return front == 0 && rear == size - 1;
	}

	bool isEmpty() {
		return front == -1;
	}

	void enQueue(int element) {
		if (isFull()) {
			std::cout << "Queue is full";
		} else {
			if (front == -1) front = 0;
			rear++;
			items[rear] = element;
		}
	}

	int deQueue() {
		int element;
		if (isEmpty()) {
			std::cout << "Queue is empty" << std::endl;
			return (-1);
		} else {
			element = items[front];
			if (front >= rear) {
				front = -1;
				rear = -1;
			} else {
				front++;
			}
			return (element);
		}
	}

	void showQueue() {
		std::cout << "\n\n";
		std::cout << "QUEUE = ";
		int i;
		if (isEmpty()) {
			std::cout << "Empty";
		} else {
			for (i = front; i <= rear; i++) {
				std::cout << "[" << i << "]"
				          << "[" << items[i] << "]";
				if (i < rear) {
					std::cout << "->";
				}
			}
		}
		std::cout << "\n\n";
	}
};