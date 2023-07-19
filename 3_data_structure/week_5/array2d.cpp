#include <iomanip>
#include <iostream>
#include <string>

struct Member {
	char name[64];
	char role[24];
	int age;
	bool ready;
};

void printGroup(Member (&member)[3], int &i);

int main() {
	std::cout << "\n\nData Structure - Assignment 2\n\n"
	          << "----------- WEEK 5 ----------\n\n"
	          << "Array 2D Implementation"
	          << "\n\n\n"
	          << std::endl;

	struct Member groups[3][3] = {
	    {{"Kawish", "Manager", 23, true},
	     {"Ibnu", "Organizer", 20, true},
	     {"John", "Member", 20, true}},
	    {{"Kevin", "Manager", 22, false},
	     {"Steven", "Organizer", 21, false},
	     {"Artour", "Member", 19, true}},
	    {{"Joergen", "Manager", 100, true},
	     {"Sven", "Organizer", 120, true},
	     {"Water Sheep", "Member", 999, true}},
	};

	std::cout << "\n\n\n===============Your Groups===============\n"
	          << std::endl;
	for (int i = 0; i < 3; i++) {
		std::cout << "====== Group "
		          << i + 1
		          << "====== "
		          << "\n=====================\n";
		printGroup(groups[i], i);
	}
	std::cout << "========================================\n\n"
	          << std::endl;

	std::cin.get();
	return 0;
}

void printGroup(Member (&members)[3], int &i) {
	std::cout << "   ==== Members "
	          << i + 1
	          << "==== "
	          << "\n  =====================";

	for (int j = 0; j < 3; j++) {
		std::cout << "\n   ["
		          << j + 1
		          << "] "
		          << "\n   Name : "
		          << members[j].name
		          << "\n   Role : "
		          << members[j].role
		          << "\n   Age : "
		          << members[j].age
		          << "\n   Ready : "
		          << members[j].ready
		          << std::endl
		          << std::endl;
	}
}