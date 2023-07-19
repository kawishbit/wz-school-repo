#include "queue.h"

#include <chrono>
#include <functional>
#include <iostream>
#include <thread>

void startInterval(std::function<void(void)> func, unsigned int interval);
void runShop();
class Queue;

int main() {
	std::cout << "\n\nData Structure - Assignment 4\n\n"
	          << "----------- WEEK 10 ----------\n\n"
	          << "Queue"
	          << "\n\n\n"
	          << std::endl;

	std::cout << "=== Queue of a game shop ===";

	std::cout << "Enter the shop by registering your queue number";

	Queue queue;

	queue.showQueue();

	int option = 1;
	int queueNumber = 0;
	bool quit = false;

	while (true) {
		std::cout << "\n\n\n";
		std::cout << "1. Enter Shop\n2. Item Sold\n3. Quit\n"
		          << std::endl;
		std::cout << "Input : ";
		std::cin >> option;

		switch (option) {
			case 1:
				std::cout << "\n\n";
				std::cout << "Enter queue number : ";
				std::cin >> queueNumber;
				queue.enQueue(queueNumber);
				break;
			case 2:
				std::cout << "\n\n";
				queue.deQueue();
				break;
			case 3:
				quit = true;
				break;
			default:
				std::cout << "\n\n";
				std::cout << "Enter queue number : ";
				std::cin >> queueNumber;
				queue.enQueue(queueNumber);
				break;
		}

		if (quit) {
			break;
		}

		queue.showQueue();
	}
	std::cin.clear();
	std::cin.get();
	system("pause");
	return 0;
}
